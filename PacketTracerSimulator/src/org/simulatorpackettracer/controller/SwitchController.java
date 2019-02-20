
package org.simulatorpackettracer.controller;

import java.util.Scanner;
import org.simulatorpackettracer.Model.Switch;
import java.lang.reflect.Array;
import java.util.ArrayList;

public class SwitchController {

   
    Switch switches = new Switch();
    
    static ArrayList<Switch> arregloSwitch = new ArrayList<Switch>();
    
    public void createSwitch(String name){    
           arregloSwitch.add(new Switch(name, 24));        
    }
    
    public void listSwitches(){
        String[] e = new String[arregloSwitch.size()];
        for(int i = 0; i < arregloSwitch.size(); i++){
           e[i] = arregloSwitch.get(i).getName();           
           System.out.println((i+1) +". "+ e[i]);
        }  
    }
    
    public void updateSwitch(){
    
    }
        
}

