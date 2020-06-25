package Main;

import java.util.Calendar;

/**
 * A class that represents a transaction
 */
public class Transaction {
    private final int transactionID;
    private final Calendar transactionDate;
    private DataFields transactionData;
    private double price;
    private Status status;

    public Transaction(int transactionID, Calendar transactionDate, DataFields transactionData,
                       double price, Status status){
        this.transactionID = transactionID;
        this.transactionDate = transactionDate;
        this.transactionData = transactionData;
        this.price = price;
        this.status = status;
    }

    public int getTransactionID() {
        return this.transactionID;
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

    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }

        if (!(other instanceof Transaction)) {
            return false;
        }

        Transaction otherTransaction = (Transaction) other;
        return otherTransaction.getTransactionID() == this.getTransactionID()
                && otherTransaction.getTransactionDate().equals(this.getTransactionDate())
                && otherTransaction.getTransactionData().equals(this.getTransactionData())
                && otherTransaction.getPrice() == this.getPrice()
                && otherTransaction.getStatus().equals(this.getStatus());
    }

    @Override
    public String toString() {
        StringBuilder transactionBuilder = new StringBuilder();
        transactionBuilder.append("Transaction ")
                .append(this.getTransactionID())
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
