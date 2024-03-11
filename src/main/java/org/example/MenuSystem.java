package org.example;

// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
import org.DAOs.MySQLPlayerDAO;
import org.DAOs.PlayerDAO;
import org.DTOs.PlayerDTO;

import java.util.List;
import java.util.Scanner;

public class MenuSystem {
    private PlayerDAO playerDAO = (PlayerDAO) new MySQLPlayerDAO(); // You can use dependency injection here

    public void displayMenu() {
        Scanner scanner = new Scanner(System.in);
        int choice;

        do {
            System.out.println("Menu:");
            System.out.println("1. Get All Players");
            System.out.println("2. Get Player by ID");
            System.out.println("0. Exit");
            System.out.print("Enter your choice: ");

            choice = scanner.nextInt();
            scanner.nextLine(); // consume the newline character

            switch (choice) {
                case 1:
                    getAllPlayers();
                    break;
                case 2:
                    getPlayerById();
                    break;
                case 0:
                    System.out.println("Exiting the program. Goodbye!");
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }

        } while (choice != 0);
    }

    private void getAllPlayers() {
        List<PlayerDTO> players = playerDAO.getAllPlayers();
        System.out.println("List of Players:");
        for (PlayerDTO player : players) {
            System.out.println(player.getId() + ". " + player.getName() + " (Rating: " + player.getRating() + ", Age: " + player.getAge() + ")");
        }
    }

    private void getPlayerById() {
        System.out.print("Enter the player ID: ");
        int playerId = new Scanner(System.in).nextInt();

        PlayerDTO player = playerDAO.getPlayerById(playerId);
        if (player != null) {
            System.out.println("Player details:");
            System.out.println(player);
        } else {
            System.out.println("Player not found with ID: " + playerId);
        }
    }

    public static void main(String[] args) {
        MenuSystem menuSystem = new MenuSystem();
        menuSystem.displayMenu();
    }
}
