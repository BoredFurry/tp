package seedu.address.model.person;

import java.util.Set;

import seedu.address.commons.util.ToStringBuilder;
import seedu.address.model.tag.Tag;

/**
 * Represents a Student in the address book.
 * Guarantees: details are present and not null, field values are validated.
 */
public class Student extends Person {

    private final Centre centre;
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
     * @param centre
     */
    public Student(Name name, Phone phone, Email email, Address address, Remark remark, Set<Tag> tags, Centre centre) {
        super(name, phone, email, address, remark, tags);
        this.centre = centre;
        this.mentor = null;
    }

    public Centre getCentre() {
        return centre;
    }

    @Override
    public boolean equals(Object other) {
        return other == this
                || (other instanceof Student
                && super.equals(other)
                && centre.equals(((Student) other).centre));
    }

    @Override
    public int hashCode() {
        return centre.hashCode() ^ super.hashCode();
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this)
                .add("name", getName())
                .add("phone", getPhone())
                .add("email", getEmail())
                .add("address", getAddress())
                .add("remark", getRemark())
                .add("tags", getTags())
                .add("centre", centre)
                .toString();
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
