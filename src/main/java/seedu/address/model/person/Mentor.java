package seedu.address.model.person;

import java.util.Set;

import seedu.address.commons.util.ToStringBuilder;
import seedu.address.model.tag.Tag;

/**
 * Represents a Mentor in the address book.
 * Guarantees: details are present and not null, field values are validated.
 */
public class Mentor extends Person {

    private final Centre centre;

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
    public Mentor(Name name, Phone phone, Email email, Address address, Remark remark, Set<Tag> tags, Centre centre) {
        super(name, phone, email, address, remark, tags);
        this.centre = centre;
    }

    public Centre getCentre() {
        return centre;
    }

    @Override
    public boolean equals(Object other) {
        return other == this
                || (other instanceof Mentor
                && super.equals(other)
                && centre.equals(((Mentor) other).centre));
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
}
