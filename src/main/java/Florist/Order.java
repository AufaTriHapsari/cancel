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
public class Order {

 
    private static int count = 0;  // Untuk menghasilkan ID unik
    private final int id;
    
    private final Customer customer;
    private final ArrayList<Bunga> daftarBunga = new ArrayList<>();

    public Order(Customer customer) {
        this.id = ++count;
       
        this.customer = customer;
    }

    public int getId() {
        return id;
    }


    public void tambahBunga(Bunga bunga) {
        daftarBunga.add(bunga);
    }

    public void hapusBunga(Bunga bunga) {
        daftarBunga.remove(bunga);
    }

    public ArrayList<Bunga> getDaftarBunga() {
        return daftarBunga;
    }

    public Customer getCustomer() {
        return customer;
    }
}
