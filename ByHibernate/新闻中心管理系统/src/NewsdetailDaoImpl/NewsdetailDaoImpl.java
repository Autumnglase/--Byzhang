package NewsdetailDaoImpl;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import com.mysql.jdbc.PreparedStatement;
import Bean.Newsdetail;
import DbConnection.DatabaseConnection;
import NewsdetailDao.NewsdetailDao;
import utils.HibernateUtils;

public class NewsdetailDaoImpl implements NewsdetailDao {

	public boolean login(String adminname, String adminpass) {
		String sql = "SELECT * FROM admin where adminname='" + adminname + "'&&adminpass='" + adminpass + "'";
		ResultSet rs = null;
		try {
			Class.forName("com.mysql.jdbc.Driver");
			Connection con = DatabaseConnection.getConnection();
			PreparedStatement ps = (PreparedStatement) con.prepareStatement(sql);
			rs = ps.executeQuery();
			if (rs.next()) {
				return true;
			}
		} catch (Exception e) {
			return false;
		}
		DatabaseConnection.close();
		return false;
	}

	@Override
	public void add(Newsdetail newsdetail) {
		// 1.获得session
		Session session = HibernateUtils.openSession();
		// 2.打开事务
		Transaction tx = session.beginTransaction();
		// 3.执行保存
		session.save(newsdetail);
		// 4.提交保存
		tx.commit();
		// 5.关闭资源
		session.close();
	}

	@Override
	public int delete(int id) {
		String sql = "DELETE FROM newssystem.newsdetail WHERE id=?";
		int result = 0;
		int ID = Integer.valueOf(id);

		try {
			Connection con = DatabaseConnection.getConnection();

			PreparedStatement delPrepared = (PreparedStatement) con.prepareStatement(sql);
			delPrepared.setInt(1, ID);
			result = delPrepared.executeUpdate();
			return result;

		} catch (Exception e) {
			e.printStackTrace();
			return result = -1;
		}

	}

	// 根据id更改书名、作者
	@Override
	public int update(int id, Newsdetail newsdetail) {
		String sql = "UPDATE newssystem.newsdetail SET title=?,content=?,author=?,time=?,type=? WHERE id=? ";

		int result = 0;
		try {
			Connection con = DatabaseConnection.getConnection();

			PreparedStatement ps = (PreparedStatement) con.prepareStatement(sql);
			ps.setString(1, newsdetail.getTitle());
			ps.setString(2, newsdetail.getContent());
			ps.setString(3, newsdetail.getAuthor());
			ps.setString(4, newsdetail.getTime());
			ps.setString(5, newsdetail.getType());
			ps.setInt(6, id);
			result = ps.executeUpdate();
			return result;

		} catch (Exception e) {
			e.printStackTrace();
			return result = -1;
		}

	}

	public List<Newsdetail> findByKeyword(String keyword) {
		Session session = HibernateUtils.getCurrentSession();
		Transaction tx = session.beginTransaction();

		String strSQL = "from Newsdetail as a where a.title like :name";

		Query query = session.createQuery(strSQL);

		query.setString("name", "%" + keyword + "%");

		return query.list();

	}

	public Newsdetail findById(int id) {
		// 1.获得session
		Session session = HibernateUtils.openSession();
		Newsdetail news = session.get(Newsdetail.class, id);
		return news;
	}

	@Override
	public List<Newsdetail> findAll() {
		// 1.获得session
		Session session = HibernateUtils.openSession();
		// 2.创建Criteria对象
		Criteria c = session.createCriteria(Newsdetail.class);
		return c.list();

	}
}
