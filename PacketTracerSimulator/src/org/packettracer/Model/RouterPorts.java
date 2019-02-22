package org.packettracer.Model;

public class RouterPorts {
    private String ip;
    private String type;
    private String number;

    public RouterPorts(String ip, String type, String number) {
        this.ip = ip;
        this.type = type;
        this.number = number;
    }
    
    public String getIp() {
        return ip;
    }

    public void setIp(String ip) {
        this.ip = ip;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }
    
    
}


