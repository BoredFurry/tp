package seedu.address.model.person;

import java.util.function.Predicate;

/**
 * Tests that a {@code Student} has been assigned a {@code Mentor}.
 */
public class StudentHasMentorsPredicate implements Predicate<Person> {

    @Override
    public boolean test(Person person) {
        String role = person.getRole();

        if (role.equals("Student")) {
            Student castStudent = (Student) person;
            Mentor assignedMentor = castStudent.getMentor();
            return assignedMentor == null;
        } else {
            return true;
        }
    }
}
