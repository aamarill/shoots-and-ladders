package components;

import java.util.List;

public class Board {

  private Slot[] slots;

  public Board(int size, List<Carrier> carriers) {
    slots = new Slot[size];
    addCarriers(carriers);
    addRemainingSlots();
  }

  private void addCarriers(List<Carrier> carriers) {
    for (Carrier carrier : carriers) {
      validate(carrier);
      int position = carrier.getStart();
      slots[position] = new Slot(carrier);
    }
  }

  private void validate(Carrier carrier) {
    if (carrier.getStart() < 0) {
      throw new RuntimeException("Carrier start is less than zero");
    } else if (carrier.getEnd() > slots.length) {
      throw new RuntimeException("Carrier end " + carrier.getEnd() + " greater than board size");
    }
  }

  private void addRemainingSlots() {
    for (int i = 0; i < slots.length; i++) {
      if (slots[i] == null) {
        slots[i] = new Slot(null);
      }
    }
  }

  public void print() {
    int i = 1;
    for (Slot slot : slots) {
      System.out.println(i + ": " + slot + " with carrier: " + slot.getCarrier());
      i++;
    }
  }

  public Slot getSlot(int position) {
    return slots[position];
  }

  public int getSize() {
    return slots.length;
  }
}
