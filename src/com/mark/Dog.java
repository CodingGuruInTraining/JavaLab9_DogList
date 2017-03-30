package com.mark;

/**
 * Created by hl4350hb on 3/29/2017.
 */
public class Dog {
    private String name;
    private double age;
    private boolean isPuppy;

    public Dog(String name, double age, boolean isPuppy) {
        this.name = name;
        this.age = age;
        this.isPuppy = isPuppy;
    }

    @Override
    public String toString() {
        if (isPuppy) {
            return "Puppy's name is " + name + " and age is " + age;
        }
        return "Dog's name is " + name + " and age is " + age;
    }

}
