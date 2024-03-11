package org.DAOs;

import org.DTOs.PlayerDTO;


import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class MySQLPlayerDAO implements PlayerDAO {
    // Connection initialization and other necessary methods...

    private Connection getConnection() throws SQLException {
        // Implement logic to establish a database connection
        return DriverManager.getConnection("jdbc:mysql://localhost:3306/premierleaguedb", "yourUsername", "yourPassword");
    }

    @Override
    public List<PlayerDTO> getAllPlayers() {
        List<PlayerDTO> players = new ArrayList<>();

        try (Connection connection = getConnection();
             Statement statement = connection.createStatement();
             ResultSet resultSet = statement.executeQuery("SELECT * FROM Player")) {

            while (resultSet.next()) {
                PlayerDTO player = new PlayerDTO();
                player.setId(resultSet.getInt("id"));
                player.setName(resultSet.getString("name"));
                player.setRating(resultSet.getFloat("rating"));
                player.setAge(resultSet.getInt("age"));
                players.add(player);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return players;
    }

    @Override
    public PlayerDTO getPlayerById(int playerId) {
        PlayerDTO player = null;

        try (Connection connection = getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement("SELECT * FROM Player WHERE id = ?")) {

            preparedStatement.setInt(1, playerId);
            try (ResultSet resultSet = preparedStatement.executeQuery()) {
                if (resultSet.next()) {
                    player = new PlayerDTO();
                    player.setId(resultSet.getInt("id"));
                    player.setName(resultSet.getString("name"));
                    player.setRating(resultSet.getFloat("rating"));
                    player.setAge(resultSet.getInt("age"));
                }
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return player;
    }

    @Override
    public void insertPlayer(PlayerDTO player) {
        try (Connection connection = getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement("INSERT INTO Player (name, rating, age) VALUES (?, ?, ?)")) {

            preparedStatement.setString(1, player.getName());
            preparedStatement.setFloat(2, player.getRating());
            preparedStatement.setInt(3, player.getAge());
            preparedStatement.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void updatePlayer(PlayerDTO player) {
        try (Connection connection = getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement("UPDATE Player SET name = ?, rating = ?, age = ? WHERE id = ?")) {

            preparedStatement.setString(1, player.getName());
            preparedStatement.setFloat(2, player.getRating());
            preparedStatement.setInt(3, player.getAge());
            preparedStatement.setInt(4, player.getId());
            preparedStatement.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void deletePlayer(int playerId) {
        try (Connection connection = getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement("DELETE FROM Player WHERE id = ?")) {

            preparedStatement.setInt(1, playerId);
            preparedStatement.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
