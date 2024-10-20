package application;

import java.util.Date;
import java.util.List;
import java.util.Scanner;

import db.DB;
import model.dao.DaoFactory;
import model.dao.SellerDao;
import model.entities.Department;
import model.entities.Seller;

public class Program {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);

		SellerDao sellerDao = DaoFactory.createSellerDao();

		System.out.println("--TEST1: Seller findById ---");
		Seller seller = sellerDao.findById(3);
		System.out.println(seller);

		System.out.println("\n--TEST2: Seller findByDepartment ---");
		Department department = new Department(1, null);
		List<Seller> list = sellerDao.findByDepartment(department);
		list.forEach(System.out::println);

		System.out.println("\n--TEST3: Seller findAll ---");
		List<Seller> list2 = sellerDao.findAll();
		list2.forEach(System.out::println);

		System.out.println("\n--TEST4: Seller insert ---");
		Seller newSeller = new Seller(null, "Greg", "greg@gmail.com", new Date(), 4000.0, department);
		sellerDao.insert(newSeller);
		System.out.println("Inserted! New id = " + newSeller.getId());
		
		System.out.println("\n--TEST5: Seller update ---");
		seller = sellerDao.findById(7);
		seller.setName("Breno Oliveira");
		sellerDao.update(seller);
		System.out.println("Update completed!");
		
		System.out.println("\n=== TEST 6: seller delete =====");
		System.out.println("Enter id for delete test: ");
		int id = sc.nextInt();
		sellerDao.deleteById(id);
		System.out.println("Delete completed");

		DB.closeConnection();
		sc.close();
	}

}
