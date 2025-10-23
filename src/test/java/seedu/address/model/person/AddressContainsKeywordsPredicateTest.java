package seedu.address.model.person;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

import seedu.address.testutil.PersonBuilder;

public class AddressContainsKeywordsPredicateTest {

    @Test
    public void equals() {
        String firstPredicateKeyword = "first";
        String secondPredicateKeyword = "second";

        AddressContainsKeywordsPredicate firstPredicate =
                new AddressContainsKeywordsPredicate(firstPredicateKeyword);
        AddressContainsKeywordsPredicate secondPredicate =
                new AddressContainsKeywordsPredicate(secondPredicateKeyword);

        // same object -> returns true
        assertTrue(firstPredicate.equals(firstPredicate));

        // same values -> returns true
        AddressContainsKeywordsPredicate firstPredicateCopy =
                new AddressContainsKeywordsPredicate(firstPredicateKeyword);
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
                new AddressContainsKeywordsPredicate("Geylang");
        assertTrue(predicate.test(new PersonBuilder().withAddress("Geylang Serangoon").build()));

        // Multiple keywords
        predicate = new AddressContainsKeywordsPredicate("Serangoon");
        assertTrue(predicate.test(new PersonBuilder().withAddress("Geylang Serangoon").build()));

        // Only one matching keyword
        predicate = new AddressContainsKeywordsPredicate("Lorong");
        assertTrue(predicate.test(new PersonBuilder().withAddress("Geylang Lorong").build()));

        // Mixed-case keywords
        predicate = new AddressContainsKeywordsPredicate("GeYlAnG SerAnGoon");
        assertTrue(predicate.test(new PersonBuilder().withAddress("Geylang Serangoon").build()));
    }

    @Test
    public void test_addressDoesNotContainKeywords_returnsFalse() {
        AddressContainsKeywordsPredicate predicate = new AddressContainsKeywordsPredicate("");

        // Non-matching keyword
        predicate = new AddressContainsKeywordsPredicate("Lorong");
        assertFalse(predicate.test(new PersonBuilder().withAddress("Geylang Serangoon").build()));

        // Keywords match phone, email and address, but does not match Address
        predicate = new AddressContainsKeywordsPredicate("12345 alice@email.com Main Street");
        assertFalse(predicate.test(new PersonBuilder().withName("12345").withPhone("12345")
                .withEmail("alice@email.com").withAddress("Geylang").build()));
    }

    @Test
    public void toStringMethod() {
        String keywords = "keyword 1";
        AddressContainsKeywordsPredicate predicate = new AddressContainsKeywordsPredicate(keywords);

        String expected = AddressContainsKeywordsPredicate.class.getCanonicalName() + "{keywords=" + keywords + "}";
        assertEquals(expected, predicate.toString());
    }
}
