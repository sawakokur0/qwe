package modules;

public class Teacher extends Person {
    private String course;
    private int yearsOfExperience;
    private int salary;

    public Teacher(String name, String surname, int age, boolean gender, String course, int yearsOfExperience, int salary) {
        super(name, surname, age, gender);
        this.course = course;
        this.yearsOfExperience = yearsOfExperience;
        this.salary = salary;
    }

    public void raiseSalary(double raise) {
        salary += salary * raise / 100;
    }

    @Override
    public String toString() {
        return super.toString() + "I teach " + course + ".";
    }
}