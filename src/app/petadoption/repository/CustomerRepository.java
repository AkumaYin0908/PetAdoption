/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package app.petadoption.repository;

import app.petadoption.model.Customer;
import app.petadoption.model.Pet;
import app.petadoption.model.PetStatus;
import app.petadoption.model.PetType;
import app.petadoption.model.Transaction;
import app.petadoption.model.User;

/**
 *
 * @author Philip
 */
public interface CustomerRepository extends GeneralRepository{
    
    public void adoptPet(Transaction transaction,Pet pet, User user);
    
    public void surrenderPet(Transaction transaction,Pet pet, User user);
}
