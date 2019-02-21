package org.packettracer.View;

public class CommandEngineView {

    public void creates(){      
        System.out.println(" Create Router 'name'");
        System.out.println(" Create Switch 'name'");    
        System.out.println(" Create Pc 'name'");
    }  
    
    public void updates(){      
        System.out.println(" Update Router 'id, name'");
        System.out.println(" Update Switch 'id, name'");    
        System.out.println(" Update Pc 'id, name'");
    } 
    
    public void deletes(){      
        System.out.println(" Delete Router 'id'");
        System.out.println(" Delete Switch 'id'");    
        System.out.println(" Delete Pc 'id'");
    } 

}
