/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package app.petadoption.repository;


import app.petadoption.model.Pet;
import app.petadoption.model.PetStatus;
import app.petadoption.model.PetType;


/**
 *
 * @author Philip
 */
public interface GeneralRepository {

    public void viewPet(Pet pet,PetType petType, PetStatus petStatus);
    public void logout();
    
    
}
