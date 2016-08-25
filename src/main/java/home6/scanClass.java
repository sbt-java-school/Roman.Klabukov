package home6;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.util.Stack;

/**
 * Created by rmk9 on 24.08.16.
 */
public class scanClass {

    public static void printClass(final Class clazz) {

        System.out.println("\n");
        if (Modifier.isAbstract(clazz.getModifiers())) {
            System.out.print("abstract ");
        }
        if (Modifier.isFinal(clazz.getModifiers())) {
            System.out.print("final ");
        }
        if (Modifier.isStatic(clazz.getModifiers())) {
            System.out.print("static ");
            if (Modifier.isPrivate(clazz.getModifiers())) {
                System.out.print("private ");
            }
            if (Modifier.isProtected(clazz.getModifiers())) {
                System.out.print("protected ");
            }
        }
        if (Modifier.isPublic(clazz.getModifiers())) {
            System.out.print("public ");
        }
        System.out.println("class " + clazz.getName());

    }

    public static void printSuperclasses(final Class clazz) {

        System.out.println("\nSuperclasses:");
        Class current = clazz.getSuperclass();
        Stack superclasses = new Stack();
        while(current != null) {
            superclasses.add(current);
            current = current.getSuperclass();
        }
        while(superclasses.size() > 0) {
            System.out.println(superclasses.pop() + "; ");
        }

    }

    public static void printInterfaces(final Class clazz) {

        System.out.println("\nInterfaces:");
        for(Class cInterface : clazz.getInterfaces()) {
            System.out.println( cInterface.getName() + "; ");
        }

    }

    public static void printFields(final Class clazz) {

        System.out.println("\nFields:");
        for (Field field : clazz.getDeclaredFields()) {
            System.out.print(field.getType().getName() + " ");
            System.out.println(field.getName() + ";");
        }

    }

    public static void printConstructors(final Class clazz) {

        System.out.println("\nConstructors(param types): ");
        for (Constructor constructor : clazz.getConstructors()) {
            for (Class paramType : constructor.getParameterTypes()) {
                System.out.print(paramType.getName() + " ");
            }
            System.out.println();
        }

    }

    public static void printMethods(final Class clazz) {

        System.out.println("\nMethods:");
        Method[] methods = clazz.getMethods();
        for (Method method : methods) {
            System.out.print(method.getReturnType().getName() + " ");
            System.out.print(method.getName() + "(");

            Class[] paramTypes = method.getParameterTypes();
            for (Class paramType : paramTypes) {
                System.out.print(paramType.getName() + " ");
            }
            System.out.println(")");
        }

    }

    public static void main(String[] args) throws ClassNotFoundException {

        Class clazz = Class.forName(args[0]);

        scanClass.printClass(clazz);
        scanClass.printSuperclasses(clazz);
        scanClass.printInterfaces(clazz);
        scanClass.printConstructors(clazz);
        scanClass.printMethods(clazz);
        scanClass.printFields(clazz);

    }


}
