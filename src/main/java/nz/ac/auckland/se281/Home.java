package nz.ac.auckland.se281;

public class Home extends Policy {

  private Integer sumInsured;
  private String rental;

  public Home(Integer sumInsured, String address, String rental) {
    super(sumInsured, address, rental);
    this.sumInsured = sumInsured;
    this.rental = rental;
    calculatePremium();
  }

  @Override
  public void calculatePremium() {
    // Calcualte the premium for the home
    // If the home is rented then the premium is 2% of the sum insured
    // If the home is not rented then the premium is 1% of the sum insured
    if (isHomeRented() == true) {
      setBasePremium(0.02 * sumInsured);
    } else {
      setBasePremium(0.01 * sumInsured);
    }
  }

  public boolean isHomeRented() {
    // Method to check if the home is rented
    // If the home is rented then return true otherwise return false
    if ((rental.toLowerCase()).contains("y")) {
      return true; // Base Premium = 2% of the Sum Insured
    } else {
      return false; // Base Premium = 1% of the Sum Insured
    }
  }

  @Override
  public String getPolicyType() {
    return "Home";
  }
}
