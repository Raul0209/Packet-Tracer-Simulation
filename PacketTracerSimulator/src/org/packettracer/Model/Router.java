package org.packettracer.Model;

import java.util.ArrayList;

public class Router {
    private String name;
    String[][] port;
       
    public Router(){}
    
    public Router(String name, int port) {
        this.name = name;
        this.port = new String[port][port+2];
        for(int i = 0; i < 2; i++){
            this.port[i][0] = "0";
            this.port[i][1] = "0";
            this.port[i][2] = "false";
            this.port[i][3] = "";
        }
    }
    
    public void setPropertiesPort(String name, int port, String ip, String mascara) {      
        this.port[port][0] = ip;
        this.port[port][1] = mascara;
    }
    
    public void setPropertiesConec(int port, String conectado, String dispositivo) {            
        this.port[port][2] = conectado;
        this.port[port][3] = dispositivo;
    }
    
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPort0() {
        String retorno = "";
        
            for(int j = 0;j < 4; j++){
                switch(j){
                    case 0:
                        retorno += " Ip: " + port[0][j];
                        break;
                    case 1:
                        retorno += " Mascara: " + port[0][j];
                        break;
                    case 2:
                        retorno += " Shutdown: " + port[0][j];
                        break;
                    case 3:
                        retorno += " Connect-To: " + port[0][j];
                        break;
                }               
            }
        
        return retorno;
    }

     public String getPort1() {
        String retorno = "";
        
            for(int j = 0; j < 4; j++){
               switch(j){
                    case 0:
                        retorno += " Ip: " + port[1][j];
                        break;
                    case 1:
                        retorno += " Mascara: " + port[1][j];
                        break;
                    case 2:
                        retorno += " Shutdown: " + port[1][j];
                        break;
                    case 3:
                        retorno += " Connect-To: " + port[1][j];
                        break;
                } 
            }
        
        return retorno;
    }
     
}
