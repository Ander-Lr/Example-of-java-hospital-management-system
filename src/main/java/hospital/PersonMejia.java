package hospital;

public abstract class PersonMejia {

  protected String nameMejia, lastnameMejia, dniMejia;
  protected int ageMejia;

  public PersonMejia(String nameMejia, String lastnameMejia, String dniMejia, int ageMejia) {
    this.nameMejia = nameMejia;
    this.lastnameMejia = lastnameMejia;
    this.dniMejia = dniMejia;
    this.ageMejia = ageMejia;
  }

  public abstract void getDataPersonMejia();
}
