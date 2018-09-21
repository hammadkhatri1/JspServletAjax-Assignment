package com.technologies.web.dao;

import java.util.ArrayList;
import java.util.List;

import com.technologies.web.model.Item;

public interface AdminDAO {

	public List<Item> getList();
	public void addItem( Item item);
	public void updateItem(Item item);
	public void DeleteItem(int sid);
	public List<Item> Search(String text);
}
