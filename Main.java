import javax.swing.*;
import java.io.*;
import java.util.*;

public class Main {

    public static void giveLetter() {
        for (Student student : Student.students) {
            if (student.totalGrade <= 100.0 && student.totalGrade >= 94.0) {
                student.letterGrade = "A";
            } else if (student.totalGrade < 94.0 && student.totalGrade >= 90.0) {
                student.letterGrade = "A-";
            } else if (student.totalGrade < 90.0 && student.totalGrade >= 87.0) {
                student.letterGrade = "B+";
            } else if (student.totalGrade < 87.0 && student.totalGrade >= 84.0) {
                student.letterGrade = "B";
            } else if (student.totalGrade < 84.0 && student.totalGrade >= 80.0) {
                student.letterGrade = "B-";
            } else if (student.totalGrade < 80.0 && student.totalGrade >= 77.0) {
                student.letterGrade = "C+";
            } else if (student.totalGrade < 77.0 && student.totalGrade >= 74.0) {
                student.letterGrade = "C";
            } else if (student.totalGrade < 74.0 && student.totalGrade >= 70.0) {
                student.letterGrade = "C-";
            } else if (student.totalGrade < 70.0 && student.totalGrade >= 67.0) {
                student.letterGrade = "D+";
            } else if (student.totalGrade < 67.0 && student.totalGrade >= 64.0) {
                student.letterGrade = "D";
            } else if (student.totalGrade < 64.0 && student.totalGrade >= 60.0) {
                student.letterGrade = "D-";
            } else if (student.totalGrade < 60.0) {
                student.letterGrade = "F";
            }
        }
    }

    public static void createStudent() {
        Scanner s = new Scanner(System.in);
        double[] hw = {};
        double[] tst = {};
        double hwTotal = 0;
        double tstTotal = 0;
        double hwWeight = 0;
        double tstWeight = 0;
        double total;
        String letter = "";
        System.out.print("Enter the student's name: ");
        String name = s.nextLine();
        System.out.print("Enter the student's ID: ");
        String id = s.nextLine();
        System.out.print("How many homework assignments are to be entered for this student? (Please enter a number) ");
        int hold = s.nextInt();
        if (hold != 0) {
            double[] hwHold = new double[hold];
            for (int i = 0; i < hold; i++) {
                System.out.print("Enter the homework grade for Homework " + (i + 1) + ": ");
                double grade = s.nextDouble();
                hwHold[i] = grade;
            }
            hw = hwHold.clone();
            for (double i : hwHold) {
                hwTotal = hwTotal + i;
            }
            hwWeight = ((hwTotal / (hwHold.length * 100)) * 30);
        } else {
            System.out.println("Please enter a valid number. ");
        }
        System.out.print("How many tests are to be entered for this student? (Please enter a number) ");
        hold = s.nextInt();
        if (hold != 0) {
            double[] tstHold = new double[hold];
            for (int i = 0; i < hold; i++) {
                System.out.print("Enter the test grade for Test " + (i + 1) + ": ");
                double grade = s.nextDouble();
                tstHold[i] = grade;
            }
            tst = tstHold.clone();
            for (double i : tstHold) {
                tstTotal = tstTotal + i;
            }
            tstWeight = ((tstTotal / (tstHold.length * 100)) * 70);
        } else {
            System.out.println("Please enter a valid number. ");
        }
        total = hwWeight + tstWeight;
        if (total <= 100.0 && total >= 94.0) {
            letter = "A";
        } else if (total < 94.0 && total >= 90.0) {
            letter = "A-";
        } else if (total < 90.0 && total >= 87.0) {
            letter = "B+";
        } else if (total < 87.0 && total >= 84.0) {
            letter = "B";
        } else if (total < 84.0 && total >= 80.0) {
            letter = "B-";
        } else if (total < 80.0 && total >= 77.0) {
            letter = "C+";
        } else if (total < 77.0 && total >= 74.0) {
            letter = "C";
        } else if (total < 74.0 && total >= 70.0) {
            letter = "C-";
        } else if (total < 70.0 && total >= 67.0) {
            letter = "D+";
        } else if (total < 67.0 && total >= 64.0) {
            letter = "D";
        } else if (total < 64.0 && total >= 60.0) {
            letter = "D-";
        } else if (total < 60.0) {
            letter = "F";
        }
        System.out.println(" ");
        Student.students.add(new Student(name, id, hw, tst, total, letter));
    }

