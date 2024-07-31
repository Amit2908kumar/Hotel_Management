package com.hotelmanagement.main;

import com.hotelmanagement.controller.*;
import com.hotelmanagement.model.ICustomer;
import com.hotelmanagement.model.IRoom;
import com.hotelmanagement.model.IStaff;
import com.hotelmanagement.model.IUser;

import java.util.List;
import java.util.Scanner;

//menu class
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

    private static IRoomController roomController = new RoomControllerImpl();

    private static void manageRooms(Scanner scanner) {
        while (true) {
            System.out.println("Manage Rooms");
            System.out.println("1. Add Room");
            System.out.println("2. View Room");
            System.out.println("3. View All Rooms");
            System.out.println("4. Update Room");
            System.out.println("5. Delete Room");
            System.out.println("6. Back to Admin Menu");
            System.out.print("Enter your choice: ");
            int choice = scanner.nextInt();
            scanner.nextLine(); // consume newline

            switch (choice) {
                case 1:
                    addRoom(scanner);
                    break;
                case 2:
                    viewRoom(scanner);
                    break;
                case 3:
                    viewAllRooms();
                    break;
                case 4:
                    updateRoom(scanner);
                    break;
                case 5:
                    deleteRoom(scanner);
                    break;
                case 6:
                    return;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }

    private static void addRoom(Scanner scanner) {
        System.out.print("Enter room number: ");
        String number = scanner.nextLine();
        System.out.print("Enter room type: ");
        String type = scanner.nextLine();
        System.out.print("Enter room price: ");
        double price = scanner.nextDouble();
        scanner.nextLine(); // consume newline

        boolean isAdded = roomController.addRoom(number, type, price);
        if (isAdded) {
            System.out.println("Room added successfully.");
        } else {
            System.out.println("Room addition failed.");
        }
    }

    private static void viewRoom(Scanner scanner) {
        System.out.print("Enter room ID: ");
        int id = scanner.nextInt();
        scanner.nextLine(); // consume newline

        IRoom room = roomController.getRoom(id);
        if (room != null) {
            System.out.println("Room ID: " + room.getId());
            System.out.println("Room Number: " + room.getNumber());
            System.out.println("Room Type: " + room.getType());
            System.out.println("Room Price: " + room.getPrice());
        } else {
            System.out.println("Room not found.");
        }
    }

    private static void viewAllRooms() {
        List<IRoom> rooms = roomController.getAllRooms();
        if (!rooms.isEmpty()) {
            for (IRoom room : rooms) {
                System.out.println("Room ID: " + room.getId());
                System.out.println("Room Number: " + room.getNumber());
                System.out.println("Room Type: " + room.getType());
                System.out.println("Room Price: " + room.getPrice());
                System.out.println();
            }
        } else {
            System.out.println("No rooms found.");
        }
    }

    private static void updateRoom(Scanner scanner) {
        System.out.print("Enter room ID: ");
        int id = scanner.nextInt();
        scanner.nextLine(); // consume newline
        System.out.print("Enter new room number: ");
        String number = scanner.nextLine();
        System.out.print("Enter new room type: ");
        String type = scanner.nextLine();
        System.out.print("Enter new room price: ");
        double price = scanner.nextDouble();
        scanner.nextLine(); // consume newline

        boolean isUpdated = roomController.updateRoom(id, number, type, price);
        if (isUpdated) {
            System.out.println("Room updated successfully.");
        } else {
            System.out.println("Room update failed.");
        }
    }

    private static void deleteRoom(Scanner scanner) {
        System.out.print("Enter room ID: ");
        int id = scanner.nextInt();
        scanner.nextLine(); // consume newline

        boolean isDeleted = roomController.deleteRoom(id);
        if (isDeleted) {
            System.out.println("Room deleted successfully.");
        } else {
            System.out.println("Room deletion failed.");
        }
    }
    private static IStaffController staffController = new StaffControllerImpl();

    private static void manageStaff(Scanner scanner) {
        while (true) {
            System.out.println("Manage Staff");
            System.out.println("1. Add Staff");
            System.out.println("2. View Staff");
            System.out.println("3. View All Staff");
            System.out.println("4. Update Staff");
            System.out.println("5. Delete Staff");
            System.out.println("6. Back to Admin Menu");
            System.out.print("Enter your choice: ");
            int choice = scanner.nextInt();
            scanner.nextLine(); // consume newline

            switch (choice) {
                case 1:
                    addStaff(scanner);
                    break;
                case 2:
                    viewStaff(scanner);
                    break;
                case 3:
                    viewAllStaff();
                    break;
                case 4:
                    updateStaff(scanner);
                    break;
                case 5:
                    deleteStaff(scanner);
                    break;
                case 6:
                    return;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }

    private static void addStaff(Scanner scanner) {
        System.out.print("Enter staff name: ");
        String name = scanner.nextLine();
        System.out.print("Enter staff position: ");
        String position = scanner.nextLine();
        System.out.print("Enter staff salary: ");
        double salary = scanner.nextDouble();
        scanner.nextLine(); // consume newline

        boolean isAdded = staffController.addStaff(name, position, salary);
        if (isAdded) {
            System.out.println("Staff added successfully.");
        } else {
            System.out.println("Staff addition failed.");
        }
    }

    private static void viewStaff(Scanner scanner) {
        System.out.print("Enter staff ID: ");
        int id = scanner.nextInt();
        scanner.nextLine(); // consume newline

        IStaff staff = staffController.getStaff(id);
        if (staff != null) {
            System.out.println("Staff ID: " + staff.getId());
            System.out.println("Staff Name: " + staff.getName());
            System.out.println("Staff Position: " + staff.getPosition());
            System.out.println("Staff Salary: " + staff.getSalary());
        } else {
            System.out.println("Staff not found.");
        }
    }

    private static void viewAllStaff() {
        List<IStaff> staff = staffController.getAllStaff();
        if (!staff.isEmpty()) {
            for (IStaff staffMember : staff) {
                System.out.println("Staff ID: " + staffMember.getId());
                System.out.println("Staff Name: " + staffMember.getName());
                System.out.println("Staff Position: " + staffMember.getPosition());
                System.out.println("Staff Salary: " + staffMember.getSalary());
                System.out.println();
            }
        } else {
            System.out.println("No staff found.");
        }
    }

    private static void updateStaff(Scanner scanner) {
        System.out.print("Enter staff ID: ");
        int id = scanner.nextInt();
        scanner.nextLine(); // consume newline
        System.out.print("Enter new staff name: ");
        String name = scanner.nextLine();
        System.out.print("Enter new staff position: ");
        String position = scanner.nextLine();
        System.out.print("Enter new staff salary: ");
        double salary = scanner.nextDouble();
        scanner.nextLine(); // consume newline

        boolean isUpdated = staffController.updateStaff(id, name, position, salary);
        if (isUpdated) {
            System.out.println("Staff updated successfully.");
        } else {
            System.out.println("Staff update failed.");
        }
    }

    private static void deleteStaff(Scanner scanner) {
        System.out.print("Enter staff ID: ");
        int id = scanner.nextInt();
        scanner.nextLine(); // consume newline

        boolean isDeleted = staffController.deleteStaff(id);
        if (isDeleted) {
            System.out.println("Staff deleted successfully.");
        } else {
            System.out.println("Staff deletion failed.");
        }
    }

    private static void viewRooms() {
        System.out.println("View available rooms");
    }
}
