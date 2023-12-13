// // employeepayrollsystem.EmployeePayrollSystem class
// package employeepayrollsystem;

// import java.io.*;
// import java.util.Scanner;
// import employee.Employee;
// import com.manager.Manager;

// public class EmployeePayrollSystem {
//     public static void printSalary(Employee e) {
//         // Your existing code for printing salary
//         System.out.println("Salary Slip of " + e.name + ":");
//         System.out.println("Employee ID: " + e.empId);
//         System.out.println("Basic Salary: " + e.basic);
//         System.out.println("House Rent Allowance: " + e.hra);
//         System.out.println("Dearness Allowance: " + e.da);
//         System.out.println("Medical Allowance: " + e.ma);
//         System.out.printf("Gross Salary: %.2f Rupees%n", e.gross);
//         System.out.println("\nDeductions:");
//         System.out.println("Provident fund: " + e.pf);
//         System.out.println("Insurance: " + e.insurance);
//         System.out.printf("\nNet Salary: %.2f Rupees%n%n", e.net);
//     }

//     public static void display(Employee e) {
//         // Your existing code for displaying employee details
//         System.out.println(e.empId + "\t" + e.name + "\t" + e.basic + "\t" + e.hra + "\t" + e.da + "\t" + e.ma + "\t" + e.pf + "\t" + e.insurance);
//     }

//     public static void main(String[] args) {
//         // Your existing code for user input and menu options

//         // Add file handling for storing and retrieving employee data
//         String filename = "employee_data.ser";

//         // Load existing employee data from file if it exists
//         Employee[] employees = loadEmployeeData(filename);

//         // Existing code for user input and menu options

//         // Save employee data to file when the program exits
//         saveEmployeeData(filename, employees);
//     }

//     private static Employee[] loadEmployeeData(String filename) {
//         Employee[] employees = null;
//         try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(filename))) {
//             employees = (Employee[]) ois.readObject();
//             System.out.println("Employee data loaded successfully.");
//         } catch (FileNotFoundException e) {
//             System.out.println("No existing employee data found. Starting fresh.");
//         } catch (IOException | ClassNotFoundException e) {
//             e.printStackTrace();
//         }
//         return employees != null ? employees : new Employee[0];
//     }

//     private static void saveEmployeeData(String filename, Employee[] employees) {
//         try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(filename))) {
//             oos.writeObject(employees);
//             System.out.println("Employee data saved successfully.");
//         } catch (IOException e) {
//             e.printStackTrace();
//         }
//     }

//     // Additional functions for manager-specific tasks
//     // ...
// }





// employeepayrollsystem.EmployeePayrollSystem.java
package employeepayrollsystem;

import java.io.*;
import java.util.Scanner;
import employee.Employee;
import com.manager.Manager;

public class EmployeePayrollSystem {
    private static final String EMPLOYEE_FILE = "employee_data.ser";
    private static final String MANAGER_FILE = "manager_data.ser";

    public static void printSalary(Employee e) {
        System.out.println("Salary Slip of " + e.name + ":");
        System.out.println("Your Employee ID is: " + employees[num].empId);  // Display the ID to the user
        System.out.println("Basic Salary: " + e.basic);
        System.out.println("House Rent Allowance: " + e.hra);
        System.out.println("Dearness Allowance: " + e.da);
        System.out.println("Medical Allowance: " + e.ma);
        System.out.printf("Gross Salary: %.2f Rupees%n", e.gross);
        System.out.println("\nDeductions:");
        System.out.println("Provident fund: " + e.pf);
        System.out.println("Insurance: " + e.insurance);
        System.out.printf("\nNet Salary: %.2f Rupees%n%n", e.net);
    }

    public static void display(Employee e) {
        System.out.println(e.empId + "\t" + e.name + "\t" + e.basic + "\t" + e.hra + "\t" + e.da + "\t" + e.ma + "\t" + e.pf + "\t" + e.insurance);
    }
    

