/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package myswimapp;

import java.io.IOException;
import java.util.HashMap;

/**
 *
 * @author Caitlyn
 */
public class MySwimApp {

    /**
     * @param args the command line arguments
     */
    
    public static loginForm lf;
    
    
    public MySwimApp(){
        lf = new loginForm();

    }

    public static void main(String[] args) throws IOException {
        // TODO code application logic here
        MySwimApp MSA = new MySwimApp();
        lf.setVisible(true);
        lf.first_time();
        
        
        
        
    }
    
}
