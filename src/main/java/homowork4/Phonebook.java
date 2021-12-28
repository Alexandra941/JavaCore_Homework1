package homowork4;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Phonebook {
    private List<Person> persons;

    public Phonebook() {
    }

    public Phonebook(List<Person> persons) {
        this.persons = persons;
    }

    public void add(String lastName, String phoneNumber) {
        if (this.persons == null)
            this.persons = new ArrayList<Person>();

        this.persons.add(new Person(lastName, phoneNumber));
    }

    public List<String> get(String lastName){
        if (this.persons == null || this.persons.isEmpty()) {
            return new ArrayList<String>();
        }

        return persons.stream().filter(p -> p.getLastName().equalsIgnoreCase(lastName)).map(Person::getPhone).collect(Collectors.toList());
    }
}
