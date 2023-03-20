package nz.ac.auckland.se281;

import java.util.ArrayList;

import org.eclipse.jgit.lib.UserConfig;
import org.eclipse.jgit.transport.CredentialItem.Username;

import nz.ac.auckland.se281.Main.PolicyType;

public class InsuranceSystem {
  public InsuranceSystem() {
    // Only this constructor can be used (if you need to initialise fields).
    
  }
  public void printDatabase() {
    // TODO: Complete this method.

    if(data_list.size() < 1){
      MessageCli.PRINT_DB_POLICY_COUNT.printMessage("0", "", ".");
    }
    else if(data_list.size() == 1){
      MessageCli.PRINT_DB_POLICY_COUNT.printMessage("1", "", ":");
      printProfile();
    }
    else{
      MessageCli.PRINT_DB_POLICY_COUNT.printMessage(Integer.toString(data_list.size()), "s", ":");
      printProfile();
    }
  }

  private ArrayList<Person> data_list = new ArrayList<>();

  public void createNewProfile(String userName,String age) {
    // TODO: Complete this method.

    MessageCli.PROFILE_CREATED.printMessage(Person.getName,Person.getAge);

    if(data_list.contains(data_list.getName)){
      MessageCli.INVALID_USERNAME_NOT_UNIQUE.printMessage();
    }
    else{
      MessageCli.PROFILE_CREATED.printMessage(userName,age);
      data_list.add();
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

  public void printProfile(){
    
    for(int i = 0;i < data_list.size();i++) {   

      //MessageCli.PRINT_DB_PROFILE_HEADER_MINIMAL.printMessage(Integer.toString(i),UserProfile.userName,UserProfile.age);//
      
      Person userName = data_list.get(i);
      System.out.println(" " + Integer.toString(i + 1) + ": ");
      userName.printDetails();
    }
  }

}
