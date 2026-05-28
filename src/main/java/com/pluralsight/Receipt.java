package com.pluralsight;

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
}
