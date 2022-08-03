/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package xyz;

/**
 *
 * @author clarisse
 */
public class Xyz {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
          private double balance;
    private double transactionfee;

    /** Contructs an e-wallet  with a balance of 1000
     * 
     */
    public Xyz()
    {
        balance = 0;
        transactionfee = 1000;
    }
    /**Constructs a bank account with a given balance
     * 
     * @param initialBalance the initial balance
     */
    public Xyz(double initialBalance)
    {
        balance = initialBalance;
     }
    /** Receive money into the e-wallet
     * 
     * @param amount the amount to Receive
     */
    public void Receive(double amount)
    {
        balance = balance + amount - transactionfee;
    }
    /**send money from the e-wallet
     * 
     * @param amount the amount to send
     */
    public void Send (double amount)
    {
        balance = balance - amount - transactionfee;
    }
    /**Gets the current balance of the e-wallet 
     * 
     * @return the current balance
     */
    public double getBalance()
    {
        return balance;
    }
    public void deduct()
    {
        if(1<=10000)
        {
            return no transactionfee;
                    
                    ifelse(10000<=100000){
            return transaction fee of Rwf '200';
            
            else
            return transaction fee of Rwf '1000';
        }
    }
       

    private void ifelse(boolean b) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    
    
}
