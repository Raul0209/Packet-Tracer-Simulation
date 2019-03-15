package org.packettracer.Controller;

import java.util.Scanner;
import java.util.ArrayList;
import java.util.Set;
import org.packettracer.Model.Router;

public class RouterController {
   
    Router router = new Router();
        
    static ArrayList<Router> arregloRouter = new ArrayList<Router>();
    
    public void createRouter(String name){
        boolean exist = false;
        
        for(int i = 0; i<arregloRouter.size(); i++){
            if (arregloRouter.get(i).getName().equalsIgnoreCase(name)){
                exist = true;
            }
        }
        
        if (exist == true){
            System.out.println("This Router already exist");
        }else{
            arregloRouter.add(new Router(name,2));
            
        }
    }
    
    public void listRouter(){
        System.out.println();
        for(int i = 0; i<arregloRouter.size(); i++){
            String name = arregloRouter.get(i).getName();
            System.out.println(i + ") " + name + " --- Ports/GigabyteEthernet: " + 2+"\n");
            System.out.println("\tGigabyteEthernet 0:" + arregloRouter.get(i).getPort0());
            System.out.println("\tGigabyteEthernet 1:" + arregloRouter.get(i).getPort1()+"\n");
        }
        System.out.println();
    }
    
    public void editRouter(int x,String name){
            int exist = 0;
            for(int i = 0; i < arregloRouter.size(); i++){
                if(arregloRouter.get(i).getName().equalsIgnoreCase(name)){
                    exist = 1;
                }
            }            
            if(exist == 1){
                System.out.println("\nThe router with this name already exist.\n");
            }else{
               arregloRouter.set(x, new Router(name, 2));   
            }    
    }
    
    public void deleteRouter(int i){
        arregloRouter.remove(i);
        System.out.println("The router has been erased");
    }
    
    public void addIpAndMascara(String name, int port,String ip, String mascara){
      
        int index = -1;
        
        for(int i = 0; i < arregloRouter.size(); i++){
            if(arregloRouter.get(i).getName().equalsIgnoreCase(name)){
                    index = i;
            }
        }       
        
        arregloRouter.get(index).setPropertiesPort(name, port, ip, mascara);
        ; 
        
    }
    
    public void dataUpdatedRou(ArrayList<Router> data){
         arregloRouter = data;
    }
    
    public ArrayList<Router> dataRouter(){    
        return arregloRouter;
    }
}
