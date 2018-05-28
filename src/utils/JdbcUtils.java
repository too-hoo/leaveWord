package utils;

import javax.sql.DataSource;

import org.apache.commons.dbutils.QueryRunner;

import com.mchange.v2.c3p0.ComboPooledDataSource;

/**
 * 工具类
 * 1.初始化C3P0连接池
 * 2.创建DBUtils核心工具类对象
 * @author toohoo
 *
 */
public class JdbcUtils {

	/**
	 * 1.初始化C3P0连接池
	 */
	private static DataSource dataSource;   //记得导入正确的包
	static{
		dataSource = new ComboPooledDataSource();
	}
	
	/**
	 * 2.创建DBUtils核心工具类对象
	 * @return
	 */
	public static QueryRunner getQueryRunner(){
		//创建QueryRunner对象，传入连接池对象
		//在创建QueryRunner对象的时候，如果传入了数据源对象
		//那么在使用QueryRunner对象方法时候，就不要传入连接对象
		//会自动从数据源中获取连接（不用关闭连接）
		return new QueryRunner(dataSource);
	}
	
	
	
}
