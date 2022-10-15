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
public class MenuHD {
    private int choice;
    
    public void listMenu(){
        System.out.println("-----Danh Sach Chuc Nang-----");
        System.out.println("-------------------------------------------");
        System.out.println("1. Lap Hoa Don");
        System.out.println("2. Xuat Hoa Don");
        System.out.println("0. Thoat");
        System.out.println("-------------------------------------------");
    }
    
    public void Run(){
        boolean temp = true;
        Scanner sc = new Scanner(System.in);
            
        while(temp){
            listMenu();
            HoaDon h = new HoaDon();
            
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
                            h.input();
                            h.saveToFile();
                            h.output();
                }break;
                case 2: {
                            h.readToFile();
                            h.output();
                }break;
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
