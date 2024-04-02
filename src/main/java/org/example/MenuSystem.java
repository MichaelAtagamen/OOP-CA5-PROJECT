package org.example;

import org.DAOs.MySQLPlayerDAO;
import org.DAOs.PlayerDAO;
import org.DTOs.PlayerDTO;
import org.Exceptions.DaoException;

import java.util.List;
import java.util.Scanner;

public class MenuSystem
{
    public static void main(String[] args)
    {
        PlayerDAO playerDao = new MySQLPlayerDAO();
        Scanner scanner = new Scanner(System.in);

        try
        {
            int choice;
            do
            {
                System.out.println("\nMenu:");
                System.out.println("1. Display All Players");
                System.out.println("2. Display Player by ID");
                System.out.println("3. Add New Player");
                System.out.println("4. Update Player");
                System.out.println("5. Delete Player");
                System.out.println("0. Exit");
                System.out.print("Enter your choice: ");
                choice = scanner.nextInt();


                switch (choice)
                {
                    case 1:
                        displayAllPlayers(playerDao);
                        break;
                    case 2:
                        displayPlayerById(playerDao, scanner);
                        break;
                    case 3:
                        addNewPlayer(playerDao, scanner);
                        break;
                    case 4:
                        updatePlayer(playerDao, scanner);
                        break;
                    case 5:
                        deletePlayer(playerDao, scanner);
                        break;
                    case 0:
                        System.out.println("Exiting the Menu System. Goodbye!");
                        break;
                    default:
                        System.out.println("Invalid choice. Please enter a valid option.");
                }
            } while (choice != 0);
        }
        catch (DaoException e)
        {
            e.printStackTrace();
        }
        finally
        {
            if (scanner != null)
            {
                scanner.close();
            }
        }
    }

    private static void displayAllPlayers(PlayerDAO playerDao) throws DaoException
    {
        List<PlayerDTO> players = playerDao.getAllPlayers();
        if (players.isEmpty())
        {
            System.out.println("No players found.");
        }
        else
        {
            for (PlayerDTO player : players)
            {
                System.out.println(player);
            }
        }
    }

    private static void displayPlayerById(PlayerDAO playerDao, Scanner scanner) throws DaoException
    {
        System.out.print("Enter Player ID: ");
        int playerId = scanner.nextInt();
        PlayerDTO player = playerDao.getPlayerById(playerId);
        if (player != null)
        {
            System.out.println("Player found: " + player);
        }
        else
        {
            System.out.println("Player not found with ID: " + playerId);
        }
    }

    private static void addNewPlayer(PlayerDAO playerDao, Scanner scanner) throws DaoException
    {
        // Implement logic to add a new player
    }

    private static void updatePlayer(PlayerDAO playerDao, Scanner scanner) throws DaoException
    {
        // Implement logic to update a player
    }

    private static void deletePlayer(PlayerDAO playerDao, Scanner scanner) throws DaoException
    {
        // Implement logic to delete a player
    }
}
