package nz.ac.auckland.se281;

public class Car extends Policy {
  private Integer Sum_Insured;
  private String mechanical;

  public Car(Integer Sum_Insured, String make, String lisence, String mechanical, String age) {
    super(Sum_Insured, make, lisence, mechanical, age);
    this.Sum_Insured = Sum_Insured;
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
    // If the car is not to be covered for mechanical breakdown then the premium will not increase
    // (regardless of age)
    int ageInt = Integer.parseInt(age);

    if (ageInt < 25) {
      if (checkMechanical() == true) {
        basePremium = (int) (0.15 * (Sum_Insured) + 80);
      } else {
        basePremium = (int) (0.15 * Sum_Insured);
      }
    } else {
      if (checkMechanical() == true) {
        basePremium = (int) (0.1 * Sum_Insured + 80);
      } else {
        basePremium = (int) (0.1 * Sum_Insured);
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
