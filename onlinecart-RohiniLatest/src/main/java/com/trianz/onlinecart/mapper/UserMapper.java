package com.trianz.onlinecart.mapper;


import java.sql.ResultSet;
import java.sql.SQLException;
import org.springframework.jdbc.core.RowMapper;

import com.trianz.onlinecart.bean.User;

public class UserMapper implements RowMapper<User> {
   public User mapRow(ResultSet rs, int rowNum) throws SQLException {
      User user = new User();
      if(rs!=null) { 
    	  System.out.println("rs not null");
	      user.setUserId(rs.getInt("user_id"));
	      user.setUserEmail(rs.getString("user_email"));
	      user.setPassword(rs.getString("user_password"));
	      user.setFirstName(rs.getString("user_first_name"));
	      user.setLastName(rs.getString("user_last_name"));
      }
      return user;
   }
}
    