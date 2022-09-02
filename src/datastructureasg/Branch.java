/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package datastructureasg;

/**
 *
 * @author VentoBento
 */
public class Branch {
    private String branchID;
    private String state;
    private ArrayList<DrivingLicense> licenseRegistered = new ArrayList<DrivingLicense>();
    
    public Branch() {}
    
    public Branch(String branchID, String state) {
        this.branchID = branchID;
        this.state = state;
    }

    public String getBranchID() {
        return branchID;
    }

    public void setBranchID(String branchID) {
        this.branchID = branchID;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public ArrayList<DrivingLicense> getLicenseRegistered() {
        return licenseRegistered;
    }

    public void setLicenseRegistered(ArrayList<DrivingLicense> licenseRegistered) {
        this.licenseRegistered = licenseRegistered;
    }
    
}
