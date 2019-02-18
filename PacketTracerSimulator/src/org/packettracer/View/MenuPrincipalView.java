package org.packettracer.View;

import java.util.Scanner;
import org.packettracer.View.SwitchView;

public class MenuPrincipalView {
    
    public void menuPrincipal(){
        SwitchView switchView = new SwitchView();
        
        Scanner readWrite = new Scanner(System.in);
        System.out.println("Cisco Packet Tracer (Simulator)");
        System.out.println("Version 1.0.0");
        System.out.println("Select: ");
        System.out.println("1. Router");
        System.out.println("2. Switch");
        System.out.println("3. Host");
        System.out.println("4. Direccionamiento");
        System.out.println("5. Ping");
        System.out.print("Option: ");
        int res = readWrite.nextInt();
        switch(res){
            case 1:
            break;
            
            case 2:
              // switchView.menuSwicth();
            break;
                
            case 3:
            break;
                
            case 4:
            break;
    
            default:
                System.out.println("Option not valid.");
                this.menuPrincipal();
            break;
        }
    }     
    
}
