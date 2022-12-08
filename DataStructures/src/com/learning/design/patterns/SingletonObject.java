package com.learning.design.patterns;

//This pattern involves a single class which is responsible to create an object while making
// sure that only single object gets created.
// This class provides a way to access its ONLY object which can be accessed directly
// without need to instantiate the object of the class.

//Single object throughout the session.
class SingletonExampleClass {

    //Early Initialization.
    //private static SingletonExampleClass singleObject = new SingletonExampleClass();

    //Lazy Initialization
    private static SingletonExampleClass singleObject;

    //Constructor -> BLOCK Creating the object!
    //By making this Constructor private
    private SingletonExampleClass() {
    }

    public static SingletonExampleClass getInstance() {
        if (singleObject == null) {
            singleObject = new SingletonExampleClass();
        }
        return singleObject;
    }
}

public class SingletonObject {


    public static void main(String[] args) {
        SingletonExampleClass object1 = SingletonExampleClass.getInstance();
        SingletonExampleClass object2 = SingletonExampleClass.getInstance();
        SingletonExampleClass object3 = SingletonExampleClass.getInstance();

        System.out.println("Hashcode of object1 :-  " + object1.hashCode());
        System.out.println("Hashcode of object2 :-  " + object2.hashCode());
        System.out.println("Hashcode of object3 :-  " + object3.hashCode());
    }

}

