package service;

import java.io.Serializable;
import java.time.LocalDateTime;


public class transactions implements Serializable {
    private String type;
    private double amount;
    private LocalDateTime time;
    private String accountnumber;

    public transactions(String type, double amount, String accountNumber) {
        this.type = type;
        this.amount = amount;
        this.accountnumber = accountNumber;
        this.time = LocalDateTime.now(); // auto timestamp
    }
    public void display(){
        System.out.println(type+" | "+amount+" | "+time);
    }
}
