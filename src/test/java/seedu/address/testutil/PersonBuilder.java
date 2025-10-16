package seedu.address.testutil;

import java.util.HashSet;
import java.util.Set;

import seedu.address.model.person.Address;
import seedu.address.model.person.Email;
import seedu.address.model.person.Mentor;
import seedu.address.model.person.Name;
import seedu.address.model.person.Person;
import seedu.address.model.person.Phone;
import seedu.address.model.person.Remark;
import seedu.address.model.person.Student;
import seedu.address.model.tag.Tag;
import seedu.address.model.util.SampleDataUtil;

/**
 * A utility class to help with building Person objects.
 */
public class PersonBuilder {

    public static final String DEFAULT_NAME = "Amy Bee";
    public static final String DEFAULT_PHONE = "85355255";
    public static final String DEFAULT_EMAIL = "amy@gmail.com";
    public static final String DEFAULT_ADDRESS = "123, Jurong West Ave 6, #08-111";
    public static final String DEFAULT_ROLE = "Mentor";
    public static final String DEFAULT_REMARK = "She likes aardvarks.";

    private Name name;
    private Phone phone;
    private Email email;
    private Address address;
    private Remark remark;
    private String role;
    private Set<Tag> tags;

    /**
     * Creates a {@code PersonBuilder} with the default details.
     */
    public PersonBuilder() {
        name = new Name(DEFAULT_NAME);
        phone = new Phone(DEFAULT_PHONE);
        email = new Email(DEFAULT_EMAIL);
        address = new Address(DEFAULT_ADDRESS);
        remark = new Remark(DEFAULT_REMARK);
        role = DEFAULT_ROLE;
        tags = new HashSet<>();
    }

    /**
     * Initializes the PersonBuilder with the data of {@code personToCopy}.
     */
    public PersonBuilder(Person personToCopy) {
        name = personToCopy.getName();
        phone = personToCopy.getPhone();
        email = personToCopy.getEmail();
        address = personToCopy.getAddress();
        remark = personToCopy.getRemark();
        role = personToCopy.getRole();
        tags = new HashSet<>(personToCopy.getTags());
    }

    /**
     * Sets the {@code Name} of the {@code Person} that we are building.
     */
    public PersonBuilder withName(String name) {
        this.name = new Name(name);
        return this;
    }

    /**
     * Parses the {@code tags} into a {@code Set<Tag>} and set it to the {@code Person} that we are building.
     */
    public PersonBuilder withTags(String ... tags) {
        this.tags = SampleDataUtil.getTagSet(tags);
        return this;
    }

    /**
     * Sets the {@code Address} of the {@code Person} that we are building.
     */
    public PersonBuilder withAddress(String address) {
        this.address = new Address(address);
        return this;
    }

    /**
     * Sets the {@code Phone} of the {@code Person} that we are building.
     */
    public PersonBuilder withPhone(String phone) {
        this.phone = new Phone(phone);
        return this;
    }

    /**
     * Sets the {@code Email} of the {@code Person} that we are building.
     */
    public PersonBuilder withEmail(String email) {
        this.email = new Email(email);
        return this;
    }

    /**
     * Sets the {@code Remark} of the {@code Person} that we are building.
     */
    public PersonBuilder withRemark(String remark) {
        this.remark = new Remark(remark);
        return this;
    }

    /**
     * Sets the role of the {@code Person} that we are building.
     */
    public PersonBuilder withRole(String role) {
        this.role = role;
        return this;
    }

    /**
     * Builds and returns a {@link Person} object based on the role of the individual.
     * The method checks the role (either "Mentor" or "Student") and creates the appropriate
     * subclass of {@link Person}. If the role does not match either "Mentor" or "Student",
     * a generic {@link Person} is created.
     *
     * <p>The method uses the following fields to construct the {@link Person} object:</p>
     * <ul>
     *   <li><b>name</b>: The name of the person.</li>
     *   <li><b>phone</b>: The phone number of the person.</li>
     *   <li><b>email</b>: The email address of the person.</li>
     *   <li><b>address</b>: The physical address of the person.</li>
     *   <li><b>remark</b>: Any additional remarks related to the person.</li>
     *   <li><b>tags</b>: A list of tags associated with the person.</li>
     * </ul>
     *
     * @return A {@link Person} object that corresponds to the specified role.
     *         If the role is "Mentor", a {@link Mentor} object is returned.
     *         If the role is "Student", a {@link Student} object is returned.
     *         If the role is neither "Mentor" nor "Student", a generic {@link Person} object is returned.
     */
    public Person build() {
        Person person;

        switch (role) {
        case "Mentor":
            person = new Mentor(name, phone, email, address, remark, tags);
            break;
        case "Student":
            person = new Student(name, phone, email, address, remark, tags);
            break;
        default:
            person = new Person(name, phone, email, address, remark, tags);
        }

        return person;
    }
}
