package com.pluralsight;
import com.pluralsight.Terminal.MenuItem;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Sandwich implements MenuItem
{
    private String bread;
    private String size;
    private Map<String, Integer> meats;
    private Map<String, Integer> Cheese;
    private List<String> Toppings;
    private List<String> Sauces;
    private boolean Toasted;


    public Sandwich(String bread, String size)
    {
        this.bread=bread;
        this.size=size;
        this.meats = new HashMap<>();
        this.Cheese = new HashMap<>();
        this.Toppings = new ArrayList<>();
        this.Sauces = new ArrayList<>();
        this.Toasted = false;
    }

    public void addMeats(String meat)
    {
        if (meats.containsKey(meat)) {
            meats.put(meat, meats.get(meat) + 1);
        } else {
            meats.put(meat, 1);
        }
    }

    public Map<String,Integer>getmeats()
    {
        return  meats;
    }

    public void addCheese(String Cheese)
    {
        if (this.Cheese.containsKey(Cheese))
        {
            //if there is already a cheese selected this will add another, "extra cheese"
            this.Cheese.put(Cheese, this.Cheese.get(Cheese) + 1);
        }
        else
        {
            //if there isn't an option it will add what the user enters
            this.Cheese.put(Cheese, 1);

            //user ask for pepper, if there isn't it goes to else, add pepper,
            //then if it is entered again it ups the count +1,
            // any new item will be added in the first if statement
        }
    }

    public void addToppings(String Topping)
    {
    Toppings.add(Topping);
    }

    public void addSauces(String Sauce)
    {
    Sauces.add(Sauce);
    }

    public void setToasted(boolean toasted)
    {
        this.Toasted=toasted;
    }

    //pricing
    private double getBasePrice()
    {
        switch (size)
        {
            case "4":  return 5.50;
            case "8":  return 7.00;
            case "12": return 8.50;
            default:   return 0.00;
        }
    }

    private double getMeatPrice()
    {
        switch (size)
        {
            case "4":  return 1.00;
            case "8":  return 2.00;
            case "12": return 3.00;
            default:   return 0.00;
        }
    }
    //extra meats
    private double getExtraMeatPrice()
    {
        switch (size)
        {
            case "4":  return 0.50;
            case "8":  return 1.00;
            case "12": return 1.50;
            default:   return 0.00;
        }
    }

    private double getCheesePrice()
    {
        switch (size)
        {
            case "4":  return 0.75;
            case "8":  return 1.50;
            case "12": return 2.25;
            default:   return 0.00;
        }
    }

    private double getExtraCheesePrice()
    {
        switch (size)
        {
            case "4":  return 0.30;
            case "8":  return 0.60;
            case "12": return 0.90;
            default:   return 0.00;
        }
    }

    @Override
    public double getPrice()
    {
        {
        double meatTotal = meats.entrySet().stream()
                .mapToDouble(e -> getMeatPrice() +
                 Math.max(0, e.getValue() - 1) * getExtraMeatPrice())
                .sum();

        double cheeseTotal = Cheese.entrySet().stream()
                .mapToDouble(e -> getCheesePrice() +
                 Math.max(0, e.getValue() - 1) * getExtraCheesePrice())
                .sum();

        return getBasePrice() + meatTotal + cheeseTotal;
         }
    }

    @Override
    public String getOptions()
    {
        return "Sandwich: " +size+ "||"+" "+ bread+ " "+"||"+Cheese+ " "+"||"+Toppings+
         " "+ "||"+Sauces+" "+ "||"+Toasted;
    }
}


