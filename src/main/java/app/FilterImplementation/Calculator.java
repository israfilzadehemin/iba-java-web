package app.FilterImplementation;

public class Calculator {

  public String doOp(int val1, int val2, String op) {
    switch (op) {
      case "add":
        return String.format("%d+%d = %d", val1, val2, val1 + val2);
      case "sub":
        return String.format("%d-%d = %d", val1, val2, val1 - val2);
      case "mul":
        return String.format("%d*%d = %d", val1, val2, val1 * val2);
      case "div":
        return String.format("%d/%d = %d", val1, val2, val1 / val2);
      default:
        return "Wrong operation!";
    }
  }

  public String doOperation(String v1, String v2, String op) {
    try {
      int value1 = Integer.parseInt(v1);
      int value2 = Integer.parseInt(v2);

      return doOp(value1, value2, op);

    } catch (NumberFormatException nex) {
      return "Please enter valid inputs!";

    } catch (ArithmeticException aex) {
      return "You tried to divide by zero!";

    } catch (Exception e) {
      return "Something went wrong!";
    }
  }

  public String doOpCookie(int val1, int val2, String op) {
    switch (op) {
      case "add":
        return String.format("%d%s%dequal%d", val1, op, val2, val1 + val2);
      case "sub":
        return String.format("%d%s%dequal%d", val1, op, val2, val1 - val2);
      case "mul":
        return String.format("%d%s%dequal%d", val1, op, val2, val1 * val2);
      case "div":
        return String.format("%d%s%dequal%d", val1, op, val2, val1 / val2);
      default:
        return "Wrong operation";
    }
  }

  public String doOperationCookie(String v1, String v2, String op) {
    try {
      int value1 = Integer.parseInt(v1);
      int value2 = Integer.parseInt(v2);

      return doOpCookie(value1, value2, op);

    } catch (Exception e) {
      return "WrongOperation";
    }
  }


}
