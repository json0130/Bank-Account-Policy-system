package nz.ac.auckland.se281;

import java.util.ArrayList;

import nz.ac.auckland.se281.Main.PolicyType;

public class InsuranceSystem {
  public InsuranceSystem() {
    // Only this constructor can be used (if you need to initialise fields).
    
  }
  public void printDatabase() {
    // TODO: Complete this method.
    int number = data_Userlist.size();

    if(data_Userlist.size() < 1){
      MessageCli.PRINT_DB_POLICY_COUNT.printMessage(number, "", ".");
    }
    else if(data_Userlist.size() == 1){
      MessageCli.PRINT_DB_POLICY_COUNT.printMessage(number, "", ":");
      
      for(String list : data_Userlist) {   

        MessageCli.PRINT_DB_PROFILE_HEADER_MINIMAL.printMessage(number,list,list);
        //<SPACE><RANK><COLON><SPACE><USERNAME><COMMA><SPACE><AGE>
      }
    }
    else{
      MessageCli.PRINT_DB_POLICY_COUNT.printMessage(number, "s", ":");

      for(String list : data_Userlist) {   
      
        MessageCli.PRINT_DB_PROFILE_HEADER_MINIMAL.printMessage(number,list,list);
        //<SPACE><RANK><COLON><SPACE><USERNAME><COMMA><SPACE><AGE>
      }
    }
  }

  static ArrayList<> data_Userlist = new ArrayList();
  static ArrayList<> data_Agelist = new ArrayList();

  public void createNewProfile(String userName, String age) {
    // TODO: Complete this method.
    data_Userlist.add(userName);
    data_Agelist.add(age);
    MessageCli.PROFILE_CREATED.printMessage(userName,age);

    if(data_Userlist.contains(userName)){
      MessageCli.INVALID_USERNAME_NOT_UNIQUE.printMessage(userName);
      data_Userlist.remove(userName);
    }
    else{
      MessageCli.PROFILE_CREATED.printMessage(userName,age);
      System.out.println(data_Userlist);
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
}
