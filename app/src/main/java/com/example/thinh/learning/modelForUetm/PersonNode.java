package com.example.thinh.learning.modelForUetm;

/**
 * Created by Nguyen Duc Thinh on 18/10/2014.
 * Project type: Android
 */
public class PersonNode extends Node {

    private String studentId;
    private String dob;
    private boolean genderMale;
    private String academicYear;
    private String academicYearClass;
    private String contact;
    private String achievement;
    private String strongPoint;

    public PersonNode() {
    }

    public PersonNode(String id, String studentId, String name, String dob,
                      boolean genderMale, String academicYear, String academicYearClass,
                      String contact, String achievement, String strongPoint) {
        super(id, name);
        setStudentId(studentId);
        setDob(dob);
        setGenderMale(genderMale);
        setAcademicYear(academicYear);
        setAcademicYear(academicYearClass);
        setContact(contact);
        setAchievement(achievement);
        setStrongPoint(strongPoint);

    }

    public String getStudentId() {
        return studentId;
    }

    public void setStudentId(String studentId) {
        this.studentId = studentId;
    }

    public String getDob() {
        return dob;
    }

    public void setDob(String dob) {
        this.dob = dob;
    }

    public boolean isGenderMale() {
        return genderMale;
    }

    public void setGenderMale(boolean genderMale) {
        this.genderMale = genderMale;
    }

    public String getAcademicYear() {
        return academicYear;
    }

    public void setAcademicYear(String academicYear) {
        this.academicYear = academicYear;
    }

    public String getAcademicYearClass() {
        return academicYearClass;
    }

    public void setAcademicYearClass(String academicYearClass) {
        this.academicYearClass = academicYearClass;
    }

    public String getContact() {
        return contact;
    }

    public void setContact(String contact) {
        this.contact = contact;
    }

    public String getAchievement() {
        return achievement;
    }

    public void setAchievement(String achievement) {
        this.achievement = achievement;
    }

    public String getStrongPoint() {
        return strongPoint;
    }

    public void setStrongPoint(String strongPoint) {
        this.strongPoint = strongPoint;
    }

    public boolean isPersonNode() {
        return true;
    }

}
