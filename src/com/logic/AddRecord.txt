package com.logic;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/addrecord")
public class AddRecord extends HttpServlet {
	private static final long serialVersionUID = 1L;

	
	public AddRecord() {
		super();
		
	}

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		RequestDispatcher r = request.getRequestDispatcher("master.html");
		r.include(request, response);
		out.println("<br>");
		out.println("<form name='frm' action='' method='GET'>");
		out.println("<table align='center' width='50%'>");
		out.println("<tr>");
		out.println("<td>NAME</td>");
		out.println("<td><input type='text' name='name' value=''/></td>");
		out.println("</tr>");

		out.println("<tr>");
		out.println("<td>EMAIL</td>");
		out.println("<td><input type='text' name='email' value=''/></td>");
		out.println("</tr>");

		out.println("<tr>");
		out.println("<td>CONTACT</td>");
		out.println("<td><input type='text' name='contact' value=''/></td>");
		out.println("</tr>");
		out.println("<tr>");

		out.println("<td colspan='2' align='center'><input type='submit' name='s' value='Add New Record'/></td>");
		out.println("</tr>");
		out.println("</table>");
		out.println("</form>");
		
		String button=request.getParameter("s");
		if(button!=null)
		{
			String uname=request.getParameter("name");
			String uemail=request.getParameter("email");
			String ucontact=request.getParameter("contact");
			try
			{
				 DBUtil d=new DBUtil();
				 boolean b=d.isAddRecord(uname,uemail,ucontact);
				 if(b)
				 {
					 out.println("<center>Record Save Success....</center>");
				 }
				 else
				 {
					 out.println("<center>Some Problem is there....</center>");
				 }
				 
			}
			catch(Exception e)
			{
				out.println("Error is "+e);
			}
		}
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
