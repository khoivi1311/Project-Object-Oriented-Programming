/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package projectoop;

import java.util.Scanner;

/**
 *
 * @author PC
 */
public class SanPham {
    protected String name,brand;
    protected int soLuong,maSo,TGBH;
    protected double donGia,thanhTien;

    public SanPham() {
        
    }

    public SanPham(String name, String brand, int soLuong, int maSo, double donGia,int TGBH,double thanhTien) {
        this.name = name;
        this.brand = brand;
        this.soLuong = soLuong;
        this.maSo = maSo;
        this.donGia = donGia;
        this.TGBH = TGBH;
        this.thanhTien = thanhTien;
    }

    public void setName(String name) throws Exception {
        if(name == null|| name.trim().equals(""))
            throw new Exception("Vui Long Nhap Lai");
        else
            this.name = name;
    }

    public void setBrand(String brand) throws Exception {
        if(brand == null || brand.trim().equals(""))
            throw new Exception("Vui Long Nhap Lai");
        else
            this.brand = brand;
    }

    public void setSoLuong(int soLuong) {
        if(soLuong < 0) soLuong = 0;
        this.soLuong = soLuong;
    }

    public void setDonGia(double donGia) {
        if(donGia < 0) donGia = 0;
        this.donGia = donGia;
    }

    public void setMaSo(int maSo) throws Exception {
        if(maSo < 0)
           throw new Exception("Vui Long Nhap Lai");
        else
            this.maSo = maSo;
    }
    
    public void setTGBH(int TGBH) throws Exception {
        if(TGBH<0)
            throw new Exception("Vui Long Nhap Lai");
        else
            this.TGBH = TGBH;
    }

    public String getName() {
        return name;
    }

    public String getBrand() {
        return brand;
    }

    public int getSoLuong() {
        return soLuong;
    }

    public int getMaSo() {
        return maSo;
    }

    public double getDonGia() {
        return donGia;
    }
    
    public int getTGBH(){
        return TGBH;
    }
    
    public double getThanhTien(){
        thanhTien = (double)donGia*soLuong;
        return thanhTien;
    }

    public void input(){
        Scanner sc = new Scanner(System.in);
        
        while(true){
            try{
                System.out.println("Hay Nhap So Thu Tu San Pham: ");
                setMaSo(maSo =Integer.parseInt(sc.nextLine()));
                break;
            }
            catch(Exception e){
                System.out.println(e);
            }
        }
        
        while(true){
            try{
                System.out.println("Hay Nhap Ten San Pham: ");
                setName(name = sc.nextLine());
                break;
            }
            catch(Exception e){
                System.out.println(e);
            }
        }   
        
        while(true){
            try{
                System.out.println("Hay Nhap Hang San Xuat: ");
                setBrand(brand = sc.nextLine());
                break;
            }
            catch(Exception e){
                System.out.println(e);
            }
        }
        
        while(true){
            try{
                System.out.println("Hay Nhap Thoi Gian Bao Hanh: ");
                setTGBH(TGBH=Integer.parseInt(sc.nextLine()));
                break;
            }
            catch(Exception e){
                System.out.println(e);
            }
        }
        
        System.out.println("Hay Nhap So Luong San Pham: ");
        setSoLuong(soLuong = Integer.parseInt(sc.nextLine()));
        System.out.println("Hay Nhap Don Gia Cua San Pham: ");
        setDonGia(donGia = Double.parseDouble(sc.nextLine()));
    }
    
    public static void form(){
        System.out.format("%-8s%-20s%-20s%-30s%-20s%-20s%-20s","STT","Ten San Pham","Hang San Xuat","Thoi Gian Bao Hanh","So Luong","Don Gia","Thanh Tien");
        System.out.println("");
    }
    
    public void output(){
        System.out.format("%-8d%-20s%-20s%-30d%-20s%-20.1f%-20.1f",maSo,name,brand,TGBH,soLuong,donGia,getThanhTien());
        System.out.println("");
    }
    
    public String toString(){
        return""+name+","+brand+","+soLuong+","+maSo+","+donGia+","+TGBH+","+getThanhTien()+"";
    }
}
