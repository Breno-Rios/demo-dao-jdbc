package application;

import java.util.List;
import java.util.Scanner;

import db.DB;
import model.dao.DaoFactory;
import model.dao.DepartmentDao;
import model.entities.Department;

public class Program2 {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);

		DepartmentDao departmentDao = DaoFactory.createDepartmentDao();

		System.out.println("--TEST1: Department insert ---");
		Department dep = new Department(null, "FoodTrucks");
		departmentDao.insert(dep);
		System.out.println("Inserted! New id = " + dep.getId());

		System.out.println("--TEST2: Department update ---");
		dep.setName("Foods");
		departmentDao.update(dep);
		System.out.println("Update completed!");

		System.out.println("\n=== TEST 3: Department delete =====");
		System.out.print("Enter id for delete test: ");
		int id = sc.nextInt();
		departmentDao.deleteById(id);
		System.out.println("Delete completed");

		System.out.println("\n=== TEST 4: Department findById =====");
		Department department = departmentDao.findById(2);
		System.out.println(department);

		System.out.println("\n=== TEST 5: Department findall =====");
		List<Department> list = departmentDao.findAll();
		list.forEach(System.out::println);

		DB.closeConnection();
		sc.close();
	}

}
