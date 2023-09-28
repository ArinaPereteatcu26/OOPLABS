package LABSystem;


import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;


public class Main {

  static List<Faculty> facultyList = new LinkedList<>();


  public static void main (String[] args) {

    startMenuReturnSelection();
  }


  public static void startMenuReturnSelection () {

    Scanner scanner = new Scanner(System.in);
    System.out.println("Welcome to TUM's student management system!");
    System.out.println("What do you want to do?");
    System.out.println("g - General operations");
    System.out.println("f - Faculty operations");
    System.out.println("s - Student operations");
    System.out.println();
    System.out.println("q - Quit Program");

    String selection = scanner.nextLine();

    switch (selection) {
      case "g":
        GeneralOperations.returnGeneralOperationsSelection();
        break;
      case "f":
        FacultyOperations.facultyOperationsMenu();
        break;
      case "s":
        break;
      case "q":
        return;
      default:
        System.out.println("You have entered a wrong selection, please try again!");
        startMenuReturnSelection();
    }
  }
}