package components;

public class Shoot implements Carrier {

  private int start;
  private int end;

  public Shoot(int start, int end) {
    if (start < end) throw new RuntimeException("Start must be greater than end for shoots");
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
