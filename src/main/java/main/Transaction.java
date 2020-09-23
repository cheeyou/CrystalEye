package main;

import java.util.Calendar;

/**
 * A class that represents a transaction
 */
public class Transaction {
    private final int transactionId;
    private final Calendar transactionDate;
    private DataFields transactionData;
    private double price;
    private Status status;

    public Transaction(int transactionId, Calendar transactionDate, DataFields transactionData,
                       double price, Status status){
        this.transactionId = transactionId;
        this.transactionDate = transactionDate;
        this.transactionData = transactionData;
        this.price = price;
        this.status = status;
    }

    public int getTransactionId() {
        return this.transactionId;
    }
    public Calendar getTransactionDate() {
        return this.transactionDate;
    }
    public DataFields getTransactionData() {
        return this.transactionData;
    }
    public double getPrice() {
        return this.price;
    }
    public Status getStatus() {
        return this.status;
    }
    public void updateTransactionData(DataFields updatedTransactionData) {
        this.transactionData.updateData();
    }
    public void updatePrice(double newPrice) {
        this.price = newPrice;
    }
    public void updateStatus(Status newStatus) {
        this.status = newStatus;
    }

    public static boolean isValidId(String id) {
        try {
            int tempInt = Integer.parseInt(id);
            return (tempInt > 0);
        } catch (NumberFormatException e) {
            return false;
        }
    }

    public static boolean isValidPrice(String price) {
        try {
            double tempDouble = Double.parseDouble(price);
            return (tempDouble > 0.0);
        } catch (NumberFormatException e) {
            return false;
        }
    }

    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }

        if (!(other instanceof Transaction)) {
            return false;
        }

        Transaction otherTransaction = (Transaction) other;
        return otherTransaction.getTransactionId() == this.getTransactionId()
                && otherTransaction.getTransactionDate().equals(this.getTransactionDate())
                && otherTransaction.getTransactionData().equals(this.getTransactionData())
                && otherTransaction.getPrice() == this.getPrice()
                && otherTransaction.getStatus().equals(this.getStatus());
    }

    @Override
    public String toString() {
        StringBuilder transactionBuilder = new StringBuilder();
        transactionBuilder.append("Transaction ")
                .append(this.getTransactionId())
                .append("\n date: ")
                .append(this.getTransactionDate().toString())
                .append(" \n price (in Ringgit): ")
                .append(this.getPrice())
                .append(" \n status: ")
                .append(this.getStatus())
                .append(this.transactionData);
        return transactionBuilder.toString();
    }
}
