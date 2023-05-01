/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package app.petadoption.model;

/**
 *
 * @author Philip
 */
public class Admin extends User {

    @Override
    public String getUserType() {
          return "Admin";
    }
    
}
