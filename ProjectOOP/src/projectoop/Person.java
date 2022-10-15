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
public class Person {
    protected String fullName, diaChi, email,soDienThoai;
    protected int namSinh;

    public Person() {
        
    }

    public Person(String fullName, String diaChi, String email, int namSinh, String soDienThoai) {
        this.fullName = fullName;
        this.diaChi = diaChi;
        this.email = email;
        this.namSinh = namSinh;
        this.soDienThoai = soDienThoai;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) throws Exception {
        if(fullName == null || fullName.trim().equals(""))
            throw new Exception("Vui Long Nhap Lai");
        else
            this.fullName = fullName;
    }

    public String getDiaChi(){
        return diaChi;
    }

    public void setDiaChi(String diaChi) throws Exception {
        if(diaChi == null || diaChi.trim().equals("")||diaChi.length()>50)
            throw new Exception("Vui Long Nhap Lai");
        else
            this.diaChi = diaChi;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) throws Exception {
        if(email == null || email.trim().equals(""))
            throw new Exception("Vui Long Nhap Lai");
        else
            this.email = email;
    }

    public int getNamSinh() {
        return namSinh;
    }

    public void setNamSinh(int namSinh) throws Exception {
        if(namSinh<0||namSinh<1000)
            throw new Exception("Vui Long Nhap Lai");
        else
            this.namSinh = namSinh;
    }

    public String getSoDienThoai() {
        return soDienThoai;
    }

    public void setSoDienThoai(String soDienThoai)throws Exception {
        if(soDienThoai == null || soDienThoai.trim().equals("")||soDienThoai.length()<10||soDienThoai.length()>11)
            throw new Exception("Vui Long Nhap Lai");
        else
            this.soDienThoai = soDienThoai;
    }
    
    public void input(){
        Scanner sc = new Scanner(System.in);
        
        while(true){
            try{
                System.out.println("Hay Nhap Ho Va Ten: ");
                setFullName(fullName = sc.nextLine());
                break;
            }
            catch(Exception e){
                System.out.println(e);
            }
        }
        
        while(true){
            try{
                System.out.println("Hay Nhap Dia Chi: ");
                setDiaChi(diaChi = sc.nextLine());
                break;
            }
            catch(Exception e){
                System.out.println(e);
            }
        }
        
        while(true){
            try{
                System.out.println("Hay Nhap Email: ");
                setEmail(email = sc.nextLine());
                break;
            }
            catch(Exception e){
                System.out.println(e);
            }
        }
        
        while(true){
            try{
                System.out.println("Hay Nhap Nam Sinh: ");
                setNamSinh(namSinh = Integer.parseInt(sc.nextLine()));
                break;
            }
            catch(Exception e){
                System.out.println(e);
            }
        }
        
        while(true){
            try{
                System.out.println("Hay Nhap So Dien Thoai: ");
                setSoDienThoai(soDienThoai = sc.nextLine());
                break;
            }
            catch(Exception e){
                System.out.println(e);
            }
        }
    }
}
