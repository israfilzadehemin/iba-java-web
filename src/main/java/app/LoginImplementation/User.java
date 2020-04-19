package app.LoginImplementation;

import java.io.*;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class User {
  HashMap<String, String> userBase = new HashMap<>();

  public void addUser(String username, String pass) {
    userBase.put(username, pass);
  }

  public void fillUsers() throws FileNotFoundException {
    List<String> users = new BufferedReader(new FileReader(new File("content/users.txt"))).lines().collect(Collectors.toList());
    for (String user : users) {
      String username = user.split(" ")[0];
      String pass = user.split(" ")[1];
      addUser(username, pass);
    }

  }

  public void userToFile() throws IOException {
    BufferedWriter bw = new BufferedWriter(new FileWriter("content/users.txt", true));

    for (Map.Entry<String, String> user : userBase.entrySet()) {
      bw.write(user.getKey());
      bw.write(" ");
      bw.write(user.getValue());
      bw.write("\n");
      bw.close();
    }


  }
}
