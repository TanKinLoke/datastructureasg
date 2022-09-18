package client;
import object.DrivingLicense;
import object.Branch;
import adt.kinloke.ArrayList;
import java.util.Scanner;
import java.time.LocalDate;

public class LicenseModule {

    /**
     * @param args the command line arguments
     */
    public static Branch[] malaysiaBranches = {
        new Branch("KL01", "Kuala Lumpur"),
        new Branch("PG01", "Penang"),
        new Branch("PR01", "Perak")
    };
    public static int selectedBranchIndex;
    
    public static ArrayList<DrivingLicense> licenseList;
    
    public static void main(String[] args) {
        
        
        int option;
        Scanner scanner = new Scanner(System.in);
        
        selectBranch();
        
        do {
            System.out.println("Driving License Module("+malaysiaBranches[selectedBranchIndex].getState()+" Branch)");
            System.out.println("----------------------");
            System.out.println("1) Register Driving License ➕");
            System.out.println("2) Search Driving License 🔍");
            System.out.println("3) List Driving License 📃");
            System.out.println("4) Maintain Driving License 🛠");
            System.out.println("5) Generate Report 📄");
            System.out.println("6) Change Branch 🏚");
            System.out.println("7) Reset Branch License Data");
            System.out.println("0) Exit\n");
            System.out.print("Option: ");
            
            option = scanner.nextInt();
            scanner.nextLine(); //Flush scanner buffer
            
            if (option == 0) {} //Do nothing if option is 0
            else if (option == 1) {
                registerLicense();
            } else if (option == 2) {
                searchLicense();
            } else if (option == 3) {
                listLicense();
            } else if (option == 4) {
                maintainLicense();
            } else if (option == 5) {
                generateLicenseModuleReport();
            } else if (option == 6) {
                selectBranch();
            } else if (option == 7) {
                resetBranchLicenseData();
            }
        } while (option != 0);
        
    }
    
    public static void selectBranch() {
        Scanner scanner = new Scanner(System.in);
        int option;
        
        System.out.println("Branch Selection");
        System.out.println("----------------");
        for (int i = 0; i < malaysiaBranches.length; i++) {
            System.out.println((i+1) + ") " + malaysiaBranches[i].getState() + " Branch");
        }
        System.out.println();
        System.out.print("Option: ");
        option = scanner.nextInt();
        scanner.nextLine();
        
        if (option > 0 && option <= malaysiaBranches.length) {
            selectedBranchIndex = option - 1;
            licenseList = malaysiaBranches[selectedBranchIndex].getLicenseRegistered();
        } else {
            System.out.println("Invalid option detected.");
            System.out.println();
            selectBranch();
        }
        
    }
    
    public static void registerLicense() {
        Scanner scanner = new Scanner(System.in);
        String ICNo, name, licenseClass;
        int yearsToAdd;
        
        System.out.println("Register Driving License");
        System.out.println("------------------------");
        System.out.print("IC No.: ");
        ICNo = scanner.nextLine();
        System.out.println();
        System.out.print("Name: ");
        name = scanner.nextLine();
        System.out.println();
        System.out.print("License Class: ");
        licenseClass = scanner.nextLine();
        System.out.println();
        System.out.print("License Years to be added: ");
        yearsToAdd = scanner.nextInt();
        scanner.nextLine();
        System.out.println();
        System.out.println();
        
        if (!ICNo.isEmpty() && !name.isEmpty() && !licenseClass.isEmpty()) {
            DrivingLicense tempLicense = new DrivingLicense(ICNo, name, licenseClass, LocalDate.now().plusYears(yearsToAdd));
            malaysiaBranches[selectedBranchIndex].addLicense(tempLicense); //Add license into the branch
            
            System.out.println("ID: " + tempLicense.getId() + ",License registered successfully");
        } else {
            System.out.println("Empty field detected");
        }
        
        System.out.println();
        System.out.println();
    }
    
