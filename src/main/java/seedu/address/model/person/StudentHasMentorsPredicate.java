package seedu.address.model.person;

import seedu.address.model.Model;

import static java.util.Objects.requireNonNull;

import java.util.List;
import java.util.function.Predicate;

public class StudentHasMentorsPredicate implements Predicate<Person> {
    private final Model model;

    public StudentHasMentorsPredicate(Model model) {
        requireNonNull(model);
        this.model = model;
    }

    @Override
    public boolean test(Person person) {
        String role = person.getRole();
        Student castStudent;

        switch (role) {

        case "Student":
            castStudent = (Student) person;
            Mentor assignedMentor = castStudent.getMentor();
            return assignedMentor == null;

        case "Mentor":
            Predicate<Person> getStudentCondition = student -> student.getRole().equals("student") ?
                    ((Student) student).getMentor().equals(person) : false;

            model.updateFilteredPersonList(getStudentCondition);

            List<Person> lastShownList = model.getFilteredPersonList();

            for (Person currStudent : lastShownList) {
                if (((Student)currStudent).getMentor().equals(person)) {
                    return true;
                }
            }

            return false;

        default:
            return false;
        }
    }
}
