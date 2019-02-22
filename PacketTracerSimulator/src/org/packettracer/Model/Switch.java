package org.packettracer.Model;

public class Switch {
    
    private String name;
    private int[] intEthernet;

    public Switch() { }   

    public Switch(String name, int intEthernet) {
        this.name = name;
        this.intEthernet = new int[intEthernet];
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int[] getIntEthernet() {
        return intEthernet;
    }

    public void setIntEthernet(int intEthernet) {
        this.intEthernet = new int[intEthernet];
    }    
}
