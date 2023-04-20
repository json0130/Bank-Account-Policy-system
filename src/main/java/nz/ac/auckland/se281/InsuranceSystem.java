package nz.ac.auckland.se281;

import java.util.ArrayList;
import nz.ac.auckland.se281.Main.PolicyType;

public class InsuranceSystem {
  public InsuranceSystem() {
    // Only this constructor can be used (if you need to initialise fields).

  }

  public void printDatabase() {
    // It prints out the database
    if (dataList.size() < 1) { // No profiles
      MessageCli.PRINT_DB_POLICY_COUNT.printMessage("0", "s", ".");
    } else if (dataList.size() == 1) { // 1 profile
      MessageCli.PRINT_DB_POLICY_COUNT.printMessage("1", "", ":");
      printProfile();
    } else { // Multiple profiles
      MessageCli.PRINT_DB_POLICY_COUNT.printMessage(Integer.toString(dataList.size()), "s", ":");
      printProfile();
    }
  }

  private ArrayList<Person> dataList = new ArrayList<>();
  // ArrayList that stores class person

  public String loadedUser = null;
  public int basePremium = 0;
  public int count = 0;

  public void createNewProfile(String name, String age) {
    // this method create a new profile and check errors
    String fixedName = name.substring(0, 1).toUpperCase() + name.substring(1).toLowerCase();
    Person user1 = new Person(fixedName, age);

    if (checkuser(fixedName) == true) {
      if (fixedName.length()
          < 3) { // Check the length of username (Needs to be greater then 2 character)
        MessageCli.INVALID_USERNAME_TOO_SHORT.printMessage(fixedName);
      } else {
        if (checkage(fixedName, age) == true) {
          dataList.add(user1); // Add Username and age to the arraylist
          MessageCli.PROFILE_CREATED.printMessage(fixedName, age);
        } else {
          MessageCli.INVALID_AGE.printMessage(age, fixedName);
        }
      }
    } else {
      MessageCli.INVALID_USERNAME_NOT_UNIQUE.printMessage(fixedName);
    }
  }

  public void loadProfile(String userName) {
    // Check if the profile is found or not and print out the message

    String fixedName = userName.substring(0, 1).toUpperCase() + userName.substring(1).toLowerCase();
    if (fixedName == loadedUser) {
      MessageCli.CANNOT_CREATE_WHILE_LOADED.printMessage(fixedName);
    } else {
      if (checkuser(fixedName) == false) {
        MessageCli.PROFILE_LOADED.printMessage(fixedName);
        loadedUser = fixedName;
      } else {
        MessageCli.NO_PROFILE_FOUND_TO_LOAD.printMessage(fixedName);
      }
    }
  }

  public void unloadProfile() {
    // unload the user that is loaded and print out the message
    if (loadedUser == null) {
      MessageCli.NO_PROFILE_LOADED.printMessage();
    } else {
      MessageCli.PROFILE_UNLOADED.printMessage(loadedUser);
      loadedUser = null;
    }
  }

  public void deleteProfile(String userName) {
    // It delete selected profile from the arraylist.
    // If the profile is loaded then it will print out the message

    String fixedName = userName.substring(0, 1).toUpperCase() + userName.substring(1).toLowerCase();

    if (checkuser(fixedName) == false) {
      // It check if the user is equal to loadedUser or not and print out the message
      // If the user is not eqaul to the loadedUSer then delete the user from the arraylist
      if (fixedName.equals(loadedUser)) {
        MessageCli.CANNOT_DELETE_PROFILE_WHILE_LOADED.printMessage(fixedName);
      } else {
        for (int i = 0; i < dataList.size(); i++) {
          Person name = dataList.get(i);
          if (fixedName.equals(name.getName())) {
            dataList.remove(i);
            MessageCli.PROFILE_DELETED.printMessage(fixedName);
          }
        }
      }
    } else {
      MessageCli.NO_PROFILE_FOUND_TO_DELETE.printMessage(fixedName);
    }
  }

  public boolean checkuser(String fixedName) {
    // It check the user's name whether its already in the arraylist or not
    for (Person user : dataList) {
      if (fixedName.equals(user.getName())) {
        return false;
      }
    }
    return true;
  }

