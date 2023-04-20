package nz.ac.auckland.se281;

public class Life extends Policy {

    public Life(Integer Sum_Insured) {
        super(Sum_Insured);
    }

    @Override
    public void calculatePremium() {
        // Calcualte the premium for the Life
        // The base premium for a life policy is calculated as 1 + age/100 of the sum insured
        // The maximum age is 100 years old

        // Get the age of the person from the Person class
        // Convert the age to integer
        String age = Person.getAge();
        int ageInt = Integer.parseInt(age);
        if (ageInt < 100) {
            basePremium = (int) (1 + (ageInt / 100) * Sum_Insured);
        } else {
            basePremium = (int) (1 + (100 / 100) * Sum_Insured);
        }
    }

    @Override
    public String getPolicyType() {
        return "Life";
    }
}
