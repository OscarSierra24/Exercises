import java.util.Objects;

class GNode {
  int value;

  public GNode(int value) {
    this.value = value;
  } 

  public boolean equals(Object obj) {
    if (obj == null) {
      return false;
    }
    if (this.getClass() != obj.getClass()) {
      return false;
    }
    GNode node = (GNode) obj;
    if (this.value == node.value) {
      return true;
    }
    return false;
  }

  public String toString() {
    return this.value + "";
  }

  @Override
  public int hashCode() {
    return Objects.hash(this.value);
  }
}   