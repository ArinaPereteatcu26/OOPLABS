package LABSystem;


import java.sql.Date;
import java.time.Instant;
import java.util.Optional;
import java.util.Scanner;


public class FacultyOperations {

  static void verifyStringParam (String inputString, int assertArraySize) {

    String[] splittedString = inputString.split("/");
    if (splittedString.length != assertArraySize) {
      System.out.println("Invalid string parameters, try again");
      facultyOperationsMenu();
    }
  }


  static void facultyOperationsMenu () {

    Scanner scanner = new Scanner(System.in);
    System.out.println("----------------------------------");
    System.out.println("Faculty operations");
    System.out.println("What do you want to do?");

    System.out.println(
        "ns/<faculty abbreviation>/<first name>/<last name>/<email>/<day>/<month>/<year> - create student");
    System.out.println("gs/<email> - graduate student");
    System.out.println("ds/<faculty abbreviation> - display enrolled students");
    System.out.println("dg/<faculty abbreviation> - display graduated students");
    System.out.println("bf/<faculty abbreviation>/<email> - check if student belongs to faculty");
    System.out.println();
    System.out.println("b - Back");
    System.out.println("q - Quit");

    String readString = scanner.nextLine();
    String splittedString = readString.split("/")[0];

    switch (splittedString) {
      case "ns":
        createStudent(readString);
        break;
      case "gs":
        graduateStudent(readString);
        break;
      case "ds":
        displayEnrolledStudents(readString);
        break;
      case "dg":
        displayGraduatedStudents(readString);
        break;
      case "bf":
        checkIfStudentBelongsToFaculty(readString);
        break;
      case "b":
        Main.startMenuReturnSelection();
        break;
      case "q":
        return;
      default:
        System.out.println("Invalid selection! Please try again...");
        facultyOperationsMenu();
    }
  }


  static void checkIfStudentBelongsToFaculty (String inputString) {

    verifyStringParam(inputString, 3);
    String[] splittedString = inputString.split("/");

    Optional<Faculty> faculty = Main.facultyList.stream()
        .filter(e -> e.getAbbreviation().equals(splittedString[1]))
        .findFirst();

    if (faculty.isPresent()) {
      Optional<Student> studentOptional = faculty.get().getStudents()
          .stream()
          .filter(e -> e.getEmail().equals(splittedString[2]) && !e.isGraduated())
          .findFirst();

      if (studentOptional.isPresent())
        System.out.println("Student belongs to the selected faculty!");
      else
        System.out.println("Student does not belong to the selected faculty!");
    } else
      System.out.println("Faculty has not been found");
    facultyOperationsMenu();
  }


  static void displayGraduatedStudents (String inputString) {

    verifyStringParam(inputString, 2);
    String[] splittedString = inputString.split("/");

    Optional<Faculty> faculty = Main.facultyList.stream()
        .filter(e -> e.getAbbreviation().equals(splittedString[1]))
        .findFirst();

    if (faculty.isPresent()) {
      faculty.get().getStudents().forEach(e -> {
        if (e.isGraduated())
          System.out.println(e.getFirstName() + " " + e.getLastName() + " ");
      });
    } else
      System.out.println("Faculty has not been found");
    facultyOperationsMenu();
  }


  static void displayEnrolledStudents (String inputString) {

    verifyStringParam(inputString, 2);
    String[] splittedString = inputString.split("/");

    Optional<Faculty> faculty = Main.facultyList.stream()
        .filter(e -> e.getAbbreviation().equals(splittedString[1]))
        .findFirst();

    if (faculty.isPresent()) {
      faculty.get().getStudents().forEach(e -> {
        if (!e.isGraduated())
          System.out.println(e.getFirstName() + " " + e.getLastName() + " ");
      });
    } else
      System.out.println("Faculty has not been found");
    facultyOperationsMenu();
  }


  static void graduateStudent (String inputString) {

    verifyStringParam(inputString, 2);
    String[] splittedString = inputString.split("/");

    Optional<Student> optionalStudent = Main.facultyList
        .stream().flatMap(e -> e.getStudents().stream())
        .filter(e -> e.getEmail().equals(splittedString[1]))
        .findFirst();

    if (optionalStudent.isPresent()) {
      optionalStudent.get().graduateStudent();
      System.out.println("Student " +
                             optionalStudent.get().getFirstName() +
                             " " + optionalStudent.get().getLastName() +
                             " has graduated!");
    } else
      System.out.println("The student has not been found");
    facultyOperationsMenu();
  }


  static void createStudent (String inputString) {

    verifyStringParam(inputString, 8);
    String[] splittedString = inputString.split("/");

    Optional<Faculty> facultyOptional = Main.facultyList
        .stream().filter(e -> e.getAbbreviation().equals(splittedString[1]))
        .findFirst();

    if (facultyOptional.isEmpty()) {
      System.out.println("Invalid faculty! Try again...");
    } else {
      facultyOptional.get()
          .addNewStudents(
              new Student(
                  splittedString[2],
                  splittedString[3],
                  splittedString[4],
                  Date.from(Instant.now()),
                  Date.valueOf(splittedString[7] + "-" + splittedString[6] + "-" + splittedString[5])
              )
          );
      System.out.println("Student created and assigned to faculty!");
    }

    facultyOperationsMenu();
  }

}
