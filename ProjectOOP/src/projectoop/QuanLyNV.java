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
public class QuanLyNV {
    private ArrayList <NhanVien> list;
    
    public QuanLyNV(){
        list = new ArrayList();
    }
    
    public void inputNV(){
        NhanVien n = new NhanVien();
        n.input();
        list.add(n);
    }
    
    public void input(){
        Scanner sc = new Scanner(System.in);
        int temp = 1;
        while(temp == 1){
            inputNV();
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
        NhanVien.form();
        for(NhanVien v:list){
            v.output();
        }
        System.out.println("-------------------------------------------");
    }
    
    public void sortByMaSo(){
        list.sort(new Comparator<NhanVien>() {
            @Override
            public int compare(NhanVien o1, NhanVien o2) {
               if(o1.getMaSo()>o2.getMaSo())
                   return 1;
               else if(o1.getMaSo()==o2.getMaSo())
                   return 0;
               else
                   return -1;
            }
        });
    }
    
    public void searchByMaSo(){
        Scanner sc= new Scanner(System.in);
        System.out.println("Nhap Ma So Nhan Vien Can Tim: ");
        int Maso = Integer.parseInt(sc.nextLine());
        NhanVien.form();
        for(NhanVien n:list){
            if(Maso == n.getMaSo())
                n.output();
        }
    }
    
    public void sua(){
        Scanner sc= new Scanner(System.in);
        System.out.println("Nhap Ma So Nhan Vien Can Sua: ");
        int Maso = Integer.parseInt(sc.nextLine());
        for(NhanVien n:list){
            if(Maso == n.getMaSo()){
                n.input();
                break;
            }
        }
    }
    
    public void xoa(){
        int vt = 0,i=0;
        Scanner sc= new Scanner(System.in);
        System.out.println("Nhap Ma So Nhan Vien Can Xoa: ");
        int Maso = Integer.parseInt(sc.nextLine());
        for(NhanVien n:list){
            if(Maso == n.getMaSo())
                vt = i;
            i++;
        }
        list.remove(vt);  
    }
    
    public void saveToFile(){
        try{
            File f = new File("D:\\NhanVien.txt");
            FileWriter fw = new FileWriter(f);
            PrintWriter pw = new PrintWriter(fw);
            for(NhanVien n:list){
                pw.println(n);
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
            File f = new File("D:\\NhanVien.txt");
            FileReader fd = new FileReader(f);
            BufferedReader br = new BufferedReader(fd);
            String line;
            while((line = br.readLine())!=null){
                if(line.trim().equals(""))continue;
                String arr[] = line.split("[,]+");
                NhanVien n = new NhanVien(Integer.parseInt(arr[0]), Float.parseFloat(arr[5]), arr[4], arr[1], arr[3], arr[2], Integer.parseInt(arr[7]), arr[6]);
                list.add(n);
            }
            br.close();
            fd.close();
        }
        catch(Exception e){
            System.out.println("Failed"+e.getMessage());
        }
    }
}

