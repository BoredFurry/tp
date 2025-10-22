package seedu.address.model.person;

import static java.util.Objects.requireNonNull;

import java.util.List;
import java.util.function.Predicate;

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
