package nz.ac.auckland.se281;

public class Car extends Policy {
  private Integer sumInsured;
  private String mechanical;

  public Car(Integer sumInsured, String make, String lisence, String mechanical, String age) {
    super(sumInsured, make, lisence, mechanical, age);
    this.sumInsured = sumInsured;
    this.mechanical = mechanical;
    this.age = age;
    calculatePremium();
  }

  @Override
  public void calculatePremium() {
    // Calcualte the premium for the car
    // If the person age is less than 25 then the premium is 15% of the sum insured
    // If the person age is greater than 25 then the premium is 10% of the sum insured
    // If the car to be covered for mechanical breakdown then the premium will increase by further
    // $80 (regardless of age)
    int ageInt = Integer.parseInt(age);

    if (ageInt < 25) {
      if (checkMechanical() == true) {
        basePremium = ((0.15 * (sumInsured)) + 80);
      } else {
        basePremium = (0.15 * sumInsured);
      }
    } else {
      if (checkMechanical() == true) {
        basePremium = ((0.1 * sumInsured) + 80);
      } else {
        basePremium = (0.1 * sumInsured);
      }
    }
    setBasePremium(basePremium);
  }

  public boolean checkMechanical() {
    if (mechanical.equals("yes")) {
      return true;
    } else {
      return false;
    }
  }

  @Override
  public String getPolicyType() {
    return "Car";
  }
}
