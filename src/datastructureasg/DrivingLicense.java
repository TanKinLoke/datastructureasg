/*
 * To change this license header, choose DrivingLicense Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package datastructureasg;
import java.time.LocalDate;
import java.util.Objects;

/**
 *
 * @author user
 */
public class DrivingLicense {
    private String id;
    private String ICNo;
    private String name;
    private LocalDate expiryDate;
    
    public DrivingLicense() {}
    
    public DrivingLicense(String id, String ICNo, String name, LocalDate expiryDate) {
        this.id = id;
        this.ICNo = ICNo;
        this.name = name;
        this.expiryDate = expiryDate;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getICNo() {
        return ICNo;
    }

    public void setICNo(String ICNo) {
        this.ICNo = ICNo;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public LocalDate getExpiryDate() {
        return expiryDate;
    }

    public void setExpiryDate(LocalDate expiryDate) {
        this.expiryDate = expiryDate;
    }
    
    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        
        final DrivingLicense licenseObj = (DrivingLicense) obj;
        
        if (Objects.equals(this.id, licenseObj.id))
            return true;
        
        //Everything else returns false
        return false;
    }
    
    @Override
    public String toString() {
        return "ID: " + id 
                +"\nIC No.: " + ICNo
                +"\nName: " + name
                +"\nExpiry Date: " + expiryDate.toString();
    } 
    
}
