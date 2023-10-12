/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.mainpt2;
import java.util.ArrayList;
import java.util.Scanner;
import Florist.*;

/**
 *
 * @author USER
 */
public class Mainpt2 {
   
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ArrayList<Customer> customers = new ArrayList<>();
        int customerIdCounter = 1; // Untuk menghasilkan ID pelanggan unik

        int choice;

        
         do {
            System.out.println("==================================");
            System.out.println("|    Welcome to Cyra Florist     |");
            System.out.println("==================================");
            System.out.println("|     1. Add Customer            |");
            System.out.println("|     2. Create Order            |");
            System.out.println("|     3. Update Flower to Order  |");
            System.out.println("|     4. Delete Flower from Order|");
            System.out.println("|     5. View All Orders         |");
            System.out.println("|     0. Exit                    |");
            System.out.println("=================================");
            System.out.print("Enter your choice: ");
            choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1 -> {
                    addCustomer(customers, customerIdCounter, scanner);
                    customerIdCounter++;
                }
                case 2 -> createOrder(customers, scanner);
                case 3 -> addFlower(customers, scanner);
                case 4 -> deleteFlower(customers, scanner);
                case 5 -> viewAllOrders(customers);
                case 0 -> System.out.println("Thank you for using Cyra Florist!");
                default -> System.out.println("Invalid choice, please try again.");
            }
        } while (choice != 0);
    }

    private static void addCustomer(ArrayList<Customer> customers, int customerId, Scanner scanner) {
        System.out.print("Enter Customer Name: ");
        String name = scanner.nextLine();
        System.out.print("Enter Customer Address: ");
        String address = scanner.nextLine();
        System.out.print("Enter Customer Phone: ");
        String phone = scanner.nextLine();

        Customer customer = new Customer(customerId, name, address, phone);
        customers.add(customer);
        System.out.println("Customer added successfully with ID: " + customerId);
    
    }

    private static void createOrder(ArrayList<Customer> customers, Scanner scanner) {
        System.out.print("Enter Customer Name: ");
        String name = scanner.nextLine();
        Customer selectedCustomer = findCustomerByName(customers, name);

        if (selectedCustomer == null) {
            System.out.println("Customer not found. Please create a customer first.");
        } else {
            Order order = new Order(selectedCustomer);
            selectedCustomer.getOrders().add(order);
            System.out.println("Order created for " + selectedCustomer.getNama() + " with Order ID: " + order.getId());
        }
    }

    private static void addFlower(ArrayList<Customer> customers, Scanner scanner) {
        System.out.print("Enter Customer Name: ");
        String name = scanner.nextLine();
        Customer selectedCustomer = findCustomerByName(customers, name);

        if (selectedCustomer == null) {
            System.out.println("Customer not found.");
        } else {
            System.out.print("Enter Order ID: ");
            int orderId = scanner.nextInt();
            scanner.nextLine();
            Order selectedOrder = findOrderById(selectedCustomer, orderId);

            if (selectedOrder == null) {
                System.out.println("Order not found for this customer.");
            } else {
                System.out.print("Enter Flower Name: ");
                String flowerName = scanner.nextLine();
                System.out.print("Enter Flower Color: ");
                String flowerColor = scanner.nextLine();
                System.out.print("Enter Flower Price: ");
                int flowerPrice = scanner.nextInt();
                scanner.nextLine();

                Bunga flower = new Bunga(flowerName, flowerColor, flowerPrice);
                selectedOrder.tambahBunga(flower);
                System.out.println("Flower added to the order.");
            }
        }
    }

    private static void deleteFlower(ArrayList<Customer> customers, Scanner scanner) {
        System.out.print("Enter Customer Name: ");
        String name = scanner.nextLine();
        Customer selectedCustomer = findCustomerByName(customers, name);

        if (selectedCustomer == null) {
            System.out.println("Customer not found.");
        } else {
            System.out.print("Enter Order ID: ");
            int orderId = scanner.nextInt();
            scanner.nextLine();
            Order selectedOrder = findOrderById(selectedCustomer, orderId);

            if (selectedOrder == null) {
                System.out.println("Order not found for this customer.");
            } else {
                System.out.print("Enter Flower Name: ");
                String flowerName = scanner.nextLine();
                ArrayList<Bunga> flowers = selectedOrder.getDaftarBunga();
                Bunga selectedFlower = findFlowerByName(flowers, flowerName);

                if (selectedFlower == null) {
                    System.out.println("Flower not found in the order.");
                } else {
                    selectedOrder.hapusBunga(selectedFlower);
                    System.out.println("Flower deleted from the order.");
                }
            }
        }
    }

    private static void viewAllOrders(ArrayList<Customer> customers) {
        System.out.println("All Orders:");
        for (Customer customer : customers) {
            for (Order order : customer.getOrders()) {
                System.out.println("Customer Name: " + customer.getNama());
                System.out.println("Order ID: " + order.getId());
                System.out.println("Daftar Bunga:");

                for (Bunga flower : order.getDaftarBunga()) {
                    System.out.println("Nama: " + flower.getNama() + ", Warna: " + flower.getWarna() + ", Harga: " + flower.getHarga());
                }
                System.out.println("----------------------------");
            }
        }
    }

    private static Customer findCustomerByName(ArrayList<Customer> customers, String name) {
        for (Customer customer : customers) {
            if (customer.getNama().equalsIgnoreCase(name)) {
                return customer;
            }
        }
        return null;
    }

    private static Order findOrderById(Customer customer, int id) {
        for (Order order : customer.getOrders()) {
            if (order.getId() == id) {
                return order;
            }
        }
        return null;
    }

    private static Bunga findFlowerByName(ArrayList<Bunga> flowers, String name) {
        for (Bunga flower : flowers) {
            if (flower.getNama().equalsIgnoreCase(name)) {
                return flower;
            }
        }
        return null;
    }
}
