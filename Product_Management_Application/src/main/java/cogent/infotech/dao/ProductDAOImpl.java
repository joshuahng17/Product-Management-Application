package cogent.infotech.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Date;

import cogent.infotech.jdbc.JDBCUtils;

public class ProductDAOImpl implements ProductDAO{

	public void addProduct(int pid, String pname, String pcat, Date manufacture_date, int price, Date expiry_date) {
		try (Connection connection = JDBCUtils.getConnection()){	
			String addSQL = "Insert into product"+
					"(id, name, category, manufacture_date, price, expiry_date) VALUES"+
					"(?, ?, ?, ?, ?, ?)";
			PreparedStatement pstmt = connection.prepareStatement(addSQL);
			pstmt.setInt(1, pid);
			pstmt.setString(2, pname);
			pstmt.setString(3, pcat);
			pstmt.setDate(4, manufacture_date);
			pstmt.setInt(5, price);
			pstmt.setDate(6, expiry_date);
			int count = pstmt.executeUpdate();
			if(count>0) {
				System.out.println("Record added into DB");
			}
			else {
				System.out.println("Failed");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public void deleteProductById(int pid) {
		try (Connection connection = JDBCUtils.getConnection()){
			String deleteSQL = "Delete from product where id = ?";
			PreparedStatement pstmt = connection.prepareStatement(deleteSQL);
			pstmt.setInt(1, pid);
			int count = pstmt.executeUpdate();
			if(count > 0) {
				System.out.println("Record(s) deleted");
			}
			else {
				System.out.println("Failed/Product not found");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}

	public void deleteProductByCat(String pcat) {
		try (Connection connection = JDBCUtils.getConnection()){
			String deleteSQL = "Delete from product where category = ?";
			PreparedStatement pstmt = connection.prepareStatement(deleteSQL);
			pstmt.setString(1, pcat);
			int count = pstmt.executeUpdate();
			if(count > 0) {
				System.out.println("Record(s) deleted");
			}
			else {
				System.out.println("Failed/Product not found");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}

	public void findCheapestProductInCat(String pcat) {
		try (Connection connection = JDBCUtils.getConnection()){
			String selectSQL = "Select * from product where category = ? AND price = (Select MIN(price) from product where category = ?)";
			PreparedStatement pstmt = connection.prepareStatement(selectSQL);
			pstmt.setString(1, pcat);
			pstmt.setString(2, pcat);
			ResultSet rs = pstmt.executeQuery();
			while(rs.next()) {
				System.out.println("ID: "+rs.getInt(1));
				System.out.println("Name: "+rs.getString(2));
				System.out.println("Category: "+rs.getString(3));
				System.out.println("Manufacture Date: "+rs.getDate(4));
				System.out.println("Price: "+rs.getInt(5));
				System.out.println("Expiry Date: "+rs.getDate(6));
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void findProductByCat(String pcat) {
		try (Connection connection = JDBCUtils.getConnection()){
			String selectSQL = "Select * from product where category = ?";
			PreparedStatement pstmt = connection.prepareStatement(selectSQL);
			pstmt.setString(1, pcat);
			ResultSet rs = pstmt.executeQuery();
			while(rs.next()) {
				System.out.println("ID: "+rs.getInt(1));
				System.out.println("Name: "+rs.getString(2));
				System.out.println("Category: "+rs.getString(3));
				System.out.println("Manufacture Date: "+rs.getDate(4));
				System.out.println("Price: "+rs.getInt(5));
				System.out.println("Expiry Date: "+rs.getDate(6));
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void findProductById(int pid) {
		try (Connection connection = JDBCUtils.getConnection()){
			String selectSQL = "Select * from product where id = ?";
			PreparedStatement pstmt = connection.prepareStatement(selectSQL);
			pstmt.setInt(1, pid);
			ResultSet rs = pstmt.executeQuery();
			while(rs.next()) {
				System.out.println("ID: "+rs.getInt(1));
				System.out.println("Name: "+rs.getString(2));
				System.out.println("Category: "+rs.getString(3));
				System.out.println("Manufacture Date: "+rs.getDate(4));
				System.out.println("Price: "+rs.getInt(5));
				System.out.println("Expiry Date: "+rs.getDate(6));
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void updateProduct(String pname, int newPrice) {
		try (Connection connection = JDBCUtils.getConnection()){
			String updateSQL = "update product set price = ? where name = ?";
			PreparedStatement pstmt = connection.prepareStatement(updateSQL);
			pstmt.setInt(1, newPrice);
			pstmt.setString(2, pname);
			int count = pstmt.executeUpdate();
			if(count > 0) {
				System.out.println("Record(s) updated");
			}
			else {
				System.out.println("Failed/Product not found");
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void findExpiredProducts() {
		try (Connection connection = JDBCUtils.getConnection()){
			String selectSQL = "Select * from product where expiry_date <= current_date()";
			PreparedStatement pstmt = connection.prepareStatement(selectSQL);
			ResultSet rs = pstmt.executeQuery();
			while(rs.next()) {
				System.out.println("ID: "+rs.getInt(1));
				System.out.println("Name: "+rs.getString(2));
				System.out.println("Category: "+rs.getString(3));
				System.out.println("Manufacture Date: "+rs.getDate(4));
				System.out.println("Price: "+rs.getInt(5));
				System.out.println("Expiry Date: "+rs.getDate(6));
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
