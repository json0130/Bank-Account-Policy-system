package nz.ac.auckland.se281;

import java.util.ArrayList;
import nz.ac.auckland.se281.Main.PolicyType;

public class InsuranceSystem {
  public InsuranceSystem() {
    // Only this constructor can be used (if you need to initialise fields).

  }

  public void printDatabase() {

    if (Data_list.size() < 1) {
      MessageCli.PRINT_DB_POLICY_COUNT.printMessage("0", "s", ".");
    } else if (Data_list.size() == 1) {
      MessageCli.PRINT_DB_POLICY_COUNT.printMessage("1", "", ":");
      printProfile();
    } else {
      MessageCli.PRINT_DB_POLICY_COUNT.printMessage(Integer.toString(Data_list.size()), "s", ":");
      printProfile();
    }
  }

  private ArrayList<Person> Data_list = new ArrayList<>();

  public void createNewProfile(String Name, String Age) {

    String fixedName = Name.substring(0, 1).toUpperCase() + Name.substring(1).toLowerCase();
    Person user1 = new Person(fixedName, Age);

    if (checkuser(fixedName) == true) {
      if (fixedName.length() < 3) {
        MessageCli.INVALID_USERNAME_TOO_SHORT.printMessage(fixedName);
      } else {
        if (checkage(fixedName, Age) == true) {
          Data_list.add(user1);
          MessageCli.PROFILE_CREATED.printMessage(fixedName, Age);
        } else {
          Data_list.remove(user1);
          MessageCli.INVALID_AGE.printMessage(Age, fixedName);
        }
      }
    } else {
      MessageCli.INVALID_USERNAME_NOT_UNIQUE.printMessage(fixedName);
    }
  }

  public void loadProfile(String userName) {
    // TODO: Complete this method.
  }

  public void unloadProfile() {
    // TODO: Complete this method.
  }

  public void deleteProfile(String userName) {
    // TODO: Complete this method.
  }

  public void createPolicy(PolicyType type, String[] options) {
    // TODO: Complete this method.
  }

  public void printProfile() {
    for (int i = 0; i < Data_list.size(); i++) {
      // MessageCli.PRINT_DB_PROFILE_HEADER_MINIMAL.printMessage(Integer.toString(i+1),);//

      Person Name = Data_list.get(i);
      System.out.print(" " + Integer.toString(i + 1) + ": ");
      Name.printDetails();
    }
  }

  public boolean checkuser(String fixedName) {
    for (Person Username : Data_list) {
      if (fixedName.equals(Username.getName())) {
        return false;
      }
    }
    return true;
  }

  public boolean checkage(String fixedName, String Age) {
    try {
      if (Integer.parseInt(Age) > 0) {
        return true;
      } else {
        return false;
      }
    } catch (Exception e) {
      return false;
    }
  }
}
