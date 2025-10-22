package seedu.address.model.person;

import seedu.address.model.Model;

import static java.util.Objects.requireNonNull;

import java.util.List;
import java.util.function.Predicate;

public class MentorHasStudentsPredicate implements Predicate<Person> {
    private final Model model;

    public MentorHasStudentsPredicate(Model model) {
        requireNonNull(model);
        System.out.println("constructor: " + model.getFilteredPersonList() + "\n");
        this.model = model;
    }

    @Override
    public boolean test(Person person) {
        String role = person.getRole();
        boolean isAssignedStudent = false;

        if (role.equals("Mentor") || role.equals("Person")) {
            System.out.println(person + " is not student");
            return false;
        }

        if (role.equals("Student") && ((Student) person).getMentor() != null) {
            List<Person> lastUsedList = model.getFilteredPersonList();
            System.out.println(lastUsedList.toString());
            for (Person currPerson : lastUsedList) {
                System.out.println("In loop, Current person:" + currPerson + "\n");
                System.out.println("Is student and mentor == person is "
                        + ((Student) currPerson).getMentor().equals(person) + "\n");
                if (((Student) currPerson).getMentor().equals(person)) {
                    System.out.println("reached\n");
                    isAssignedStudent = true;
                }
            }
        }
        return isAssignedStudent;
    }
}
