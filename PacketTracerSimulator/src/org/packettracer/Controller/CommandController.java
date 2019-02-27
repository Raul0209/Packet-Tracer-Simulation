package org.packettracer.Controller;

import java.util.Scanner;

import org.packettracer.Controller.SwitchController;
import org.packettracer.Controller.RouterController;
import org.packettracer.View.CommandEngineView;

public class CommandController {
    
    Scanner dt = new Scanner(System.in);
    SwitchController switchController = new SwitchController();
    RouterController routerController = new RouterController();
    ComputerController computerController = new ComputerController();
    CommandEngineView commandEngineView = new CommandEngineView();
    String[] createCommands = {"Create Router","Create Switch","Create Pc",
        "Show Switch","Show Router","Show Pc", "Update Router","Update Switch",
        "Update Pc","Delete Router","Delete Switch","Delete Pc", "Create ?",
        "Update ?", "Delete ?", "ipconfig pc", "defaultgateway pc"}; 
    
    public void commandEngine(){
        String command = "";
        System.out.println("Packet Tracer (Simulator)");
        do{
           System.out.print(">");
            command = dt.nextLine();
            String[] com=command.split("\\ ");
                        
            try{            
                for(int i = 0; i < createCommands.length; i++){
                    if(createCommands[i].equalsIgnoreCase(com[0] + " " +com[1])){
                        switch(createCommands[i]){
                            case "Create Router":
                                routerController.createRouter(com[2]);
                                break;
                            case "Create Switch" :
                                switchController.createSwitch(com[2]);
                                break;
                            case "Create Pc" :
                                computerController.createComputer(com[2]);
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
                                routerController.editRouter(Integer.parseInt(com[2]), com[3]);
                                break;
                            case "Update Switch" :
                                switchController.editSwitch(Integer.parseInt(com[2]), com[3]);
                                break;
                            case "Update Pc" :
                                computerController.editComputer(Integer.parseInt(com[2]), com[3]);
                                break;
                            case "Delete Router":
                                routerController.deleteRouter(Integer.parseInt(com[2]));
                                break;
                            case "Delete Switch" :
                                switchController.deleteSwitch(Integer.parseInt(com[2]));
                                break;
                            case "Delete Pc" :
                                computerController.deleteComputer(Integer.parseInt(com[2]));
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
                            case "ipconfig pc":
                                computerController.addIpAddress(com[2], com[3], com[4]);
                                break;
                            case "defaultgateway pc":
                                computerController.addDefaultGateway(com[2], com[3]);
                                break;
                        }
                    }
                }
            }catch(Exception e){
                System.out.println(">Syntax Error.");
            }                          
            
        }while(!command.equalsIgnoreCase("exit"));
    }
    
}
