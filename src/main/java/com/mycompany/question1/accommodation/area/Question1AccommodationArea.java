package com.mycompany.question1.accommodation.area;

import java.util.Scanner;
import speke.AccommodationArea;
import speke.GymArea;
import speke.SwimmingArea;

public class Question1AccommodationArea {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        GymArea gym = new GymArea();
        SwimmingArea pool = new SwimmingArea();
        AccommodationArea activeArea = gym;

        System.out.println("=== Welcome to Speke Apartments Accommodation Control System ===");

        char choice = '\0';
        do {
            System.out.println("\nMain Menu:");
            System.out.println("S - Select active area (G = Gym, P = Swimming)");
            System.out.println("W - Add occupants");
            System.out.println("X - Remove occupants");
            System.out.println("Y - Switch ON light (1–3)");
            System.out.println("Z - Switch OFF light (1–3)");
            System.out.println("R - Report status");
            System.out.println("Q - Quit");
            System.out.print("Enter choice: ");

            String input = scanner.nextLine().trim().toUpperCase();
            if (input.isEmpty()) continue;
            choice = input.charAt(0);

            switch (choice) {
                case 'S':
                    System.out.print("Select area (G = Gym, P = Swimming): ");
                    String area = scanner.nextLine().trim().toUpperCase();
                    if (area.equals("G")) {
                        activeArea = gym;
                        System.out.println("Active area set to Gym Area.");
                    } else if (area.equals("P")) {
                        activeArea = pool;
                        System.out.println("Active area set to Swimming Area.");
                    } else {
                        System.out.println("Invalid area selection. Try again.");
                    }
                    break;

                case 'W':
                    int add = getValidInteger(scanner, "Enter number of occupants to add: ");
                    activeArea.addOccupants(add);
                    System.out.println(add + " occupants added to " + activeArea.name + ".");
                    break;

                case 'X':
                    int remove = getValidInteger(scanner, "Enter number of occupants to remove: ");
                    activeArea.removeOccupants(remove);
                    System.out.println(remove + " occupants removed from " + activeArea.name + ".");
                    break;

                case 'Y':
                    int lightOn = getValidLight(scanner, "Enter light number to switch ON (1–3): ");
                    activeArea.switchOnLight(lightOn);
                    System.out.println("Light " + lightOn + " switched ON in " + activeArea.name + ".");
                    break;

                case 'Z':
                    int lightOff = getValidLight(scanner, "Enter light number to switch OFF (1–3): ");
                    activeArea.switchOffLight(lightOff);
                    System.out.println("Light " + lightOff + " switched OFF in " + activeArea.name + ".");
                    break;

                case 'R':
                    activeArea.reportStatus();
                    break;

                case 'Q':
                    System.out.println("Exiting system... Goodbye!");
                    break;

                default:
                    System.out.println("Invalid choice. Please try again.");
            }

        } while (choice != 'Q');

        scanner.close();
    }

    private static int getValidInteger(Scanner scanner, String prompt) {
        int n = -1;
        while (true) {
            System.out.print(prompt);
            try {
                n = Integer.parseInt(scanner.nextLine().trim());
                if (n >= 0) break;
                else System.out.println("Please enter a non-negative integer.");
            } catch (NumberFormatException e) {
                System.out.println("Invalid input! Please enter an integer.");
            }
        }
        return n;
    }

    private static int getValidLight(Scanner scanner, String prompt) {
        int n = -1;
        while (true) {
            System.out.print(prompt);
            try {
                n = Integer.parseInt(scanner.nextLine().trim());
                if (n >= 1 && n <= 3) break;
                else System.out.println("Light number must be between 1 and 3.");
            } catch (NumberFormatException e) {
                System.out.println("Invalid input! Please enter a valid light number (1–3).");
            }
        }
        return n;
    }
}
