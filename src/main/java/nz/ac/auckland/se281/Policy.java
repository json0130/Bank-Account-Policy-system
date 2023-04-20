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

  public Policy(Integer Sum_Insured) {
    this.Sum_Insured = Sum_Insured;
  }

  public Policy(Integer Sum_Insured, String address, Boolean rental2) {
    this.Sum_Insured = Sum_Insured;
    this.address = address;
  }

  public abstract String getPolicyType();

  public abstract void calculatePremium();

}
