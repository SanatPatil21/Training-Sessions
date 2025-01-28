package emp.assignment;

//This code is an Improved Version of Exception Handling keeping it loosely coupled
import java.util.InputMismatchException;
import java.util.Scanner;

abstract class Employee {
    String name;
    int age;
    String designation;
    float salary;
    int empid;
    static Employee[] emparray = new Employee[100];
    static int empCount = 0;
    Scanner sc = new Scanner(System.in);

    private int ageValidator() {
        while(true){
            try {
                System.out.println("Please Enter your age: ");
                int ageInput = sc.nextInt();
                if (ageInput > 60 || ageInput < 21) {
                    throw new InvalidAgeInputException("Please enter age between 21 and 60");
                }
                return ageInput;
            } catch (InputMismatchException e) {
                System.out.println("Please enter numeric value");
                // sc.nextLine();
            } catch (InvalidAgeInputException e) {
                System.out.println(e.getMessage());
            }

        }
        
    }

    Employee(float salary, String designation) {

        boolean uniqueId = false;
        do {
            System.out.println("Please Enter a Employee ID: ");
            int employeeIdInput = sc.nextInt();
            uniqueId = true;
            for (int i = 0; i < empCount; i++) {
                if (emparray[i].empid == employeeIdInput) {
                    uniqueId = false;
                    System.out.println("Employee ID already exists. Please enter a unique ID.");
                    break;
                }
            }
            if (uniqueId) {
                this.empid = employeeIdInput;
            }
        } while (!uniqueId);

        sc.nextLine();
        System.out.println("Please Enter your name: ");
        this.name = sc.nextLine();
        //Calling the ageValidator() which handles all the try catch stuffs
        this.age=ageValidator();
        this.salary = salary;
        this.designation = designation;

        if (empCount < emparray.length) {
            emparray[empCount++] = this;
        }


    }

    public void display() {
        System.out.println("Employee Id: " + empid);
        System.out.println("Name: " + name);
        System.out.println("Age: " + age);
        System.out.println("Salary: " + salary);
        System.out.println("Designation: " + designation);
        System.out.println();
    }

    public abstract void raiseSalary();



}

final class Clerk extends Employee {
    Clerk() {
        super(10000, "Clerk");
    }

    public void raiseSalary() {
        salary += 5000;
    }
}

class Programmer extends Employee {
    Programmer() {
        super(50000, "Programmer");
    }

    public void raiseSalary() {
        salary += 10000;
    }
}

class Manager extends Employee {
    Manager() {
        super(100000, "Manager");
    }

    public void raiseSalary() {
        salary += 10000;
    }
}

public class EmpManagementApp {
    public static void main(String args[]) throws InputMismatchException {
        Scanner sc = new Scanner(System.in);
        int mainMenuChoice = 0, employeeType = 0;

        System.out.println("Welcome to Employee Management App!");

        do {
            System.out.println("-------------------------------------");
            System.out.println("MAIN MENU");
            System.out.println("1. Create Employee");
            System.out.println("2. Display");
            System.out.println("3. Raise Salary");
            System.out.println("4. Remove Employee");
            System.out.println("5. Exit");
            System.out.println("-------------------------------------");
            System.out.print("Enter your choice: ");
            mainMenuChoice = Menu.validateChoice(5);

            switch (mainMenuChoice) {
                case 1:
                    do {
                        System.out.println("---------------------------------------------");
                        System.out.println("1. Create Clerk");
                        System.out.println("2. Create Programmer");
                        System.out.println("3. Create Manager");
                        System.out.println("4. Back");
                        System.out.println("--------------------------------------------");

                        employeeType = Menu.validateChoice(4);

                        if (employeeType == 1) {
                            System.out.println("Adding Details of Clerk");
                            new Clerk();
                        } else if (employeeType == 2) {
                            System.out.println("Adding Details of Programmer");
                            new Programmer();
                        } else if (employeeType == 3) {
                            System.out.println("Adding Details of Manager");
                            new Manager();
                        }
                    } while (employeeType != 4);
                    break;
                case 2:
                    System.out.println("Displaying all employees:");
                    for (int i = 0; i < Employee.empCount; i++) {
                        Employee.emparray[i].display();
                    }
                    break;

                case 3:
                    System.out.println("Raising salaries of all employees:");
                    for (int i = 0; i < Employee.empCount; i++) {
                        Employee.emparray[i].raiseSalary();
                    }
                    break;

                case 4:
                    System.out.print("Enter the employee ID to delete: ");
                    int deleteEmployeeInput = sc.nextInt();
                    boolean found = false;

                    for (int i = 0; i < Employee.empCount; i++) {
                        if (Employee.emparray[i].empid == deleteEmployeeInput) {
                            Employee.emparray[i].display();
                            System.out.print("Are you sure you want to delete this Employee? (Y/N): ");
                            char confirmationInput = sc.next().charAt(0);

                            if (confirmationInput == 'Y' || confirmationInput == 'y') {
                                Employee.emparray[i] = null;
                                Employee.empCount--;
                                System.out.println("Employee successfully removed.");
                            } else {
                                System.out.println("Employee removal cancelled.");
                            }

                            found = true;
                            break;
                        }
                    }

                    if (!found) {
                        System.out.println("Employee ID not found.");
                    }
                    break;

                case 5:
                    System.out.println("Exiting the application...");
                    break;

            }

        } while (mainMenuChoice != 5);

        sc.close();
    }
}

class InvalidAgeInputException extends Exception {
    InvalidAgeInputException() {
        super();
    }

    InvalidAgeInputException(String msg) {
        super(msg);
    }
}

class InvalidChoiceException extends Exception {
    InvalidChoiceException() {
        super();
    }

    InvalidChoiceException(String msg) {
        super(msg);
    }

    public void displayMessage(int maxChoice) {
        System.out.println("Please enter a choice between 1 and " + maxChoice);
    }

}

// We create a class to seperate out the try-catch block from the main methods
class Menu {
    private static int maxChoice;

    public static int validateChoice(int max) {
        maxChoice = max;
        while (true) {
            System.out.println("Enter Choice:- ");
            try {
                int choice = new Scanner(System.in).nextInt();
                if (choice < 1 || choice > maxChoice)
                    throw new InvalidChoiceException();
                return choice;
            } catch (InputMismatchException e) {
                System.out.println("Please enter a numeric value only ");
            } catch (InvalidChoiceException e) {
                e.displayMessage(maxChoice);
            }
        }

    }

}
