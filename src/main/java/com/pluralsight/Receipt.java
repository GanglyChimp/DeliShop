package com.pluralsight;

import com.pluralsight.Terminal.MenuItem;

import java.io.*;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Receipt
{
    private Order order;
    private String timestamp;
    private String displayTime;

    public Receipt(Order order)
    {
        this.order = order;
        this.timestamp = LocalDateTime.now()
                .format(DateTimeFormatter.ofPattern("MMdd-HHmm"));
        this.displayTime = LocalDateTime.now()
                .format(DateTimeFormatter.ofPattern("MM-dd / HH:mm"));
    }

    public void save()
    {
        saveText();
        saveCsv();
    }

    private void saveText()
    {
        String fileName = "receipts/" + timestamp + ".txt";

        File folder = new File("receipts");
        if (!folder.exists()) folder.mkdir();

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
            writer.println("Thank you, for your order .");

            System.out.println("Receipt saved to " + fileName);
        }
        catch (IOException e)
        {
            System.out.println("Error saving receipt: " + e.getMessage());
        }
    }

    private void saveCsv()
    {
        String fileName = "receipts/" + timestamp + ".csv";

        File folder = new File("receipts");
        if (!folder.exists()) folder.mkdir();

        try (PrintWriter writer = new PrintWriter(new FileWriter(fileName)))
        {
            writer.println("Date,Item,Price");

            for (MenuItem item : order.getItems())
            {
                writer.printf("%s,\"%s\",%.2f%n",
                        displayTime,
                        item.getOptions().replace("\"", "'"),
                        item.getPrice());
            }

            writer.printf("%s,\"Total\",%.2f%n", displayTime, order.getTotal());

            System.out.println("CSV saved to " + fileName);
        }
        catch (IOException e)
        {
            System.out.println("Error saving CSV: " + e.getMessage());
        }
    }
}
