package org.example;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "students")
public class Student {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "roll_no")
    private int rollNo;

    @Column(name = "student_name", length = 100, nullable = false)
    private String sName;

    @Column(name = "student_age")
    private int sAge;

    // Required no-arg constructor
    public Student() {
    }

    // Convenience constructor
    public Student(String sName, int sAge) {
        this.sName = sName;
        this.sAge = sAge;
    }

    // Getters and setters
    public int getRollNo() {
        return rollNo;
    }

    public String getSName() {
        return sName;
    }

    public void setSName(String sName) {
        this.sName = sName;
    }

    public int getSAge() {
        return sAge;
    }

    public void setSAge(int sAge) {
        this.sAge = sAge;
    }

    @Override
    public String toString() {
        return "Student{" +
                "rollNo=" + rollNo +
                ", sName='" + sName + '\'' +
                ", sAge=" + sAge +
                '}';
    }
}