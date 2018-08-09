package com.trianz.onlinecart.dao;

import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import org.apache.log4j.Logger;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.stereotype.Component;

import com.trianz.onlinecart.bean.Product;
import com.trianz.onlinecart.bean.User;
import com.trianz.onlinecart.mapper.ProductMapper;
import com.trianz.onlinecart.mapper.UserMapper;

@ComponentScan(basePackages = {"com.trianz.onlinecart","com.trianz.onlinecart.dao"})
@Component
public class OnlineCartDaoImpl implements OnlineCartDao {
	
	private final static Logger logger = Logger.getLogger(OnlineCartDaoImpl.class);

//	@Autowired
	private DataSource dataSource = null;
	private JdbcTemplate jdbcTemplate;
    
	public void setDataSource(DataSource dataSource) {
		this.dataSource = dataSource;
		this.jdbcTemplate = new JdbcTemplate(dataSource);
	}
	
	private JdbcTemplate onlineJdbcTemplate() {
		DriverManagerDataSource ds = new DriverManagerDataSource();
		ds.setDriverClassName("com.mysql.cj.jdbc.Driver");
		ds.setUrl("jdbc:mysql://localhost:3306/online_cart");
		ds.setUsername("root");
		ds.setPassword("admin");
		JdbcTemplate jt = new JdbcTemplate(ds);
		return jt;
	}

	@Override
	public User getUser(String name) throws Exception {
//		jdbcTemplate = new JdbcTemplate(dataSource);
		logger.debug("Inside OnlineCartDaoImpl => getUser <=> user:" + name);
		String SQL = "SELECT * FROM user WHERE user_email = ?";
		logger.debug("Before query execution");
		User user = null;
		try {
			user = (User) onlineJdbcTemplate().queryForObject(SQL, new Object[] { name }, new UserMapper());
//			user = (User) this.jdbcTemplate.queryForObject(SQL, new Object[] { name }, new UserMapper());

		} catch (EmptyResultDataAccessException erdae) {
			logger.error("EmptyResultDataAccessException while query execution");
			throw new Exception();
		} catch (Exception e) {
			logger.error("Generic other Exception while query execution" + e);
			throw new Exception();
		} 
		logger.debug("After query execution");
		return user;
	}

	@Override
    public boolean registerUser(User user) throws Exception {  
		logger.debug("Inside OnlineCartDaoImpl => registerUser <=> user:" + user.getUserEmail()); 	
    	String SQL = "INSERT INTO user (user_email,user_password,user_first_name,user_last_name,user_role)"+
                "VALUES (?, ?, ?, ?, ?)";
        // Defines the query arguments and the corresponding SQL types
        // of the arguments.
        String[] params = new String[5];
        params[0] = user.getUserEmail();
        params[1] = user.getPassword();
        params[2] = user.getFirstName();
        params[3] = user.getLastName();
        params[4] = "customer";
        onlineJdbcTemplate().update(SQL, params);
//      jdbcTemplate.update(SQL, params);
        logger.debug("row inserted.");
        return true;     
    }
    
	@Override
	public boolean updateUser(User user) throws Exception {
		logger.debug("Inside OnlineCartDaoImpl => updateUser <=> user:" + user.getUserEmail());
		String SQL = "UPDATE user set user_city = ?, user_state = ?, user_country = ?, user_address1 = ?, user_address2 = ? , user_phone = ?  where user_email = '" + user.getUserEmail() + "'";
		String[] params = new String[6];
        params[0] = user.getUserCity();
        params[1] = user.getUserState();
        params[2] = user.getUserCountry();
        params[3] = user.getUserAddress1();
        params[4] = user.getUserAddress2();
        params[5] = user.getUserPhone();
        onlineJdbcTemplate().update(SQL, params);
        logger.debug("row updated.");
        return true;    
	}
	
	@Override
	public List<Product> getAllProducts() throws Exception {
		List<Product> productList = new ArrayList<Product>();
		logger.debug("Inside ProductJDBCTemplate=>getAllProducts()");
		String SQL = "SELECT * FROM product";
		logger.debug("Before query execution");
		try {
			productList = (List<Product>) onlineJdbcTemplate().queryForObject(SQL, new ProductMapper());
//			productList = (List<Product>) this.jdbcTemplate.queryForObject(SQL, new ProductMapper());
		} catch (EmptyResultDataAccessException erdae) {
			logger.error("EmptyResultDataAccessException while query execution");
			throw new Exception();
		} catch (Exception e) {
			logger.error("Generic other Exception while query execution");
			throw new Exception();
		} 
		logger.debug("After query execution");
		return productList;
	}
	
	@Override
	public List<String> getProductCategories() throws Exception {
		logger.debug("Inside ProductJDBCTemplate=getProductCategories()");
		String SQL = "SELECT DISTINCT(category_name) FROM product";
		logger.debug("Before query execution");
		List<String> categories = new ArrayList<String>();
		try {
			categories = onlineJdbcTemplate().queryForList(SQL, String.class);
//			categories = this.jdbcTemplate.queryForList(SQL, String.class);
		} catch (EmptyResultDataAccessException erdae) {
			logger.error("EmptyResultDataAccessException while query execution");
			throw new Exception();
		} catch (Exception e) {
			logger.error("Generic other Exception while query execution");
			throw new Exception();
		} 
		logger.debug("After query execution");
		return categories;
	}




}
