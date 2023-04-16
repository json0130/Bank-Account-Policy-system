package nz.ac.auckland.se281;

import javax.print.attribute.standard.PrinterName;

public class Person {
  // instance fields
  // public string userName : it can be used by other classes straight away since it is public
  private String name; // private can not be used by other classes
  private String age;

  public Person(String userName, String age) { // constructor : no return type needed
    name = userName;
    this.age = age;
  }

  public String getAge() {
    return age; // Through public method the priavate 'age' can be used in other classes
  }

  public String getName() {
    return name;
  }

  public void printDetails() {
    System.out.println(name + ", " + age);
  }

}
