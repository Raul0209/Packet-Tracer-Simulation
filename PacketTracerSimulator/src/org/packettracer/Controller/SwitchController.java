package org.packettracer.Controller;

import java.util.Scanner;
import org.packettracer.Model.Switch;
import java.util.ArrayList;

public class SwitchController {

    Scanner dt = new Scanner(System.in);
    Switch switches = new Switch();
    
    
    static ArrayList<Switch> arregloSwitch = new ArrayList<Switch>();
    
    public void createSwitch(String name){    
            int exist = 0;
            for(int i = 0; i < arregloSwitch.size(); i++){
                if(arregloSwitch.get(i).getName().equalsIgnoreCase(name)){
                    exist = 1;
                }
            }            
            if(exist == 1){
               System.out.println("\nThe switch with this name already exist.\n");
            }else{
                arregloSwitch.add(new Switch(name, 24));        
            }
    }
    
    public void listSwitches(){
        System.out.println();
        for(int i = 0; i < arregloSwitch.size(); i++){
           String name = arregloSwitch.get(i).getName();
           String ports = arregloSwitch.get(i).getIntEthernet();
           
           System.out.println(" " + i +") "+ name +" - Etherner: "+ 24);
           System.out.println(ports+"\n");
        }
        
    }
    
    public void editSwitch(int x,String name){
            int exist = 0;
            for(int i = 0; i < arregloSwitch.size(); i++){
                if(arregloSwitch.get(i).getName().equalsIgnoreCase(name)){
                    exist = 1;
                }
            }            
            if(exist == 1){
               System.out.println("\nThe switch with this name already exist.\n");
            }else{
                arregloSwitch.get(x).setName(name);        
            }    
    }
        
    public void deleteSwitch(int index){
        arregloSwitch.remove(index);        
    }
    
    public void dataUpdatedSw(ArrayList<Switch> data){
         arregloSwitch = data;
    }
    
    public ArrayList<Switch> dataSwitch(){    
        return arregloSwitch;
    }
    
}
