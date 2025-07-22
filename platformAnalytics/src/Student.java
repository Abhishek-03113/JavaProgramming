class Student {
    private final String studentId;
    private final String name;
    private final String country;

    public Student(String studentId, String name, String country) {
        this.studentId = studentId;
        this.name = name;
        this.country = country;
    }

    public String getStudentId() {
        return studentId;
    }

    public String getName() {
        return name;
    }

    public String getCountry() {
        return country;
    }

    @Override
    public String toString() {
        return String.format("%s (%s) from %s", name, studentId, country);
    }
}