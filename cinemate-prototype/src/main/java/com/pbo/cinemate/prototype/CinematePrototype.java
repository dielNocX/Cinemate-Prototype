/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.pbo.cinemate.prototype;

/**
 *
 * @author Asus
 */
public class CinematePrototype {

    public static void main(String[] args) {        
        Account acc = new Admin("ADMIN", "ADMIN", "ADMIN");
        
        if (acc instanceof Admin){
            Movie.fillMovie();
            FnB.fillFnb();
        }
        acc = normalFlowRegister();
        
        if (acc instanceof User){
            Movie.viewList();
            Movie.selectMovie();
            
            FnB.viewList();
            FnB.selectFnb();
        }
        
        
    }
    
    public static Account normalFlowRegister(){
        User.register();
        Account acc = null;
        while (acc == null) {
            acc = Account.login();
        }
        if (acc != null) {
            acc.showProfile(); 
        }
        return acc;
    }
    
    
    
    
    
}
