package com.technologies.web.dao;


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;

import com.technologies.web.model.Item;
import com.technologies.web.utils.DBUtil;

public class AdminDAOImplementation implements AdminDAO{

	private Connection conn;

	public AdminDAOImplementation() {
		conn = DBUtil.getConnection();
	}

	
	@Override
	public void addItem(Item item) {
		try {
			String query = "insert into item (item_name) values (?)";
			PreparedStatement preparedStatement = conn.prepareStatement( query );
			preparedStatement.setString( 1, item.getItem_name());
			
			preparedStatement.executeUpdate();
			preparedStatement.close();
			
		} 
		catch (SQLException e) {
			e.printStackTrace();
		}

	}

	@Override
	public void updateItem(Item item) {
		
		try 
	
	{
		PreparedStatement ps = conn.prepareStatement("update item set item_name=? where item_id=?");
		
		ps.setString(1, item.getItem_name());
		ps.setString(2, item.getItemId());
		
		ps.execute();
		ps.close();
	}catch(Exception h) {
		h.printStackTrace();

	}
	}

	@Override
	public void DeleteItem(int id) {
		try {
			String query="Delete from item where item_id=?";
			PreparedStatement prepStat=conn.prepareStatement(query);
			prepStat.setLong(1,id);
			prepStat.executeUpdate();
			prepStat.close();
		}catch(Exception g) {
			g.printStackTrace();
		}
	}

	@Override
	public List<Item> Search(String text) {
		
		List<Item> itemsArraylist = new ArrayList<Item>();
		
	    try {
	    	String query="select * from item where item_name like ?";
	       PreparedStatement prepStat=conn.prepareStatement(query);
	    	prepStat.setString(1,text + "%");
	    	 ResultSet rs = prepStat.executeQuery();
		    	
	    	 while(rs.next())
	    	 {
	            Item itm = new Item();

	            itm.setItemId(rs.getString(1));
	            itm.setItem_name(rs.getString(2));	
	            
	            itemsArraylist.add(itm);

	        }
	    }catch (SQLException e) {

	        e.printStackTrace();
	    }
	    return itemsArraylist;

	}


	@Override
	public List<Item> getList() {
		List<Item> itemsArraylist = new ArrayList<Item>();
			
	    try {
	        Statement statement = conn.createStatement();
	        ResultSet rs = statement.executeQuery("select * from item");
	        while(rs.next())
	        {
	            Item itm = new Item();

	            itm.setItemId(rs.getString(1));
	            itm.setItem_name(rs.getString(2));	
	            
	            itemsArraylist.add(itm);

	        }
	    }catch (SQLException e) {

	        e.printStackTrace();
	    }
	    return itemsArraylist;
	}


	

}
