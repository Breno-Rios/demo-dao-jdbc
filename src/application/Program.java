package application;

import java.util.List;

import db.DB;
import model.dao.DaoFactory;
import model.dao.SellerDao;
import model.entities.Department;
import model.entities.Seller;

public class Program {

	public static void main(String[] args) {
		
		SellerDao sellerDao =  DaoFactory.createSellerDao();
		
		
		System.out.println("--TEST1: Seller findById ---");
		Seller seller = sellerDao.findById(3);
		System.out.println(seller);
		
		System.out.println("\n--TEST1: Seller findByDepartment ---");
		Department department = new Department(4,null);
		List<Seller> list = sellerDao.findByDepartment(department);
		list.forEach(System.out:: println);
		
		
		DB.closeConnection();
		

	}

}
