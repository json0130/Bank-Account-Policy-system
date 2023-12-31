package nz.ac.auckland.se281;

public abstract class Policy {

  // instance fields
  protected Integer sumInsured;
  protected String address;
  protected String rental;
  protected String mechanical;
  protected double basePremium;
  protected String make;
  protected String lisence;
  public double discountedPremium;
  protected String age;
  protected Integer ageInt;

  public Policy(Integer sumInsured, String make, String lisence, String mechanical, String age) {
    this.sumInsured = sumInsured;
    this.make = make;
    this.lisence = lisence;
    this.mechanical = mechanical;
    this.age = age;
  }

  public Policy(Integer sumInsured, Integer ageInt) {
    this.sumInsured = sumInsured;
    this.ageInt = ageInt;
  }

  public Policy(Integer sumInsured, String address, String rental) {
    this.sumInsured = sumInsured;
    this.address = address;
    this.rental = rental;
  }

  public double getBasePremium() {
    return basePremium;
  }

  public void setBasePremium(double basePremium) {
    this.basePremium = basePremium;
  }

  public void setDiscountedPremium(double discountedPremium) {
    this.discountedPremium = discountedPremium;
  }

  public double getDiscountedPremium() {
    return discountedPremium;
  }

  public abstract String getPolicyType();

  public abstract void calculatePremium();
}
