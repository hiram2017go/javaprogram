package com.zyy.servlet;

import java.io.File;
import java.io.IOException;
import java.util.Iterator;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileItemFactory;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

/**
 * Servlet implementation class FileServlet
 */
@WebServlet("/FileServlet")
public class FileServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public FileServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doPost(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		System.out.println("doPost");
	
		FileItemFactory factory = new DiskFileItemFactory();
		ServletFileUpload upload = new ServletFileUpload(factory);
		
		try {
			List item = upload.parseRequest(request);
			Iterator iter = item.iterator();
			while(iter.hasNext()) {
				FileItem fileItem = (FileItem)iter.next();
				if(fileItem.isFormField()) { //普通的表单提交
					System.out.print(fileItem.getFieldName()+";"+"fileItem.name="+fileItem.getName()+"\r\n");
				}else {
					System.out.println(fileItem.getFieldName()+";");
					System.out.println(fileItem.getName());
					int idx = fileItem.getName().lastIndexOf("\\");
					String fileName = fileItem.getName().substring(idx);
					String path = this.getServletContext().getRealPath("\\upload");
					System.out.println("path="+path);
					File f = new File(path+"\\"+fileName);
					
					try {
						fileItem.write(f);
					} catch (Exception e) {
						// TODO: handle exception
					}finally {
					}
				}
			}
			
			
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println("出了异常:"+e.getMessage());
		}
	}

}
