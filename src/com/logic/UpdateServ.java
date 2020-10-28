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
 * Servlet implementation class UpdateServ
 */
@WebServlet("/upd")
public class UpdateServ extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public UpdateServ() {
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
		String rvalue = request.getParameter("rid");
		int rid = Integer.parseInt(rvalue);
		try {
			RequestDispatcher r = request.getRequestDispatcher("master.html");
			r.include(request, response);
			out.println("<br>");
			DBUtil db = new DBUtil();
			java.sql.ResultSet rs = db.getRecordById(rid);
			if (rs.next()) {
				out.println("<form name='frm' action='fupd' method='GET'>");
				out.println("<table border='5' align='center'>");
				out.println("<tr><td colspan='2' align='center'><input type='hidden' name='rid' value='" + rs.getInt(1)
						+ "'/></td></tr>");
				out.println("<tr><td>NAME</td><td><input type='text' name='name' value='" + rs.getString(2)
						+ "'/></td></tr>");
				out.println("<tr><td>EMAIL</td><td><input type='text' name='email' value='" + rs.getString(3)
						+ "'/></td></tr>");
				out.println("<tr><td>CONTACT</td><td><input type='text' name='contact' value='" + rs.getString(4)
						+ "'/></td></tr>");
				out.println(
						"<tr><td colspan='2' align='center'><input type='submit' name='s' value='Update Record'/></td></tr>");

				out.println("</table>");
				out.println("</form>");
			}

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
