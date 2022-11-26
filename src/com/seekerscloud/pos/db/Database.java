package com.seekerscloud.pos.db;

import com.seekerscloud.pos.model.Customer;
import com.seekerscloud.pos.model.Order;
import com.seekerscloud.pos.model.Product;
import com.seekerscloud.pos.model.User;

import java.util.ArrayList;

public class Database {
    public  static ArrayList<User>userTable = new ArrayList<User>();
    public  static ArrayList<Customer>customerTable = new ArrayList<Customer>();

    public  static ArrayList<Product>productTable = new ArrayList<Product>();

    public static ArrayList<Order>orderTable= new ArrayList<Order>();

    static {
        customerTable.add(new Customer("C-001","Jagath","Colombo",45000));
        customerTable.add(new Customer("C-002","Saman","Badulla",80000));
        customerTable.add(new Customer("C-003","Kamal","Galle",30000));

        productTable.add(new Product("D-001","Description 1",25,4500));
        productTable.add(new Product("D-002","Description 2",50,7500));
        productTable.add(new Product("D-003","Description 3",75,3500));
        productTable.add(new Product("D-004","Description 4",100,1500));
        productTable.add(new Product("D-005","Description 5",35,1200));
    }
}
