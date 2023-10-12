/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Florist;
import java.util.ArrayList;
/**
 *
 * @author USER
 */

public final class Customer {
    private final int customerID; // ID pelanggan
    private String nama;
    private String alamat;
    private String telepon;
    private final ArrayList<Order> orders = new ArrayList<>();

    public Customer(int customerID, String nama, String alamat, String telepon) {
        this.customerID = customerID;
        this.nama = nama;
        this.alamat = alamat;
        this.telepon = telepon;
    }

    public int getCustomerID() {
        return customerID;
    }

    public String getNama() {
        return nama;
    }

    public void setNama(String nama) {
        this.nama = nama;
    }

    public String getAlamat() {
        return alamat;
    }

    public void setAlamat(String alamat) {
        this.alamat = alamat;
    }

    public String getTelepon() {
        return telepon;
    }

    public void setTelepon(String telepon) {
        this.telepon = telepon;
    }

    public ArrayList<Order> getOrders() {
        return orders;
    }

    public void addOrder(Order order) {
        orders.add(order);
    }

    public void viewOrders() {
        if (orders.isEmpty()) {
            System.out.println("No orders available for customer: " + nama);
        } else {
            System.out.println("Orders for customer " + nama + " (ID: " + customerID + "):");
            for (Order order : orders) {
                System.out.println("Order ID: " + order.getId());
            }
        }
    }
}
