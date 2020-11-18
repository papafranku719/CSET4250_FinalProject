import java.util.LinkedList;

public class Student {
    String name;
    String id;
    double[] homework = {};
    double[] tests = {};
    double totalGrade;
    String letterGrade;

    public Student (String name, String id, double[] homework, double[] tests, double totalGrade, String letterGrade) {
        this.name = name;
        this.id = id;
        this.homework = homework;
        this.tests = tests;
        this.totalGrade = totalGrade;
        this.letterGrade = letterGrade;
    }

    public static LinkedList<Student> students = new LinkedList<Student>();

}
