package app.DynamicWebpage;

public class Student {
  public final String name;
  public final int age;
  public final String group;


  public Student(String name, int age, String group) {
    this.name = name;
    this.age = age;
    this.group = group;
  }

  public String getName() {
    return name;
  }

  public int getAge() {
    return age;
  }

  public String getGroup() {
    return group;
  }

  public String upperName() {
    return name.toUpperCase();
  }

}
