package nz.ac.auckland.se281;

import java.util.ArrayList;

public class Person {
  // instance fields
  private String name; // private can not be used by other classes
  public String age;

  // Create an instance of policy that stores all the policies of specific user and store this
  // instance inside the datalist arraylist
  ArrayList<Policy> policyListOfUser = new ArrayList<Policy>();

  public Person(String userName, String age) { // constructor : no return type needed
    name = userName;
    this.age = age;
    // policyListOfUser = new ArrayList<Policy>();
  }

  public String getAge() {
    return age;
  }

  public String getName() {
    return name;
  }

  public void printDetails() {
    System.out.print(name + ", " + age + ", ");
  }

  public void addPolicy(Policy policy) {
    // add policy to the loaded profile
    policyListOfUser.add(policy);
  }

  public int totalInsured() {
    calculateDiscount();
    // It calculates the total sum insured of the user
    int totalSumInsured = 0;
    for (Policy policies : policyListOfUser) {
      totalSumInsured += policies.getDiscountedPremium();
    }
    return totalSumInsured;
  }

  public void printNumberOfPolicies() {
    // It prints the number of policies that the user has
    // Print policy if the user has only one policy and print policies if the user has more then one

    System.out.println(
        (policyListOfUser.size() == 1)
            ? Integer.toString(policyListOfUser.size())
                + " policy for a total of $"
                + Integer.toString(totalInsured())
            : Integer.toString(policyListOfUser.size())
                + " policies for a total of $"
                + Integer.toString(totalInsured()));
  }

  public void printPolicies() {
    // Print the policies of the user
    for (Policy policies : policyListOfUser) {
      // check the type of the policy and print the policy
      if (policies.getPolicyType() == "Home") {
        int basePremium = (int) (policies.getBasePremium());
        System.out.println(
            "\tHome Policy ("
                + policies.address
                + ", Sum Insured: $"
                + policies.sum_Insured
                + ", Premium: $"
                + // covert the basepremium to string
                Integer.toString(basePremium)
                + " -> $"
                + // Convert the discounted premium to integer
                Integer.toString((int) policies.getDiscountedPremium())
                + ")");

      } else if (policies.getPolicyType() == "Car") {
        int basePremium = (int) (policies.getBasePremium());
        System.out.println(
            "\tCar Policy ("
                + policies.make
                + ", Sum Insured: $"
                + policies.sum_Insured
                + ", Premium: $"
                // print the basepremium of the car policy
                + Integer.toString(basePremium)
                + " -> $"
                + Integer.toString((int) policies.getDiscountedPremium())
                + ")");

      } else if (policies.getPolicyType() == "Life") {
        int basePremium = (int) (policies.getBasePremium());
        System.out.println(
            "\tLife Policy (Sum Insured: $"
                + policies.sum_Insured
                + ", Premium: $"
                + Integer.toString(basePremium)
                + " -> $"
                + Integer.toString((int) policies.getDiscountedPremium())
                + ")");
      }
    }
  }

  public void calculateDiscount() {
    // It calculates the Discount depends on the number of policy that the user has
    // If the user has 2 policies then the discount is 10%
    // If the user has more then 3 policies then the discount is 20%
    if (policyListOfUser.size() == 2) {
      for (Policy policies : policyListOfUser) {
        policies.setDiscountedPremium(policies.getBasePremium() * (1 - 0.1));
      }
    } else if (policyListOfUser.size() > 2) {
      for (Policy policies : policyListOfUser) {
        policies.setDiscountedPremium(policies.getBasePremium() * 0.8);
      }
    } else {
      for (Policy policies : policyListOfUser) {
        policies.setDiscountedPremium(policies.getBasePremium());
      }
    }
  }

  public boolean alreadyHaveLifePolicy() {
    // It checks if the user has a life policy in the policy arraylist
    for (Policy policies : policyListOfUser) {
      if (policies.getPolicyType() == "Life") {
        return true;
      }
    }
    return false;
  }
}
