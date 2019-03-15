package org.packettracer.Model;

import java.util.ArrayList;

public class Switch {
    
    private String name;
    private String[] intEthernet;

    public Switch() { }   

    public Switch(String name, int intEthernet) {
        this.name = name;
        this.intEthernet = new String[intEthernet];
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getIntEthernet() {
        String puertos = "";
        
            for(int i = 0; i < intEthernet.length; i++){
                puertos +="\n"+"\t"+ "Ethernet"+i+") "+intEthernet[i];
            }
        return puertos;
    }

    public void setIntEthernet(int intEthernet) {
        this.intEthernet = new String[intEthernet];
    }    
    
    public void setValor(int port, String valor) {
        this.intEthernet[port] = valor;
    }    
    
     public void delValor(int port) {
        this.intEthernet[port] = null;
    }  
    
    public String datoPort(int index) {       
        return intEthernet[index];
    }
}
