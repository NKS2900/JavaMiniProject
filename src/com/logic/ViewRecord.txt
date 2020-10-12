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
 * Servlet implementation class ViewRecord
 */
@WebServlet("/view")
public class ViewRecord extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public ViewRecord() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		RequestDispatcher r = request.getRequestDispatcher("master.html");
		r.include(request, response);
		out.println("<br/>");
		try {
			DBUtil db = new DBUtil();
			java.sql.ResultSet rs = db.getAllRecords();
			out.println("<table width='60%' border='5' align='center'>");
			out.println("<tr><th>NAME</th><th>EMAIL</th><th>CONTACT</th><th>DELETE</th><th>UPDATE</th></tr>");
			while (rs.next()) {
				String n = rs.getString(2);
				String e = rs.getString(3);
				String c = rs.getString(4);
				out.println("<tr>");
				out.println("<td>" + n + "</td>");
				out.println("<td>" + e + "</td>");
				out.println("<td>" + c + "</td>");
				out.println("<td><a href=''>Delete Record</a></td>");
				out.println("<td><a href=''>Update Record</td>");

				out.println("</tr>");

			}
			out.println("</table>");
		} catch (Exception e) {
			out.println("Error is " + e);
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
