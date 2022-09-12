package com.example.web;

import com.example.model.*;
import javax.servlet.*;
import javax.servlet.http.*;
import java.io.*;
import java.util.*;


public class BeerSelect extends HttpServlet {
  public void doPost(HttpServletRequest request,
                    HttpServletResponse response)
                    throws IOException, ServletException {

    // response.setContentType("text/html");
    // PrintWriter out = response.getWriter();
    // out.println("Beer Selection Advice<br>");
    String c = request.getParameter("color");

    BeerExpert be = new BeerExpert();
    List result = be.getBrands(c);

    request.setAttribute("styles", result);

    // 为JSP实例化一个请求分配器
    RequestDispatcher view = request.getRequestDispatcher("result.jsp");

    view.forward(request, response);

    // for(Object element: result){
    //   out.println("<br>try: " + (String) element);
    // }

  }
}