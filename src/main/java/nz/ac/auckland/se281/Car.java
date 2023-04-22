package nz.ac.auckland.se281;

public class Car extends Policy {
  private Integer sum_Insured;
  private String mechanical;

  public Car(Integer sum_Insured, String make, String lisence, String mechanical, String age) {
    super(sum_Insured, make, lisence, mechanical, age);
    this.sum_Insured = sum_Insured;
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
        basePremium = ((0.15 * (sum_Insured)) + 80);
      } else {
        basePremium = (0.15 * sum_Insured);
      }
    } else {
      if (checkMechanical() == true) {
        basePremium = ((0.1 * sum_Insured) + 80);
      } else {
        basePremium = (0.1 * sum_Insured);
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
