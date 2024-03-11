package org.DAOs;

import org.DTOs.PlayerDTO;
import org.Exceptions.DaoException;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class MySQLPlayerDAO extends MySqlDao implements PlayerDAO {

    @Override
    public List<PlayerDTO> getAllPlayers() throws DaoException {
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        List<PlayerDTO> playersList = new ArrayList<>();

        try {
            connection = this.getConnection();
            String query = "SELECT * FROM Player";
            preparedStatement = connection.prepareStatement(query);
            resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
                int playerId = resultSet.getInt("id");
                String name = resultSet.getString("name");
                float rating = resultSet.getFloat("rating");
                int age = resultSet.getInt("age");

                PlayerDTO player = new PlayerDTO(playerId, name, rating, age);
                playersList.add(player);
            }
        } catch (SQLException e) {
            throw new DaoException("getAllPlayers() " + e.getMessage());
        } finally {
            try {
                if (resultSet != null) {
                    resultSet.close();
                }
                if (preparedStatement != null) {
                    preparedStatement.close();
                }
                if (connection != null) {
                    freeConnection(connection);
                }
            } catch (SQLException e) {
                throw new DaoException("Error closing resources: " + e.getMessage());
            }
        }

        return playersList;
    }

    @Override
    public PlayerDTO getPlayerById(int playerId) throws DaoException {
        // Placeholder implementation
        throw new UnsupportedOperationException("getPlayerById method not implemented yet");
        // Or, if you want to return null temporarily
        // return null;
    }

    @Override
    public void insertPlayer(PlayerDTO player) throws DaoException {
        // Implement insertPlayer logic here
    }

    @Override
    public void updatePlayer(PlayerDTO player) throws DaoException {
        // Implement updatePlayer logic here
    }

    @Override
    public void deletePlayer(int playerId) throws DaoException {
        // Implement deletePlayer logic here
    }
}