  public boolean checkage(String fixedName, String age) {
    // Check age to be positive interger.
    try {
      if (Integer.parseInt(age) > 0) {
        return true;
      } else {
        return false;
      }
    } catch (Exception e) {
      return false;
    }
  }

  public ArrayList<Policy> policyListOfUser = new ArrayList<>();

  public void createPolicy(PolicyType type, String[] options) {
    // It create a new policy and check errors
    if (loadedUser == null) {
      MessageCli.NO_PROFILE_LOADED.printMessage();
    } else {
      if (type == PolicyType.HOME) {
        String Sum_Insured = options[0];
        String address = options[1];
        String rental = options[2];
        // Convert Sum_Insured to Integer
        Integer Sum_Insured1 = Integer.parseInt(Sum_Insured);
        // Convert rental to Boolean
        Boolean rental1 = Boolean.parseBoolean(rental);

        Policy home = new Home(Sum_Insured1, address, rental1);

        for (Person user : dataList) {
          if (user.getName().equals(loadedUser)) {
            user.addPolicy(home);
            policyListOfUser.add(home);
            MessageCli.NEW_POLICY_CREATED.printMessage(loadedUser, "Home");
          }
        }

      } else if (type == PolicyType.CAR) {
        String Sum_Insured = options[0];
        String address = options[1];
        String rental = options[2];
        String contents = options[3];

        // Convert Sum_Insured to Integer
        Integer Sum_Insured1 = Integer.parseInt(Sum_Insured);

        Policy Car = new Car(Sum_Insured1, address, rental, contents);

        for (Person user : dataList) {
          if (user.getName().equals(loadedUser)) {
            user.addPolicy(Car);
            policyListOfUser.add(Car);
            MessageCli.NEW_POLICY_CREATED.printMessage(loadedUser, "Car");
          }
        }

      } else if (type == PolicyType.LIFE) {
        String Sum_Insured = options[0];

        // Convert Sum_Insured to Integer
        Integer Sum_Insured1 = Integer.parseInt(Sum_Insured);

        Policy Life = new Life(Sum_Insured1);

        for (Person user : dataList) {
          if (user.getName().equals(loadedUser)) {
            user.addPolicy(Life);
            policyListOfUser.add(Life);
            MessageCli.NEW_POLICY_CREATED.printMessage(loadedUser, "LIFE");
          }
        }
      }
    }
  }

  public void calculateDiscount(Integer Sum_Insured1) {
    // It calculates the Discount depends on the number of policy that the user has

    if (countPolicy() == 2) {
      // If the client has exactly 2 policies then the total base preimum is reduced by 10%
      Sum_Insured1 = Sum_Insured1 - (Sum_Insured1 * 10 / 100);
    } else if (countPolicy() > 3) {
      // If the client has 3 or more policies then the total base preimum is reduced by 20%
      Sum_Insured1 = Sum_Insured1 - (Sum_Insured1 * 20 / 100);
    } else {
      // If the client has less then 2 policies then the total base preimum is not reduced
    }
  }

  public int countPolicy() {
    // It counts how many policy does the user has
    for (Policy policy : policyListOfUser) {
      if (policy == null) {

      } else {
        count++;
      }
    }
    return count;
  }

  public void printNumberOfPolicies() {
    // It prints the number of policies that the user has
    // Print policy if the user has only one policy and print policies if the user has more then one
    // policy
    if (countPolicy() == 1) {
      System.out.print(Integer.toString(countPolicy()) + "policy");
    } else {
      System.out.print(Integer.toString(countPolicy()) + "policies");
    }
  }

  private int calculatetotalPremium(Policy policy) {

    return basePremium;
  }

  public void printProfile() {
    // It prints all of the elements in the arraylist
    // It also check if the user is equal to loadedUser or not and print out the message
    for (int i = 0; i < dataList.size(); i++) {
      Person name = dataList.get(i);
      if (name.getName().equals(loadedUser)) {
        System.out.print(" *** " + Integer.toString(i + 1) + ": ");
        name.printDetails();
        printNumberOfPolicies();
      } else {
        System.out.print(" " + Integer.toString(i + 1) + ": ");
        name.printDetails();
        printNumberOfPolicies();
      }
    }
  }
}