    private static Employee[] loadEmployeeData(String filename) {
        Employee[] employees = null;
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(filename))) {
            employees = (Employee[]) ois.readObject();
            System.out.println("Employee data loaded successfully.");
        } catch (FileNotFoundException e) {
            System.out.println("No existing employee data found. Starting fresh.");
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
        return employees != null ? employees : new Employee[0];
    }

    private static void saveEmployeeData(String filename, Employee[] employees) {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(filename))) {
            oos.writeObject(employees);
            System.out.println("Employee data saved successfully.");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    

    public static Manager[] loadManagerData(String filename) {
        Manager[] managers = null;
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(filename))) {
            managers = (Manager[]) ois.readObject();
            System.out.println("Manager data loaded successfully.");
        } catch (FileNotFoundException e) {
            System.out.println("No existing manager data found. Starting fresh.");
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
        return managers != null ? managers : new Manager[0];
    }

    public static void saveManagerData(String filename, Manager[] managers) {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(filename))) {
            oos.writeObject(managers);
            System.out.println("Manager data saved successfully.");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Load existing employee and manager data from files if they exist
        Employee[] employees = loadEmployeeData(EMPLOYEE_FILE);
        Manager[] managers = loadManagerData(MANAGER_FILE);

        while (true) {
            System.out.println("\n   EMPLOYEE PAYROLL SYSTEM ");
            System.out.println("\n*CHOOSE YOUR OPTION*");
            System.out.println("1) SHOW ALL RECORDS");
            System.out.println("2) ADD NEW EMPLOYEE RECORD");
            System.out.println("3) PRINT THE SALARY SLIP");
            System.out.println("4) UPDATE EMPLOYEE RECORD");
            System.out.println("5) EXIT");
            System.out.print("Enter your choice: ");
            int choice = scanner.nextInt();
            scanner.nextLine();

            if (choice != 5) {
                switch (choice) {
                    case 1:
                        System.out.println("\nEmp. ID. Emp.Name \t Basic \t HRA \t DA \t MA \t PF \t Insurance ");
                        for (Employee employee : employees) {
                            display(employee);
                        }
                        break;
                    case 2:
                        employees = addEmployee(employees, scanner);
                        break;
                    case 3:
                        for (Employee employee : employees) {
                            employee.calculateSalary();
                        }
                        System.out.print("Enter employee ID to get payslip: ");
                        int empID = scanner.nextInt();
                        boolean flag = false;
                        for (Employee employee : employees) {
                            if (empID == employee.empId) {
                                printSalary(employee);
                                flag = true;
                                break;
                            }
                        }
                        if (!flag) {
                            System.out.println("No Record Found!!");
                        }
                        break;
                    case 4:
                        updateEmployee(employees, scanner);
                        break;
                    default:
                        System.out.println("Error");
                }

                // Save employee data to file after each operation
                saveEmployeeData(EMPLOYEE_FILE, employees);

                System.out.print("\nDo You Want To Continue (1/0): ");
                int ch = scanner.nextInt();
                if (ch == 0) {
                    break;
                }
            } else {
                break;
            }
        }

        // Save employee and manager data to files when the program exits
        saveEmployeeData(EMPLOYEE_FILE, employees);
        saveManagerData(MANAGER_FILE, managers);
    }

    public static Employee[] addEmployee(Employee[] employees, Scanner scanner) {
        int num = employees.length;
        employees = resizeArray(employees, num + 1);

        employees[num] = new Employee();
        // System.out.print("Employee ID: ");
        // employees[num].empId = scanner.nextInt();  
        Employee emp = new Employee();      
        employees[num].empId = emp.generateRandomEmployeeId();
        System.out.println("Your Employee ID is: " + employees[num].empId);  // Display the ID to the user
        // scanner.nextLine();
        while (true) {
            try {
                System.out.print("Employee Name: ");
                String name = scanner.nextLine();
                validateEmployeeName(name);  // Custom method to validate the name
                employees[num].name = name;
                break;  // Break out of the loop if the name is valid
            } catch (InvalidEmployeeNameException e) {
                System.out.println("Error: " + e.getMessage());
            }
        }
        System.out.print("Basic Salary: ");
        employees[num].basic = scanner.nextInt();
        System.out.print("House Rent Allowance: ");
        employees[num].hra = scanner.nextInt();
        System.out.print("Dearness Allowance: ");
        employees[num].da = scanner.nextInt();
        System.out.print("Medical Allowance: ");
        employees[num].ma = scanner.nextInt();
        System.out.println("Enter the deductions:");
        System.out.print("Provident Fund: ");
        employees[num].pf = scanner.nextInt();
        System.out.print("Insurance: ");
        employees[num].insurance = scanner.nextInt();
        System.out.println();

        return employees;
    }
    static class InvalidEmployeeNameException extends Exception {
        public InvalidEmployeeNameException(String message) {
            super(message);
        }
    }
    private static void validateEmployeeName(String name) throws InvalidEmployeeNameException {
        // Check if the name contains numeric or symbolic values
        if (!name.matches("[a-zA-Z]+")) {
            throw new InvalidEmployeeNameException("Employee name should contain only alphabetic characters.");
        }
    }



    public static void updateEmployee(Employee[] employees, Scanner scanner) {
        System.out.print("Enter the employee ID to update data: ");
        int update = scanner.nextInt();
        boolean flag = false;
        for (Employee employee : employees) {
            if (update == employee.empId) {
                while (true) {
                    System.out.println("\nWHAT YOU WANT TO UPDATE?");
                    System.out.println("1) NAME");
                    System.out.println("2) BASIC SALARY");
                    System.out.println("3) HOUSE RENT ALLOWANCE");
                    System.out.println("4) DEARNESS ALLOWANCE");
                    System.out.println("5) MEDICAL ALLOWANCE");
                    System.out.println("6) PROVIDENT FUND");
                    System.out.println("7) INSURANCE");
                    System.out.println("8) UPDATE ALL RECORDS");
                    System.out.print("Enter your choice: ");
                    int updateChoice = scanner.nextInt();
                    scanner.nextLine();
                    switch (updateChoice) {
                        case 1:
                            System.out.print("Employee Name: ");
                            employee.name = scanner.nextLine();
                            break;
                        case 2:
                            System.out.print("Basic Salary: ");
                            employee.basic = scanner.nextInt();
                            break;
                        case 3:
                            System.out.print("House Rent Allowance: ");
                            employee.hra = scanner.nextInt();
                            break;
                        case 4:
                            System.out.print("Dearness Allowance: ");
                            employee.da = scanner.nextInt();
                            break;
                        case 5:
                            System.out.print("Medical Allowance: ");
                            employee.ma = scanner.nextInt();
                            break;
                        case 6:
                            System.out.print("Provident Fund: ");
                            employee.pf = scanner.nextInt();
                            break;
                        case 7:
                            System.out.print("Insurance: ");
                            employee.insurance = scanner.nextInt();
                            break;
                        case 8:
                            System.out.print("Employee Name: ");
                            employee.name = scanner.nextLine();
                            System.out.print("Basic Salary: ");
                            employee.basic = scanner.nextInt();
                            System.out.print("House Rent Allowance: ");
                            employee.hra = scanner.nextInt();
                            System.out.print("Dearness Allowance: ");
                            employee.da = scanner.nextInt();
                            System.out.print("Medical Allowance: ");
                            employee.ma = scanner.nextInt();
                            System.out.println("Enter the deductions:");
                            System.out.print("Provident Fund: ");
                            employee.pf = scanner.nextInt();
                            System.out.print("Insurance: ");
                            employee.insurance = scanner.nextInt();
                            break;
                        default:
                            System.out.println("Error Selection. Try Again!");
                    }
                    System.out.print("\nDo You Want To Update More (1/0): ");
                    int updateMore = scanner.nextInt();
                    scanner.nextLine();
                    if (updateMore == 0) {
                        break;
                    }
                }
                flag = true;
                break;
            }
        }
        
        if (!flag) {
            System.out.println("No Record Found!!");
        }
    }

    public static Employee[] resizeArray(Employee[] array, int newSize) {
        Employee[] newArray = new Employee[newSize];
        System.arraycopy(array, 0, newArray, 0, Math.min(array.length, newSize));
        return newArray;
    }
}
