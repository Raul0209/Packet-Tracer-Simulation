package org.packettracer.Sistema;

import org.packettracer.Controller.CommandController;

public class Principal {
    public static void main(String []args){
        
        CommandController engine = new CommandController();
        engine.commandEngine();
    }
}
