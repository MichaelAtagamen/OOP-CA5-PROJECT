package org.DAOs;

import org.DTOs.PlayerDTO;

import java.util.List;

public interface PlayerDAO {
    List<PlayerDTO> getAllPlayers();
    PlayerDTO getPlayerById(int playerId);
    void insertPlayer(PlayerDTO player);
    void updatePlayer(PlayerDTO player);
    void deletePlayer(int playerId);
}



