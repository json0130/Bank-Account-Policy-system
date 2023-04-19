package nz.ac.auckland.se281;

public abstract class Policy {

  // instance fields
  protected Integer Sum_Insured;
  protected String address;
  protected String rental;
  public int basePremium;

  public Policy(Integer Sum_Insured, String address, String rental, String mechanical) {
    this.Sum_Insured = Sum_Insured;
    this.address = address;
    this.rental = rental;
  }

  public Policy(Integer Sum_Insured) {}

  public Policy(Integer Sum_Insured, String address, String rental) {}

  public Integer getSum_Insured() {
    return Sum_Insured;
  }

  public String getAddress() {
    return address;
  }

  public String getRental() {
    return rental;
  }

  public abstract void calculatePremium();
}
