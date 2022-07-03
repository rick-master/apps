package com.example.pizzafirebaseconnect;

public class Pizzas {

    // variables for storing our data.
    private String pizzaName, pizzaCrust, pizzaCost;

    public Pizzas() {
        // empty constructor


        // required for Firebase.
    }

    // Constructor for all variables.
    public Pizzas(String pizzaName, String pizzaCrust, String pizzaCost) {
        this.pizzaName = pizzaName;
        this.pizzaCrust = pizzaCrust;
        this.pizzaCost = pizzaCost;
    }

    // getter methods for all variables.
    public String getCourseName() {
        return pizzaName;
    }

    public void setCourseName(String pizzaName) {
        this.pizzaName = pizzaName;
    }

    public String getCourseDescription() {
        return pizzaCrust;
    }

    // setter method for all variables.
    public void setCourseDescription(String pizzaCrust) {
        this.pizzaCrust = pizzaCrust;
    }

    public String getCourseDuration() {
        return pizzaCost;
    }

    public void setCourseDuration(String pizzaCost) {
        this.pizzaCost = pizzaCost;
    }
}
