package com.zyy.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.zyy.beans.Customer;
import com.zyy.dao.CustomerDao;
import com.zyy.dao.impl.CustomerImpl;

/**
 * Servlet implementation class ItemServlet
 */
@WebServlet("/ItemServlet")
public class ItemServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ItemServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//response.getWriter().append("Served at: ").append(request.getContextPath());
		//System.out.print("name=========------------=======");
		String name = request.getParameter("name");
		String city = request.getParameter("email");
		
		//System.out.print("name========================"+name);
		Customer c = new Customer();
		c.setName(name);
		c.setCity(city);
		
		CustomerDao cl = (CustomerDao) new CustomerImpl();
		try {
			cl.Save(c);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		//已完成数据插入
		List list = null;
		try {
			list = cl.list();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		PrintWriter out = response.getWriter();
		
		for(int i = 0;i < list.size(); i++) {
			Customer cu = (Customer)list.get(i);
			int id = cu.getId();
			String myName = cu.getName();
			String myCity = cu.getCity();
			
			out.println("id="+id+";name="+myName+";city="+myCity+"</br>");
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
