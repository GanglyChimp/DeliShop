package com.pluralsight;

import com.pluralsight.Model.Menu;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class OrderScreenTest
{

    @Test

    public void testBreadSelection()
    {
        // simulate user picking option 1 (white bread)
        int breadChoice = 1;
        String bread = Menu.breadType[breadChoice - 1];
        assertEquals("white", bread);


    }

    @Test
    public void testSizeSelectionFourInch()
    {
        int sizeChoice = 1;
        String size = Menu.SizesInch[sizeChoice - 1];
        assertEquals("4", size);
    }

    @Test
    public void testSizeSelectionEightInch()
    {
        int sizeChoice = 2;
        String size = Menu.SizesInch[sizeChoice - 1];
        assertEquals("8", size);
    }

    @Test
    public void testSizeSelectionTwelveInch()
    {
        int sizeChoice = 3;
        String size = Menu.SizesInch[sizeChoice - 1];
        assertEquals("12", size);
    }

    @Test
    public void testSizeSelectionBoundary()
    {
        int sizeChoice = Menu.SizesInch.length;
        String size = Menu.SizesInch[sizeChoice - 1];
        assertEquals("12", size);
    }

    @Test
    public void testCheeseSelectionAmerican()
    {
        int cheeseChoice = 1;
        String cheese = Menu.cheeseType[cheeseChoice - 1];
        assertEquals("American", cheese);
    }
}