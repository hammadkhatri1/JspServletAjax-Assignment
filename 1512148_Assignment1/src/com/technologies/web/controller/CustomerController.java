package com.technologies.web.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.technologies.web.dao.AdminDAOImplementation;
import com.technologies.web.dao.CustomerDAOImplementation;
import com.technologies.web.model.CustomerItem;
import com.technologies.web.model.Item;

/**
 * Servlet implementation class CustomerController
 */
@WebServlet("/CustomerController")
public class CustomerController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
	private AdminDAOImplementation admindao;
	private CustomerDAOImplementation customerDao;
	   
    public CustomerController() {
    	admindao=new AdminDAOImplementation();
    	customerDao =new CustomerDAOImplementation();
 // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.setAttribute("item", admindao.getList());
		getServletContext().getRequestDispatcher("/customer.jsp").forward(request, response);
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		String action=request.getParameter("action");
		if(action.equals("Order")) {
			
			CustomerItem ci=new CustomerItem();
			
			ci.setFirstName(request.getParameter("customerFirstName"));
			ci.setLastName(request.getParameter("customerLastName"));
			ci.setItemId(request.getParameter("itemId"));
			
			customerDao.OrderItemByCustomer(ci);
		}
		
	}
}
