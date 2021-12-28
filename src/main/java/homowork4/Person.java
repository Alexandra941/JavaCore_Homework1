package homowork4;

public class Person {
    private String LastName;
    private String Phone;

    public Person(String lastName, String phone) {
        LastName = lastName;
        Phone = phone;
    }

    public String getLastName() {
        return LastName;
    }

    public String getPhone() {
        return Phone;
    }
}
