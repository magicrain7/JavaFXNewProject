package teamProject;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Database {

	Connection conn = null;
	PreparedStatement pstmt = null;

	public Connection dbconnect() {

		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			conn = DriverManager.getConnection("Jdbc:oracle:thin:@192.168.0.57:1521:xe", "hr", "hr");

		} catch (ClassNotFoundException e1) {
			e1.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();

		}
		return conn;
	}

	public Customer dbcustomer(String str) {
		conn = dbconnect();
		String sql = "select * from customer";
		try {
			pstmt = conn.prepareStatement(sql);
			ResultSet rs = pstmt.executeQuery();
			while (rs.next()) {
				if (rs.getString("id").equals(str)) {
					Customer cus = new Customer(rs.getString("id"), rs.getString("password"), 
							rs.getString("name"),rs.getString("address"), rs.getString("phone"));
					return cus;
				}
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

	public boolean dbselect(Customer cus) {
		conn = dbconnect();
		String sql = "select id,password from customer";
		try {
			pstmt = conn.prepareStatement(sql);
			ResultSet rs = pstmt.executeQuery();
			while (rs.next()) {
				if (rs.getString("id").equals(cus.getId()) && rs.getString("password").equals(cus.getPassword())) {
					return true;
				}
			}
			;

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return false;
	}

	public void dbfood() {
		conn = dbconnect();
		String sql = "select * from food";
		try {
			pstmt = conn.prepareStatement(sql);
			ResultSet rs = pstmt.executeQuery();
			System.out.println(rs);

		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public Basket dbOrderBasket(int food) {
		conn = dbconnect();
		String sql = "select r.rest_name,f.food_name,f.price ,f.food_id from basket b,restaurant r,food f where b.bask_rest_id = r.rest_id and b.BASK_FOOD_ID = f.FOOD_ID";
		try {
			pstmt = conn.prepareStatement(sql);
			ResultSet rs = pstmt.executeQuery();
			if(food == 0) {
			}
			System.out.println(rs);
			while(rs.next()) {
			if (food == rs.getInt("food_id")) {
			Basket bas = new Basket(rs.getString("food_name"),rs.getString("rest_name"),rs.getInt("price"));
			return bas;
			}
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

	public int dbbasket(Basket bas) {
		conn = dbconnect();
		String sql = "insert into basket values(?,?,?)";
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, bas.getMyid());
			pstmt.setInt(2, bas.getMyrest());
			pstmt.setInt(3, bas.getMyfood());
			int rs = pstmt.executeUpdate();
			System.out.println(rs);
			return bas.getMyfood();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return bas.getMyfood();
	}

	public void dbregistry(Customer cus) {
		conn = dbconnect();
		String sql = "insert into customer values(?,?,?,?,?)";
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, cus.getId());
			pstmt.setString(2, cus.getAdress());
			pstmt.setString(3, cus.getName());
			pstmt.setString(4, cus.getPhone());
			pstmt.setString(5, cus.getPassword());
			int rs = pstmt.executeUpdate();
			System.out.println(rs);

		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

}