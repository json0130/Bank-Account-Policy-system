package nz.ac.auckland.se281;

public class Home extends Policy {

    public Home(Integer Sum_Insured, String address, Boolean rental1) {
        super(Sum_Insured, address, rental1);
    }

    @Override
    public void calculatePremium() {
        // Calcualte the premium for the home
        // If the home is rented then the premium is 2% of the sum insured
        // If the home is not rented then the premium is 1% of the sum insured
        if (IsHomeRented() == true) {
            basePremium = (int) (0.02 * Sum_Insured);
        } else {
            basePremium = (int) (0.01 * Sum_Insured);
        }
    }

    public boolean IsHomeRented() {
        // Method to check if the home is rented
        // If the home is rented then return true otherwise return false
        if (rental.equals("yes")) {
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
