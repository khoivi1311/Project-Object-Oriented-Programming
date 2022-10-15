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
public class MenuNV {
    private int choice;

    public MenuNV() {
        
    }
        
    public void listMenu(){
        System.out.println("-----Danh Sach Chuc Nang-----");
        System.out.println("-------------------------------------------");
        System.out.println("1. Nhap Danh Sach Nhan Vien");
        System.out.println("2. In Danh Sach Len Man Hinh");
        System.out.println("3. Sap Xep Danh Sach Nhan Vien Theo Ma So Nhan Vien");
        System.out.println("4. Sua Thong Tin Nhan Vien Theo Ma So Nhan Vien");
        System.out.println("5. Tim Thong Tin Nhan Vien Theo Ma So Nhan Vien");
        System.out.println("6. Xoa Thong Tin Nhan Vien Theo Ma So Nhan Vien");
        System.out.println("0. Thoat");
        System.out.println("-------------------------------------------");
    }
    
    public void Run(){
        boolean temp = true;
        Scanner sc = new Scanner(System.in);
        while(temp){
            QuanLyNV q = new QuanLyNV();
            q.readToFile();
            listMenu();
            while(true){
                try{
                    System.out.println("Moi Ban Chon Chuc Nang: ");
                    choice =Integer.parseInt(sc.nextLine());
                    break;
                }
                catch(Exception e){
                        System.out.println(e.getMessage());
                        }
            }
            switch(choice){
                case 1: {
                            q.input();
                            q.saveToFile();
                }break;
                
                case 2: {
                            q.output();
                }break;
                
                case 3: {
                            q.sortByMaSo();
                            q.saveToFile();
                            q.output();
                }break;
                
                case 4:{
                            q.sua();
                            q.saveToFile();
                            q.output();
                }break;
                
                case 5:{
                            q.searchByMaSo();
                }break;
                
                case 6:{
                            q.xoa();
                            q.saveToFile();
                            q.output();
                }break;
                
                case 0:{
                            temp = false;
                            System.out.println("---Thanks For Use---");
                            System.out.println("------GoodBye------");
                } break;
                
                default: System.out.println("Chuc Nang Khong Ton Tai!!!"); break;
            }
        }
    }
    
}
