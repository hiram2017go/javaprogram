package com.zyy.struts.action;

import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.upload.FormFile;

import com.zyy.struts.form.UploadForm;

public class UploadAction extends Action {

	@Override
	public ActionForward execute(ActionMapping mapping, ActionForm form, HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		System.out.println("-----------------------");
		// TODO Auto-generated method stub
		UploadForm uploadForm = (UploadForm)form;
		FormFile ff = uploadForm.getFile();
		try {
			InputStream in = ff.getInputStream();
			String fileName = ff.getFileName();
			int size = ff.getFileSize();
			String path = super.servlet.getServletContext().getRealPath("/upload");
			System.out.println(path+"\\"+fileName);
			OutputStream out = new FileOutputStream(path+"\\"+fileName);
			byte[] buf = new byte[size];
			in.read(buf);
			out.write(buf);
			in.close();
			out.close();
		}catch(Exception ex) {
			
		}
		
		return null;
	}

}
