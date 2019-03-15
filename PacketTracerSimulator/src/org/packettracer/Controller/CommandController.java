package org.packettracer.Controller;

import java.util.ArrayList;
import java.util.Scanner;

import org.packettracer.View.CommandEngineView;

import org.packettracer.Model.Switch;
import org.packettracer.Model.Computer;
import org.packettracer.Model.Router;

public class CommandController {
    
    
     ArrayList<Switch> arregloSwitchTem = new ArrayList<Switch>();
     ArrayList<Computer> arregloComputerTem = new ArrayList<Computer>();
     ArrayList<Router> arregloRouterTem = new ArrayList<Router>();
    
    Scanner dt = new Scanner(System.in);
    SwitchController switchController = new SwitchController();
    RouterController routerController = new RouterController();
    ComputerController computerController = new ComputerController();
    CommandEngineView commandEngineView = new CommandEngineView();
    String[] createCommands = {"Create Router","Create Switch","Create Pc",
        "Show Switch","Show Router","Show Pc", "Update Router","Update Switch",
        "Update Pc","Delete Router","Delete Switch","Delete Pc", "Create ?",
        "Update ?", "Delete ?", "Ipconfig Pc", "Defaultgateway Pc", "Ipconfig Router",
        "Connection", "Ping"}; 
                                                                         
    public void commandEngine(){
        String command = "";
        System.out.println("Packet Tracer (Simulator)");
        do{
           System.out.print(">");
            command = dt.nextLine();
            String[] comand=command.split("\\ ");
                        
            try{            
                for(int i = 0; i < createCommands.length; i++){
                    if(createCommands[i].equalsIgnoreCase(comand[0])){
                        switch(createCommands[i]){
                            case "Connection":                                
                                this.connectionTo(comand[1],Integer.parseInt(comand[2]),comand[3],Integer.parseInt(comand[4]));
                                break;
                            case "Ping" :
                                System.out.println("Hacienod ping");
                                break;
                        }
                    }else if(createCommands[i].equalsIgnoreCase(comand[0] + " " +comand[1])){
                       
                        switch(createCommands[i]){
                            case "Create Router":
                                routerController.createRouter(comand[2]);
                                break;
                            case "Create Switch" :
                                switchController.createSwitch(comand[2]);
                                break;
                            case "Create Pc" :
                                computerController.createComputer(comand[2]);
                                break;
                            case "Show Switch" :
                                switchController.listSwitches();
                                break;
                            case "Show Router" :
                                routerController.listRouter();
                                break;
                            case "Show Pc" :
                                computerController.listComputers();
                                break;
                            case "Update Router":
                                updateDeviceName(comand[1],Integer.parseInt(comand[2]),comand[3]);
                                routerController.editRouter(Integer.parseInt(comand[2]), comand[3]);
                                break;
                            case "Update Switch" :
                                updateDeviceName(comand[1],Integer.parseInt(comand[2]),comand[3]);
                                switchController.editSwitch(Integer.parseInt(comand[2]), comand[3]);
                                break;
                            case "Update Pc" :
                                updateDeviceName(comand[1],Integer.parseInt(comand[2]),comand[3]);
                                computerController.editComputer(Integer.parseInt(comand[2]), comand[3]);
                                break;
                            case "Delete Router":
                                deleteDeviceName(comand[1],Integer.parseInt(comand[2]));
                                routerController.deleteRouter(Integer.parseInt(comand[2]));
                                break;
                            case "Delete Switch" :    
                                deleteDeviceName(comand[1],Integer.parseInt(comand[2]));
                                switchController.deleteSwitch(Integer.parseInt(comand[2]));
                                break;
                            case "Delete Pc" :
                                deleteDeviceName(comand[1],Integer.parseInt(comand[2]));
                                computerController.deleteComputer(Integer.parseInt(comand[2]));
                                break;
                            case "Create ?" :
                                commandEngineView.creates();
                                break;
                            case "Update ?" :
                                commandEngineView.updates();
                                break;
                            case "Delete ?" :
                                commandEngineView.deletes();
                                break;
                            case "Ipconfig Pc":
                                computerController.addIpAddress(comand[2], comand[3], comand[4]);
                                break;
                            case "Defaultgateway Pc":
                                computerController.addDefaultGateway(comand[2], comand[3]);
                                break;
                            case "Ipconfig Router":
                                routerController.addIpAndMascara(comand[2],Integer.parseInt(comand[3]), comand[4],comand[5]);
                                break;
                        }
                    }
                }
            }catch(Exception e){
               // System.out.println(">Syntax Error.");
               System.out.println(e);
            }                          
            
        }while(!command.equalsIgnoreCase("exit"));
    }
    
