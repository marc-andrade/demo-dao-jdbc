package application;

import java.util.List;

import model.dao.DaoFactory;
import model.dao.DepartmentDao;
import model.entities.Department;

public class Program2 {

	public static void main(String[] args) {
		
		DepartmentDao departmentDao = DaoFactory.creatDepartmentDao();
		
		System.out.println("=== TEST 1: department findById ====");
		Department department = departmentDao.findById(1);
		
		System.out.println(department);
		
		System.out.println("\n=== TEST 2: department findAll ====");
		List<Department> list = departmentDao.findAll();
		list.forEach(System.out::println);
		
		System.out.println("\n=== TEST 3: department insert ====");
		department = new Department(null, "Music");
		departmentDao.insert(department);
		System.out.println("Inserted! New Id = " + department.getId());
		
		System.out.println("\n=== TEST 4: department update ====");
		department = departmentDao.findById(5);
		department.setName("Sports");
		departmentDao.update(department);
		System.out.println("Update completed");
		
		System.out.println("\n=== TEST 5: department delete ====");
		int id = 5;
		departmentDao.deleteById(id);
		System.out.println("Delete completed");
	}

}
