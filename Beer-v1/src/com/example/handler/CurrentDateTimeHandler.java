package com.example.handler;

import java.util.Calendar;
import javax.servlet.jsp.JspException;
import javax.servlet.jsp.JspWriter;
import javax.servlet.jsp.tagext.TagSupport;

public class CurrentDateTimeHandler extends TagSupport {

  public int doStartTag() throws JspException {
    Date dNow = new Date();
    SimpleDateFormat ft = new SimpleDateFormat("E yyyy.MM.dd 'at' hh:mm:ss a zzz");
    System.out.println("Current Date: " + ft.format(dNow));
    JspWriter out = getJspContext().getOut();
    out.println("<span> " + ft.format(dNow) + "</span>");
    return SKIP_BODY;// will not evaluate the body content of the tag
  }
}

// <span style="color: red; font-size: 12px;">Mon 2016.04.04 at 04:14:09 PM
// PDT</span>