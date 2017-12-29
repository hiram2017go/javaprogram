package com.zyy.tag;

import java.io.IOException;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.tagext.TagSupport;

public class HelloTag2 extends TagSupport {

	@Override
	public int doEndTag() throws JspException {
		String str = "Hello JSP Tag2!";
		try {
			pageContext.getOut().println(str);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return super.doEndTag();
	}

}
