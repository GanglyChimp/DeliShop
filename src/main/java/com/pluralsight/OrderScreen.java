package com.pluralsight;

import com.pluralsight.Terminal.Display;
import com.pluralsight.Terminal.MenuItem;

import java.util.List;

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
            this.display.printLine("5) Remove Item");
            this.display.printLine("0) Cancel Order");
            this.display.printLine("============================");

            int choice = this.display.getMenuChoice(0, 5);

            switch (choice)
            {
                case 1:
                    //initial selection of bread type
                    this.display.printHeader("Select Bread");
                    this.display.printMenu(Menu.breadType);
                    int breadChoice = this.display.getMenuChoice(1, Menu.breadType.length);

                    String bread = Menu.breadType[breadChoice - 1];
                    this.display.printLine(bread + "  Bread selected.");
                    //size
                    this.display.printHeader("Select Size");
                    this.display.printMenu(Menu.SizesInch);
                    int sizeChoice = this.display.getMenuChoice(1, Menu.SizesInch.length);

                    String size = Menu.SizesInch[sizeChoice - 1];

                    //create sandwich
                    Sandwich sandwich = new Sandwich(bread, size);

                    //select meats
                    this.display.printHeader("Select Meat");
                    this.display.printMenu(Menu.meatType);
                    this.display.printLine("0) Done adding meats");

                    boolean addingMeats = true;

                    while (addingMeats)
                    {
                        int meatChoice = this.display.getMenuChoice(0, Menu.meatType.length);
                        if (meatChoice == 0)
                        {
                           addingMeats = false;

                        }
                        else
                        {
                            sandwich.addMeats(Menu.meatType[meatChoice - 1]);
                            this.display.printLine(Menu.meatType[meatChoice - 1] + " added, Total $"+sandwich.getPrice());
                            this.display.printLine("Make another selection or Press 0 to continue.");
                        }
                    }


                    //choose cheese
                    this.display.printHeader("Select Cheese");
                    this.display.printMenu(Menu.cheeseType);
                    this.display.printLine("0) Done adding cheese");
                    boolean addingCheese = true;

                    while (addingCheese)
                    {
                        int cheeseChoice = this.display.getMenuChoice(0, Menu.cheeseType.length);

                        if (cheeseChoice == 0)
                        {
                            addingCheese = false;
                        }
                        else
                        {
                            sandwich.addCheese(Menu.cheeseType[cheeseChoice - 1]);
                            this.display.printLine(Menu.cheeseType[cheeseChoice - 1] + " added, Total $"+sandwich.getPrice());
                        }

                    }
                    
                    //toppings
                    this.display.printHeader("select Toppings");
                    this.display.printMenu(Menu.toppings);
                    this.display.printLine("0) Done adding toppings");

                    boolean addingToppings = true;

                    while (addingToppings)
                    {
                        int toppingChoice = this.display.getMenuChoice(0, Menu.toppings.length);
                        if (toppingChoice == 0)
                        {
                            addingToppings = false;
                        }
                        else
                        {
                            sandwich.addToppings(Menu.toppings[toppingChoice - 1]);
                            this.display.printLine(Menu.toppings[toppingChoice - 1] + " added.");
                            this.display.printLine("Make another selection or Press 0 to continue.");
                        }
                    }

                    // sauces
                    this.display.printHeader("Select Sauces");
                    this.display.printMenu(Menu.sauceType);
                    this.display.printLine("0) Done adding sauces");

                    boolean addingSauces = true;

                    while (addingSauces)
                    {
                        int sauceChoice = this.display.getMenuChoice(0, Menu.sauceType.length);
                        if (sauceChoice == 0)
                        {
                            addingSauces = false;
                        }
                        else
                        {
                            sandwich.addSauces(Menu.sauceType[sauceChoice - 1]);
                            this.display.printLine(Menu.sauceType[sauceChoice - 1] + " added.");
                            this.display.printLine("Make another selection or Press 0 to continue.");
                        }
                    }
                    //toasted y/n
                    this.display.printHeader("Toasted?");
                    this.display.printLine("1) Yes");
                    this.display.printLine("2) No");
                    int toastedChoice = this.display.getMenuChoice(1, 2);

                    sandwich.setToasted(toastedChoice == 1);

                    this.order.addItem(sandwich);
                    this.display.printLine("Sandwich added to order.");

                    //add order.
                    break;

                case 2:
                    //  addDrink()
                    this.display.printHeader("Select Drink");
                    this.display.printMenu(Menu.drinkType);
                    String flavor = Menu.drinkType[this.display.getMenuChoice(1, Menu.drinkType.length) - 1];

                    this.display.printHeader("Select Drink Size");
                    this.display.printMenu(Menu.drinkSize);
                    String drinkSize = Menu.drinkSize[this.display.getMenuChoice(1, Menu.drinkSize.length) - 1];

                    Drinks drink = new Drinks(drinkSize, flavor);

                    this.order.addItem(drink);
                    this.display.printLine(drinkSize + " " + flavor + " added to order.");
                    break;

                case 3:
                    // addChips()
                    this.display.printHeader("Select Chips");
                    this.display.printMenu(Menu.chipsType);
                    String chipType = Menu.chipsType[this.display.getMenuChoice(1, Menu.chipsType.length) - 1];

                    Chips chips = new Chips(chipType);

                    this.order.addItem(chips);
                    this.display.printLine(chipType + " added to order. ");
                    break;

                case 4:
                    // checkout()
                    this.display.printHeader("Order Summary");
                    for (MenuItem item : this.order.getItems())
                    {
                        this.display.printLine(item.getOptions());
                        this.display.printLine(String.format("  $%.2f", item.getPrice()));
                    }
                    this.display.printLine("============================");
                    this.display.printLine(String.format("Total: $%.2f", this.order.getTotal()));
                    this.display.printLine("============================");
                    boolean confirm = this.display.getAnswer("Confirm order?");
                    if (confirm)
                    {
                        Receipt receipt = new Receipt(this.order);
                        receipt.save();
                        this.display.printLine("Thank you for your order");
                        return;
                    }
                    break;

                case 5:
                    if (this.order.getItems().isEmpty())
                    {
                        this.display.printLine("No items in order.");
                        break;
                    }
                    this.display.printHeader("Remove Item");
                    List<MenuItem> items = this.order.getItems();
                    for (int i = 0; i < items.size(); i++)
                    {
                        this.display.printLine((i + 1) + ") " + items.get(i).getOptions() +
                                String.format(" - $%.2f", items.get(i).getPrice()));
                    }
                    this.display.printLine("Select item to remove:");
                    int removeChoice = this.display.getMenuChoice(1, items.size());
                    this.order.removeItem(removeChoice - 1);
                    this.display.printLine("Item removed.");
                    break;

                case 0:
                    this.order.cancelOrder();
                    this.display.printLine("Order cancelled.");
                    return;
            }
        }
    }
}