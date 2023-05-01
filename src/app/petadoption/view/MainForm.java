/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package app.petadoption.view;

import java.util.Scanner;

public class MainForm {
    
    
    
    
    
    public static void init(){
      Scanner scanner=new Scanner(System.in);
        
        
        System.out.println("Pet Adoption System 1.0");
        System.out.println("[1] Login");
        System.out.println("[2] Register");
        int choice=scanner.nextInt();
        
        if(choice==1){
            
        }else if (choice ==2){
            
        }else{
            System.out.println("Invalid input");
        }
        
        
        
        
    }
    
    public void initAdminForm(){
          System.out.println("[1] View Pet"
                + "\n[2] Add Pet"
                + "\n[3] Update Pet"
                + "\n[4] Drop Pet"
                + "\n[5] View Adoption List"
                + "\n[6] View Surrendered Pets"
                + "\n[7] Generate Form"
                + "\n[8] View Adopted Pets"
                + "\n[9] Search Employee"
                + "\n[0] Logout");
    }
    
    public void initCustomerForm(){
         System.out.println("[1] View Pet"
                + "\n[2] Adopt Pet"
                + "\n[3] Surrender Pet"
                + "\n[0] Logout");
    }
}
