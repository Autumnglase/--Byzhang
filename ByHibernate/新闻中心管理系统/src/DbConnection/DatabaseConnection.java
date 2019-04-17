package DbConnection;
import java.sql.*;
public class DatabaseConnection {
	

	
//	声明jdbc的相关对象
	protected static Statement s = null;
	protected static ResultSet rs = null;
	protected static Connection conn = null;
	
//	创建数据库连接
	public static synchronized Connection getConnection(){
		try{
			Class.forName("com.mysql.jdbc.Driver");
			conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/newssystem","root","root");
			
		}catch(Exception e){
			e.printStackTrace();
		}
		return conn;
	}
	 
//	执行update语句
	public static int executeUpdate(String sql){
		int result = 0;
		
		try{
			s=getConnection().createStatement();
			result = s.executeUpdate(sql);
		}catch(SQLException e){
			e.printStackTrace();
		}
		return result;
	}
//	执行select语句
	public static ResultSet executeQuery(String sql){
		try{
			s = getConnection().createStatement();
			rs = s.executeQuery(sql);
		}catch(SQLException e){
			e.printStackTrace();
		}
		return rs;
	}
	
//	执行动态sql语句
	public static PreparedStatement executePreparedStatement(String sql){
		PreparedStatement ps = null;
		try{
			
			ps = getConnection().prepareStatement(sql);
			
		}catch(Exception e){
			e.printStackTrace();
		}
		return ps;
	}
	
//	事物回滚
	public static void rollback(){
		try{
			getConnection().rollback();
		}catch(SQLException e){
			e.printStackTrace();
		}
	}
	
//	关闭数据库连接对象
	public static void close(){
		try{
			if(rs!=null){
				rs.close();
				
			}
			if(s!=null){
				s.close();
			}
			if(conn!=null){
				conn.close();
			}
		}catch(SQLException e){
			e.printStackTrace();;
		}
	}
	
}
