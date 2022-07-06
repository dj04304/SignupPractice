package domain.dao;

import domain.entity.User;

public interface UserDao {
	public int userSave(User user) throws Exception;
	public User findUserByUsername() throws Exception;
	public int modifyUserByUsername(int user_code) throws Exception;
	public int remove(int user_code) throws Exception;
}
