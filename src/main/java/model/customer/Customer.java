package model.customer;

import java.util.NoSuchElementException;
import java.util.Objects;
import java.util.Optional;
import java.util.ArrayList;

import main.Gender;
import main.Phone;
import main.Transaction;

/**
 * Represents a Customer in the storage book.
 * Guarantees: details are present and not null, field values are validated, immutable
 */
public class Customer {

    // Identity fields
    private int id;
    private String name;
    private final Optional<String> ic;
    private int age;
    private Gender gender;
    private Phone phoneNumber;
    private String occupation;

    // Data fields
    private String address;
    private ArrayList<Transaction> transactions;

    public Customer(int id, String name, String ic, int age, Gender gender, Phone phoneNumber, String occupation,
                    String address) {
        this.id = id;
        this.name = name;
        this.ic = Optional.ofNullable(ic);
        this.age = age;
        this.gender = gender;
        this.phoneNumber = phoneNumber;
        this.occupation = occupation;
        this.address = address;
        this.transactions = new ArrayList<>();
    }

    public int getId() {
        return id;
    }
    public String getName() {
        return this.name;
    }

    public String getIc() {
        if (this.ic.isPresent()) {
            return this.ic.get();
        } else {
            throw new NoSuchElementException("IC not found");
        }
    }

    public int getAge() {
        return this.age;
    }

    public Gender getGender() {
        return this.gender;
    }

    public Phone getPhoneNumber() {
        return this.phoneNumber;
    }

    public String getOccupation() {
        return this.occupation;
    }

    public String getAddress() {
        return this.address;
    }

    public ArrayList<Transaction> getTransactions() {
        return this.transactions;
    }

    public void updateAge(int latestAge) {
        this.age = latestAge;
    }
    public void updateGender(Gender newGender) {
        this.gender = newGender;
    }
    public void updatePhoneNumber(Phone latestPhoneNumber) {
        this.phoneNumber = latestPhoneNumber;
    }
    public void updateOccupation(String latestOccupation) {
        this.occupation = latestOccupation;
    }
    public void updateAddress(String latestAddress) {
        this.address = latestAddress;
    }
    public Boolean hasTransaction(Transaction otherTransaction) {
        for (Transaction transaction : this.transactions) {
            if (otherTransaction.equals(transaction)) {
                return true;
            }
        }
        return false;
    }
    public void addTransaction(Transaction transactionToAdd) {
        if (!this.hasTransaction(transactionToAdd)) {
            transactions.add(transactionToAdd);
        }
    }

    //Defines a weaker form of equality
    public boolean isSameCustomer(Customer other) {
        if (other == this) {
            return true;
        }

        return other != null
                && other.getName().equals(this.getName())
                && other.getPhoneNumber().equals(this.getPhoneNumber());
    }

    /**
     * Updates the customer information with an updated replica customer.
     * In this implementation transactions and ic are not modified. Take note.
     */
    public void update(Customer customer) {
        name = customer.name;
        age = customer.age;
        gender = customer.gender;
        phoneNumber = customer.phoneNumber;
        occupation = customer.occupation;
        address = customer.address;
    }

    /**
     * Returns true if both persons have the same identity and data fields.
     * This defines a stronger notion of equality between two persons.
     */
    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }

        if (!(other instanceof Customer)) {
            return false;
        }

        Customer otherPerson = (Customer) other;
        return otherPerson.getName().equals(getName())
                && otherPerson.getIc().equals(getIc())
                && otherPerson.getAge() == getAge()
                && otherPerson.getGender() == getGender()
                && otherPerson.getPhoneNumber().equa
                && otherPerson.getAddress().equals(getAddress())
                && otherPerson.getTags().equals(getTags());
    }

    @Override
    public int hashCode() {
        // use this method for custom fields hashing instead of implementing your own
        return Objects.hash(name, phone, email, address, tags);
    }

    @Override
    public String toString() {
        StringBuilder customerBuilder = new StringBuilder();
        customerBuilder.append(" Customer stats: \n")
                .append(" name: ")
                .append(this.getName())
                .append(" \n ic: ")
                .append(this.getIc())
                .append(" \n age: ")
                .append(this.getAge())
                .append(" \n gender: ")
                .append(this.getGender())
                .append(" \n h/p: ")
                .append(this.getPhoneNumber())
                .append(" \n occupation: ")
                .append(this.getOccupation())
                .append(" \n address: ")
                .append(this.getAddress())
                .append(" \n transaction history: \n");
        for (Transaction transaction : transactions) {
            customerBuilder.append(transaction);
        }
        return customerBuilder.toString();
    }
}
