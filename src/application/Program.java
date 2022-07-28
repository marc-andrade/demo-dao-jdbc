package application;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.List;

import model.dao.DaoFactory;
import model.dao.SellerDao;
import model.entities.Department;
import model.entities.Seller;

public class Program {

	public static void main(String[] args) throws ParseException {
		
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		
		SellerDao sellerDao = DaoFactory.createSellerDao();
		
		System.out.println("=== TEST 1: seller findById ====");
		Seller seller = sellerDao.findById(3);
		
		System.out.println(seller);
		
		System.out.println("\n=== TEST 2: seller findByDepartment ====");
		Department department = new Department(2,null);
		List<Seller> list = sellerDao.findByDepartment(department);
		
		list.forEach(x -> System.out.println(x));
		
		System.out.println("\n=== TEST 3: seller findAll ====");
		
		list = sellerDao.findAll();
		
		list.forEach(System.out::println);
		
		System.out.println("\n=== TEST 4: seller insert ====");
		
		seller = new Seller(null,"Marcos","marcos@email.com", sdf.parse("21/06/1997"), 4000.0, 
				department);
		
		sellerDao.insert(seller);
		System.out.println("Inserted! New Id = " + seller.getId());
	}

}
