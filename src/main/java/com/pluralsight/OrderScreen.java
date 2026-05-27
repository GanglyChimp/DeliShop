package com.pluralsight;

import com.pluralsight.Terminal.Display;

public class OrderScreen {
    private Display display;
    private Order order;

    public OrderScreen(Display display)
    {
        this.display = display;
        this.order = new Order();
    }

    public void display()
    {
        while (true)
        {
            this.display.printHeader("Order Screen");
            this.display.printLine("1) Add Sandwich");
            this.display.printLine("2) Add Drink");
            this.display.printLine("3) Add Chips");
            this.display.printLine("4) Checkout");
            this.display.printLine("0) Cancel Order");
            this.display.printLine("============================");

            int choice = this.display.getMenuChoice(0, 4);

            switch (choice)
            {
                case 1:
                    //initial selection of bread type
                    this.display.printHeader("Select Bread");
                    this.display.printMenu(Menu.breadType);
                    int breadChoice = this.display.getMenuChoice(1, Menu.breadType.length);
                    String bread = Menu.breadType[breadChoice - 1];
                    //size
                    //create sandwich
                    //select meats
                    //choose cheese
                    //toppings
                    // sauces
                    //toasted y/n
                    //add order.
                    break;
                case 2:
                    //  addDrink()
                    break;
                case 3:
                    // addChips()
                    break;
                case 4:
                    // checkout()
                    break;
                case 0:
                    this.order.cancelOrder();
                    this.display.printLine("Order cancelled.");
                    return;
            }
        }
    }
}