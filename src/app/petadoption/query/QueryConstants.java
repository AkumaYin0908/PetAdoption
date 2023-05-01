/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package app.petadoption.query;

/**
 *
 * @author Philip
 */
public interface QueryConstants {
    
    public String VIEW_PET="SELECT * FROM tblpet "
            + "left join tblpet_type on tblpet.pet_type=tblpet_type.type_id "
            + "left join tblpet_status on tblpet.status=tblpet_status.status_id";
    
    
    public String SELECT_PETTYPE="SELECT * FROM tblpet_type";
    
    public String SELECT_PETSTATUS="SELECT * FROM tblpet_status";
    
    
    
}
