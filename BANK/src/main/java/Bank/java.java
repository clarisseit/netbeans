/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Bank;


import java.util.Scanner;
import java.util.ArrayList;


/**
 *
 * @author OTTOX
 */
public class Customer {
    int ID_Number; 
    String firstName;
    String lastname; 
    int date_of_birth; 
    int bank_account;
    String account_type; 
int account_balance;
//int amount;
Scanner  input =new Scanner(System.in);
 public  Customer(){
     
 }
public Customer(int ID_Number,String firstName,String lastname,String account_type,int date_of_birth,int bank_account,int account_balance){
    this.ID_Number=ID_Number;
    this.firstName=firstName;
    this.lastname=lastname;
    this.date_of_birth=date_of_birth;
    this.account_balance=account_balance;
    //this.amount=amount;
    this.account_type=account_type;
    this.bank_account=bank_account;
    
}
public void deposit(int amount){
    if(amount <500){
    System.out.print("NOT enought do deposit");
    }
    else{
        account_balance=account_balance+amount;
        System.out.println("You have deposite "+amount+" you new balance is "+account_balance);
    }
}

    public boolean withdraw(int amount){
        if(account_balance <amount){
            System.out.println("Insulficient amount");
        }
        else{
            account_balance=account_balance -amount;
            System.out.println("your have withdrawed amount on you account "+amount+" you new balance  "+account_balance);
            return true;
        }
        return false;
    }
    public void dispaly(ArrayList<Customer> accounts){
        System.out.println(accounts);
    }
    public void Transfer(int amount,int account){
        if(account_balance <amount){
            System.out.println("Insulficient amount");
        }
        else{
            System.out.println("you have trasfer "+amount+ "to "+account);
            account=account_balance -amount;
            System.out.println("you new balance is: "+account_balance);
        }
       
    }
    
    public void TransferMoney(Customer cust1, Customer cust2, int amount){
    if(cust1.withdraw(amount)==true){
        cust2.deposit(amount);
    }
    }
    
}
