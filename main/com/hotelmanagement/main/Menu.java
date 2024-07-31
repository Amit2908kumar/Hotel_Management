package com.hotelmanagement.main;

import com.hotelmanagement.controller.IUserController;
import com.hotelmanagement.controller.UserControllerImpl;
import com.hotelmanagement.controller.ICustomerController;
import com.hotelmanagement.controller.CustomerControllerImpl;
import com.hotelmanagement.model.ICustomer;
import com.hotelmanagement.model.IUser;

import java.util.List;
import java.util.Scanner;

public class Menu {
    private static IUserController userController = new UserControllerImpl();
    private static ICustomerController customerController = new CustomerControllerImpl();

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.println("Hotel Management System");
            System.out.println("1. Register");
            System.out.println("2. Login");
            System.out.println("3. Exit");
            System.out.print("Enter your choice: ");
            int choice = scanner.nextInt();
            scanner.nextLine(); // consume newline

            switch (choice) {
                case 1:
                    register(scanner);
                    break;
                case 2:
                    login(scanner);
                    break;
                case 3:
                    System.out.println("Exiting...");
                    scanner.close();
                    return;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }

    private static void register(Scanner scanner) {
        System.out.print("Enter username: ");
        String username = scanner.nextLine();
        System.out.print("Enter password: ");
        String password = scanner.nextLine();
        System.out.print("Enter role (admin/user): ");
        String role = scanner.nextLine();

        boolean isRegistered = userController.register(username, password, role);
        if (isRegistered) {
            System.out.println("User registered successfully.");
        } else {
            System.out.println("User registration failed.");
        }
    }

    private static void login(Scanner scanner) {
        System.out.print("Enter username: ");
        String username = scanner.nextLine();
        System.out.print("Enter password: ");
        String password = scanner.nextLine();

        IUser user = userController.login(username, password);
        if (user != null) {
            System.out.println("Login successful. Welcome, " + user.getUsername());
            if ("admin".equals(user.getRole())) {
                showAdminMenu(scanner);
            } else {
                showUserMenu(scanner);
            }
        } else {
            System.out.println("Login failed. Invalid credentials.");
        }
    }

    private static void showAdminMenu(Scanner scanner) {
        while (true) {
            System.out.println("Admin Menu");
            System.out.println("1. Manage Customers");
            System.out.println("2. Manage Rooms");
            System.out.println("3. Manage Staff");
            System.out.println("4. Manage Inventory");
            System.out.println("5. Logout");
            System.out.print("Enter your choice: ");
            int choice = scanner.nextInt();
            scanner.nextLine(); // consume newline

            switch (choice) {
                case 1:
                    manageCustomers(scanner);
                    break;
                case 2:
                    manageRooms(scanner);
                    break;
                case 3:
                    manageStaff(scanner);
                    break;
                case 4:
                    manageInventory(scanner);
                    break;
                case 5:
                    System.out.println("Logging out...");
                    return;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }

    private static void showUserMenu(Scanner scanner) {
        while (true) {
            System.out.println("User Menu");
            System.out.println("1. View Rooms");
            System.out.println("2. Logout");
            System.out.print("Enter your choice: ");
            int choice = scanner.nextInt();
            scanner.nextLine(); // consume newline

            switch (choice) {
                case 1:
                    viewRooms();
                    break;
                case 2:
                    System.out.println("Logging out...");
                    return;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }

    private static void manageCustomers(Scanner scanner) {
        while (true) {
            System.out.println("Manage Customers");
            System.out.println("1. Add Customer");
            System.out.println("2. View Customer");
            System.out.println("3. View All Customers");
            System.out.println("4. Update Customer");
            System.out.println("5. Delete Customer");
            System.out.println("6. Back to Admin Menu");
            System.out.print("Enter your choice: ");
            int choice = scanner.nextInt();
            scanner.nextLine(); // consume newline

            switch (choice) {
                case 1:
                    addCustomer(scanner);
                    break;
                case 2:
                    viewCustomer(scanner);
                    break;
                case 3:
                    viewAllCustomers();
                    break;
                case 4:
                    updateCustomer(scanner);
                    break;
                case 5:
                    deleteCustomer(scanner);
                    break;
                case 6:
                    return;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }

    private static void addCustomer(Scanner scanner) {
        System.out.print("Enter customer name: ");
        String name = scanner.nextLine();
        System.out.print("Enter customer email: ");
        String email = scanner.nextLine();

        boolean isAdded = customerController.addCustomer(name, email);
        if (isAdded) {
            System.out.println("Customer added successfully.");
        } else {
            System.out.println("Customer addition failed.");
        }
    }

    private static void viewCustomer(Scanner scanner) {
        System.out.print("Enter customer ID: ");
        int id = scanner.nextInt();
        scanner.nextLine(); // consume newline

        ICustomer customer = customerController.getCustomer(id);
        if (customer != null) {
            System.out.println("Customer ID: " + customer.getId());
            System.out.println("Customer Name: " + customer.getName());
            System.out.println("Customer Email: " + customer.getEmail());
        } else {
            System.out.println("Customer not found.");
        }
    }

    private static void viewAllCustomers() {
        List<ICustomer> customers = customerController.getAllCustomers();
        if (!customers.isEmpty()) {
            for (ICustomer customer : customers) {
                System.out.println("Customer ID: " + customer.getId());
                System.out.println("Customer Name: " + customer.getName());
                System.out.println("Customer Email: " + customer.getEmail());
                System.out.println();
            }
        } else {
            System.out.println("No customers found.");
        }
    }

    private static void updateCustomer(Scanner scanner) {
        System.out.print("Enter customer ID: ");
        int id = scanner.nextInt();
        scanner.nextLine(); // consume newline
        System.out.print("Enter new customer name: ");
        String name = scanner.nextLine();
        System.out.print("Enter new customer email: ");
        String email = scanner.nextLine();

        boolean isUpdated = customerController.updateCustomer(id, name, email);
        if (isUpdated) {
            System.out.println("Customer updated successfully.");
        } else {
            System.out.println("Customer update failed.");
        }
    }

    private static void deleteCustomer(Scanner scanner) {
        System.out.print("Enter customer ID: ");
        int id = scanner.nextInt();
        scanner.nextLine(); // consume newline

        boolean isDeleted = customerController.deleteCustomer(id);
        if (isDeleted) {
            System.out.println("Customer deleted successfully.");
        } else {
            System.out.println("Customer deletion failed.");
        }
    }

    private static void manageRooms(Scanner scanner) {
        // Placeholder for room management functionality
        System.out.println("Manage Rooms (Add, Update, Delete, View)");
    }

    private static void manageStaff(Scanner scanner) {
        // Placeholder for staff management functionality
        System.out.println("Manage Staff (Add, Update, Delete, View)");
    }

    private static void manageInventory(Scanner scanner) {
        // Placeholder for inventory management functionality
        System.out.println("Manage Inventory (Add, Update, Delete, View)");
    }

    private static void viewRooms() {
        // Placeholder for viewing room functionality for regular users
        System.out.println("View available rooms");
    }
}
