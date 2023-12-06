package test;

import java.util.ArrayList;

import database.UserDAOHandler;
import model.User;

public class Main {
	public static void main(String[] args) {
		UserDAOHandler udh = new UserDAOHandler();
		
//		User u1 = new User();
//		u1.setId(3);
//		u1.setUsername("hoanggiang");
//		u1.setPassword("12345678");
//		if (udh.addUser(u1) ) {
//			System.out.println("Add success!");
//		} else {
//			System.out.println("Add fail!");			
//		}
		
		
//		u1.setId(3);
//		u1.setUsername("vuhieu");
//		u1.setPassword("12345678910");
//		if (udh.updateUser(u1) ) {
//			System.out.println("Update success!");
//		} else {
//			System.out.println("Update fail!");			
//		}
		
		
//		if (udh.deleteUser(3) ) {
//			System.out.println("Delete success!");
//		} else {
//			System.out.println("Delete fail!");			
//		}
		
		
//		ArrayList<User> items = udh.getUsers(null, (byte)20);
//		items.forEach(item -> {
//			System.out.println(item);
//		});
		
		System.out.println(udh.getUserById(7));
	}
}
