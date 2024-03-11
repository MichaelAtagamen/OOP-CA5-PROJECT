package org.DAOs;

import org.DTOs.PlayerDTO;
import org.Exceptions.DaoException;

import java.util.List;

public interface PlayerDAO {
    List<PlayerDTO> getAllPlayers() throws DaoException;
    PlayerDTO getPlayerById(int playerId) throws DaoException;
    void insertPlayer(PlayerDTO player) throws DaoException;
    void updatePlayer(PlayerDTO player) throws DaoException;
    void deletePlayer(int playerId) throws DaoException;
}