    public static void deleteStudent() {
        Scanner s = new Scanner(System.in);
        System.out.print("Enter the student's ID: ");
        String search = s.nextLine();
        Student.students.removeIf(student -> student.id.equals(search));
    }

    public static void searchForStudent() {
        Scanner s = new Scanner(System.in);
        System.out.print("Enter the student's ID: ");
        String search = s.nextLine();
        for (Student student : Student.students) {
            if (student.id.equals(search)) {
                System.out.println("Student Name          : " + (student.name) +"\n" +
                        "Student ID            : " + (student.id) +"\n" +
                        "Student's HW Grades   : " + (Arrays.toString(student.homework)) +"\n" +
                        "Student's Test Grades : " + (Arrays.toString(student.tests)) +"\n" +
                        "Student's Total Grade : " + (student.totalGrade) + "\n" +
                        "Student's Letter Grade: " + (student.letterGrade) + "\n");
            }
        }
    }

    private static void updateStudent() {
        String choice = "";
        Scanner s = new Scanner(System.in);
        System.out.print("Enter the student's ID: ");
        String search = s.nextLine();
        for (Student student : Student.students) {
            if (student.id.equals(search)) {
                while (!choice.equals("3")) {
                    System.out.print("""
                            1. Update Student Name
                            2. Update Student ID
                            3. Exit Update Function
                            Using the numbers above, please make a selection:\s""");
                    choice = s.nextLine();
                    switch (choice) {
                        case "1":
                            System.out.print("Enter the student's name: ");
                            student.name = s.nextLine();
                            break;
                        case "2":
                            System.out.print("Enter the student's ID: ");
                            student.id = s.nextLine();
                            break;
                        case "3":
                            break;
                    }
                }
            }
        }
    }

