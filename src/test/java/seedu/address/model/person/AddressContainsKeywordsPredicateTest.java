package seedu.address.model.person;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import org.junit.jupiter.api.Test;

import seedu.address.testutil.PersonBuilder;

public class AddressContainsKeywordsPredicateTest {

    @Test
    public void equals() {
        List<String> firstPredicateKeywordList = Collections.singletonList("first");
        List<String> secondPredicateKeywordList = Arrays.asList("first", "second");

        AddressContainsKeywordsPredicate firstPredicate =
                new AddressContainsKeywordsPredicate(firstPredicateKeywordList);
        AddressContainsKeywordsPredicate secondPredicate =
                new AddressContainsKeywordsPredicate(secondPredicateKeywordList);

        // same object -> returns true
        assertTrue(firstPredicate.equals(firstPredicate));

        // same values -> returns true
        AddressContainsKeywordsPredicate firstPredicateCopy =
                new AddressContainsKeywordsPredicate(firstPredicateKeywordList);
        assertTrue(firstPredicate.equals(firstPredicateCopy));

        // different types -> returns false
        assertFalse(firstPredicate.equals(1));

        // null -> returns false
        assertFalse(firstPredicate.equals(null));

        // different person -> returns false
        assertFalse(firstPredicate.equals(secondPredicate));
    }

    @Test
    public void test_addressContainsKeywords_returnsTrue() {
        // One keyword
        AddressContainsKeywordsPredicate predicate =
                new AddressContainsKeywordsPredicate(Collections.singletonList("Geylang"));
        assertTrue(predicate.test(new PersonBuilder().withAddress("Geylang Serangoon").build()));

        // Multiple keywords
        predicate = new AddressContainsKeywordsPredicate(Arrays.asList("Geylang", "Serangoon"));
        assertTrue(predicate.test(new PersonBuilder().withAddress("Geylang Serangoon").build()));

        // Only one matching keyword
        predicate = new AddressContainsKeywordsPredicate(Arrays.asList("Serangoon", "Lorong"));
        assertTrue(predicate.test(new PersonBuilder().withAddress("Geylang Lorong").build()));

        // Mixed-case keywords
        predicate = new AddressContainsKeywordsPredicate(Arrays.asList("GeYlAnG", "SerAnGoon"));
        assertTrue(predicate.test(new PersonBuilder().withAddress("Geylang Serangoon").build()));
    }

    @Test
    public void test_addressDoesNotContainKeywords_returnsFalse() {
        // Zero keywords
        AddressContainsKeywordsPredicate predicate = new AddressContainsKeywordsPredicate(Collections.emptyList());
        assertFalse(predicate.test(new PersonBuilder().withAddress("Geylang").build()));

        // Non-matching keyword
        predicate = new AddressContainsKeywordsPredicate(Arrays.asList("Lorong"));
        assertFalse(predicate.test(new PersonBuilder().withAddress("Geylang Serangoon").build()));

        // Keywords match phone, email and address, but does not match Address
        predicate = new AddressContainsKeywordsPredicate(Arrays.asList("12345", "alice@email.com", "Main", "Street"));
        assertFalse(predicate.test(new PersonBuilder().withName("12345").withPhone("12345")
                .withEmail("alice@email.com").withAddress("Geylang").build()));
    }

    @Test
    public void toStringMethod() {
        List<String> keywords = List.of("keyword1", "keyword2");
        AddressContainsKeywordsPredicate predicate = new AddressContainsKeywordsPredicate(keywords);

        String expected = AddressContainsKeywordsPredicate.class.getCanonicalName() + "{keywords=" + keywords + "}";
        assertEquals(expected, predicate.toString());
    }
}
