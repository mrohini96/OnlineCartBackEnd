package com.trianz.onlinecart.mapper;
import java.sql.ResultSet;
	import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.jdbc.core.RowMapper;

import com.trianz.onlinecart.bean.*;

public class ProductMapper implements RowMapper<List<Product>> {
	public List<Product> mapRow(ResultSet rs, int rowNum) throws SQLException {
		List<Product> productList = new ArrayList<Product>();
		do {
			Product product = new Product();
			product.setProductId(rs.getInt("product_id"));
			product.setProductName(rs.getString("product_name"));
			product.setProductPrice(rs.getFloat("product_price"));
			product.setCategoryName(rs.getString("category_name"));
			productList.add(product);
		} while (rs.next());
		return productList;
	}
}

