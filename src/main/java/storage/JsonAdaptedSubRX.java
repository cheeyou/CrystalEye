package storage;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import commons.exceptions.IllegalValueException;
import main.SubRX;

/**
 * Jackson-friendly version of (@link SubRX).
 */
public class JsonAdaptedSubRX {

    public static final String MISSING_FIELD_MESSAGE_FORMAT = "SubRX's %s field is missing!";

    private String right;
    private String left;
    private String pupillaryDistance;
    private String addRight;
    private String addLeft;
    private String binocular;
    private String rightVA;
    private String leftVA;
    private String binocularVA;

    /**
     * Converts a given (@code SubRX) into this class for Jackson use.
     */
    public JsonAdaptedSubRX(SubRX subRX) {
        right = subRX.getRight();
        left = subRX.getLeft();
        pupillaryDistance = subRX.getPupillaryDistance();
        addRight = subRX.getAddRight();
        addLeft = subRX.getAddLeft();
        binocular = subRX.getBinocular();
        rightVA = subRX.getRightVA();
        leftVA = subRX.getLeftVA();
        binocular = subRX.getBinocularVA();
    }

    /**
     * Constructs a (@code JsonAdaptedSubRX) with the given SubRX details.
     */
    @JsonCreator
    public JsonAdaptedSubRX(@JsonProperty("right") String right, @JsonProperty("left") String left,
                            @JsonProperty("pupillaryDistance") String pupillaryDistance,
                            @JsonProperty("addRight") String addRight, @JsonProperty("addLeft") String addLeft,
                            @JsonProperty("binocular") String binocular, @JsonProperty("rightVA") String rightVA,
                            @JsonProperty("leftVA") String leftVA, @JsonProperty("binocularVA") String binocularVA) {
        this.right = right;
        this.left = left;
        this.pupillaryDistance = pupillaryDistance;
        this.addRight = addRight;
        this.addLeft = addLeft;
        this.binocular = binocular;
        this.rightVA = rightVA;
        this.leftVA = leftVA;
        this.binocularVA = binocularVA;
    }

    /**
     * Converts this Jackson-friendly adapted PrevRX object into the model's (@code PrevRX) object.
     *
     * @throws IllegalValueException if there were any data constraints violated in the adapted SubRX.
     */
    public SubRX toModelType() throws IllegalValueException {
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
        if (binocular == null) {
            throw new IllegalValueException(String.format(MISSING_FIELD_MESSAGE_FORMAT, "binocular"));
        }
        if (rightVA == null) {
            throw new IllegalValueException(String.format(MISSING_FIELD_MESSAGE_FORMAT, "rightVA"));
        }
        if (leftVA == null) {
            throw new IllegalValueException(String.format(MISSING_FIELD_MESSAGE_FORMAT, "leftVA"));
        }
        if (binocularVA == null) {
            throw new IllegalValueException(String.format(MISSING_FIELD_MESSAGE_FORMAT, "binocularVA"));
        }
        return new SubRX(right, left, pupillaryDistance, addRight, addLeft, binocular, rightVA,
                leftVA, binocularVA);
    }
}
