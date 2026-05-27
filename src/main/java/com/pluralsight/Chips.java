package com.pluralsight;

import com.pluralsight.Terminal.MenuItem;

public class Chips implements MenuItem

{
    private String type;


    public Chips(String type)
    {
        this.type=type;

    }



    @Override
    public double getPrice()
    {
        return 1.50;
    }

    @Override
    public String getOptions()
    {
        return "Chips" + type;
    }
}
