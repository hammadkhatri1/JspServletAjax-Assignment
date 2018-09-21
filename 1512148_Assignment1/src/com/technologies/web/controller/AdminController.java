package com.technologies.web.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.technologies.web.dao.AdminDAOImplementation;
import com.technologies.web.model.Item;

/**
 * Servlet implementation class admin
 */
@WebServlet("/AdminController")
public class AdminController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
	private AdminDAOImplementation dao;
    
    public AdminController() {
        super();
     	dao = new AdminDAOImplementation();
     	  
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		request.setAttribute("item", dao.getList());
		getServletContext().getRequestDispatcher("/admin.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String action=request.getParameter("action");

    	if(action.equals("insertItem")) {
			
			Item item =new Item();
			
			String name=request.getParameter("itemName");
			
			item.setItem_name(name);
			
			dao.addItem(item);	
		
		}else if (action.equals("deleteItem")) {
			
			String id=request.getParameter("id");
			dao.DeleteItem(Integer.parseInt(id));	
			
		}
		else if(action.equals("updateItem")) {
			
			Item item =new Item();
			
			String id=request.getParameter("itemId");
			String name=request.getParameter("itemNamee");
			
			item.setItemId(id);
			item.setItem_name(name);
			dao.updateItem(item);	
		}
		else if(action.equals("SearchItem")) {
			
			String searchText=request.getParameter("searchText");
			
			request.setAttribute("item", dao.Search(searchText));
			getServletContext().getRequestDispatcher("/admin.jsp").forward(request, response);
		
		}
    	
	}


}
