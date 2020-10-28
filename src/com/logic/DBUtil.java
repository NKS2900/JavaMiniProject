package com.logic;

import java.sql.*;

public class DBUtil {
	private Connection conn;
	private PreparedStatement stmt;
	private ResultSet rs;

	public DBUtil() throws Exception {
		Class.forName("com.mysql.jdbc.Driver");
		conn = DriverManager.getConnection("jdbc:mysql://localhost:3309/mysql", "root", "root");
	}

	public boolean isAddRecord(String... name) throws Exception {
		stmt = conn.prepareStatement("insert into minireg values('0',?,?,?)");
		stmt.setString(1, name[0]);
		stmt.setString(2, name[1]);
		stmt.setString(3, name[2]);
		int value = stmt.executeUpdate();
		if (value > 0) {
			return true;
		} else {
			return false;
		}

	}

	public ResultSet getAllRecords() throws Exception {
		stmt = conn.prepareStatement("select *from minireg");
		rs = stmt.executeQuery();
		return rs;
	}

	public boolean isDelete(int regid) throws Exception {
		stmt = conn.prepareStatement("delete from minireg where regid=?");
		stmt.setInt(1, regid);
		int value = stmt.executeUpdate();
		if (value > 0) {
			return true;
		} else {
			return false;
		}
	}

	public ResultSet getRecordById(int rid) throws Exception {
		stmt = conn.prepareStatement("select *from minireg where regid=?");
		stmt.setInt(1, rid);
		rs = stmt.executeQuery();
		return rs;
	}

	public boolean updateRecord(int rid, String n, String e, String c) throws Exception {
		stmt = conn.prepareStatement("update minireg set name=?,email=?,contact=? where regid=?");
		stmt.setString(1,n);
		stmt.setString(2, e);
		stmt.setString(3, c);
		stmt.setInt(4, rid);
		int value = stmt.executeUpdate();
		if (value > 0) {
			return true;
		} else {
			return false;
		}
	}
}
