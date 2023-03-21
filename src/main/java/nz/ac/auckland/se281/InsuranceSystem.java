package nz.ac.auckland.se281;

import java.util.ArrayList;
import nz.ac.auckland.se281.Main.PolicyType;

public class InsuranceSystem {
  public InsuranceSystem() {
    // Only this constructor can be used (if you need to initialise fields).

  }

  public void printDatabase() {

    if (dataList.size() < 1) {
      MessageCli.PRINT_DB_POLICY_COUNT.printMessage("0", "s", ".");
    } else if (dataList.size() == 1) {
      MessageCli.PRINT_DB_POLICY_COUNT.printMessage("1", "", ":");
      printProfile();
    } else {
      MessageCli.PRINT_DB_POLICY_COUNT.printMessage(Integer.toString(dataList.size()), "s", ":");
      printProfile();
    }
  }

  private ArrayList<Person> dataList = new ArrayList<>();

  public void createNewProfile(String name, String age) {
    // this method create a new profile
    String fixedName = name.substring(0, 1).toUpperCase() + name.substring(1).toLowerCase();
    Person user1 = new Person(fixedName, age);

    if (checkuser(fixedName) == true) {
      if (fixedName.length() < 3) {
        MessageCli.INVALID_USERNAME_TOO_SHORT.printMessage(fixedName);
      } else {
        if (checkage(fixedName, age) == true) {
          dataList.add(user1);
          MessageCli.PROFILE_CREATED.printMessage(fixedName, age);
        } else {
          dataList.remove(user1);
          MessageCli.INVALID_AGE.printMessage(age, fixedName);
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
    for (int i = 0; i < dataList.size(); i++) {
      // MessageCli.PRINT_DB_PROFILE_HEADER_MINIMAL.printMessage(Integer.toString(i+1),);//

      Person name = dataList.get(i);
      System.out.print(" " + Integer.toString(i + 1) + ": ");
      name.printDetails();
    }
  }

  public boolean checkuser(String fixedName) {
    for (Person Username : dataList) {
      if (fixedName.equals(Username.getName())) {
        return false;
      }
    }
    return true;
  }

  public boolean checkage(String fixedName, String age) {
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
}
