package storage;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import main.Gender;
import main.Phone;

/**
 * Jackson-friendly version of (@link Customer).
 */
public class JsonAdaptedCustomer {

    public static final String MISSING_FIELD_MESSAGE_FORMAT = "Customer's %s field is missing!";

    private final String name;
    private final Optional<String> ic;
    private final int age;
    private final Gender gender;
    private final Phone phoneNumber;
    private final String occupation;
    private final String address;
    private final List<JsonAdaptedTransaction> transactions = new ArrayList<>();
}
