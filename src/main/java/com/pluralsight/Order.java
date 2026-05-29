package com.pluralsight;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import com.pluralsight.Terminal.MenuItem;

public class Order
{
    private List<MenuItem> items;
    public Order()
    {
        this.items=new ArrayList<>();
    }

    //add to the users order
    public void addItem(MenuItem item)
    {
        items.add(item);
    }

    //returning the items
    public List<MenuItem>getItems()
    {
        return items;
    }

    //we want to see what the latest entry was, makes it easier to remove recent decisions
    public List<MenuItem>getItemsNewestFirst()
    {
        List<MenuItem>reversed = new ArrayList<>(items);
        Collections.reverse(reversed);
        return reversed;
        //we reverse the order of the list to see the newest first
    }
    //removeing an item
    public void removeItem(int index)
    {
        if (index >= 0 && index < items.size())
        {
            items.remove(index);
        }
    }
    //getting the total price of all items
    public double getTotal()
    {
        return items.stream()
                .mapToDouble(MenuItem::getPrice)
                .sum();
        //adds the sum of the items
    }

    //clear all items
    public void cancelOrder()
    {
        items.clear();
        //simple .clear wipes the items list

    }
}
