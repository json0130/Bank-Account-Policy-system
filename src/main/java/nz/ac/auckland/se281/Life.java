package nz.ac.auckland.se281;

public class Life extends Policy {

  private Integer sumInsured;

  public Life(Integer sumInsured, int ageInt) {
    super(sumInsured, ageInt);
    this.sumInsured = sumInsured;
    this.ageInt = ageInt;
    calculatePremium();
  }

  @Override
  public void calculatePremium() {
    // Calcualte the premium for the Life and store inside the arraylist
    // The base premium for a life policy is calculated as 1 + age/100 of the sum insured
    // Get the age of the person from the Person class
    // Convert ageInt to double
    double ageInt = this.ageInt;
    setBasePremium(sumInsured * (1 + ageInt / 100) / 100);
  }

  @Override
  public String getPolicyType() {
    // return the policy type
    return "Life";
  }
}
