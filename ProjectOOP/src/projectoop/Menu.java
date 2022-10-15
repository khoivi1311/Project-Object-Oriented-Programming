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
public class Menu {
    private int choice;
    
    public void listMenu(){
        System.out.println("-----Danh Sach Chuc Nang-----");
        System.out.println("-------------------------------------------");
        System.out.println("1. Quan Ly Nhan Vien");
        System.out.println("2. Quan Ly Khach Hang");
        System.out.println("3. Tao Hoa Don");
        System.out.println("0. Thoat");
        System.out.println("-------------------------------------------");
    }
    
    public void Run(){
        boolean temp = true;
        Scanner sc = new Scanner(System.in);
        while(temp){
            MenuNV m1 = new MenuNV();
            MenuKH m2 = new MenuKH();
            MenuHD m3 = new MenuHD();
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
                case 1: m1.Run();break;
                case 2: m2.Run();break;
                case 3: m3.Run();break;
                case 0:{
                            temp = false;
                            System.out.println("---Thanks For Use---");
                            System.out.println("------GoodBye------");
                } break;
                default: System.out.println("Chuc Nang Khong Ton Tai!!!");break;
            }
        }
    }
}
