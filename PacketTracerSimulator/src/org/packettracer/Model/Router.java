package org.packettracer.Model;

import java.util.ArrayList;
import org.packettracer.Model.RouterPorts;

public class Router {
    private String name;
    private int[] port;
    
    static ArrayList<RouterPorts> portObject = new ArrayList<RouterPorts>();
       
    public Router(){}
    public Router(String name, int port) {
        this.name = name;
        this.port = new int[port];
    }
    
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int[] getPort() {
        return port;
    }

    public void setPort(int port) {
        this.port = new int [port];
    }
    
    
}
