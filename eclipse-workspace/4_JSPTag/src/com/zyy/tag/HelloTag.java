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
	//��ǩ������ʱ�������
	public int doEndTag() throws JspException {
		String str = "Hello JSP Tag!";
		JspWriter out = pageContext.getOut();
		
		try {
			out.println(str);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return this.EVAL_PAGE;//��ǩ��ִ�У��±ߵ����ݻ�Ҫ��������
	}

	@Override
	//��ǩ��ʼ��ʱ�������
	public int doStartTag() throws JspException {
		// TODO Auto-generated method stub
		return this.SKIP_BODY;//ִ��body
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
