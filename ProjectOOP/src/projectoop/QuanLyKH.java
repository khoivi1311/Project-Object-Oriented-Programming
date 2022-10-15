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
import java.util.Comparator;
import java.util.Scanner;

/**
 *
 * @author PC
 */
public class QuanLyKH {
    private ArrayList <KhachHang> list;
    
    public QuanLyKH(){
        list = new ArrayList();
    }
    
     public void inputKH(){
        KhachHang k = new KhachHang();
        k.input();
        list.add(k);
    }
     
    public void input(){
        Scanner sc = new Scanner(System.in);
        int temp = 1;
        while(temp == 1){
            inputKH();
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
        System.out.println("-------------------------------------------");
        System.out.println("---Danh Sach Nhan Vien---");
        KhachHang.form();
        for(KhachHang k:list){
            k.output();
        }
        System.out.println("-------------------------------------------");
    }
    
    public void sortByMaSo(){
        list.sort(new Comparator<KhachHang>(){
            @Override
            public int compare(KhachHang o1, KhachHang o2) {
                if(o1.getMaSo()>o2.getMaSo())
                    return 1;
                else if(o1.getMaSo()==o2.getMaSo())
                    return 0;
                else 
                    return -1;
            }
            
        });
    }
    
    public void searchBySDT(){
        Scanner sc= new Scanner(System.in);
        System.out.println("Nhap So Dien Thoai Khach Hang Can Tim: ");
        String sdt = sc.nextLine();
        KhachHang.form();
        for(KhachHang k:list){
            if(sdt.trim().equals(k.getSoDienThoai()))
                k.output();
        }
    }
    
    public void sua(){
        Scanner sc= new Scanner(System.in);
        System.out.println("Nhap Ma So Khach Hang Can Sua: ");
        int Maso = Integer.parseInt(sc.nextLine());
        for(KhachHang k:list){
            if(Maso == k.getMaSo())
                k.input();
        }
    }
    
        public void xoa(){
        int vt = 0,i=0;
        Scanner sc= new Scanner(System.in);
        System.out.println("Nhap Ma So Khach Hang Can Xoa: ");
        int Maso = Integer.parseInt(sc.nextLine());
        for(KhachHang k:list){
            if(Maso == k.getMaSo())
                vt = i;
            i++;
        }
        list.remove(vt);  
    }
    
    public void saveToFile(){
        try{
            File f = new File("D:\\KhachHang.txt");
            FileWriter fw = new FileWriter(f);
            PrintWriter pw = new PrintWriter(fw);
            for(KhachHang k:list){
                pw.println(k);
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
            File f = new File("D:\\KhachHang.txt");
            FileReader fd = new FileReader(f);
            BufferedReader br = new BufferedReader(fd);
            String line;
            while((line = br.readLine())!=null){
                if(line.trim().equals(""))continue;
                String arr[] = line.split("[,]+");
                KhachHang k = new KhachHang(Integer.parseInt(arr[0]), arr[1], arr[3], arr[2], Integer.parseInt(arr[5]), arr[4]);
                list.add(k);
            }
        }
        catch(Exception e){
            System.out.println("Failed"+e.getMessage());
        }
    }
    
}
