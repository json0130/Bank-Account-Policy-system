package nz.ac.auckland.se281;

public class Life extends Policy {

  private Integer Sum_Insured;

  public Life(Integer Sum_Insured, int ageInt) {
    super(Sum_Insured, ageInt);
    this.Sum_Insured = Sum_Insured;
    this.ageInt = ageInt;
    calculatePremium();
  }

  @Override
  public void calculatePremium() {
    // Calcualte the premium for the Life and store inside the arraylist
    // The base premium for a life policy is calculated as 1 + age/100 of the sum insured
    // The maximum age is 100 years old
    // If the age is greater than 100 then the premium is 1 + 100/100 of the sum insured

    // Get the age of the person from the Person class
    // Convert ageInt to double
    double ageInt = this.ageInt;
    setBasePremium(Sum_Insured * (1 + ageInt / 100) / 100);
  }

  @Override
  public String getPolicyType() {
    return "Life";
  }
}
