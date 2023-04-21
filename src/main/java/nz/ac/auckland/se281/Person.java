package nz.ac.auckland.se281;

import java.util.ArrayList;

public class Person {
  // instance fields
  // public string userName : it can be used by other classes straight away since it is public
  private String name; // private can not be used by other classes
  private String age; // static means that the variable is shared by all instances of the class
  private String discountedPremiumString;

  // Create an instance of policy that stores all the policies of specific user and store this
  // instance inside the datalist arraylist
  ArrayList<Policy> policyListOfUser;

  public Person(String userName, String age) { // constructor : no return type needed
    name = userName;
    this.age = age;
    policyListOfUser = new ArrayList<Policy>();
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

  public String calculateDiscount() {
    // It calculates the Discount depends on the number of policy that the user has
    // If the user has 2 policies then the discount is 10%
    // If the user has more then 3 policies then the discount is 20%
    // Do not change the arraylist to statics
    int basePremium = Integer.parseInt(policyListOfUser.get(0).calculatePremium());

    if (policyListOfUser.size() == 2) {
      // Calculate the discount
      int discount = (int) (basePremium * 0.1);
      // Calculate the premium after discount
      int premiumAfterDiscount = basePremium - discount;
      // Convert int to String
      discountedPremiumString = Integer.toString(premiumAfterDiscount);
      return discountedPremiumString;

    } else if (policyListOfUser.size() > 3) {
      // Calculate the discount
      int discount = (int) (basePremium * 0.2);
      // Calculate the premium after discount
      int premiumAfterDiscount = -discount;
      // Convert int to String
      discountedPremiumString = Integer.toString(premiumAfterDiscount);
      // Add discounted premium to the policyListOfUser
      return discountedPremiumString;
    }
    // Convert int to String
    String basePremiumString = Integer.toString(basePremium);

    return basePremiumString;
  }

  public int totalInsured() {
    // It calculates the total sum insured of the user
    int totalSumInsured = 0;
    // for (Policy policies : policyListOfUser) {
    //   // Convert String to int
    //   int discountedPremium = Integer.parseInt(policies.calculateDiscount());
    //   totalSumInsured += discountedPremium;
    // }
    return totalSumInsured;
  }

  public void printNumberOfPolicies() {
    // It prints the number of policies that the user has
    // Print policy if the user has only one policy and print policies if the user has more then one

    System.out.println(
        (policyListOfUser.size() == 1)
            ? Integer.toString(policyListOfUser.size())
                + " policy for a total of $"
                + totalInsured()
            : Integer.toString(policyListOfUser.size())
                + " policies for a total of $"
                + totalInsured());
  }

  public void printPolicies() {
    // Print the policies of the user
    for (Policy policies : policyListOfUser) {
      // check the type of the policy and print the policy
      if (policies.getPolicyType() == "Home") {
        System.out.println(
            "\tHome Policy ("
                + policies.address
                + ", Sum Insured: $"
                + policies.Sum_Insured
                + ", Premium: $"
                + policies.calculatePremium()
                + " -> $"
                + calculateDiscount()
                + ")");

      } else if (policies.getPolicyType() == "Car") {
        System.out.println(
            "\tCar Policy ("
                + policies.make
                + ", Sum Insured: $"
                + policies.Sum_Insured
                + ", Premium: $"
                // print the basepremium of the car policy
                + policies.calculatePremium()
                + " -> $"
                + calculateDiscount()
                + ")");

      } else if (policies.getPolicyType() == "Life") {
        System.out.println(
            "\tLife Policy (Sum Insured: $"
                + policies.Sum_Insured
                + ", Premium: $"
                + policies.calculatePremium()
                + " -> $"
                + calculateDiscount()
                + ")");
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
