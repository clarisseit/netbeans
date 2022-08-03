/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.nbank.service;

import com.nbank.model.Customer;
import java.rmi.Remote;
import java.rmi.RemoteException;

/**
 *
 * @author HP 640 G2
 */
public interface CustomerServiceInterface extends Remote{
    public void saveCustomer(Customer customer) throws RemoteException;
    public void updateCustomer(Customer customer) throws RemoteException;
    
}
