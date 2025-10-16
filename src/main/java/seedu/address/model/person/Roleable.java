package seedu.address.model.person;

/**
 * Represents a contact that has a role in the address book.
 * Implementing classes (e.g. {@code Person}, {@code Student}, {@code Mentor})
 * should define how their role is represented and returned as a string.
 */
public interface Roleable {
    String getRole();
}
