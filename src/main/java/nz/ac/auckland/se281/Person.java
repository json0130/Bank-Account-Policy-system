package nz.ac.auckland.se281;

public class Person {
  // instance fields
  // public string userName : it can be used by other classes straight away since it is public
  private String name; // private can not be used by other classes
  private static String age;
  private static int count = 0;

  public Person(String userName, String age) { // constructor : no return type needed
    name = userName;
    Person.age = age;
  }

  public static String getAge() {
    return age; // Through public method the priavate 'age' can be used in other classes
  }

  public String getName() {
    return name;
  }

  public void printDetails() {
    System.out.println(name + ", " + age + ", ");
    // Convert count to string
    String countString = Integer.toString(count);

    MessageCli.PRINT_DB_PROFILE_HEADER_LONG.printMessage(name, age, countString);
    MessageCli.PRINT_DB_POLICY_COUNT.printMessage("1", "", ":");
  }

  public void addPolicy(Policy policy) {
    // add policy to the loaded profile

  }
}
