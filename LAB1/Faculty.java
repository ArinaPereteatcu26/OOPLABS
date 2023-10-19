package LABSystem;


import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;


public class Faculty {

  private String name;

  private String abbreviation;

  private List<Student> students;

  private StudyField studyField;


  public Faculty (String name, String abbreviation, StudyField studyField) {

    this.name = name;
    this.abbreviation = abbreviation;
    this.studyField = studyField;
    this.students = new LinkedList<>();
  }


  public String getName () {

    return name;
  }


  public void setName (String name) {

    this.name = name;
  }


  public String getAbbreviation () {

    return abbreviation;
  }


  public void setAbbreviation (String abbreviation) {

    this.abbreviation = abbreviation;
  }


  public List<Student> getStudents () {

    return students;
  }


  public void addNewStudents (Student... students) {

    this.students.addAll(Arrays.stream(students).toList());
  }


  public StudyField getStudyField () {

    return studyField;
  }


  public void setStudyField (StudyField studyField) {

    this.studyField = studyField;
  }
}
