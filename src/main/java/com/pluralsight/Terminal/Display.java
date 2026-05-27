package com.pluralsight.Terminal;
import java.util.Scanner;
public class Display
{
    private Scanner scanner;
    public Display()
    {
       this.scanner=new Scanner(System.in);
    }

   //loop through listed options and prints
    public void printMenu(String[]options)
    {
        for(int i = 0; i< options.length; i++)
        {
            System.out.println((i+1)+ ")" + options[i]);
        }
    }

    // prints a header for each screen
    public void printHeader(String title)
    {
        System.out.println("============================");
        System.out.println("  " + title);
        System.out.println("============================");
    }
    public int getMenuChoice(int min, int max)
    {
        while (true)
        {
            try
            {
                int choice = Integer.parseInt(scanner.nextLine().trim());
                if (choice >= min && choice <= max) return choice;
                System.out.println("Please enter a number between " + min + " and " + max);
            }
            catch (NumberFormatException e)
            {
                System.out.println("Invalid input. Please enter a number.");
            }
        }

    }

        public void printLine(String text)
        {
            System.out.println(text);
        }

        // gets raw string input from user
        public String getUserInput(String prompt)
        {
            System.out.print(prompt);
            return scanner.nextLine().trim();
        }

        // gets a yes or no answer for toasted and checkout confirmation
        public boolean getAnswer(String prompt)
        {
            while (true)
            {
                System.out.print(prompt + " (y/n): ");
                String input = scanner.nextLine().trim().toLowerCase();
                if (input.equals("y")) return true;
                if (input.equals("n")) return false;
                System.out.println("Please enter y or n.");
            }
        }

        // clears the screen
      //  public void clearScreen()
      //  {
      //      System.out.println("\n".repeat(50));
      //  }

}


