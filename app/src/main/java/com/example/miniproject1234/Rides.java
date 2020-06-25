package com.example.miniproject1234;

public class Rides {
            public String start,end,quantity,price,dat,tme;
            public Rides(){

    }
  public Rides(String start,String end,String quantity,String price,String dat,String tme){
                this.start=start;
                this.end=end;
                this.quantity=quantity;
                this.price=price;
                this.tme=tme;
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

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public  String getDat(){
                return dat;
    }

     public void setDat(String dat){
                this.dat=dat;
     }


    public String getTme() {
        return tme;
    }

    public void setTme(String tme) {
        this.tme = tme;
    }
}
