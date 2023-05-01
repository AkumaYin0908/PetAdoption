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
public class Address {
    
    private String barangay;
    private String munCity;
    private String province;

    public Address() {
    }

    public Address(String barangay, String munCity, String province) {
        this.barangay = barangay;
        this.munCity = munCity;
        this.province = province;
    }

    public String getBarangay() {
        return barangay;
    }

    public void setBarangay(String barangay) {
        this.barangay = barangay;
    }

    public String getMunCity() {
        return munCity;
    }

    public void setMunCity(String munCity) {
        this.munCity = munCity;
    }

    public String getProvince() {
        return province;
    }

    public void setProvince(String province) {
        this.province = province;
    }
    
    
    
}
