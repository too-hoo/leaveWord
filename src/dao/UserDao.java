package dao;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;

import beans.User;
import utils.JdbcUtils;


public class UserDao {
	
	/**
	 * 
	 * @param username
	 * @param password
	 * @return
	 * @throws Exception
	 */
	public User getByUsernameAndPwd(String username, String password) throws Exception {
		QueryRunner qr = JdbcUtils.getQueryRunner();
		String sql = " select * from t_user where name = ? and password = ?";
		
		return qr.query(sql, new BeanHandler<>(User.class), username,password);
	}
}
