package LABSystem;


import java.util.Scanner;


public final class GeneralOperations {

  static void returnGeneralOperationsSelection () {

    Scanner scanner = new Scanner(System.in);

    System.out.println("---------------------------------");
    System.out.println("General Operations");
    System.out.println("What do you want to do?");
    System.out.println();
    System.out.println("nf/<faculty name>/<faculty abbreviation>/<field> - create faculty");
    System.out.println("ss/<student email> - search student and show faculty");
    System.out.println("df - display faculties");
    System.out.println("dff/<field> - display all faculties of a field");
    System.out.println();
    System.out.println("b - back");
    System.out.println("q - Quit program");
    System.out.println("---------------------------------");

    String selection = scanner.nextLine();
    String splittedSelection = selection.split("/")[0];

    switch (splittedSelection) {
      case "nf":
        createFaculty(selection);
        break;
      case "ss":
        searchStudentAndDisplayFaculty(selection);
        break;
      case "df":
        displayAllFaculties();
        break;
      case "dff":
        displayAllFacultiesOfAField(selection);
        break;
      case "b":
        Main.startMenuReturnSelection();
        break;
      case "q":
        return;
      default:
        System.out.println("Invalid selection! Try again...");
        returnGeneralOperationsSelection();
    }
  }


  static void displayAllFacultiesOfAField (String inputString) {

    verifyStringParam(inputString, 2);

    try {
      StudyField studyField = StudyField.valueOf(inputString.split("/")[1]);
      Main.facultyList.stream()
          .filter(e -> e.getStudyField().equals(studyField))
          .forEach(e -> System.out.println(e.getName()));
    } catch (Exception e) {
      System.out.println("Study field not found!");
    } finally {
      returnGeneralOperationsSelection();
    }
  }


  static void displayAllFaculties () {

    Main.facultyList
        .forEach(e -> System.out.println(e.getName()));
    returnGeneralOperationsSelection();
  }


  static void verifyStringParam (String inputString, int assertArraySize) {

    String[] splittedString = inputString.split("/");
    if (splittedString.length != assertArraySize) {
      System.out.println("Invalid string parameters, try again");
      returnGeneralOperationsSelection();
    }
  }


  static void searchStudentAndDisplayFaculty (String stringParam) {

    String[] splittedString = stringParam.split("/");

    for (Faculty faculty :
        Main.facultyList) {
      if (faculty.getStudents()
          .stream()
          .anyMatch(e -> e.getEmail().equals(splittedString[1]))) {
        System.out.println("Student: " + splittedString[1] + " is in " + faculty.getName() + " faculty");
        returnGeneralOperationsSelection();
      }
      System.out.println("Student was not found in any faculty, please try again...");
      returnGeneralOperationsSelection();
    }


    verifyStringParam(stringParam, 2);
  }


  static void createFaculty (String paramString) {

    String[] splittedString = paramString.split("/");

    verifyStringParam(paramString, 4);

    try {
      Faculty newFaculty = new Faculty(
          splittedString[1], //faculty name
          splittedString[2], //faculty abbreviation
          StudyField.valueOf(splittedString[3]) //faculty field
      );
      Main.facultyList.add(newFaculty);
      System.out.println("Faculty was created!");
    } catch (Exception ignored) {
      System.out.println("Faculty couldn't be created, try again");
    } finally {
      returnGeneralOperationsSelection();
    }
  }


}
