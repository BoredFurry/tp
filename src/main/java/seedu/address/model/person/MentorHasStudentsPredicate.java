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
        if (person instanceof Mentor) {
            for (Person currPerson : personList) {
                if (currPerson instanceof Student
                        && ((Student) currPerson).getMentor().equals(person)) {
                    return false;
                }
            }
        }
        return true;
    }
}