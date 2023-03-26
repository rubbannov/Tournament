package ru.netology.game;

import ru.netology.excceptions.NotRegisteredException;
import ru.netology.player.Player;

import java.util.ArrayList;
import java.util.Objects;

public class Game {
    ArrayList<Player> players = new ArrayList<>();

    public void registration(Player player) {
        players.add(player);
    }

    public int round(String playerName1, String playerName2) {
        Player player1 = registered(playerName1);
        Player player2 = registered(playerName2);
        if (player1 == null) {
            throw new NotRegisteredException("Player " + playerName1 + " is not registered");
        }
        if (player2 == null) {
            throw new NotRegisteredException("Player " + playerName2 + " is not registered");

        }

        if (player1.getStrength() > player2.getStrength()) {
            return 1;
        } else if (player1.getStrength() < player2.getStrength()) {
            return 2;
        }
        return 0;
    }

    public Player registered(String playername) {
        for (Player item : players) {
            if (Objects.equals(item.getName(), playername)) {
                return item;
            }
        }
        return null;
    }
}