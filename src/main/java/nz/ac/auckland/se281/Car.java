package nz.ac.auckland.se281;

public class Car extends Policy {

    private String mechanical;
    private Integer Sum_Insured;

    public Car(Integer Sum_Insured, String make, String lisence, String mechanical){
        super(Sum_Insured, make, lisence, mechanical);

    }

    @Override
    public void calculatePremium() {
        // Calcualte the premium for the car
        // If the person age is less than 25 then the premium is 15% of the sum insured
        // If the person age is greater than 25 then the premium is 10% of the sum insured
        // If the car to be covered for mechanical breakdown then the premium will increase by further $80 (regardless of age)
        // If the car is not to be covered for mechanical breakdown then the premium will not increase (regardless of age)

        // Get the age of the person from the Person class
        // Convert the age to integer
        String age = Person.getAge();
        int ageInt = Integer.parseInt(age);

        if(ageInt < 25){
            if(checkMechanical(mechanical) ==  true){
                Sum_Insured = (int) (0.15 * (Sum_Insured) + 80);
            }else{
                Sum_Insured = (int) (0.15 * Sum_Insured);
            }
        }else{
            if(checkMechanical(mechanical) ==  true){
                Sum_Insured = (int) (0.1 * Sum_Insured + 80);
            }else{
                Sum_Insured = (int) (0.1 * Sum_Insured);
            }
        }
    }

    public boolean checkMechanical(String mechanical){
        if(mechanical.equals("yes")){
            return true;
        }else{
            return false;
        }
    }
}
