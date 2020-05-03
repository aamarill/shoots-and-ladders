package components;

public interface Carrier {

  public int getStart();

  public int getEnd();

  public Player carry(Player player);
}
