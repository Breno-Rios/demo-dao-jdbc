package application;

import java.util.Date;

import model.entities.Department;
import model.entities.Seller;

public class Program {

	public static void main(String[] args) {
		
		
		Department department = new Department(1,"Qualidade");
		
		Seller seller = new Seller(1, "Breno", "Breno@gmail.com", new Date(), 2000.0, department);
		
		System.out.println(seller);

	}

}
