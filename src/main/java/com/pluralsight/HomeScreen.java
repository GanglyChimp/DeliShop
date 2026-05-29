package com.pluralsight;
import com.pluralsight.Terminal.Display;
import com.pluralsight.order.OrderScreen;

public class HomeScreen
     {

        private Display display;

        public HomeScreen(Display display)
        {
            this.display = display;
        }

        public void display() {
            while (true)
            {
//                this.display.clearScreen();
                this.display.printHeader("Welcome to the Sandwich Shop");
                this.display.printLine("1) New Order");
                this.display.printLine("0) Exit");
                this.display.printLine("============================");

                int choice = this.display.getMenuChoice(0, 1);

                switch (choice)
                {
                    case 1:

                        this.display.printLine("Starting new order...");
                        OrderScreen orderScreen=new OrderScreen(this.display);
                        orderScreen.display();
                        break;
                    case 0:
                        this.display.printLine("Goodbye, thank you for visiting!");
                        System.exit(0);
                        break;
                }
            }
        }
    }
