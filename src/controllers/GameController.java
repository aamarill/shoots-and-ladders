package controllers;

import components.*;

import java.util.List;

public class GameController {

  Board board;
  List<Die> dice;
  Player winningPlayer;

  public GameController(Board board, List<Die> dice) {
    this.board = board;
    this.dice = dice;
  }

  public void playTurn(Player player) {
    int result = rollDice();
    System.out.println(player.getName() + " rolled a " + result);
    player.setPosition(player.getPosition() + result);

    if (isWinner(player)) {
      winningPlayer = player;
      return;
    }

    Slot newSlot = board.getSlot(player.getPosition());
    Carrier carrier = newSlot.getCarrier();

    if (carrier != null) {
      player.setPosition(carrier.getEnd());
    }
  }

  private boolean isWinner(Player player) {
    return player.getPosition() > board.getSize();
  }

  private int rollDice() {
    int result = 0;
    for (Die die : dice) {
      result += die.roll();
    }
    return result;
  }

  public Player getWinningPlayer() {
    return winningPlayer;
  }
}
