package object;

import adt.kinloke.ArrayList;

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
    
    public void addLicense(DrivingLicense license) {
        licenseRegistered.add(license);
    }
    
}
