package NewsdetailDaoImpl;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import com.mysql.jdbc.PreparedStatement;
import Bean.Newsdetail;
import DbConnection.DatabaseConnection;
import NewsdetailDao.NewsdetailDao;

public class NewsdetailDaoImpl implements NewsdetailDao {
	
	public boolean login(String adminname, String adminpass) {
		String sql = "SELECT * FROM admin where adminname='"+adminname+"'&&adminpass='"+adminpass+"'";
		ResultSet rs= null;
		try {
			Class.forName("com.mysql.jdbc.Driver");
			Connection con = DatabaseConnection.getConnection();
			PreparedStatement ps = (PreparedStatement) con.prepareStatement(sql);
			rs = ps.executeQuery();
			if(rs.next())
			{
				return true;
			}
		} catch(Exception e) {
			return false;
		}
		DatabaseConnection.close();
		return false;
	}
	
	
	@Override
	public int add(Newsdetail newsdetail) {
		String sql="INSERT INTO newssystem.newsdetail(id,title,content,author,time,type) VALUES (?,?,?,?,?,?)";
		int result=0;
		try {
			Connection con = DatabaseConnection.getConnection();
			
			PreparedStatement ps = (PreparedStatement) con.prepareStatement(sql);
			
			ps.setInt(1, newsdetail.getId());
			ps.setString(2, newsdetail.getTitle());
			ps.setString(3, newsdetail.getContent());
			ps.setString(4, newsdetail.getAuthor());
			ps.setString(5, newsdetail.getTime());
			ps.setString(6, newsdetail.getType());
			result=ps.executeUpdate();
			con.close();
			return result;
		} catch (Exception e) {
			e.printStackTrace();
		}
		DatabaseConnection.close();
		return result;
	}

	@Override
	public int delete(int id) {
		String sql="DELETE FROM newssystem.newsdetail WHERE id=?";
		int result=0;
		int ID=Integer.valueOf(id);
		
		try {
			Connection con = DatabaseConnection.getConnection();
			
			PreparedStatement delPrepared=(PreparedStatement) con.prepareStatement(sql); 
			delPrepared.setInt(1, ID);
			result=delPrepared.executeUpdate();
			return result;
			
		} catch (Exception e) {
			e.printStackTrace();
			return result=-1;
		}
		
	}
	//	根据id更改书名、作者
	@Override
	public int update(int id,Newsdetail newsdetail) {
		String sql="UPDATE newssystem.newsdetail SET title=?,content=?,author=?,time=?,type=? WHERE id=? ";
		
		int result=0;
		try {
			Connection con = DatabaseConnection.getConnection();
			
			PreparedStatement ps=(PreparedStatement) con.prepareStatement(sql);
			ps.setString(1, newsdetail.getTitle());
			ps.setString(2, newsdetail.getContent());
			ps.setString(3, newsdetail.getAuthor());
			ps.setString(4, newsdetail.getTime());
			ps.setString(5, newsdetail.getType());
			ps.setInt(6, id);
			result=ps.executeUpdate();
			return result;
			
		} catch (Exception e) {
			e.printStackTrace();
			return result=-1;
		}
		
		
	}

	public Newsdetail findByKeyword(String keyword) {
		String sql = "SELECT * FROM newssystem.newsdetail WHERE title like ? ";
		Newsdetail newsdetail=new Newsdetail();
		ResultSet rs=null;
		try {
			Connection con = DatabaseConnection.getConnection();
			PreparedStatement ps=(PreparedStatement) con.prepareStatement(sql);
			ps.setString(1, "%"+keyword+"%");
			rs=ps.executeQuery();
			while(rs.next()){
				newsdetail.setId(rs.getInt("id"));
				newsdetail.setTitle(rs.getString("title"));
				newsdetail.setContent(rs.getString("content"));
				newsdetail.setAuthor(rs.getString("author"));
				newsdetail.setTime(rs.getString("time"));
				newsdetail.setType(rs.getString("type"));	
			}
			return newsdetail;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
		
		
		
		
	}
	
	public Newsdetail findById(int id) {
		String sql = "SELECT * FROM newssystem.newsdetail WHERE id =?";
		Newsdetail newsdetail=new Newsdetail();
		ResultSet rs=null;
		try {
			Connection con = DatabaseConnection.getConnection();
			PreparedStatement ps=(PreparedStatement) con.prepareStatement(sql);
			ps.setInt(1, id);
			rs=ps.executeQuery();
			while(rs.next()){
				newsdetail.setId(rs.getInt("id"));
				newsdetail.setTitle(rs.getString("title"));
				newsdetail.setContent(rs.getString("content"));
				newsdetail.setAuthor(rs.getString("author"));
				newsdetail.setTime(rs.getString("time"));
				newsdetail.setType(rs.getString("type"));
				//newsdetail=new Newsdetail(id,title,content,author,time,type);			
			}
			return newsdetail;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

	@Override
	public List<Newsdetail> findAll() {
		String sql="SELECT * FROM newssystem.newsdetail ORDER BY id ";//对查询到的id进行排序
		List<Newsdetail> list=new ArrayList<Newsdetail>();
		Newsdetail newsdetail=null;
		ResultSet rs=null;
		try {
			Connection con = DatabaseConnection.getConnection();
			PreparedStatement ps=(PreparedStatement) con.prepareStatement(sql);
			rs=ps.executeQuery();
			while(rs.next()){
				int id=rs.getInt("id");
				String title=rs.getString("title");
				String content=rs.getString("content");
				String author=rs.getString("author");
				String time=rs.getString("time");
				String type=rs.getString("type");
				
				newsdetail=new Newsdetail(id,title,content,author,time,type);
				list.add(newsdetail);				
			}
			return list;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}
}
