package nz.ac.auckland.se281;

public class Life extends Policy {

  private Integer sum_Insured;

  public Life(Integer sum_Insured, int ageInt) {
    super(sum_Insured, ageInt);
    this.sum_Insured = sum_Insured;
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
    setBasePremium(sum_Insured * (1 + ageInt / 100) / 100);
  }

  @Override
  public String getPolicyType() {
    return "Life";
  }
}
