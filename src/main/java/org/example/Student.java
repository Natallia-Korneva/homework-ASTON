package org.example;
// Создайте класс Student, содержащий следующие характеристики – имя, группа, курс, оценки по предметам.
import java.util.*;

class Student {
    private String name;
    private String group;
    private int course;
    private Map<String, Integer> grades = new HashMap<>();

    public Student(String name, String group, int course) {
        this.name = name;
        this.group = group;
        this.course = course;
    }

   public void addGrade(String subject, int grade) {
        grades.put(subject, grade);
    }

    public double averageGrade() {
        if(grades.isEmpty()) return 0;

        double sum = 0;
        for(int grade : grades.values()) {
            sum += grade;
        }
        return sum / grades.size();
    }

    public String getName() { return name; }
    public String getGroup() { return group; }
    public int getCourse() { return course; }
    public void setCourse(int course) { this.course = course; }
}
