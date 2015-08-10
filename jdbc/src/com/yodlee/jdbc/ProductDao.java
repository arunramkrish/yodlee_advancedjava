package com.yodlee.jdbc;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class ProductDao {
	public void create(String name, float price) {
		Connection connection = null;
		PreparedStatement stmt = null;
		try {
			connection = DatabaseUtil.getConnection();
			
			String sql = "INSERT INTO PRODUCT(name,price) values(?, ?)";
			
			stmt = connection.prepareStatement(sql);
			stmt.setDate(4, new Date(new java.util.Date().getTime()));
			stmt.setString(1, name);
			stmt.setFloat(2, price);
			
			int rows = stmt.executeUpdate();
			
			System.out.println("inserted successfully" + rows);
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DatabaseUtil.releaseResources(connection, stmt, null);
		}
	}
	
	public void readProducts()  {
		Connection connection = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;
		try {
			connection = DatabaseUtil.getConnection();
			
			String sql = "SELECT name,price FROM PRODUCT";
			
			stmt = connection.prepareStatement(sql);
			
			rs = stmt.executeQuery();
			while (rs.next()) {
				System.out.println(rs.getString("name") + " " + rs.getFloat("price"));
			}
			
			System.out.println("fetched successfully");
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DatabaseUtil.releaseResources(connection, stmt, rs);
		}
	}
	public static void main(String[] args) {
		new ProductDao().create("prod1", 99.9F);
		
		new ProductDao().readProducts();
	}
}
