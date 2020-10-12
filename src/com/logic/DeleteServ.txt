package com.logic;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class DeleteServ
 */
@WebServlet("/del")
public class DeleteServ extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DeleteServ() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	   response.setContentType("text/html");
	   PrintWriter out=response.getWriter();
	   out.println("I am delete servlet");
	   String rvalue=request.getParameter("rid");
	   int rid=Integer.parseInt(rvalue);
	   try
	   {
		     DBUtil db=new DBUtil();
		     boolean b=db.isDelete(rid);
		     if(b)
		     {
		    	RequestDispatcher r=request.getRequestDispatcher("view");
		    	r.forward(request, response);
		     }
		     else
		     {
		    	 out.println("<h1>Some problem is there</h1>");
		     }
	   }
	   catch(Exception e)
	   {
		   out.println("Error is "+e);
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
