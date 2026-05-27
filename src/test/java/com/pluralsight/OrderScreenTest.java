package com.pluralsight;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class OrderScreenTest
{

    @Test

    public void testBreadSelection() {
        // simulate user picking option 1 (white bread)
        int breadChoice = 1;
        String bread = Menu.breadType[breadChoice - 1];
        assertEquals("white", bread);
    }


}