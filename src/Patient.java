public class Patient implements Comparable<Patient> {
    private String name;
    private int age;
    private int priority;

    public Patient(String name, int age, int priority) {
        this.name = name;
        this.age = age;
        this.priority = priority;
    }

    @Override
    public int compareTo(Patient other) {
        return Integer.compare(this.priority, other.priority);
    }

    public String toString() {
        return name + " (Age: " + age + ", Priority: " + priority + ")";
    }
}
