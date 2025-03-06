package ch.noseryoung.app;

import java.time.LocalDate;
import java.util.Objects;
import java.util.Scanner;

import ch.noseryoung.exceptions.*;

import static java.lang.Math.pow;


public class TriangleApp {
  private String company;
  private String handler;

  private boolean isRunning;

  private String sideAInput;
  private String sideBInput;
  private String sideCInput;

  private double sideA;
  private double sideB;
  private double sideC;

  private String code;

  Scanner scanner = new Scanner(System.in);

  /**
   * The constructor.
   *
   * @param company of type String to print in the application header
   * @param handler of type String to print in the application header
   */
  public TriangleApp(String company, String handler) {
    isRunning = true;
    this.company = Objects.requireNonNullElse(company, "NoserYoung");
    this.handler = Objects.requireNonNullElse(handler, "Ramadan");

  }

  /**
   * This method starts the actual application. It will remain in a loop as long
   * as the field "isRunning" is true.
   */
  public void start() {
    printHeader();
    while (isRunning) {
      System.out.println("\nTEST CASES TRIANGLE\n");

      System.out.println("Cathetus A:");
      sideAInput = scanner.nextLine();
      System.out.println("Cathetus B:");
      sideBInput = scanner.nextLine();
      System.out.println("Hypotenuse C:");
      sideCInput = scanner.nextLine();

      try {
        validateInput();
        code = determineTriangleType();
      } catch (TriangleException e) {
        code = e.getMessage();
      } finally {
        printResult();
        promptAction();
      }
    }
  }

  /**
   * This method prints the application header.
   */
  private void printHeader() {
    System.out.println("******************************************\n ");
    System.out.println("          Triangle Evaluator\n ");
    System.out.println("******************************************\n ");
    System.out.println("COMPANY: " + company + LocalDate.now().getYear() + "\n");
    System.out.println("HANDLER: " + handler + "\n");
    System.out.println("******************************************\n\n ");

  }

  /**
   * This method prints the evaluated code in an aesthetically pleasing way.
   */
  private void printResult() {
    System.out.println("******************************************\n ");
    System.out.println("RESULT: " + code + "\n");
    System.out.println("******************************************\n\n ");
  }

  /**
   * This method prompts the user to give an input for a trinalge side.
   * 
   * @param side of type String to display as title for the prompt.
   * @return the input of type String.
   */
  private String promptSide(String side) {
    System.out.println(side + ":");
    return scanner.nextLine();
  }

  /**
   * This method prompts the user to give an input.<br>
   * "q": Quits the program.<br>
   * "c": Continues the program.<br>
   * else: Keeps asking for an input until "q" or "c" is entered.
   */
  private void promptAction() {
    String action = "";
    do {
        System.out.println("<q> QUIT");
        System.out.println("<c> CONTINUE");
        action = scanner.nextLine().toLowerCase();
    } while (!action.equals("q") && !action.equals("c"));

    if (action.equals("q")) {
      isRunning = false;
    }
	
    System.out.println("******************************");
  }

  /**
   * This method validates the three entered values, to be used as sides for a
   * triangle.
   * 
   * @throws TriangleException if the validation fails. This means that the
   *                           entered values do not lead to a triangle.
   */
  private void validateInput() throws TriangleException {
    try {
      sideA = Double.parseDouble(sideAInput);
      sideB = Double.parseDouble(sideBInput);
      sideC = Double.parseDouble(sideCInput);
	  
    } catch (NumberFormatException nfe) {
      throw new IllegalTriangleSideException();
    }

    if  (sideA == 0 || sideB == 0 || sideC == 0) {
      throw new ZeroTriangleSideException();
    }
    if (sideA < 0 || sideB < 0 || sideC < 0) {
      throw new NegativeTriangleSideException();
    }
    if (sideA + sideB == sideC || sideA + sideC == sideB || sideB + sideC == sideA) {
      throw new TriangleIsLineException();
    }
    if (sideA + sideB <= sideC || sideA + sideC <= sideB || sideB + sideC <= sideA) {
      throw new ImpossibleTriangleException();
    }
    }

  /**
   * This method determines whether the three entered values lead to a
   * equilateral, isosceles, right-angled or scalene triangle.
   * 
   * @return The corresponding code for each triangle.
   */
  private String determineTriangleType() {
    if (sideA == sideB && sideB == sideC) {
    return "TRI66TF";
    } else if (sideA == sideB || sideA == sideC || sideB == sideC) {
      return "TRI84TF";
    } else if (Math.abs(Math.pow(sideA, 2) + Math.pow(sideB, 2) - Math.pow(sideC, 2)) < 0.000001 ||
            Math.abs(Math.pow(sideA, 2) + Math.pow(sideC, 2) - Math.pow(sideB, 2)) < 0.000001 ||
            Math.abs(Math.pow(sideB, 2) + Math.pow(sideC, 2) - Math.pow(sideA, 2)) < 0.000001) {
      return "TRI72TF";
    } else if (sideA != sideB && sideB != sideC && sideA != sideC) {
      return "TRI60TF";
    } else {
      return null;
    }
}
}
