import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import ru.netology.excceptions.NotRegisteredException;
import ru.netology.game.Game;
import ru.netology.player.Player;

import static org.junit.jupiter.api.Assertions.assertThrows;

public class GameTest {
    Game game = new Game();

    Player player1 = new Player(1, "Scorpion", 45);
    Player player2 = new Player(2, "Johnny Cage", 47);
    Player player3 = new Player(3, "Liu Kang", 46);
    Player player4 = new Player(4, "Raiden", 50);
    Player player5 = new Player(5, "Reptile", 45);

    @BeforeEach
    public void setUp() {
        game.registration(player1);
        game.registration(player2);
        game.registration(player3);
        game.registration(player4);
        game.registration(player5);
    }

    @Test
    public void testRoundRegisteredFirstFighterWin() {
        int expected = 1;
        int actual = game.round("Johnny Cage", "Scorpion");

        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void testRoundRegisteredSecondFighterWin() {
        int expected = 2;
        int actual = game.round("Liu Kang", "Raiden");

        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void testRoundRegisteredDraw() {
        int expected = 0;
        int actual = game.round("Reptile", "Scorpion");

        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void testRoundIsNotRegisteredFirstFighter() {
        assertThrows(NotRegisteredException.class, () -> {
            game.round("Shang Tsung", "Reptile");
        });
    }

    @Test
    public void testRoundIsNotRegisteredSecondFighter() {
        assertThrows(NotRegisteredException.class, () -> {
            game.round("Liu Kang", "Shang Tsung");
        });
    }

}
