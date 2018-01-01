package com.zyy.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.zyy.bean.CollectionBean;
import com.zyy.dao.CollDao;
import com.zyy.dao.impl.CollDaoImpl;

/**
 * Servlet implementation class CollectionServlet
 */
@WebServlet("/CollectionServlet")
public class CollectionServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CollectionServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//response.getWriter().append("Served at: ").append(request.getContextPath());
		String action = request.getParameter("action");
		if(action != null && action.equals("save")) {
			save(request, response);
		}else if(action != null && action.equals("list")) {
			list(request, response);
		}else if(action != null && action.equals("get")) {
			get(request, response);
		}else if(action != null && action.equals("update")) {
			update(request, response);
		}else if(action != null && action.equals("delete")) {
			delete(request, response);
		}else {
			
		}
	}
	
	protected void save(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//response.getWriter().append("Served at: ").append(request.getContextPath());
		String name = request.getParameter("name");
		String url = request.getParameter("url");
		
		CollDao dao = new CollDaoImpl();
		CollectionBean bean = new CollectionBean();
		bean.setName(name);
		bean.setUrl(url);
		dao.save(bean);
		
		list(request, response);
	}
	
	protected void list(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//response.getWriter().append("Served at: ").append(request.getContextPath());
		
		CollDao dao = new CollDaoImpl();
		List list = dao.list();
		request.setAttribute("CL", list);
		
		request.getRequestDispatcher("/Collection.jsp").forward(request, response);
	}
	
	protected void get(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//response.getWriter().append("Served at: ").append(request.getContextPath());
		String id = request.getParameter("id");
		
		CollDao dao = new CollDaoImpl();
		
		CollectionBean bean = dao.get(new Integer(id));
		request.setAttribute("CollectionBean", bean);
		
		request.getRequestDispatcher("/CollectionEdit.jsp").forward(request, response);
	}
	
	protected void update(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//response.getWriter().append("Served at: ").append(request.getContextPath());
		String id = request.getParameter("id");
		String name = request.getParameter("name");
		String url = request.getParameter("url");
		CollectionBean bean = new CollectionBean();
		bean.setId(new Integer(id));
		bean.setName(name);
		bean.setUrl(url);
		
		CollDao dao = new CollDaoImpl();
		dao.update(bean);
		
		list(request, response);
	}
	
	protected void delete(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//response.getWriter().append("Served at: ").append(request.getContextPath());
		String[] ids = request.getParameterValues("ids");
		
		CollDao dao = new CollDaoImpl();
		dao.delete(ids);
		
		list(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
