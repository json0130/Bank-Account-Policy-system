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

  public void loadProfile(String name) {
    // Check if the profile is found or not and print out the message

    String fixedName = name.substring(0, 1).toUpperCase() + name.substring(1).toLowerCase();
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

  public void createPolicy(PolicyType type, String[] options) {
    // TODO: Complete this method.
  }

  public void printProfile() {
    // It prints all of the elements in the arraylist
    // It also check if the user is equal to loadedUser or not and print out the message
    for (int i = 0; i < dataList.size(); i++) {
      Person name = dataList.get(i);
      if (name.getName().equals(loadedUser)) {
        System.out.print(" *** " + Integer.toString(i + 1) + ": ");
        name.printDetails();
      } else {
        System.out.print(" " + Integer.toString(i + 1) + ": ");
        name.printDetails();
      }
    }
  }

  public String fixProfileName(String name) {
    // It fixes the name to be capitalised
    String fixedName = name.substring(0, 1).toUpperCase() + name.substring(1).toLowerCase();
    return fixedName;
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
}
