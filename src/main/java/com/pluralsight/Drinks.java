package com.pluralsight;

import com.pluralsight.Terminal.MenuItem;

public class Drinks implements MenuItem
{

   private String size;
   private String flavor;
    //constructors size/flaovr or type of drink
   public Drinks(String size, String flavor)
   {
       this.size=size;
       this.flavor=flavor;

   }





    //in menu item it returns the price based on a case of S/M/L with prices listed
    @Override
    public double getPrice()
    {
        return switch (size.toLowerCase())
        {
            case "small" -> 2.00;
            case "medium" -> 2.50;
            case "large" -> 3.00;
            default -> 0.0;
        };
    }

    @Override
    public String getOptions()
    {
        return "Drink: " + size + " " + flavor;
    }
}