    public static void updateGrades() {
        String choice = "";
        double hwTotal = 0;
        double tstTotal = 0;
        double hwWeight;
        double tstWeight;
        Scanner s = new Scanner(System.in);
        System.out.print("Enter the student's ID: ");
        String search = s.nextLine();
        for (Student student : Student.students) {
            if (student.id.equals(search)) {
                System.out.println("This student has " + student.homework.length + " homework assignments " +
                        "and " + student.tests.length + " tests on record.");
                while (!choice.equals("7")) {
                    System.out.println("""
                            1. Enter new homework grade
                            2. Enter new test grade
                            3. Update homework grade
                            4. Update test grade
                            5. Delete homework grade
                            6. Delete test grade
                            7. Exit Update Function
                            Using the numbers above, please make a selection:\s""");
                    choice = s.nextLine();
                    switch (choice) {
                        case "1":
                            System.out.print("How many homework assignments are to be entered for this student? (Please enter a number) ");
                            int hold = s.nextInt();
                            double[] hwHold = new double[student.homework.length + hold];
                            for (int i = 0; i < student.homework.length; i++) {
                                hwHold[i] = student.homework[i];
                            }

                            for (int i = student.homework.length; i < hwHold.length; i++) {
                                System.out.print("Enter the homework grade for Homework " + (i + 1) + ": ");
                                hwHold[i] = s.nextDouble();
                            }
                            student.homework = hwHold.clone();

                            for (double i : hwHold) {
                                hwTotal = hwTotal + i;
                            }
                            hwWeight = ((hwTotal / (hwHold.length * 100)) * 30);

                            for (double i : student.tests) {
                                tstTotal = tstTotal + i;
                            }
                            tstWeight = ((tstTotal / (student.tests.length * 100)) * 70);

                            student.totalGrade = hwWeight + tstWeight;
                            giveLetter();
                            break;
                        case "2":
                            System.out.print("How many tests are to be entered for this student? (Please enter a number) ");
                            hold = s.nextInt();
                            double[] tstHold = new double[student.tests.length + hold];
                            for (int i = 0; i < student.tests.length; i++) {
                                tstHold[i] = student.tests[i];
                            }

                            for (int i = student.tests.length; i < tstHold.length; i++) {
                                System.out.print("Enter the test grade for Test " + (i + 1) + ": ");
                                tstHold[i] = s.nextDouble();
                            }
                            student.tests = tstHold.clone();

                            for (double i : tstHold) {
                                tstTotal = tstTotal + i;
                            }
                            tstWeight = ((tstTotal / (tstHold.length * 100)) * 70);

                            for (double i : student.homework) {
                                hwTotal = hwTotal + i;
                            }
                            hwWeight = ((hwTotal / (student.homework.length * 100)) * 30);

                            student.totalGrade = hwWeight + tstWeight;
                            giveLetter();
                            break;
                        case "3":
                            System.out.print("Please pick any homework assignment between Homework 1 and Homework " + (student.homework.length) + ": ");
                            hold = s.nextInt();
                            int holdCon = hold - 1;
                            for (int i = 0; i < student.homework.length; i++) {
                                if (i == holdCon) {
                                    System.out.print("Enter the new homework grade for Homework " + (hold) + ": ");
                                    student.homework[i] = s.nextDouble();
                                }
                            }

                            for (double i : student.homework) {
                                hwTotal = hwTotal + i;
                            }
                            hwWeight = ((hwTotal / (student.homework.length * 100)) * 30);

                            for (double i : student.tests) {
                                tstTotal = tstTotal + i;
                            }
                            tstWeight = ((tstTotal / (student.tests.length * 100)) * 70);

                            student.totalGrade = hwWeight + tstWeight;
                            giveLetter();
                            break;
                        case "4":
                            System.out.print("Please pick any test between Test 1 and Test " + (student.tests.length) + ": ");
                            hold = s.nextInt();
                            holdCon = hold - 1;
                            for (int i = 0; i < student.tests.length; i++) {
                                if (i == holdCon) {
                                    System.out.print("Enter the new test grade for Test " + (hold) + ": ");
                                    student.tests[i] = s.nextDouble();
                                }
                            }

                            for (double i : student.tests) {
                                tstTotal = tstTotal + i;
                            }
                            tstWeight = ((tstTotal / (student.tests.length * 100)) * 70);

                            for (double i : student.homework) {
                                hwTotal = hwTotal + i;
                            }
                            hwWeight = ((hwTotal / (student.homework.length * 100)) * 30);

                            student.totalGrade = hwWeight + tstWeight;
                            giveLetter();
                            break;
                        case "5":
                            System.out.print("Please pick any homework assignment between Homework 1 and Homework " + (student.homework.length) + ": ");
                            hold = s.nextInt();
                            holdCon = hold - 1;
                            double[] hwDel = new double[student.homework.length - 1];
                            for (int i = 0, k = 0; i < student.homework.length; i++) {
                                if (i == holdCon) {
                                    continue;
                                }
                                hwDel[k++] = student.homework[i];
                            }
                            student.homework = hwDel.clone();

                            for (double i : student.homework) {
                                hwTotal = hwTotal + i;
                            }
                            hwWeight = ((hwTotal / (student.homework.length * 100)) * 30);

                            for (double i : student.tests) {
                                tstTotal = tstTotal + i;
                            }
                            tstWeight = ((tstTotal / (student.tests.length * 100)) * 70);

                            student.totalGrade = hwWeight + tstWeight;
                            giveLetter();
                            break;
                        case "6":
                            System.out.print("Please pick any test between Test 1 and Test " + (student.tests.length) + ": ");
                            hold = s.nextInt();
                            holdCon = hold - 1;
                            double[] tstDel = new double[student.tests.length - 1];
                            for (int i = 0, k = 0; i < student.tests.length; i++) {
                                if (i == holdCon) {
                                    continue;
                                }
                                tstDel[k++] = student.tests[i];
                            }
                            student.tests = tstDel.clone();

                            for (double i : student.tests) {
                                tstTotal = tstTotal + i;
                            }
                            tstWeight = ((tstTotal / (student.tests.length * 100)) * 70);

                            for (double i : student.homework) {
                                hwTotal = hwTotal + i;
                            }
                            hwWeight = ((hwTotal / (student.homework.length * 100)) * 30);

                            student.totalGrade = hwWeight + tstWeight;
                            giveLetter();
                            break;
                        case "7":
                            break;
                    }
                }
            }
        }
    }

    private static void writeToFile (File file) {
        try {
            FileWriter myWriter = new FileWriter(file);
            for (Student student : Student.students) {
                myWriter.write("Student Name          : " + student.name +"\n" +
                        "Student ID            : " + student.id +"\n" +
                        "Student's HW Grades   : " + Arrays.toString(student.homework) +"\n" +
                        "Student's Test Grades : " + Arrays.toString(student.tests) +"\n" +
                        "Student's Total Grade : " + student.totalGrade + "\n" +
                        "Student's Letter Grade: " + student.letterGrade + "\n" +
                        "-----------------------------------------" + "\n");
            }
            myWriter.close();
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("An error occurred.");
        }
    }

