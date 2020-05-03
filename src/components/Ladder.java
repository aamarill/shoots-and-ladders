package components;

public class Ladder implements Carrier {

  private int start;
  private int end;

  public Ladder(int start, int end) {
    if (start > end) {
      throw new RuntimeException("End must be larger than start for ladders");
    }

    this.start = start;
    this.end = end;
  }

  public int getStart() {
    return start;
  }

  public int getEnd() {
    return end;
  }

  public Player carry(Player player) {
    player.setPosition(end);
    return player;
  }

}
