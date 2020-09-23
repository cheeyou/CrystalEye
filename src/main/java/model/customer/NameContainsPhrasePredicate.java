package model.customer;

import java.util.function.Predicate;

import commons.util.StringUtil;

public class NameContainsPhrasePredicate implements Predicate<Customer> {
    private final String phrase;

    public NameContainsPhrasePredicate(String phrase) {
        this.phrase = phrase;
    }

    @Override
    public boolean test(Customer customer) {
        return StringUtil.containsPhraseIgnoreCase(customer.getName(), this.phrase);
    }

    @Override
    public boolean equals(Object other) {
        return other == this // short circuit if same object
                || (other instanceof NameContainsPhrasePredicate // instanceof handles nulls
                && phrase.equals(((NameContainsPhrasePredicate) other).phrase)); // state check
    }
}
