package Main;

import java.util.NoSuchElementException;
import java.util.Optional;
import java.util.ArrayList;

public class Customer {
    private final String name;
    private final Optional<String> ic;
    private int age;
    private Gender gender;
    private Phone phoneNumber;
    private String occupation;
    private String address;
    private ArrayList<Transaction> transactions;

    public Customer(String name, String ic, int age, Gender gender, Phone phoneNumber, String occupation,
                    String address) {
        this.name = name;
        this.ic = Optional.ofNullable(ic);
        this.age = age;
        this.gender = gender;
        this.phoneNumber = phoneNumber;
        this.occupation = occupation;
        this.address = address;
        this.transactions = new ArrayList<>();
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
