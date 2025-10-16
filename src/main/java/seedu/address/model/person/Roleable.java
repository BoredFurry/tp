package seedu.address.model.person;

/**
 * Represents an entity that has a role.
 *
 * This interface should be implemented by any class whose instances are
 * expected to have a specific role, such as a Mentor or Student in the address book.
 */
public interface Roleable {
    /**
     * Returns the role of the entity implementing this interface.
     *
     * @return a {@code String} representing the role.
     */
    String getRole();
}
