package storage;

import java.util.Calendar;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import commons.exceptions.IllegalValueException;
import main.DataFields;
import main.Status;
import main.Transaction;

/**
 * Jackson-friendly version of (@link Transaction).
 */
public class JsonAdaptedTransaction {

    public static final String MISSING_FIELD_MESSAGE_FORMAT = "Transaction's %s field is missing!";
    public static final String INVALID_INTEGER_ID = "Transaction's %s field has a invalid integer id.";

    // Using String data type for fields to accommodate null values and prevent precision loss.
    private final String transactionId;
    private final String transactionDate;
    private final JsonAdaptedDataFields transactionData;
    private final String price;
    private final String status;

    /**
     * Converts a given (@code Transaction) into this class for Jackson use.
     */
    public JsonAdaptedTransaction(Transaction transaction) {
        transactionId = String.valueOf(transaction.getTransactionId());
        transactionDate = transaction.getTransactionDate().toString();
        transactionData = new JsonAdaptedDataFields(transaction.getTransactionData());
        price = String.valueOf(transaction.getPrice());
        status = transaction.getStatus().toString();
    }

    /**
     * Constructs a (@code JsonAdaptedTransaction) with the given transaction details.
     */
    @JsonCreator
    public JsonAdaptedTransaction(@JsonProperty("transactionId") String transactionID,
                                  @JsonProperty("transactionDate") String transactionDate,
                                  @JsonProperty("transactionData") JsonAdaptedDataFields transactionData,
                                  @JsonProperty("price") String price, @JsonProperty("Status") String status) {
        this.transactionId = transactionID;
        this.transactionDate = transactionDate;
        this.transactionData = transactionData;
        this.price = price;
        this.status = status;
    }

    /**
     * Converts this Jackson-friendly adapted transaction object into the model's (@code Transaction) object.
     *
     * @throws IllegalValueException if there were any data constraints violated in the adapted task.
     */
    public Transaction toModelType() throws IllegalValueException {
        // transactionId ====================================================
        if (transactionId == null) {
            throw new IllegalValueException(String.format(MISSING_FIELD_MESSAGE_FORMAT,
                    Transaction.class.getSimpleName() + " Id"));
        }
        if (!Transaction.isValidId(transactionId)) {
            throw new IllegalValueException(String.format(INVALID_INTEGER_ID,
                    Transaction.class.getSimpleName() + " Id"));
        }
        final int modelTransactionId = Integer.parseInt(transactionId);

        // transactionDate ====================================================
        if (transactionDate == null) {
            throw new IllegalValueException(String.format(MISSING_FIELD_MESSAGE_FORMAT,
                    Calendar.class.getSimpleName()));
        }

        // transactionData ====================================================
        if (transactionData == null) {
            throw new IllegalValueException(String.format(MISSING_FIELD_MESSAGE_FORMAT,
                    DataFields.class.getSimpleName()));
        }
        final DataFields modelTransactionData = transactionData.toModelType();

        // price ==============================================================
        if (price == null) {
            throw new IllegalValueException(String.format(MISSING_FIELD_MESSAGE_FORMAT,
                    "price"));
        }
        if (!Transaction.isValidPrice(price)) {
            throw new IllegalValueException("Transaction's price is not valid.")
        }
        final double modelPrice = Double.parseDouble(price);

        Transaction transaction = new Transaction(modelTransactionId, , modelTransactionData, modelPrice, Status.PENDING);

        // if status is pending, then ignore, because by default it is incomplete
        if (status.equals(Status.READYFORCOLLECTION.toString())) {
            transaction.updateStatus(Status.READYFORCOLLECTION);
        } else if (status.equals(Status.DONE.toString())) {
            transaction.updateStatus(Status.DONE);
        }

        return transaction;
    }
}
