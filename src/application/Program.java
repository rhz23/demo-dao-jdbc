package application;

import model.dao.DaoFactory;
import model.dao.SellerDao;
import model.entities.Department;
import model.entities.Seller;

import java.util.Date;
import java.util.List;

public class Program {

    public static void main(String[] args) {

        /*
        Department obj = new Department(1, "Books");
        System.out.println(obj);

        Seller seller = new Seller(21, "Bob", "bob@gmail.com", new Date(), 3000.0, obj);
         */

        SellerDao sellerDao = DaoFactory.createSellerDao();


        System.out.println("===Test 1: seller findById ===");
        Seller seller = sellerDao.findById(3);

        System.out.println(seller);

        System.out.println("\n===Test 2: seller findDepartment ===");
        Department department = new Department(2, null);
        List<Seller> list = sellerDao.findByDepartment(department);
        for(Seller obj : list){
            System.out.println(obj);
        }

        System.out.println("\n===Test 3: seller findAll ===");
        list = sellerDao.findAll();
        for(Seller obj : list){
            System.out.println(obj);
        }

        System.out.println("\n===Test 4: seller Insert ===");
        Seller newSeller = new Seller(null, "Greg", "greg@gmail.com", new Date(), 4000.00, department);
        sellerDao.insert(newSeller);
        System.out.println("Inserted! New ID = " + newSeller.getId());

    }
}
