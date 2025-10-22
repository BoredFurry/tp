package seedu.address.model.person;

import seedu.address.model.Model;

import static java.util.Objects.requireNonNull;

import java.util.List;
import java.util.function.Predicate;

public class MentorHasStudentsPredicate implements Predicate<Person> {
    private final List<Person> personList;

    public MentorHasStudentsPredicate(List<Person> personList) {
        requireNonNull(personList);
        System.out.println("constructor: " + personList + "\n");
        this.personList = personList;
    }

    @Override
    public boolean test(Person person) {
        String role = person.getRole();

        if (role.equals("Mentor")) {
            System.out.println("currlist: " + personList + "\n");
            for (Person currPerson : personList) {
                if (currPerson.getRole().equals("Student") && ((Student) currPerson).getMentor() != null) {

                    System.out.println("In loop, Current person:" + currPerson + "\n");
                    System.out.println("Is student and mentor == person is "
                            + ((Student) currPerson).getMentor().equals(person) + "\n");

                    if (((Student) currPerson).getMentor().equals(person)) {
                        System.out.println("reached\n");
                        return false;
                    }
                }
            }
        }

        if (role.equals("Student") || role.equals("Person")) {
            System.out.println(person + " is not student");
            return false;
        }

        return false;
    }
}