    public static void searchLicense() {
        Scanner scanner = new Scanner(System.in);
        String id;
        
        System.out.println("Search Driving License");
        System.out.println("------------------------");
        System.out.print("ID: ");
        id = scanner.nextLine();
        System.out.println();
        
        System.out.println("Result");
        System.out.println("------");
        for (int i = 1; i <= licenseList.size(); i++) {
            DrivingLicense tempLicense = licenseList.getEntry(i);
            if (tempLicense.getId().equals(id)) {
                System.out.println(tempLicense.toString());
                System.out.println();    
                return;
            }
        }
        
        System.out.println("No entry found.");
        System.out.println();
        
    }
    
    public static void listLicense() {
        System.out.println("List Driving License");
        System.out.println("------------------------");
        
        if (licenseList.size() > 0) {            
            for (int i = 1; i <= licenseList.size(); i++) {
                System.out.println(licenseList.getEntry(i).toString());
                System.out.println("------------------------");
            }
        } else {
            System.out.println("No entry found");
        }
        
        
        
        System.out.println();
        System.out.println();
        
    }
    
    public static void maintainLicense() {
        Scanner scanner = new Scanner(System.in);
        String id;
        int option;
        
        System.out.println("Search Driving License");
        System.out.println("------------------------");
        System.out.print("ID: ");
        id = scanner.nextLine();
        System.out.println();
        
        System.out.println("Result");
        System.out.println("------");
        for (int i = 1; i <= licenseList.size(); i++) {
            DrivingLicense tempLicense = licenseList.getEntry(i);
            if (tempLicense.getId().equals(id)) {
                System.out.println(tempLicense.toString());
                System.out.println();
                System.out.print("Option (1 = Edit, 2 = Delete, 0 = Back): ");
                option = scanner.nextInt();
                scanner.nextLine();
                
                if (option == 1) {
                    String ICNo, name, licenseClass;
                    int yearsToAdd;
                    System.out.print("IC No. ("+tempLicense.getICNo()+"): ");
                    tempLicense.setICNo(scanner.nextLine());
                    System.out.println();
                    System.out.print("Name ("+tempLicense.getName()+"): ");
                    tempLicense.setName(scanner.nextLine());
                    System.out.println();
                    System.out.print("License Class ("+tempLicense.getLicenseClass()+"): ");
                    tempLicense.setLicenseClass(scanner.nextLine());
                    System.out.println();
                    System.out.print("License Years to be added/subtracted ("+tempLicense.getExpiryDate()+"): ");
                    tempLicense.setExpiryDate(tempLicense.getExpiryDate().plusYears(scanner.nextInt()));
                    scanner.nextLine();
                    System.out.println();
                    System.out.println();
                    
                    licenseList.replace(i, tempLicense);

                    System.out.println("ID: " + tempLicense.getId() + ",License updated successfully");
                } else if (option == 2) {
                    licenseList.remove(i);
                } else if (option == 0) {
                    return;
                } else {
                    System.out.println("Invalid option.");
                }
                
                malaysiaBranches[selectedBranchIndex].setLicenseRegistered(licenseList);
                System.out.println();
                return;
            }
        }
        
        System.out.println("No entry found.");
        System.out.println();
    }
    
    public static void generateLicenseModuleReport() {
        System.out.println("License Module Report");
        System.out.println("---------------------");
        for (int i = 0; i < malaysiaBranches.length; i++) {
            ArrayList<DrivingLicense> tempLicenseList = malaysiaBranches[i].getLicenseRegistered();
            
            System.out.println(malaysiaBranches[i].getState() + " Branch:");
            System.out.println("License Registered: " + tempLicenseList.size());
            System.out.println("Latest Registered License ID: " + ((tempLicenseList.getLast() == null) ? "None" : tempLicenseList.getLast().getId()));
            System.out.println();
        }
    }
    
    public static void resetBranchLicenseData() {
        Scanner scanner = new Scanner(System.in);
        char option;
        
        System.out.println("Reset Branch License Data (" + malaysiaBranches[selectedBranchIndex].getState() + " Branch)");
        System.out.println("---------------------------------------------------------");
        System.out.print("Are you sure? (Y/N): ");
        option = scanner.next().charAt(0);
        
        if (Character.toUpperCase(option) == 'Y') {
            licenseList.clear();
            malaysiaBranches[selectedBranchIndex].setLicenseRegistered(licenseList);
            System.out.println("Branch License Record reset successfully");
        } else {
            return;
        }
    }
    
}
