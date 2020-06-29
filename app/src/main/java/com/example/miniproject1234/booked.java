package com.example.miniproject1234;

public class booked {
    String start,end,quantity,ridernumber,price;
    public booked(){

    }
    public booked(String start,String end,String quantity,String ridernumber,String price){
        this.start=start;
        this.end=end;
        this.quantity=quantity;
        this.price=price;


        this.ridernumber=ridernumber;
    }

    public String getStart() {
        return start;
    }

    public void setStart(String start) {
        this.start = start;
    }

    public String getEnd() {
        return end;
    }

    public void setEnd(String end) {
        this.end = end;
    }

    public String getQuantity() {
        return quantity;
    }

    public void setQuantity(String quantity) {
        this.quantity = quantity;
    }

    public String getRidernumber() {
        return ridernumber;
    }

    public void setRidernumber(String ridernumber) {
        this.ridernumber = ridernumber;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }
}
