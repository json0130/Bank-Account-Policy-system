package nz.ac.auckland.se281;

import java.util.ArrayList;

public class Person {
  // instance fields
  // public string userName : it can be used by other classes straight away since it is public
  private String name; // private can not be used by other classes
  private static String age; // static means that the variable is shared by all instances of the class
  private int discount = 0;

  // Create an instance of policy that stores all the policies of specific user and store this
  // instance inside the datalist arraylist
  private ArrayList<Policy> policyListOfUser;

  public Person(String userName, String age) { // constructor : no return type needed
    name = userName;
    Person.age = age;
    policyListOfUser = new ArrayList<Policy>();
  }

  public static String getAge() {
    return age; // Through public method the priavate 'age' can be used in other classes
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

  public void calculateDiscount(Integer Sum_Insured1) {
    // It calculates the Discount depends on the number of policy that the user has

    if (policyListOfUser.size() == 2) {
      // If the client has exactly 2 policies then the total base preimum is reduced by 10%
      discount = Sum_Insured1 - (Sum_Insured1 * 10 / 100);
    } else if (policyListOfUser.size() > 3) {
      // If the client has 3 or more policies then the total base preimum is reduced by 20%
      discount = Sum_Insured1 - (Sum_Insured1 * 20 / 100);
    } else {
      // If the client has less then 2 policies then the total base preimum is not reduced
    }
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
                + policies.basePremiumString
                + " -> $"
                + discount
                + ")");

      } else if (policies.getPolicyType() == "Car") {
        System.out.println(
            "\tCar Policy ("
                + policies.address
                + ", Sum Insured: $"
                + policies.Sum_Insured
                + ", Premium: $"
                + policies.basePremiumString
                + " -> $"
                + discount
                + ")");

      } else if (policies.getPolicyType() == "Life") {
        System.out.println(
            "\tLife Policy (Sum Insured: $"
                + policies.Sum_Insured
                + ", Premium: $"
                + policies.basePremiumString
                + " -> $"
                + discount
                + ")");
      }
    }
  }

  public String totalInsured() {
    // It calculate the total insured amount of the user
    int totalInsured = 0;
    for (Policy policies : policyListOfUser) {
      totalInsured += policies.Sum_Insured;
    }
    return Integer.toString(totalInsured);
  }

  public boolean hasLifePolicy() {
  // It checks if the user has a life policy in the policy arraylist
    for (Policy policies : policyListOfUser) {
      if (policies.getPolicyType() == "Life") {
        return true;
      }
    }
    return false;
  }
}


