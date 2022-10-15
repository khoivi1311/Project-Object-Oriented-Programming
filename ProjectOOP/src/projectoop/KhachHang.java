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
public class KhachHang extends Person {
    private int MaSo;

    public KhachHang() {
        
    }

    public KhachHang(int MaSo, String fullName, String diaChi, String email, int namSinh, String soDienThoai) {
        super(fullName, diaChi, email, namSinh, soDienThoai);
        this.MaSo = MaSo;
    }

    public int getMaSo() {
        return MaSo;
    }

    public void setMaSo(int MaSo) throws Exception {
        if(MaSo < 0)
           throw new Exception("Vui Long Nhap Lai");
        else
            this.MaSo = MaSo;
    }
    
    
    
    @Override
    public void input(){
        Scanner sc = new Scanner(System.in);
        
        while(true){
            try{
                System.out.println("Hay Nhap Ma So Cua Khach Hang: ");
                setMaSo(MaSo = Integer.parseInt(sc.nextLine()));
                break;
            }
            catch(Exception e){
                System.out.println(e);
            }      
        }
        
        super.input();
    }
    
    public static void form(){
        System.out.format("%-8s%-30s%-30s%-30s%-20s%-10s","Ma So","Ho Va Ten","Email","Dia Chi","So Dien Thoai","Nam Sinh");
        System.out.println("");
    }
    
    public void output(){
        System.out.format("%-8d%-30s%-30s%-30s%-20s%-10d",MaSo,fullName,email,diaChi,soDienThoai,namSinh);
        System.out.println("");
    }
    
    @Override
    public String toString(){
        return""+MaSo+","+fullName+","+email+","+diaChi+","+soDienThoai+","+namSinh+"";
    }
    
}
