package seedu.address.model.person;

import seedu.address.model.tag.Tag;

import java.util.Set;

import seedu.address.model.tag.Tag;

/**
 * Represents a Mentor in the address book.
 * Guarantees: details are present and not null, field values are validated.
 */
public class Mentor extends Person {
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
    public Mentor(Name name, Phone phone, Email email, Address address, Remark remark, Set<Tag> tags) {
        super(name, phone, email, address, remark, tags);
    }
}
