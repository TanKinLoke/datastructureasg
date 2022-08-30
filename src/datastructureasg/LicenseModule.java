/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package datastructureasg;
import java.util.Scanner;
import java.time.LocalDate;

/**
 *
 * @author user
 */
public class LicenseModule {

    /**
     * @param args the command line arguments
     */
    static ArrayList<DrivingLicense> licenseList = new ArrayList<DrivingLicense>();
    
    public static void main(String[] args) {
        
        
        int option;
        Scanner scanner = new Scanner(System.in);
        
        do {
            System.out.println("Driving License Module");
            System.out.println("----------------------");
            System.out.println("1) Register Driving License");
            System.out.println("2) Search Driving License");
            System.out.println("3) List Driving License");
            System.out.println("4) Maintain Driving License");
            System.out.println("5) Generate Report");
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
            }
        } while (option != 0);
        
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
            licenseList.add(tempLicense);
            
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
                
                System.out.println("");
                return;
            }
        }
        
        System.out.println("No entry found.");
        System.out.println();
    }
    
    public static void generateLicenseModuleReport() {
        
    }
    
}
