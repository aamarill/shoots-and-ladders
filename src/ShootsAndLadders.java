import components.*;
import controllers.GameController;

import java.util.List;

public class ShootsAndLadders {

  public static void main(String[] args) {
    // Configuration (would change depending on product requirements)
    int boardSize = 30;
    List<Player> players = List.of(new Player("Adan", 1), new Player("Zack", 1));
    List<Die> dice = List.of(new Die(1, 6), new Die(1, 6));
    List<Carrier> carriers = List.of(new Ladder(3, 7), new Shoot(9, 1));
    Board board  = new Board(boardSize, carriers);
    board.print();

    // Game orchestrator
    GameController gameController = new GameController(board, dice);

    // Game flow
    boolean continueGame = true;
    while (continueGame) {
      for (Player player : players) {
        gameController.playTurn(player);
        player.printStatus();

        if (gameController.getWinningPlayer() != null) {
          continueGame = false;
          break;
        }
      }
    }
  }

}
