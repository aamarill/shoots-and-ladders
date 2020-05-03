package components;

import java.util.Random;

public class Die {

  private int min;
  private int max;
  private Random random;

  public Die(int min, int max) {
    this.min = min;
    this.max = max;
    random = new Random();
  }

  public int roll() {
    return random.nextInt(max) + min;
  }
}
