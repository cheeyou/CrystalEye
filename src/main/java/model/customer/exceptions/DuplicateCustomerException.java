package model.customer.exceptions;

/**
 * Signals that the operation will result in duplicate Customers (Customers are consdiered duplicates if they have the
 * same identity.)
 */
public class DuplicateCustomerException extends RuntimeException {
    public DuplicateCustomerException() {
        super("Operation would result in duplicate customers");
    }
}
