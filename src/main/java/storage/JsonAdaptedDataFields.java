package storage;

import java.util.NoSuchElementException;
import java.util.Optional;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import commons.exceptions.IllegalValueException;
import main.DataFields;
import main.FinalRX;
import main.PrevRX;
import main.ProductRX;
import main.SubRX;

/**
 * Jackson-friendly version of (@link DataFields).
 */
public class JsonAdaptedDataFields {

    public static final String MISSING_FIELD_MESSAGE_FORMAT = "DataFields's %s field is missing!";

    private final PrevRX prevRX;
    private final SubRX subRX;
    private final FinalRX finalRX;
    private final Optional<ProductRX> productRX;

    /**
     * Converts a given (@code DataFields) into this class for Jackson use.
     */
    public JsonAdaptedDataFields(DataFields dataFields) {
        this.prevRX = dataFields.getPrevRX();
        this.subRX = dataFields.getSubRX();
        this.finalRX = dataFields.getFinalRX();
        this.productRX = dataFields.getProductRX();
    }

    /**
     * Constructs a (@code JsonAdaptedDataFields) with the given data fields details.
     */
    @JsonCreator
    public JsonAdaptedDataFields(@JsonProperty("prevRX") PrevRX prevRX, @JsonProperty("subRX") SubRX subRX,
                                 @JsonProperty("finalRX") FinalRX finalRX,
                                 @JsonProperty("productRX") Optional<ProductRX> productRX) {
        this.prevRX = prevRX;
        this.subRX = subRX;
        this.finalRX = finalRX;
        this.productRX = productRX;
    }

    /**
     * Converts this Jackson-friendly adapted tag object into the model's {@code DataFields} object.
     *
     * @throws IllegalValueException if there were any data constraints violated in the adapted tag.
     */
    public DataFields toModelType() throws IllegalValueException {
        if (prevRX == null) {
            throw new IllegalValueException(String.format(MISSING_FIELD_MESSAGE_FORMAT, "PrevRX"));
        }
        if (subRX == null) {
            throw new IllegalValueException(String.format(MISSING_FIELD_MESSAGE_FORMAT, "SubRX"));
        }
        if (finalRX == null) {
            throw new IllegalValueException(String.format(MISSING_FIELD_MESSAGE_FORMAT, "FinalRX"));
        }
        if (productRX == null) {
            throw new IllegalValueException(String.format(MISSING_FIELD_MESSAGE_FORMAT, "ProductRX"));
        }
        try {
            ProductRX temp = productRX.get();
            return new DataFields(prevRX, subRX, finalRX, temp);
        } catch (NoSuchElementException e) {
            return new DataFields(prevRX, subRX, finalRX, null);
        }
    }
}
