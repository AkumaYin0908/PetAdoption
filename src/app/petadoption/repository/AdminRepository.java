/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package app.petadoption.repository;

import app.petadoption.model.Pet;
import app.petadoption.model.Transaction;


/**
 *
 * @author Philip
 */
public interface AdminRepository extends GeneralRepository {
    
    public void addPet(Pet pet);
    public void updatePet(Pet pet);
    public void dropPet(Pet pet);
    public void viewAdoptionList(Transaction transaction);
    public void viewSurrenderedPets(Transaction transaction);
    public void GenerateForm(Transaction transaction);
   
    
    
}
