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
public class NhanVien extends Person {
    private int maSo;
    private float luong;
    private String chucVu;

    public NhanVien() {
        
    }

    public NhanVien(int maSo, float luong, String chucVu, String fullName, String diaChi, String email, int namSinh, String soDienThoai) {
        super(fullName, diaChi, email, namSinh, soDienThoai);
        this.maSo = maSo;
        this.luong = luong;
        this.chucVu = chucVu;
    }

    public int getMaSo(){
        
        return maSo;
    }

    public void setMaSo(int maSo) throws Exception {
        if(maSo < 0)
           throw new Exception("Vui Long Nhap Lai");
        else
            this.maSo = maSo;
    }

    public float getLuong() {
        return luong;
    }

    public void setLuong(float luong) throws Exception{
        if(luong < 0)
            throw new Exception("Vui Long Nhap Lai");
        else
            this.luong = luong;
        
    }

    public String getChucVu() {
        return chucVu;
    }

    public void setChucVu(String chucVu) throws Exception{
        if(chucVu == null || chucVu.trim().equals(""))
            throw new Exception("Vui Long Nhap Chuc Vu");
        this.chucVu = chucVu;
    }
    
    @Override
    public void input(){
        Scanner sc = new Scanner(System.in);
        
        while(true){
            try{
                System.out.println("Hay Nhap Ma So Cua Nhan Vien: ");
                setMaSo(maSo = Integer.parseInt(sc.nextLine()));
                break;
            }
            catch(Exception e){
                System.out.println(e);
            }      
        }
        
        while(true){
            try{
                System.out.println("Hay Nhap Luong Cua Nhan Vien: ");
                setLuong(luong = Float.parseFloat(sc.nextLine()));
                break;
            }
            catch(Exception e){
                System.out.println(e);
            }       
        }
        
        while(true){
            try{
                System.out.println("Hay Nhap Chuc Vu Cua Nhan Vien: ");
                setChucVu(chucVu = sc.nextLine());
                break;
            }
            catch(Exception e){
                System.out.println(e);
            }       
        }
        
        super.input();
    }
    
    public static void form(){
        System.out.format("%-8s%-30s%-30s%-30s%-20s%-15s%-20s%-10s","Ma So","Ho Va Ten","Email","Dia Chi","Chuc Vu","Luong","So Dien Thoai","Nam Sinh");
        System.out.println("");
    }
    
    public void output(){
        System.out.format("%-8d%-30s%-30s%-30s%-20s%-15.1f%-20s%-10d",maSo,fullName,email,diaChi,chucVu,luong,soDienThoai,namSinh);
        System.out.println("");
    }
    
    @Override
    public String toString(){
        return""+maSo+","+fullName+","+email+","+diaChi+","+chucVu+","+luong+","+soDienThoai+","+namSinh+"";
    }
}
