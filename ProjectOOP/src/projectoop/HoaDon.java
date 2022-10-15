/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package projectoop;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author PC
 */
public class HoaDon {
    private ArrayList<SanPham> list;
    private String tenNV,date,soDienThoai;
    private double tongTien;
    
    public HoaDon(){
        list = new ArrayList();
    }

    public String getSoDienThoai() {
        return soDienThoai;
    }
    
    public String getTenNV() {
        return tenNV;
    }

    public String getDate() {
        return date;
    }

    public double getTongTien() {
        for(SanPham s:list){
            tongTien += (double)s.getThanhTien();
        }
        return tongTien;
    }

    public void setTenNV(String tenNV) throws Exception{
        if(tenNV == null|| tenNV.trim().equals(""))
            throw new Exception("Vui Long Nhap Lai");
        else
            this.tenNV = tenNV;
    }

    public void setSoDienThoai(String soDienThoai) throws Exception {
        if(soDienThoai == null|| soDienThoai.trim().equals(""))
            throw new Exception("Vui Long Nhap Lai");
        else
            this.soDienThoai=soDienThoai;
    }

    public void setDate(String date) throws Exception {
        if(date == null||date.trim().equals(""))
            throw new Exception("Vui Long Nhap Lai");
        else
            this.date = date;
    }
    
    public void inputSP(){
        SanPham s = new SanPham();
        s.input();
        list.add(s);
    }
    
    public void input(){
        Scanner sc = new Scanner(System.in);
        
        while(true){
            try{
                System.out.println("Hay Nhap Ten NV Lap Hoa Don: ");
                setTenNV(tenNV = sc.nextLine());
                break;
            }
            catch(Exception e){
                System.out.println(e);
            }
        }
        
        while(true){
            try{
                System.out.println("Hay Nhap So Dien Thoai Khach Hang: ");
                setSoDienThoai(soDienThoai = sc.nextLine());
                break;
            }
            catch(Exception e){
                System.out.println(e);
            }
        }
        while(true){
            try{
                System.out.println("Hay Nhap Ngay Thang Nam Mua Hang: ");
                setDate(date = sc.nextLine());
                break;
            }
            catch(Exception e){
                System.out.println(e);
            }
        }
        int temp = 1;
        while(temp == 1){
            inputSP();
            while(true){
                try{
                    System.out.println("Chon (1): Nhap Tiep     Chon (0) Thoat");
                    temp = Integer.parseInt(sc.nextLine());
                    break;
                }
                catch(Exception e){
                    System.out.println(e.getMessage());
                }
            }
        }
    }
    
    public void output(){
        System.out.println("==============Hoa Don==============");
        System.out.println("So Dien Thoai Khach Hang: " +getSoDienThoai());
        System.out.println("Ngay Mua Hang: "+getDate());
        System.out.println("Ten Nhan Vien Lap: " +getTenNV());
        System.out.println("===================================");
        SanPham.form();
        for(SanPham s:list){
            s.output();
        }
        System.out.println("===================================");
        System.out.printf("Tong Tien: %.1f\n",getTongTien());
    }
    
    public void saveToFile(){
        try{
            Scanner sc = new Scanner(System.in);
            System.out.println("Hay Nhap So Hoa Don");
            String so = sc.nextLine();
            String nameFile = soDienThoai +"_"+so +"_HoaDon.txt";
            File f = new File("D:\\HoaDon\\"+nameFile);
            FileWriter fw = new FileWriter(f);
            PrintWriter pw = new PrintWriter(fw);
            pw.println(tenNV);
            pw.println(date);
            pw.println(soDienThoai);
            for(SanPham s:list){
                pw.println(s);
            }   
            pw.close();
            fw.close();
        }
        catch(Exception e){
            System.out.println("Failed"+e.getMessage());
        }
    }
    
    public void readToFile(){
        try{
            Scanner sc = new Scanner(System.in);
            System.out.println("Hay Nhap So Dien Thoai De Xuat Hoa Don: ");
            String ten = sc.nextLine();
            System.out.println("Hay Nhap So Hoa Don");
            String so = sc.nextLine();
            String nameFile = ten +"_"+so + "_HoaDon.txt";
            File f = new File("D:\\HoaDon\\"+nameFile);
            FileReader fd = new FileReader(f);
            BufferedReader br = new BufferedReader(fd);
            String line;
            String sdt,date,name;
            
            if((name = br.readLine())!=null){
                tenNV = name.trim();
            }
            
            if((date = br.readLine())!=null){
                this.date = date.trim();
            }
            
            if((sdt = br.readLine())!=null){
                soDienThoai = sdt.trim();
            }
            
            while((line = br.readLine())!=null){
                if(line.trim().equals(""))continue;
                String arr[] = line.split("[,]+");
                SanPham s = new SanPham(arr[0], arr[1], Integer.parseInt(arr[2]), Integer.parseInt(arr[3]), Double.parseDouble(arr[4]), Integer.parseInt(arr[5]), Double.parseDouble(arr[6]));
                list.add(s);
            }
            br.close();
            fd.close();
        }
        catch(Exception e){
            System.out.println("Failed"+e.getMessage());
        }
    }
}
