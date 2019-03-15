
package org.packettracer.Model;

public class Computer {
    
    private String name;
    private String ipAddress;
    private String subNetMask;
    private String defaultGateway;
    private String conectadoTo;
    

    public Computer() { 
    }   

    public Computer(String name) {
        this.name = name;
    }        

    public Computer(String name, String ipAddress, String subNetMask, String defaultGateway, String conectadoTo) {
        this.name = name;
        this.ipAddress = ipAddress;
        this.subNetMask = subNetMask;
        this.defaultGateway = defaultGateway;
        this.conectadoTo = conectadoTo;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getIpAddress() {
        return ipAddress;
    }

    public void setIpAddress(String ipAddress) {
        this.ipAddress = ipAddress;
    }

    public String getSubNetMask() {
        return subNetMask;
    }

    public void setSubNetMask(String subNetMask) {
        this.subNetMask = subNetMask;
    }

    public String getDefaultGateway() {
        return defaultGateway;
    }

    public void setDefaultGateway(String defaultGateway) {
        this.defaultGateway = defaultGateway;
    }

    public String getConectadoTo() {
        return conectadoTo;
    }

    public void setConectadoTo(String conectadoTo) {
        this.conectadoTo = conectadoTo;
    }

    
}