package com.zyy.tag;

import java.io.IOException;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.JspWriter;
import javax.servlet.jsp.PageContext;
import javax.servlet.jsp.tagext.Tag;

public class HelloTag implements Tag {

	private Tag tag;
	private PageContext pageContext = null;
	@Override
	//标签结束的时候该怎样
	public int doEndTag() throws JspException {
		String str = "Hello JSP Tag!";
		JspWriter out = pageContext.getOut();
		
		try {
			out.println(str);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return this.EVAL_PAGE;//标签已执行，下边的内容还要继续计算
	}

	@Override
	//标签开始的时候该怎样
	public int doStartTag() throws JspException {
		// TODO Auto-generated method stub
		return this.SKIP_BODY;//执行body
	}

	@Override
	public Tag getParent() {
		// TODO Auto-generated method stub
		return this.tag;
	}

	@Override
	public void release() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void setPageContext(PageContext pageContext) {
		// TODO Auto-generated method stub
		this.pageContext = pageContext;
	}

	@Override
	public void setParent(Tag tag) {
		// TODO Auto-generated method stub
		this.tag = tag;
	}

}
