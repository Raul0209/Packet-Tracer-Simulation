
package org.packettracer.Controller;

import java.awt.Panel;
import java.awt.event.KeyEvent;
import java.util.Scanner;
import org.packettracer.Model.Computer;


import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;



public class ComputerController {
    Scanner dt = new Scanner(System.in);
    Computer computers = new Computer();
    Panel pnl; 
     
   
    
    static ArrayList<Computer> arrayComputer = new ArrayList<Computer>();
    
    
    
    public void createComputer(String name){    
            int exist = 0;
            for(int i = 0; i < arrayComputer.size(); i++){
                if(arrayComputer.get(i).getName().equalsIgnoreCase(name)){
                    exist = 1;
                }
            }            
            if(exist == 1){
               System.out.println("\nThe computer with this name already exist.\n");
            }else{
                arrayComputer.add(new Computer(name));
            }
    }
    
    public void listComputers(){ 
        System.out.println();
       
        for(int i = 0; i < arrayComputer.size(); i++){
           String name = arrayComputer.get(i).getName();
           String ipAddress = arrayComputer.get(i).getIpAddress();
           String subNetMask = arrayComputer.get(i).getSubNetMask();
           String defaultGateway = arrayComputer.get(i).getDefaultGateway();
           String connectTo = arrayComputer.get(i).getConectadoTo();
           System.out.println(" " + i +") "+ name + " --- IP Address: " + ipAddress + 
                   " -- SubNetMask: " + subNetMask + " -- Default-Gateway: " + defaultGateway
                   + " -- Connect-To: " + connectTo);
        }
        System.out.println();
    }
    public void addIpAddress(String name, String ipAddress, String subNetMask){
        int contador=-1;
        for(Computer y: arrayComputer){
            contador++;
            if(name.equalsIgnoreCase(y.getName())){
                arrayComputer.get(contador).setIpAddress(ipAddress);
                arrayComputer.get(contador).setSubNetMask(subNetMask);                           
           }                  
        }
    }
    public void addDefaultGateway(String name, String defaultGateway){
        int contador=-1;
        for(Computer y: arrayComputer){
            contador++;
            if(name.equalsIgnoreCase(y.getName())){
                arrayComputer.get(contador).setDefaultGateway(defaultGateway);               
           }                  
        }
    }
        
    
    public void editComputer(int x,String name){
            int exist = 0;
            for(int i = 0; i < arrayComputer.size(); i++){
                if(arrayComputer.get(i).getName().equalsIgnoreCase(name)){
                    exist = 1;
                }
            }            
            if(exist == 1){
               System.out.println("\nThe computer with this name already exist.\n");
            }else{
                arrayComputer.get(x).setName(name);        
            }    
    }
        
    public void deleteComputer(int index){
        arrayComputer.remove(index);
        System.out.println("The pc has been erased");        
    }

   public void dataUpdatedPc(ArrayList<Computer> data){
         arrayComputer = data;
    }
   
   public ArrayList<Computer> dataComputer(){    
        return arrayComputer;
    }
    
}
