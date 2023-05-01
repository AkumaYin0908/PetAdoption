/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package app.petadoption.model;

/**
 *
 * @author User
 */
public class Pet {

    private int petId;
    private String name;
    private int age;
    private Gender gender;
    private String description;
    private PetType petType;
    private PetStatus status;

    public Pet() {
    }

    public Pet(int petId, String name, int age, Gender gender, String description, PetType petType, PetStatus status) {
        this.petId = petId;
        this.name = name;
        this.age = age;
        this.gender = gender;
        this.description = description;
        this.petType = petType;
        this.status = status;
    }

    public int getPetId() {
        return petId;
    }

    public void setPetId(int petId) {
        this.petId = petId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public Gender getGender() {
        return gender;
    }

    public void setGender(Gender gender) {
        this.gender = gender;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public PetType getPetType() {
        return petType;
    }

    public void setPetType(PetType petType) {
        this.petType = petType;
    }

    public PetStatus getStatus() {
        return status;
    }

    public void setStatus(PetStatus status) {
        this.status = status;
    }
    
    

}
