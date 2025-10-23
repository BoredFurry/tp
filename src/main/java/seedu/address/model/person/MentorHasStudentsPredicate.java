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
        if (person instanceof Mentor) {

            for (Person currPerson : personList) {
                if (currPerson instanceof Student
                        && ((Student) currPerson).getMentorString().equals(person.getName().toString())) {
                    return false;
                }
            }
        }

        if (person != null) {
            System.out.println(person + " is not student");
            return false;
        }

        return false;
    }
}
