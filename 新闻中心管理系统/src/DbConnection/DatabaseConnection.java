package DbConnection;
import java.sql.*;
public class DatabaseConnection {
	

	
//	����jdbc����ض���
	protected static Statement s = null;
	protected static ResultSet rs = null;
	protected static Connection conn = null;
	
//	�������ݿ�����
	public static synchronized Connection getConnection(){
		try{
			Class.forName("com.mysql.jdbc.Driver");
			conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/newssystem","root","root");
			
		}catch(Exception e){
			e.printStackTrace();
		}
		return conn;
	}
	 
//	ִ��update���
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
//	ִ��select���
	public static ResultSet executeQuery(String sql){
		try{
			s = getConnection().createStatement();
			rs = s.executeQuery(sql);
		}catch(SQLException e){
			e.printStackTrace();
		}
		return rs;
	}
	
//	ִ�ж�̬sql���
	public static PreparedStatement executePreparedStatement(String sql){
		PreparedStatement ps = null;
		try{
			
			ps = getConnection().prepareStatement(sql);
			
		}catch(Exception e){
			e.printStackTrace();
		}
		return ps;
	}
	
//	����ع�
	public static void rollback(){
		try{
			getConnection().rollback();
		}catch(SQLException e){
			e.printStackTrace();
		}
	}
	
//	�ر����ݿ����Ӷ���
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
