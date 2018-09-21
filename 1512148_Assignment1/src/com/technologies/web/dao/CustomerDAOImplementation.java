package com.technologies.web.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import com.technologies.web.model.CustomerItem;
import com.technologies.web.model.Item;
import com.technologies.web.utils.DBUtil;

public class CustomerDAOImplementation implements CustomerDAO{

	private Connection conn;

	public CustomerDAOImplementation() {
		conn = DBUtil.getConnection();
	}

	@Override
	public void OrderItemByCustomer(CustomerItem item) {
		// TODO Auto-generated metho
		try {
				String query = "insert into item_customer (item_id,cust_first_name,cust_last_name) values (?,?,?)";
				PreparedStatement preparedStatement = conn.prepareStatement( query );
				preparedStatement.setString( 1, item.getItemId());
				preparedStatement.setString( 2, item.getFirstName());
				preparedStatement.setString( 3, item.getLastName());
				
				preparedStatement.executeUpdate();
				preparedStatement.close();
				
			} 
			catch (SQLException e) {
				e.printStackTrace();
			}

		}


		
	}


