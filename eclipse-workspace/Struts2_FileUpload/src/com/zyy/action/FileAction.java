package com.zyy.action;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;

import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionSupport;

public class FileAction extends ActionSupport {

	private File[] file; //从jsp的form表单中的file封装为此处的file
	
	private String fileContentType;
	
	private String[] fileFileName; //这个属性和fileContentType必须与File这个属性的前缀相同
	
	private String savePath;
	
	
/*	public File getFile() {
		return file;
	}


	public void setFile(File file) {
		this.file = file;
	}
*/

	public String getFileContentType() {
		return fileContentType;
	}


	public void setFileContentType(String fileContentType) {
		this.fileContentType = fileContentType;
	}


	/*public String getFileFileName() {
		return fileFileName;
	}


	public void setFileFileName(String fileFileName) {
		this.fileFileName = fileFileName;
	}
*/

	public File[] getFile() {
		return file;
	}


	public void setFile(File[] file) {
		this.file = file;
	}


	public String[] getFileFileName() {
		return fileFileName;
	}


	public void setFileFileName(String[] fileFileName) {
		this.fileFileName = fileFileName;
	}


	public String getSavePath() {
		savePath = ServletActionContext.getServletContext().getRealPath("//upload");
		System.out.println("savepath="+savePath);
		return savePath;
	}


	public void setSavePath(String savePath) {
		this.savePath = savePath;
	}


	@Override
	public String execute() throws Exception {
		String path = this.getSavePath();
		
		for(int i = 0; i < file.length; i++) {
		String fileName = this.fileFileName[i]; //如果使用this.getFile().getName() 得到的是临时文件夹名
		
		String pathName = path+"\\"+fileName;
		System.out.println("name="+pathName);
		
		FileInputStream in = new FileInputStream(this.getFile()[i]);
		FileOutputStream out = new FileOutputStream(pathName);
		
		byte[] b = new byte[in.available()];
		
		in.read(b);
		out.write(b);
		
		in.close();
		out.close();
		}
		return SUCCESS;
	}
}
