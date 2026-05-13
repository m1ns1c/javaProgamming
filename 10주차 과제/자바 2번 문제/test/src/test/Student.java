package test;

public class Student {
    private String studentID;
    private String name;

    public Student(String studentID, String name) {
        this.studentID = studentID;
        this.name = name;
    }

    public String getStudentID() {
        return studentID;
    }

    public String getName() {
        return name;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof Student)) {
            return false;
        }
        
        Student std = (Student) obj;
        
        boolean sameID = this.studentID.equals(std.studentID);
        boolean sameName = this.name.equals(std.name);
        
        if (sameID == true && sameName == true) {
            return true;
        } 
        else {
            return false;
        }
    }

    @Override
    public String toString() {
        String result = studentID + " " + name;
        return result;
    }
}