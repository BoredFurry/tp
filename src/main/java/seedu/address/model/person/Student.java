package seedu.address.model.person;

import java.util.Set;

import seedu.address.model.tag.Tag;

/**
 * Represents a Student in the address book.
 * Guarantees: details are present and not null except mentor, field values are validated.
 */
public class Student extends Person {
    private Mentor mentor;
    /**
     * Every field must be present and not null.
     *
     * @param name
     * @param phone
     * @param email
     * @param address
     * @param remark
     * @param tags
     */
    public Student(Name name, Phone phone, Email email, Address address, Remark remark, Set<Tag> tags) {
        super(name, phone, email, address, remark, tags);
        this.mentor = null;
    }
    public void setMentor(Mentor mentor) {
        this.mentor = mentor;
    }
    public Mentor getMentor() {
        return this.mentor;
    }
    public void removeMentor() {
        this.mentor = null;
    }
}
