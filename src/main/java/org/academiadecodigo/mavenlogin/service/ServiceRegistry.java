package org.academiadecodigo.mavenlogin.service;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by codecadet on 28/11/16.
 */
public class ServiceRegistry {

    Map<String, Service> registry = new HashMap<>();

    private static ServiceRegistry ourInstance = new ServiceRegistry();

    public static ServiceRegistry getInstance() {
        return ourInstance;
    }

    private ServiceRegistry() {
    }

    public void add(Service service){
        registry.put(service.getName(), service);
    }

    public Service getRegistry(String name){
        return registry.get(name);
    }
}
