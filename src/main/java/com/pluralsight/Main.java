package com.pluralsight;

import com.pluralsight.Terminal.Display;

public class Main
{
    public static void main(String[]args)
    {
                Display display = new Display();
                HomeScreen homeScreen = new HomeScreen(display);
                homeScreen.display();
    }

}
