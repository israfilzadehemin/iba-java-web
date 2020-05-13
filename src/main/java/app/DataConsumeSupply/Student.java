package app.DataConsumeSupply;

import java.util.List;

public class Student {
  private String name;
  private int age;
  private String group;
  private List<String> responsibilities;

  public Student() {
  }

  public Student(String name, int age, String group) {
    this.name = name;
    this.age = age;
    this.group = group;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public int getAge() {
    return age;
  }

  public void setAge(int age) {
    this.age = age;
  }

  public String getGroup() {
    return group;
  }

  public void setGroup(String group) {
    this.group = group;
  }

  public List<String> getResponsibilities() {
    return responsibilities;
  }

  public void setResponsibilities(List<String> responsibilities) {
    this.responsibilities = responsibilities;
  }

  @Override
  public String toString() {
    return String.format("Student{name='%s', age=%d, group='%s', responsibilities=%s}", name, age, group, responsibilities);
  }
}
