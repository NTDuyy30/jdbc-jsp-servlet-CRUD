package database;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import database.connectionpool.ConnectionPool;
import database.connectionpool.ConnectionPoolImpl;
import model.User;

public class UserDAOHandler {
	private ConnectionPool cp;
	private Connection con;
	
	public UserDAOHandler() {
		this.cp = new ConnectionPoolImpl();
		try {
			this.con = this.cp.getConnection("User");
			if (this.con.getAutoCommit()) {
				this.con.setAutoCommit(false);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	
	public User getUserById(int idGet) {
		StringBuilder sql = new StringBuilder();
		sql.append("SELECT * FROM user WHERE id = ?");
		User item = null;
		
		try {
			PreparedStatement pst = this.con.prepareStatement(sql.toString());
			pst.setInt(1, idGet);
			
			ResultSet rs = pst.executeQuery();
			
			if (rs != null) {
				while (rs.next()) {
					item = new User(rs.getInt("id"), rs.getString("username"), rs.getString("password"));
				}
				rs.close();
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			try {
				this.con.rollback();
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		}
		return item;
	}
	
	
	public ArrayList<User> getUsers(User similar, byte total) {
		ArrayList<User> items = new ArrayList<>();
		
		StringBuilder sql = new StringBuilder();
		sql.append("SELECT * FROM user LIMIT ?");
		
		try {
			PreparedStatement pst = this.con.prepareStatement(sql.toString());
			pst.setByte(1, total);
			
			ResultSet rs = pst.executeQuery();
			
			if (rs != null) {
				while (rs.next()) {
					items.add(new User(rs.getInt("id"), rs.getString("username"), rs.getString("password")));
				}
				rs.close();
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			try {
				this.con.rollback();
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		}
		return items;
	}
	
	
	public boolean addUser(User item) {
		StringBuilder sql = new StringBuilder();
		sql.append("INSERT INTO user(id, username, password) ");
		sql.append("VALUES(?, ?, ?)");
		
		try {
			PreparedStatement pst = this.con.prepareStatement(sql.toString());
			pst.setInt(1, item.getId());
			pst.setString(2, item.getUsername());
			pst.setString(3, item.getPassword());
			
			int result = pst.executeUpdate();
			
			if (result == 0) {
				this.con.rollback();
				return false;
			}
			this.con.commit();
			return true;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			try {
				this.con.rollback();
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			return false;
		}
	}
	
	
	public boolean updateUser(User item) {
		StringBuilder sql = new StringBuilder();
		sql.append("UPDATE user ");
		sql.append("SET username = ?, password = ? ");
		sql.append("WHERE id = ?");
		
		try {
			PreparedStatement pst = this.con.prepareStatement(sql.toString());
			pst.setString(1, item.getUsername());
			pst.setString(2, item.getPassword());
			pst.setInt(3, item.getId());
			
			int result = pst.executeUpdate();
			
			if (result == 0) {
				this.con.rollback();
				return false;
			}
			this.con.commit();
			return true;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			try {
				this.con.rollback();
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			return false;
		}
	}
	public boolean deleteUser(int idDel) {
		StringBuilder sql = new StringBuilder();
		sql.append("DELETE FROM user ");
		sql.append("WHERE id = ?");
		
		try {
			PreparedStatement pst = this.con.prepareStatement(sql.toString());
			pst.setInt(1, idDel);
			
			int result = pst.executeUpdate();
			
			if (result == 0) {
				this.con.rollback();
				return false;
			}
			this.con.commit();
			return true;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			try {
				this.con.rollback();
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			return false;
		}
	}
}
