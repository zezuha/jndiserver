package jndiserver;

import java.net.InetAddress;
import java.util.Hashtable;
import java.util.concurrent.Callable;

import javax.naming.Context;
import javax.naming.InitialContext;

import org.jnp.server.Main;
import org.jnp.server.NamingBeanImpl;


public class StandaloneJNDIServer implements Callable<Object> {

    public Object call() throws Exception {
        setup();
        return null;
    }

    @SuppressWarnings("unchecked")
    private void setup() throws Exception {
        //configure the initial factory
        //**in John´s code we did not have this**
        System.setProperty(Context.INITIAL_CONTEXT_FACTORY, "org.jnp.interfaces.NamingContextFactory");

        //start the naming info bean
        final NamingBeanImpl _naming = new NamingBeanImpl();
        _naming.start();

        //start the jnp serve
        final Main _server = new Main();
        _server.setNamingInfo(_naming);
        _server.setPort(15400);
        _server.setBindAddress(InetAddress.getLocalHost().getHostName());
        _server.start();

        // bind under names
        final Context _context = new InitialContext();
        _context.bind("jdbc", "myJDBC");
        _context.bind("kill", Evil.class);
        _context.bind("clazz", String.class);
    }

    public static void main(String... args) {
        try{
            new StandaloneJNDIServer().call();
        } catch(Exception _e){
            _e.printStackTrace();
        }

    }
}