    //ACTUALIZA LOS NOMBRES DE LOS OTROS DISPOSITIVOS AL MOMENTO DE MIDIFICARLOS
    public void updateDeviceName(String dis,int id, String newName){
        arregloSwitchTem = switchController.dataSwitch();
        arregloComputerTem = computerController.dataComputer();
        arregloRouterTem = routerController.dataRouter();
        
            switch(dis){
                case "pc":
                    for(int e = 0; e < arregloSwitchTem.size(); e++){
                        for(int a = 0; a < 24; a++){
                            if(arregloSwitchTem.get(e).datoPort(a) != null){
                                if(arregloSwitchTem.get(e).datoPort(a).equalsIgnoreCase(arregloComputerTem.get(id).getName())){
                                    arregloSwitchTem.get(e).setValor(a,newName);    
                                    switchController.dataUpdatedSw(arregloSwitchTem);
                                } 
                            } 
                        }                              
                    }                    
                    break;
                case "switch":
                    for(int e = 0; e < arregloComputerTem.size(); e++){        
                        if(arregloComputerTem.get(e).getConectadoTo() != null){                          
                            
                            if(arregloComputerTem.get(e).getConectadoTo().equalsIgnoreCase(arregloSwitchTem.get(id).getName())){
                                arregloComputerTem.get(e).setConectadoTo(newName);    
                                computerController.dataUpdatedPc(arregloComputerTem);
                            } 
                        }                                                       
                    } 
                    for(int e = 0; e < arregloRouterTem.size(); e++){        
                        if(arregloRouterTem.get(e).getPort0().contains(arregloSwitchTem.get(id).getName())){                          
                            arregloRouterTem.get(e).setPropertiesConec(0,"true",newName);    
                            routerController.dataUpdatedRou(arregloRouterTem);                            
                        }
                        if(arregloRouterTem.get(e).getPort1().contains(arregloSwitchTem.get(id).getName())){
                            arregloRouterTem.get(e).setPropertiesConec(1,"true",newName);    
                            routerController.dataUpdatedRou(arregloRouterTem);
                        } 
                    } 
                    break;
                case "router":
                    for(int e = 0; e < arregloSwitchTem.size(); e++){
                        for(int a = 0; a < 24; a++){
                            if(arregloSwitchTem.get(e).datoPort(a) != null){
                                if(arregloSwitchTem.get(e).datoPort(a).equalsIgnoreCase(arregloRouterTem.get(id).getName())){
                                    arregloSwitchTem.get(e).setValor(a,newName);    
                                    switchController.dataUpdatedSw(arregloSwitchTem);
                                } 
                            } 
                        }                              
                    } 
                    break;
            }
           
        
        routerController.dataUpdatedRou(arregloRouterTem);
        switchController.dataUpdatedSw(arregloSwitchTem);
        computerController.dataUpdatedPc(arregloComputerTem);
    }
    
    
    //ELIMINA LOS NOMBRES DE LOS OTROS DISPOSITIVOS AL MOMENTO DE ELIMINARLOS
    public void deleteDeviceName(String dis,int id){
        arregloSwitchTem = switchController.dataSwitch();
        arregloComputerTem = computerController.dataComputer();
        arregloRouterTem = routerController.dataRouter();
        
            switch(dis){
                case "pc":
                    for(int e = 0; e < arregloSwitchTem.size(); e++){
                        for(int a = 0; a < 24; a++){
                            if(arregloSwitchTem.get(e).datoPort(a) != null){
                                if(arregloSwitchTem.get(e).datoPort(a).equalsIgnoreCase(arregloComputerTem.get(id).getName())){
                                    arregloSwitchTem.get(e).setValor(a,null);    
                                    switchController.dataUpdatedSw(arregloSwitchTem);
                                } 
                            } 
                        }                              
                    }                    
                    break;
                case "switch":
                    for(int e = 0; e < arregloComputerTem.size(); e++){        
                        if(arregloComputerTem.get(e).getConectadoTo() != null){                          
                            
                            if(arregloComputerTem.get(e).getConectadoTo().equalsIgnoreCase(arregloSwitchTem.get(id).getName())){
                                arregloComputerTem.get(e).setConectadoTo(null);    
                                computerController.dataUpdatedPc(arregloComputerTem);
                            } 
                        }                                                       
                    } 
                    for(int e = 0; e < arregloRouterTem.size(); e++){        
                        if(arregloRouterTem.get(e).getPort0().contains(arregloSwitchTem.get(id).getName())){                          
                            arregloRouterTem.get(e).setPropertiesConec(0,"false","");    
                            routerController.dataUpdatedRou(arregloRouterTem);                            
                        }
                        if(arregloRouterTem.get(e).getPort1().contains(arregloSwitchTem.get(id).getName())){
                            arregloRouterTem.get(e).setPropertiesConec(1,"false","");    
                            routerController.dataUpdatedRou(arregloRouterTem);
                        } 
                    }
                    break;
                case "router":
                    for(int e = 0; e < arregloSwitchTem.size(); e++){
                        for(int a = 0; a < 24; a++){
                            if(arregloSwitchTem.get(e).datoPort(a) != null){
                                if(arregloSwitchTem.get(e).datoPort(a).equalsIgnoreCase(arregloRouterTem.get(id).getName())){
                                    arregloSwitchTem.get(e).setValor(a,null);    
                                    switchController.dataUpdatedSw(arregloSwitchTem);
                                } 
                            } 
                        }                              
                    }
                    break;
            }
           
        
        routerController.dataUpdatedRou(arregloRouterTem);
        switchController.dataUpdatedSw(arregloSwitchTem);
        computerController.dataUpdatedPc(arregloComputerTem);
    }
    
    
    //CONECTA DISPOSITIVOS Y COMO PRUEBA LES PONE EL NOMBRE EN DETERMINADO PUERTO
    public void connectionTo(String dis1, int port1, String dis2, int port2){     
       //Arreglos temporales de cada host, traidos con la funcion de cada controlador.
        arregloSwitchTem = switchController.dataSwitch();
        arregloComputerTem = computerController.dataComputer();
        arregloRouterTem = routerController.dataRouter();
        
        int toSwitch = -1;
        int toPc = -1;
        int toRouter = -1;
        
        String isPc = "no";
        String isSwitch = "no";
        String isRouter = "no";
        
        //Valida que dispositivo es el 1 y le pone si
            for(int i = 0; i < arregloComputerTem.size(); i++){
                if(arregloComputerTem.get(i).getName().equalsIgnoreCase(dis1)){
                    isPc = "si";                   
                }
            }   
            
            for(int e = 0; e < arregloSwitchTem.size(); e++){
                if(arregloSwitchTem.get(e).getName().equalsIgnoreCase(dis1)){
                    isSwitch = "si";                   
                }                
            }
            
            for(int e = 0; e < arregloRouterTem.size(); e++){
                if(arregloRouterTem.get(e).getName().equalsIgnoreCase(dis1)){
                    isRouter = "si";   
                }                
            }
        //---------------------------------------------------------------------
        
        //Connection depende al primer dispositivo
        
            if(isPc.equalsIgnoreCase("si")){
                //Posicion de la pc en el arreglo---
                for(int i = 0; i < arregloComputerTem.size(); i++){
                    if(arregloComputerTem.get(i).getName().equalsIgnoreCase(dis1)){
                        toPc = i;                     
                    }
                }                   
                
                //Posicion del switch en el arreglo---
                for(int e = 0; e < arregloSwitchTem.size(); e++){
                    if(arregloSwitchTem.get(e).getName().equalsIgnoreCase(dis2)){
                        toSwitch = e;                    
                    }                
                }
                
                
                
                //Seteo de datos de connection                            
                if(toPc != -1 && toSwitch != -1){
                    
                    //Elimina el nombre de la pc en el switch para volver a conectarse luego
                        for(int e = 0; e < arregloSwitchTem.size(); e++){
                            for(int a = 0; a < 24; a++){
                                if(arregloSwitchTem.get(e).datoPort(a) != null){
                                    if(arregloSwitchTem.get(e).datoPort(a).equalsIgnoreCase(dis1)){
                                        arregloSwitchTem.get(e).delValor(a);    
                                        switchController.dataUpdatedSw(arregloSwitchTem);
                                    } 
                                } 
                            }                              
                        }
                
                    //Verifica que el puerto este libre para poder setear
                        if(arregloSwitchTem.get(toSwitch).datoPort(port2) != null){
                                for(int i = 0; i < 24; i++){
                                    if(arregloSwitchTem.get(toSwitch).datoPort(i) == null){
                                        arregloSwitchTem.get(toSwitch).setValor(i, dis1);
                                        i = 23;
                                    }                                
                                }                            
                        }else{
                            arregloSwitchTem.get(toSwitch).setValor(port2, dis1);
                        } 
                    //seteo de valores
                    arregloComputerTem.get(toPc).setConectadoTo(dis2); 
                    System.out.println(dis1 + " conectado a "+ dis2);
                    //Actualizacion de datos del arreglo de cada host con el metodo creado en su controllador
                    switchController.dataUpdatedSw(arregloSwitchTem);
                    computerController.dataUpdatedPc(arregloComputerTem);
                }         
            
            }else if(isSwitch.equalsIgnoreCase("si")){
                
                for(int i = 0; i < arregloRouterTem.size(); i++){
                    if(arregloRouterTem.get(i).getName().equalsIgnoreCase(dis2)){
                        toRouter = i;                     
                    }
                }               
                                
                for(int i = 0; i < arregloComputerTem.size(); i++){
                    if(arregloComputerTem.get(i).getName().equalsIgnoreCase(dis2)){
                        toPc = i;                     
                    }
                }   
            
                for(int e = 0; e < arregloSwitchTem.size(); e++){
                    if(arregloSwitchTem.get(e).getName().equalsIgnoreCase(dis1)){
                        toSwitch = e;                    
                    }                
                }
                               
                if(toPc != -1){
                    for(int e = 0; e < arregloSwitchTem.size(); e++){
                        for(int a = 0; a < 24; a++){
                            if(arregloSwitchTem.get(e).datoPort(a) != null){
                                if(arregloSwitchTem.get(e).datoPort(a).equalsIgnoreCase(dis2)){
                                    arregloSwitchTem.get(e).delValor(a);    
                                    switchController.dataUpdatedSw(arregloSwitchTem);
                                } 
                            } 
                        }                              
                    }
                    if(toPc != -1 && toSwitch != -1){
                        if(arregloSwitchTem.get(toSwitch).datoPort(port1) != null){
                            for(int i = 0; i < 24; i++){
                                if(arregloSwitchTem.get(toSwitch).datoPort(i) == null){
                                    arregloSwitchTem.get(toSwitch).setValor(i, dis2);
                                    i = 23;
                                }                                
                            }                            
                        }else{
                            arregloSwitchTem.get(toSwitch).setValor(port1, dis2);
                        }     
                        arregloComputerTem.get(toPc).setConectadoTo(dis1); 
                        System.out.println(dis1 + " conectado a "+ dis2);
                        switchController.dataUpdatedSw(arregloSwitchTem);
                        computerController.dataUpdatedPc(arregloComputerTem);
                    } 
                }else if(toRouter >= 0){     
                    //Eliminar los dispositivos en los otros.
                        if(arregloRouterTem.get(toRouter).getPort0().contains(arregloSwitchTem.get(toSwitch).getName())){
                            arregloRouterTem.get(toRouter).setPropertiesConec(0, "false", ""); 
                        }
                        if(arregloRouterTem.get(toRouter).getPort1().contains(arregloSwitchTem.get(toSwitch).getName())){
                            arregloRouterTem.get(toRouter).setPropertiesConec(1, "false", ""); 
                        }
                    
                        for(int a = 0; a < 24; a++){
                            if(arregloSwitchTem.get(toSwitch).datoPort(a) != null){
                                if(arregloSwitchTem.get(toSwitch).datoPort(a).equalsIgnoreCase(dis2)){
                                    arregloSwitchTem.get(toSwitch).delValor(a);    
                                    switchController.dataUpdatedSw(arregloSwitchTem);
                                }
                            } 
                        }  

                        if(toRouter != -1 && toSwitch != -1){
                            if(arregloSwitchTem.get(toSwitch).datoPort(port1) != null){
                                for(int i = 0; i < 24; i++){
                                    if(arregloSwitchTem.get(toSwitch).datoPort(i) == null){
                                        arregloSwitchTem.get(toSwitch).setValor(i, dis2);
                                        i = 23;
                                    }                                
                                }                            
                            }else{
                                arregloSwitchTem.get(toSwitch).setValor(port1, dis2);
                            }
                            
                           // arregloSwitchTem.get(toSwitch).setValor(port1, dis2);
                            arregloRouterTem.get(toRouter).setPropertiesConec(port2, "true", dis1); 
                            System.out.println(dis1 + " conectado a "+ dis2);
                            routerController.dataUpdatedRou(arregloRouterTem);
                            computerController.dataUpdatedPc(arregloComputerTem);
                        } 

                        arregloSwitchTem = switchController.dataSwitch();
                        arregloComputerTem = computerController.dataComputer();
                        arregloRouterTem = routerController.dataRouter();


                        //Virifica con quien sigue conectado
                        for(int e = 0; e < arregloRouterTem.size(); e++){
                            for(int i = 0; i < arregloSwitchTem.size(); i++){
                                if(arregloRouterTem.get(e).getPort0().contains(arregloSwitchTem.get(i).getName()) 
                                        || arregloRouterTem.get(e).getPort1().contains(arregloSwitchTem.get(i).getName()) ){

                                }else{
                                    for(int a = 0; a < 24; a++){
                                        if(arregloSwitchTem.get(i).datoPort(a) != null){
                                            if(arregloSwitchTem.get(i).datoPort(a).equalsIgnoreCase(arregloRouterTem.get(e).getName())){
                                                arregloSwitchTem.get(i).delValor(a);    
                                                switchController.dataUpdatedSw(arregloSwitchTem);
                                            }
                                        } 
                                    }    
                                }
                            }                       
                        }
                    
                    
                             
                }
            
            }else if(isRouter.equalsIgnoreCase("si")){
                
                    for(int i = 0; i < arregloRouterTem.size(); i++){
                        if(arregloRouterTem.get(i).getName().equalsIgnoreCase(dis1)){
                            toRouter = i;                     
                        }
                    }            

                    for(int e = 0; e < arregloSwitchTem.size(); e++){
                        if(arregloSwitchTem.get(e).getName().equalsIgnoreCase(dis2)){
                            toSwitch = e;                    
                        }                
                    }
                
                   

                    if(toRouter != -1 && toSwitch != -1){
                        if(arregloRouterTem.get(toRouter).getPort0().contains(arregloSwitchTem.get(toSwitch).getName())){
                            arregloRouterTem.get(toRouter).setPropertiesConec(0, "false", ""); 
                        }
                        if(arregloRouterTem.get(toRouter).getPort1().contains(arregloSwitchTem.get(toSwitch).getName())){
                            arregloRouterTem.get(toRouter).setPropertiesConec(1, "false", ""); 
                        }

                        for(int a = 0; a < 24; a++){
                            if(arregloSwitchTem.get(toSwitch).datoPort(a) != null){
                                if(arregloSwitchTem.get(toSwitch).datoPort(a).equalsIgnoreCase(dis1)){
                                    arregloSwitchTem.get(toSwitch).delValor(a);    
                                    switchController.dataUpdatedSw(arregloSwitchTem);
                                }
                            } 
                        }  
                        
                        if(arregloSwitchTem.get(toSwitch).datoPort(port2) != null){
                            for(int i = 0; i < 24; i++){
                                if(arregloSwitchTem.get(toSwitch).datoPort(i) == null){
                                    arregloSwitchTem.get(toSwitch).setValor(i, dis1);
                                    i = 23;
                                }                                
                            }                            
                        }else{
                            arregloSwitchTem.get(toSwitch).setValor(port2, dis1);
                        }
                            arregloRouterTem.get(toRouter).setPropertiesConec(port1, "true", dis2); 
                            System.out.println(dis1 + " conectado a "+ dis2);
                            routerController.dataUpdatedRou(arregloRouterTem);
                            computerController.dataUpdatedPc(arregloComputerTem);
                            
                        //Trae nuevamente los datos
                        arregloSwitchTem = switchController.dataSwitch();
                        arregloComputerTem = computerController.dataComputer();
                        arregloRouterTem = routerController.dataRouter();

                     //Eliminar el router del que no este conectado a el
                        for(int e = 0; e < arregloRouterTem.size(); e++){
                            for(int i = 0; i < arregloSwitchTem.size(); i++){
                                if(arregloRouterTem.get(e).getPort0().contains(arregloSwitchTem.get(i).getName()) 
                                        || arregloRouterTem.get(e).getPort1().contains(arregloSwitchTem.get(i).getName()) ){

                                }else{
                                    for(int a = 0; a < 24; a++){
                                        if(arregloSwitchTem.get(i).datoPort(a) != null){
                                            if(arregloSwitchTem.get(i).datoPort(a).equalsIgnoreCase(arregloRouterTem.get(e).getName())){
                                                arregloSwitchTem.get(i).delValor(a);    
                                                switchController.dataUpdatedSw(arregloSwitchTem);
                                            }
                                        } 
                                    }    
                                }
                            }                       
                        }
                    } 

                        
                
            }
        
                 
    }
    
    public void ping(String name, String ip){
        arregloSwitchTem = switchController.dataSwitch();
        arregloComputerTem = computerController.dataComputer();
        arregloRouterTem = routerController.dataRouter();
        
        
        
        
        
    }
    
    
}
