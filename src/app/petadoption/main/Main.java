
package app.petadoption.main;

import app.petadoption.connection.DBConnection;
import app.petadoption.controller.AdminController;
import app.petadoption.model.Admin;
import app.petadoption.model.Customer;
import app.petadoption.model.Gender;
import app.petadoption.model.Pet;
import app.petadoption.model.PetStatus;
import app.petadoption.model.PetType;
import app.petadoption.model.User;


public class Main {
    public static void main(String[] args) {
       AdminController adminController=new AdminController(new DBConnection());
       adminController.viewPet(new Pet(), new PetType(), new PetStatus());
    }
}
