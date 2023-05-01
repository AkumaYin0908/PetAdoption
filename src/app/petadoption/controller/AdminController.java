/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package app.petadoption.controller;

import app.petadoption.connection.DBConnection;
import app.petadoption.model.Gender;
import app.petadoption.model.Pet;
import app.petadoption.model.PetStatus;
import app.petadoption.model.PetType;
import app.petadoption.model.Transaction;
import app.petadoption.query.QueryConstants;
import app.petadoption.repository.AdminRepository;
import app.petadoption.view.MainForm;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.InputMismatchException;
import java.util.Map;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

public class AdminController implements AdminRepository {

    private PreparedStatement statement;
    private ResultSet result;
    private final DBConnection connection;
    private Scanner scanner;

    public AdminController(DBConnection connection) {
        this.connection = connection;
        this.connection.connect();
    }

    @Override
    public void addPet(Pet pet) {
        Map<Integer, String> typeChoices = new HashMap<>();

        scanner = new Scanner(System.in);
        System.out.println("************************************** ADD PET **************************************");
        System.out.println("Enter name: ");
        pet.setName(scanner.next());

        System.out.println("Enter age: ");
        pet.setAge(scanner.nextInt());

        System.out.println("Enter gender(M/F): ");
        switch (scanner.next()) {
            case "M":
                pet.setGender(Gender.MALE);
                break;

            case "F":
                pet.setGender(Gender.FEMALE);
                break;
            default:
                System.out.println("Invalid input. Please Try again");
        }

        System.out.println("Enter description(Color, other details, etc. ): ");
        pet.setDescription(scanner.nextLine());

        System.out.println("Choose from the given pet type: ");

        //RETRIEVING PET_TYPE AND WILL DISPLAYED AS CHOICES
        try {
            statement = connection.getSqlConnection().prepareStatement(QueryConstants.SELECT_PETTYPE);
            result = statement.executeQuery();

            while (result.next()) {
                typeChoices.put(result.getInt("type_id"), result.getString("type"));
            }

            for (Map.Entry<Integer, String> entry : typeChoices.entrySet()) {
                System.out.println("[" + entry.getKey() + "] " + entry.getValue());
            }

            int choice = scanner.nextInt();
            if (typeChoices.containsKey(choice)) {
                pet.setPetType(choice);
            } else {
                System.out.println("Invalid input");
            }

        } catch (SQLException | InputMismatchException ex) {
            Logger.getLogger(AdminController.class.getName()).log(Level.SEVERE, null, ex);
        }

        System.out.println("Choose from the given pet status: ");

        ////RETRIEVING PET_STATUS AND WILL DISPLAYED AS CHOICES
        try {
            statement = connection.getSqlConnection().prepareStatement(QueryConstants.SELECT_PETSTATUS);
            result = statement.executeQuery();

            while (result.next()) {
                typeChoices.put(result.getInt("status_id"), result.getString("status"));
            }

            for (Map.Entry<Integer, String> entry : typeChoices.entrySet()) {
                System.out.println("[" + entry.getKey() + "] " + entry.getValue());
            }
            int choice = scanner.nextInt();

            if (typeChoices.containsKey(choice)) {
                pet.setStatus(choice);
            } else {
                System.out.println("Invalid input");
            }

        } catch (SQLException | InputMismatchException ex) {
            Logger.getLogger(AdminController.class.getName()).log(Level.SEVERE, null, ex);
        }

        try {
            statement = connection.getSqlConnection().prepareStatement(QueryConstants.ADD_PET);
            statement.setString(1, pet.getName());
            statement.setInt(2, pet.getAge());
            statement.setString(3, pet.getGender().toString());
            statement.setString(4, pet.getDescription());
            statement.setInt(5, pet.getPetType());
            statement.setInt(6, pet.getStatus());
            statement.executeUpdate();

            System.out.println(pet.getName() + " has been added to the database successfully");
            System.out.println("***************************************************************************************");
            connection.getSqlConnection().close();
            MainForm.init();
        } catch (SQLException ex) {
            Logger.getLogger(AdminController.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    @Override
    public void updatePet(Pet pet) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void dropPet(Pet pet) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void viewPet(Pet pet, PetType petType, PetStatus petStatus) {
        System.out.println("************************************** PET LIST **************************************");
        try {
            statement = connection.getSqlConnection().prepareStatement(QueryConstants.VIEW_PET);
            result = statement.executeQuery();

            System.out.printf("%s\t%-20s\t%-10s\t%-10s\t%-40s\t%-20s\t%-20s %n", "ID", "Name", "Age", "Gender", "Description", "Type", "Status");
            while (result.next()) {
                pet.setPetId(result.getInt("pet_id"));
                pet.setName(result.getString("name"));
                pet.setAge(result.getInt("age"));
                pet.setGender(Gender.valueOf(result.getString("gender")));
                pet.setDescription(result.getString("description"));
                petType.setType(result.getString("type"));
                petStatus.setStatus(result.getString("status"));
            }
            System.out.printf("%d\t%-20s\t%-10d\t%-10s\t%-40s\t%-20s\t%-20s %n", pet.getPetId(), pet.getName(), pet.getAge(),
                    pet.getGender(), pet.getDescription(), petType.getType(), petStatus.getStatus());

            System.out.println("***************************************************************************************");
            connection.getSqlConnection().close();
            MainForm.initAdminForm();
        } catch (SQLException ex) {
            Logger.getLogger(AdminController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public void GenerateForm(Transaction transaction) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void viewAdoptionList(Transaction transaction) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void viewSurrenderedPets(Transaction transaction) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void logout() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
