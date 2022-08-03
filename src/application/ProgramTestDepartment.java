package application;

import java.util.List;
import java.util.Scanner;

import model.dao.DaoFactory;
import model.dao.DepartmentDao;
import model.entities.Department;

public class ProgramTestDepartment {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);

		DepartmentDao departmentDao = new DaoFactory().createDepartmentDao();

		System.out.println("=== TEST 1: Department findById ===");
			Department dep = departmentDao.findById(1);
			System.out.println(dep);
		
		System.out.println("\n=== TEST 2: Department findAll ===");
			List <Department> list = departmentDao.findAll();
			for (Department department : list) {
				System.out.println(department);
			}

		System.out.println("\n=== TEST 3: Department insert ===");
			Department newDepartment = new Department(null, "Music");
			departmentDao.insert(newDepartment); 
			System.out.println("Inserted! New id = " + newDepartment.getId());

		System.out.println("\n=== TEST 4: Department Update ===");
			Department depart = departmentDao.findById(1);
			depart.setName("Food");
			departmentDao.update(depart);
			System.out.println("Update competed!");

		System.out.println("\n=== TEST 5: Department delete ===");
			System.out.println("Enter id for delete test: ");
			int id = sc.nextInt();
			departmentDao.deleteById(id);
			System.out.println("Delete completed");

		sc.close();
	}
}
