package pdsu.hrms.dao;

import java.sql.*;

public class JDBCUtil {
	private static final String DRIVER="com.mysql.jdbc.Driver";
	private static final String URI = "jdbc:mysql://localhost:3306/deptinfo";
	private static final String USER_NAME ="root";
	private static final String USER_PASS = "root";
	private static Connection coon;
	private static Statement state;
	static {
		try {
			Class.forName(DRIVER);
		}catch (Exception e) {
			// TODO: handle exception
			System.out.println("数据库加载驱动异常");
			e.printStackTrace();
		}
	}
	public static Statement getConnection() {
		try {
			coon = DriverManager.getConnection(URI, USER_NAME, USER_PASS);
		}catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			System.out.println("数据库连接失败");
		}
		try {
			state= coon.createStatement();
		}catch (Exception e) {
			// TODO: handle exception
			System.out.println("statement创建失败");
			e.printStackTrace();
		}
		return state;
	}
	//关闭结果集
	public static void close (ResultSet rs) {
		try {
			if(rs!=null)rs.close();
		}catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}
  	//关闭语句
	public static void close (PreparedStatement ps) {
		try {
			if(ps!=null)ps.close();
		}catch (Exception e) {
			e.printStackTrace();
		}
	}
	//关闭语句
	public static void close(Connection coon) {
		try{
		   if(coon!=null)coon.close();
		}catch (Exception e) {
		   e.printStackTrace();
	}
	}
}
