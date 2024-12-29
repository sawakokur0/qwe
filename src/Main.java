import modules.*;

import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws FileNotFoundException {
        File studentFile = new File("src/students.txt");
        File teacherFile = new File("src/teachers.txt");

        Scanner studentSc = new Scanner(studentFile);
        Scanner teacherSc = new Scanner(teacherFile);

        ArrayList<Student> students = new ArrayList<>();
        ArrayList<Teacher> teachers = new ArrayList<>();

        while (studentSc.hasNextLine()) {
            String line = studentSc.nextLine();
            String[] tokens = line.split(" ");
            String name = tokens[0];
            String surname = tokens[1];
            int age = Integer.parseInt(tokens[2]);
            boolean gender = tokens[3].equalsIgnoreCase("Male");

            Student student = new Student(name, surname, age, gender);

            for (int i = 4; i < tokens.length; i++) {
                student.addGrade(Integer.parseInt(tokens[i]));
            }
            students.add(student);
        }

        while (teacherSc.hasNextLine()) {
            String line = teacherSc.nextLine();
            String[] tokens = line.split(" ");
            String name = tokens[0];
            String surname = tokens[1];
            int age = Integer.parseInt(tokens[2]);
            boolean gender = tokens[3].equalsIgnoreCase("Male");
            String course = tokens[4];
            int yearsOfExperience = Integer.parseInt(tokens[5]);
            int salary = Integer.parseInt(tokens[6]);

            Teacher teacher = new Teacher(name, surname, age, gender, course, yearsOfExperience, salary);
        }
        studentSc.close();
        teacherSc.close();

        School school = new School();
        for (Student student : students) {
            school.addMember(student);
        }
        for (Teacher teacher : teachers) {
            school.addMember(teacher);
        }

    }
}