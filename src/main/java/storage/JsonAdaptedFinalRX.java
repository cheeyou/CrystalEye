package storage;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import commons.exceptions.IllegalValueException;
import main.FinalRX;

/**
 * Jackson-friendly version of (@link FinalRX)
 */
public class JsonAdaptedFinalRX {

    public static final String MISSING_FIELD_MESSAGE_FORMAT = "FinalRX's %s field is missing!";

    private String right;
    private String left;
    private String pupillaryDistance;
    private String addRight;
    private String addLeft;
    private String ocht;
    private String lens;
    private String rightVA;
    private String leftVA;
    private String frame;
    private String retinoscopy;
    private String keratometry;
    private String history;

    /**
     * Converts a given (@code FinalRX) into this class for Jackson use.
     */
    public JsonAdaptedFinalRX(FinalRX finalRX) {
        right = finalRX.getRight();
        left = finalRX.getLeft();
        pupillaryDistance = finalRX.getPupillaryDistance();
        addRight = finalRX.getAddRight();
        addLeft = finalRX.getAddLeft();
        ocht = finalRX.getOcht();
        lens = finalRX.getLens();
        rightVA = finalRX.getRightVA();
        leftVA = finalRX.getLeftVA();
        frame = finalRX.getFrame();
        retinoscopy = finalRX.getRetinoscopy();
        keratometry = finalRX.getKeratometry();
        history = finalRX.getHistory();
    }

    /**
     * Constructs a (@code JsonAdaptedFinalRX) with the given FinalRX details.
     */
    @JsonCreator
    public JsonAdaptedFinalRX(@JsonProperty("right") String right, @JsonProperty("left") String left,
                             @JsonProperty("pupillaryDistance") String pupillaryDistance,
                             @JsonProperty("addRight") String addRight, @JsonProperty("addLeft") String addLeft,
                             @JsonProperty("ocht") String ocht, @JsonProperty("lens") String lens,
                             @JsonProperty("rightVA") String rightVA, @JsonProperty("leftVA") String leftVA,
                             @JsonProperty("frame") String frame, @JsonProperty("retinoscopy") String retinoscopy,
                             @JsonProperty("keratometry") String keratometry, @JsonProperty("history") String history) {
        this.right = right;
        this.left = left;
        this.pupillaryDistance = pupillaryDistance;
        this.addRight = addRight;
        this.addLeft = addLeft;
        this.ocht = ocht;
        this.lens = lens;
        this.rightVA = rightVA;
        this.leftVA = leftVA;
        this.frame = frame;
        this.retinoscopy = retinoscopy;
        this.keratometry = keratometry;
        this.history = history;
    }

    /**
     * Converts this Jackson-friendly adapted PrevRX object into the model's (@code FinalRX) object.
     *
     * @throws IllegalValueException if there were any data constraints violated in the adapted FinalRX.
     */
    public FinalRX toModelType() throws IllegalValueException {
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
        if (rightVA == null) {
            throw new IllegalValueException(String.format(MISSING_FIELD_MESSAGE_FORMAT, "rightVA"));
        }
        if (leftVA == null) {
            throw new IllegalValueException(String.format(MISSING_FIELD_MESSAGE_FORMAT, "leftVA"));
        }
        if (frame == null) {
            throw new IllegalValueException(String.format(MISSING_FIELD_MESSAGE_FORMAT, "frame"));
        }
        if (retinoscopy == null) {
            throw new IllegalValueException(String.format(MISSING_FIELD_MESSAGE_FORMAT, "retinoscopy"));
        }
        if (keratometry == null) {
            throw new IllegalValueException(String.format(MISSING_FIELD_MESSAGE_FORMAT, "keratometry"));
        }
        if (history == null) {
            throw new IllegalValueException(String.format(MISSING_FIELD_MESSAGE_FORMAT, "history"));
        }
        return new FinalRX(right, left, ocht, pupillaryDistance, lens, addRight, addLeft, rightVA,
                leftVA, frame, retinoscopy, keratometry, history);
    }
}
