package org.simulatorpackettracer.controller;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import org.simulatorpackettracer.controller.SwitchController;

public class Inicio {
    private String comandoIngresado;    
    private SwitchController switchCrud = new SwitchController();
    Scanner sc = new Scanner(System.in);   
    
    
    public void ingresoComandos(){
        comandoIngresado = sc.nextLine();
        this.menuDispositivos(comandoIngresado);        
    }
    public void menuDispositivos(String dispositivo){
        List<String> l = Arrays.asList(dispositivo.split(" "));
        if(l.size()>=3){
            switch(l.get(1).toLowerCase()){
                case "switch":
                    this.menuSwitch(dispositivo);
                    break;
                case "router":
                    this.menuRouter(dispositivo);
                    break;
                case "pc":
                    this.menuPc(dispositivo);
            }            
        }        
    }
    public void menuSwitch(String opcion){
        List<String> l = Arrays.asList(opcion.split(" "));
        
        if(l.size() >= 3){
            switch(l.get(0).toLowerCase()){
                case "create":
                    switchCrud.createSwitch(l.get(2));
                    switchCrud.listSwitches();
                    break;
                case "update":
                    System.out.println("Menu switch editar");
                    break;
                case "delete":
                    System.out.println("Menu switch eliminar");
            }
            
        }        
        
    }
    
    public void menuRouter(String opcion){
        List<String> l = Arrays.asList(opcion.split(" "));
        
        if(l.size() >= 3){
            switch(l.get(0).toLowerCase()){
                case "create":
                    System.out.println("Menu router crear");
                    break;
                case "update":
                    System.out.println("Menu router editar");
                    break;
                case "delete":
                    System.out.println("Menu router eliminar");
            }            
        }        
        
    }
    
    public void menuPc(String opcion){
        List<String> l = Arrays.asList(opcion.split(" "));
        
        if(l.size() >= 3){
            switch(l.get(0).toLowerCase()){
                case "create":
                    System.out.println("Menu pc crear");
                    break;
                case "update":
                    System.out.println("Menu pc editar");
                    break;
                case "delete":
                    System.out.println("Menu pc eliminar");
            }            
        }        
    }
    
    /*public void palabraInicio(String primeraPalabra){
        //System.out.println(primeraPalabra);
        List<String> l = Arrays.asList(primeraPalabra.split(" "));
        if(l.size() >= 3){
            for(int i=0; i<palabrasInicio.length; i++){
            if (l.get(0).equalsIgnoreCase(palabrasInicio[i])){                
                dispositivo(primeraPalabra);
            }
            
        }
        System.out.println("No se reconoce el comando ejecutado");
        this.ingresoComandos();
            
        }
        //System.out.println("No se reconoce el comando ejecutado");
        //this.ingresoComandos();
        
    }
    public void dispositivo(String dispositivo){
        List<String> l = Arrays.asList(dispositivo.split(" "));
        //System.out.println(dispositivo);
        if(l.size() >= 3){
            for(int i=0; i<dispositivos.length; i++){
            if (l.get(1).equalsIgnoreCase(dispositivos[i])){                
                this.ingresoComandos();
            }            
        }
        System.out.println("No se reconoce el comando ejecutado");
        this.ingresoComandos();
            
        }
        //System.out.println("No se reconoce el comando ejecutado");
        //this.ingresoComandos();
    }
    public void nombreDispositivo(String nombre){
        //System.out.println(primeraPalabra);
        List<String> l = Arrays.asList(nombre.split(" "));
        if(l.size() >= 3){
            for(int i=0; i<l.size(); i++){
                System.out.println(l.get(i));
            
        }
        
        this.ingresoComandos();
            
        }
        //System.out.println("No se reconoce el comando ejecutado");
        //this.ingresoComandos();
        
    }*/
}
