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
    private String licenseClass;
    private LocalDate expiryDate;
    public static int idCount = 1;
    
    public DrivingLicense() {}
    
    public DrivingLicense(String id) {
        this.id = id;
    }
    
    public DrivingLicense(String ICNo, String name, String licenseClass, LocalDate expiryDate) {
        id = String.format("L%05d", idCount);
        this.ICNo = ICNo;
        this.name = name;
        this.licenseClass = licenseClass;
        this.expiryDate = expiryDate;
        idCount++;
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
    
    public String getLicenseClass() {
        return licenseClass;
    }

    public void setLicenseClass(String licenseClass) {
        this.licenseClass = licenseClass;
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
        
        if (id.equals(licenseObj.id))
            return true;
        
        //Everything else returns false
        return false;
    }
    
    @Override
    public String toString() {
        return "ID: " + id 
                +"\nIC No.: " + ICNo
                +"\nName: " + name
                +"\nLicense Class: " + licenseClass
                +"\nExpiry Date: " + expiryDate.toString();
    } 
}
