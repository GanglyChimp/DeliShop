package com.pluralsight;

import com.pluralsight.Terminal.MenuItem;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Receipt
{
    private Order order;
    private String timestamp;
    private String displayTime;

    public Receipt(Order order)
    {
        this.order=order;
        this.timestamp= LocalDateTime.now()
        .format(DateTimeFormatter.ofPattern("MMdd-HHmm"));
     //formats "Now" 0528-1411
        this.displayTime = LocalDateTime.now()
         .format(DateTimeFormatter.ofPattern("MM-dd / HH:mm"));
     //takes the time stamp and formats as  05-28 / 14:11

    }

    public void save()
    {

            String fileName = "receipts/" + timestamp + ".txt";

            File folder = new File("receipts");
            if (!folder.exists())
            {
                folder.mkdir();
            }

            try (PrintWriter writer = new PrintWriter(new FileWriter(fileName)))
            {
                writer.println("============================");
                writer.println("        SANDWICH SHOP       ");
                writer.println("============================");
                writer.println("Date: " + displayTime);
                writer.println("============================");

                for (MenuItem item : order.getItems())
                {
                    writer.println(item.getOptions());
                    writer.printf("  $%.2f%n", item.getPrice());
                }

                writer.println("============================");
                writer.printf("Total: $%.2f%n", order.getTotal());
                writer.println("============================");
                writer.println("Thank you for your order.");

                System.out.println("Receipt saved to " + fileName);
            }
            catch (IOException e)
            {
                System.out.println("Error saving receipt: " + e.getMessage());
            }
        }
}
