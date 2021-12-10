package jndiserver;

import java.util.Hashtable;

import javax.naming.Context;
import javax.naming.InitialContext;

public class Lookup {

    @SuppressWarnings("unchecked")
    public static void main(String[] args) {

        final Hashtable _properties = new Hashtable();

        _properties.put("java.naming.factory.initial", "org.jnp.interfaces.NamingContextFactory");
        _properties.put("java.naming.provider.url",    "jnp://127.0.1.1:15400");

        try{
            final Context _context = new InitialContext(_properties);

            System.out.println("Lookup RESULT: " + _context);
            System.out.println("Lookup RESULT: " + _context.lookup("java:comp"));
            System.out.println("Lookup RESULT: " + _context.lookup("java:jdbc"));

            // if kill actually works this is the last operation to happen
            System.out.println("Lookup RESULT: " + _context.lookup("java:kill"));

            System.out.println("Lookup RESULT: " + _context.lookup("java:clazz"));
            Object x = _context.lookup("java:clazz");
            System.out.println("Lookup RESULT: " + x.getClass().getName());


        } catch (Exception _e) {
            _e.printStackTrace();
        }
    }

}