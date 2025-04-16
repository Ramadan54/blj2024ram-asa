import java.time.LocalDate;

public class Person {
    private String name;
    private LocalDate birthDate;

    public Person(String name, LocalDate birthDate) {
        this.name = name;
        this.birthDate = birthDate;
    }
    public String getName() {
        return name;
    }
    public LocalDate getBirthDate() {
        return birthDate;
    }
    public int getAge() {
        return LocalDate.now().getYear() - birthDate.getYear();
    }
    @Override
    public String toString() {
        return name + " (" + getAge() + " Jahre)";
    }
}
