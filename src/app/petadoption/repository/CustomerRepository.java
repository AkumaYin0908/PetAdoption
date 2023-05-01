/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package app.petadoption.repository;


import app.petadoption.model.Pet;
import app.petadoption.model.PetStatus;
import app.petadoption.model.PetType;
import app.petadoption.model.Transaction;


/**
 *
 * @author Philip
 */
public interface CustomerRepository extends GeneralRepository{
    
    public void adoptPet(Transaction transaction,Pet pet);
    
    public void surrenderPet(Transaction transaction,Pet pet);
}
