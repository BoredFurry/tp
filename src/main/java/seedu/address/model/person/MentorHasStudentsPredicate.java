package seedu.address.model.person;

import static java.util.Objects.requireNonNull;

import java.util.List;
import java.util.function.Predicate;

/**
 * Tests that a {@code Mentor} has been assigned to a {@code Student}.
 */
public class MentorHasStudentsPredicate implements Predicate<Person> {
    /**
     * A list of {@code Person} which the class will check through to find a {@code Student} with the provided
     * {@code Mentor}.
     */
    private final List<Person> personList;

    /**
     * Constructs a {@code MentorHasStudentsPredicate} using the specified list of persons.
     * This constructor ensures that the provided list is not {@code null}.
     * It also logs the list of persons to the console for debugging purposes.
     *
     * @param personList the list of {@link Person} objects associated with this predicate
     * @throws NullPointerException if {@code personList} is {@code null}
     */
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
