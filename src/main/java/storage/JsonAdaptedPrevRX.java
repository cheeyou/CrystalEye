package storage;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import commons.exceptions.IllegalValueException;
import main.PrevRX;

/**
 * Jackson-friendly version of (@link PrevRX).
 */
public class JsonAdaptedPrevRX {

    public static final String MISSING_FIELD_MESSAGE_FORMAT = "PrevRX's %s field is missing!";

    private String right;
    private String left;
    private String pupillaryDistance;
    private String addRight;
    private String addLeft;
    private String ocht;
    private String lens;
    private String unaided;
    private String binocular;
    private String rightVA;
    private String leftVA;
    private String unaidedRightVA;
    private String unaidedLeftVA;
    private String binocularVA;

    /**
     * Converts a given (@code PrevRX) into this class for Jackson use.
     */
    public JsonAdaptedPrevRX(PrevRX prevRX) {
        right = prevRX.getRight();
        left = prevRX.getLeft();
        pupillaryDistance = prevRX.getPupillaryDistance();
        addRight = prevRX.getAddRight();
        addLeft = prevRX.getAddLeft();
        ocht = prevRX.getOcht();
        lens = prevRX.getLens();
        unaided = prevRX.getUnaided();
        binocular = prevRX.getBinocular();
        rightVA = prevRX.getRightVA();
        leftVA = prevRX.getLeftVA();
        unaidedRightVA = prevRX.getUnaidedRightVA();
        unaidedLeftVA = prevRX.getUnaidedLeftVA();
        binocular = prevRX.getBinocularVA();
    }

    /**
     * Constructs a (@code JsonAdaptedPrevRX) with the given PrevRX details.
     */
    @JsonCreator
    public JsonAdaptedPrevRX(@JsonProperty("right") String right, @JsonProperty("left") String left,
                             @JsonProperty("pupillaryDistance") String pupillaryDistance,
                             @JsonProperty("addRight") String addRight, @JsonProperty("addLeft") String addLeft,
                             @JsonProperty("ocht") String ocht, @JsonProperty("lens") String lens,
                             @JsonProperty("unaided") String unaided, @JsonProperty("binocular") String binocular,
                             @JsonProperty("rightVA") String rightVA, @JsonProperty("leftVA") String leftVA,
                             @JsonProperty("unaidedRightVA") String unaidedRightVA,
                             @JsonProperty("unaidedLeftVA") String unaidedLeftVA,
                             @JsonProperty("binocularVA") String binocularVA) {
        this.right = right;
        this.left = left;
        this.pupillaryDistance = pupillaryDistance;
        this.addRight = addRight;
        this.addLeft = addLeft;
        this.ocht = ocht;
        this.lens = lens;
        this.unaided = unaided;
        this.binocular = binocular;
        this.rightVA = rightVA;
        this.leftVA = leftVA;
        this.unaidedRightVA = unaidedRightVA;
        this.unaidedLeftVA = unaidedLeftVA;
        this.binocularVA = binocularVA;
    }

    /**
     * Converts this Jackson-friendly adapted PrevRX object into the model's (@code PrevRX) object.
     *
     * @throws IllegalValueException if there were any data constraints violated in the adapted PrevRX.
     */
    public PrevRX toModelType() throws IllegalValueException {
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
        if (lens == null) {
            throw new IllegalValueException(String.format(MISSING_FIELD_MESSAGE_FORMAT, "lens"));
        }
        if (unaided == null) {
            throw new IllegalValueException(String.format(MISSING_FIELD_MESSAGE_FORMAT, "unaided"));
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
        if (unaidedRightVA == null) {
            throw new IllegalValueException(String.format(MISSING_FIELD_MESSAGE_FORMAT, "unaidedRightAV"));
        }
        if (unaidedLeftVA == null) {
            throw new IllegalValueException(String.format(MISSING_FIELD_MESSAGE_FORMAT, "unaidedLeftVA"));
        }
        if (binocularVA == null) {
            throw new IllegalValueException(String.format(MISSING_FIELD_MESSAGE_FORMAT, "binocularVA"));
        }
        return new PrevRX(right, left, ocht, pupillaryDistance, lens, addRight, addLeft, unaided, binocular, rightVA,
                leftVA, unaidedRightVA, unaidedLeftVA, binocularVA);
    }
}