    private static void readFromFile(File file) {
        String name = "";
        String id = "";
        double[] hw = {};
        double[] tst = {};
        double total = 0;
        String letter = "";
        BufferedReader LoadedFile;
        try {
            LoadedFile = new BufferedReader(new FileReader(file));
            String line = LoadedFile.readLine();
            while (line != null) {
                if (line.contains("Name")) {
                    String[] SplitLine = line.split(": ");
                    name = SplitLine[1];
                } else if (line.contains("ID")) {
                    String[] SplitLine = line.split(": ");
                    id = SplitLine[1];
                } else if (line.contains("HW")) {
                    String[] SplitLine = line.split(":");
                    String arrayString = SplitLine[1];
                    String[] items = arrayString.replaceAll("\\[", "").replaceAll("\\]", "").replaceAll("\s", "").split(",");
                    double[] results = new double[items.length];
                    for (int i = 0; i < items.length; i++) {
                        try {
                            results[i] = Double.parseDouble(items[i]);
                        } catch (NumberFormatException nfe) {
                            System.out.println("An error occurred.");
                        };
                    }
                    hw = results.clone();
                } else if (line.contains("Test")) {
                    String[] SplitLine = line.split(":");
                    String arrayString = SplitLine[1];
                    String[] items = arrayString.replaceAll("\\[", "").replaceAll("\\]", "").replaceAll("\s", "").split(",");
                    double[] results = new double[items.length];
                    for (int i = 0; i < items.length; i++) {
                        try {
                            results[i] = Double.parseDouble(items[i]);
                        } catch (NumberFormatException nfe) {
                            System.out.println("An error occurred.");
                        };
                    }
                    tst = results.clone();
                } else if (line.contains("Total")) {
                    String[] SplitLine = line.split(": ");
                    total = Double.parseDouble(SplitLine[1]);
                } else if (line.contains("Letter")) {
                    String[] SplitLine = line.split(": ");
                    letter = SplitLine[1];
                } else if (line.contains("--")) {
                    Student.students.add(new Student(name, id, hw, tst, total, letter));
                }
                line = LoadedFile.readLine();

            }
            LoadedFile.close();
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("An error occurred.");
        }
    }

    public static void main(String[] args) {
        String myDocuments = null;
        try {
            Process p =  Runtime.getRuntime().exec("reg query \"HKCU\\Software\\Microsoft\\Windows\\CurrentVersion\\Explorer\\Shell Folders\" /v personal");
            p.waitFor();

            InputStream in = p.getInputStream();
            byte[] b = new byte[in.available()];
            in.read(b);
            in.close();

            myDocuments = new String(b);
            myDocuments = myDocuments.split("\\s\\s+")[4];
            myDocuments = myDocuments + "/students.txt";

        } catch(Throwable t) {
            t.printStackTrace();
        }

        // Since the .jar file is being relied on
        // If someone happens to change the associations without knowing, it'll brick the program
        // windows associations and file extensions -- google it
        // put instructions on how to make/fix associations

        Scanner s = new Scanner(System.in);
        String choice = "";
        while (!choice.equals("8")) {
            System.out.println("""
                    1. Add Student Record
                    2. Update Student Name/ID
                    3. Update Student Grades
                    4. Search Student Record
                    5. Delete Student Record
                    6. Save to File
                    7. Load from File
                    8. Exit Application
                    Using the numbers above, please make a selection:\s""");
            choice = s.nextLine();
            switch (choice) {
                case "1":
                    createStudent();
                    break;
                case "2":
                    updateStudent();
                    break;
                case "3":
                    updateGrades();
                    break;
                case "4":
                    searchForStudent();
                    break;
                case "5":
                    deleteStudent();
                    break;
                case "6":
                    File file = new File (myDocuments);
                    writeToFile(file);
                    System.out.println("File successfully saved.");
                    break;
                case "7":
                    file = new File (myDocuments);
                    readFromFile(file);
                    System.out.println("File successfully loaded.");
                    break;
                case "8":
                    System.exit(0);
                case "9":
                    System.out.println(":D");
                    break;
            }
        }
    }
}
