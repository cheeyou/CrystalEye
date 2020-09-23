package storage;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import commons.exceptions.IllegalValueException;
import main.ProductRX;

/**
 * Jackson-friendly version of (@link ProductRX).
 */
public class JsonAdaptedProductRX {

    public static final String MISSING_FIELD_MESSAGE_FORMAT = "ProductRX's %s field is missing!";

    private String right;
    private String left;
    private String pupillaryDistance;
    private String addRight;
    private String addLeft;
    private String ocht;

    /**
     * Converts a given (@code ProductRX) into this class for Jackson use.
     */
    public JsonAdaptedProductRX(ProductRX productRX) {
        right = productRX.getRight();
        left = productRX.getLeft();
        pupillaryDistance = productRX.getPupillaryDistance();
        addRight = productRX.getAddRight();
        addLeft = productRX.getAddLeft();
        ocht = productRX.getOcht();
    }

    /**
     * Constructs a (@code JsonAdaptedProductRX) with the given ProductRX details.
     */
    @JsonCreator
    public JsonAdaptedProductRX(@JsonProperty("right") String right, @JsonProperty("left") String left,
                                @JsonProperty("pupillaryDistance") String pupillaryDistance,
                                @JsonProperty("addRight") String addRight, @JsonProperty("addLeft") String addLeft,
                                @JsonProperty("ocht") String ocht) {
        this.right = right;
        this.left = left;
        this.pupillaryDistance = pupillaryDistance;
        this.addRight = addRight;
        this.addLeft = addLeft;
        this.ocht = ocht;
    }

    /**
     * Converts this Jackson-friendly adapted ProductRX object into the model's (@code ProductRX) object.
     *
     * @throws IllegalValueException if there were any data constraints violated in the adapted ProductRX.
     */
    public ProductRX toModelType() throws IllegalValueException {
        if (right == null) {
            throw new IllegalValueException(String.format(MISSING_FIELD_MESSAGE_FORMAT, "right"));
        }
        if (left == null) {
            throw new IllegalValueException(String.format(MISSING_FIELD_MESSAGE_FORMAT, "left"));
        }
        if (pupillaryDistance == null) {
            throw new IllegalValueException(String.format(MISSING_FIELD_MESSAGE_FORMAT, "pupillaryDistance"));
        }
        if (addRight == null) {
            throw new IllegalValueException(String.format(MISSING_FIELD_MESSAGE_FORMAT, "addRight"));
        }
        if (addLeft == null) {
            throw new IllegalValueException(String.format(MISSING_FIELD_MESSAGE_FORMAT, "addLeft"));
        }
        if (ocht == null) {
            throw new IllegalValueException(String.format(MISSING_FIELD_MESSAGE_FORMAT, "ocht"));
        }
        return new ProductRX(right, left, ocht, pupillaryDistance, addRight, addLeft);
    }
}
