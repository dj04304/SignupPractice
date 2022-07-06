package domain.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import domain.entity.User;
import domain.jdbc.DBConnectionMgr;

public class UserDaoImpl implements UserDao{
	
	private String sql;
	
	private DBConnectionMgr pool;
	private Connection con;
	private PreparedStatement pstmt;
	private ResultSet rs;
	
	public UserDaoImpl() {
		pool = DBConnectionMgr.getInstance();
	}

	@Override
	public int userSave(User user) throws Exception {
		int result = 0;
		
		sql = "INSERT INTO\r\n"
				+ "	user_mst\r\n"
				+ "VALUES(\r\n"
				+ "	0,\r\n"
				+ "	?,\r\n"
				+ "	?,\r\n"
				+ "	?,\r\n"
				+ "	?,\r\n"
				+ "	?,\r\n"
				+ "	?,\r\n"
				+ "	NOW(),\r\n"
				+ "	NOW()\r\n"
				+ ");	";
		
		con = pool.getConnection(); //데이터 베이스 연결
		try {
			pstmt = con.prepareStatement(sql); //해당 데이터베이스에 쿼리문을 전달
			pstmt.setString(1, user.getName());
			pstmt.setString(2, user.getEmail());
			pstmt.setString(3, user.getUsername());
			pstmt.setString(4, user.getPasword());
			pstmt.setString(5, user.getRoles());
			pstmt.setString(6, user.getProvider());
			result = pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			pool.freeConnection(con, pstmt);
		}
		
		return result;
	}

	@Override
	public User findUserByUsername() throws Exception {
		return null;
	}

	@Override
	public int modifyUserByUsername(int user_code) throws Exception {
		return 0;
	}

	@Override
	public int remove(int user_code) throws Exception {
		return 0;
	}

}
