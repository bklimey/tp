package seedu.address.model.person;

import java.util.List;
import java.util.Locale;
import java.util.function.Predicate;

/**
 * Tests that a {@code Person}'s {@code Gender} matches any of the keywords given.
 */
public class GenderContainsKeywordsPredicate implements Predicate<Person> {
    private final List<String> keywords;

    public GenderContainsKeywordsPredicate(List<String> keywords) {
        this.keywords = keywords;
    }

    @Override
    public boolean test(Person person) {
        return keywords.stream()
                .anyMatch(keyword -> person.getGender().gender.toLowerCase(Locale.ROOT)
                        .contains(keyword.toLowerCase()));
    }

    @Override
    public boolean equals(Object other) {
        return other == this // short circuit if same object
                || (other instanceof GenderContainsKeywordsPredicate // instanceof handles nulls
                && keywords.equals(((GenderContainsKeywordsPredicate) other).keywords)); // state check
    }

}