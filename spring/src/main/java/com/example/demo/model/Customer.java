
package com.example.demo.model;
import jakarta.persistence.Entity;
//import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
@Entity
public class Customer
{
    @Id
    //@GeneratedValue
    int customerId;
    String customerName;
    String theme;
    String mobile;
    String date;
    int expenditure;
    int balance;
    public Customer()
    {
    }
    public Customer(int customerId, String customerName, String theme, String mobile, String date, int expenditure, int balance)
    {
        this.customerId = customerId;
        this.customerName = customerName;
        this.theme = theme;
        this.mobile = mobile;
        this.date = date;
        this.expenditure = expenditure;
        this.balance= balance;

    }
    public int getcustomerId() {
        return customerId;
    }
    public void setcustomerId(int customerId) {
        this.customerId = customerId;
    }
    public String getcustomerName() {
        return customerName;
    }
    public void setcustomerName(String customerName) {
        this.customerName = customerName;
    }
    public String getTheme() {
        return theme;
    }
    public void setTheme(String theme) {
        this.theme = theme;
    }
    public String getMobile() {
        return mobile;
    }
    public void setMobile(String mobile) {
        this.mobile = mobile;
    }
    public String getDate() {
        return date;
    }
    public void setDate(String date) {
        this.date = date;
    }
    public int getExpenditure() {
        return expenditure;
    }
    public void setExpenditure(int expenditure) {
        this.expenditure = expenditure;
    }
    public int getBalance() {
        return balance;
    }
    public void setBalance(int balance) {
        this.balance = balance;
    }
}

