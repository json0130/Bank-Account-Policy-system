package nz.ac.auckland.se281;


public abstract class Policy {

  // instance fields
  protected Integer Sum_Insured;
  protected String address;
  protected String rental;
  protected String mechanical;
  protected double basePremium;
  protected String make;
  protected String lisence;
  public double discountedPremium;
  protected String age;
  protected Integer ageInt;

  public Policy(Integer Sum_Insured, String make, String lisence, String mechanical, String age) {
    this.Sum_Insured = Sum_Insured;
    this.make = make;
    this.lisence = lisence;
    this.mechanical = mechanical;
    this.age = age;
  }

  public Policy(Integer Sum_Insured, Integer ageInt) {
    this.Sum_Insured = Sum_Insured;
    this.ageInt = ageInt;
  }

  public Policy(Integer Sum_Insured, String address, String rental) {
    this.Sum_Insured = Sum_Insured;
    this.address = address;
    this.rental = rental;
  }

  public double getBasePremium() {
    return basePremium;
  }

  public void setBasePremium(double basePremium) {
    this.basePremium = basePremium;
  }

  public void setDiscountedPremium(double d) {
    this.discountedPremium = d;
  }

  public double getDiscountedPremium() {
    return discountedPremium;
  }

  public abstract String getPolicyType();

  public abstract void calculatePremium();
}
