package entity;

import Services.EtudiantService;
import Services.FormateurService;

import java.lang.reflect.InvocationTargetException;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class Factory {

    private static final Map<Class<?>, Object> instances = new ConcurrentHashMap<>();

    public static <T> void add(Class<T> serviceClass) {
        try {
            T instance = serviceClass.getDeclaredConstructor().newInstance();
            instances.put(serviceClass, instance);
        } catch (InstantiationException | IllegalAccessException | NoSuchMethodException | InvocationTargetException e) {
            throw new RuntimeException("Error creating instance for class: " + serviceClass.getName(), e);
        }
    }

    @SuppressWarnings("unchecked")
    public static <T> T get(Class<T> serviceClass) {
        return (T) instances.get(serviceClass);
    }




}
