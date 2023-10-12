/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Florist;

/**
 *
 * @author USER
 */
public class Bunga {
    
    private final String nama;
    private final String warna;
    private final int harga;

    public Bunga(String nama, String warna, int harga) {
        this.nama = nama;
        this.warna = warna;
        this.harga = harga;
    }

    public String getNama() {
        return nama;
    }

    public String getWarna() {
        return warna;
    }

    public int getHarga() {
        return harga;
    }
}
