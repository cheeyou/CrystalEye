package Main;

import java.util.Optional;

/**
 * Represents an RX used in the data sheet
 */
public class RX {

    //DataFields fields
    private String right;
    private String left;
    private String pupillaryDistance;
    private String addRight;
    private String addLeft;

    //Constructor
    public RX(String right, String left, String pupillaryDistance, String addRight, String addLeft) {
        this.right = right;
        this.left = left;
        this.pupillaryDistance = pupillaryDistance;
        this.addRight = addRight;
        this.addLeft = addLeft;
    }

    public String getRight() {
        return this.right;
    }
    public String getLeft() {
        return this.left;
    }
    public String getPupillaryDistance() {
        return this.pupillaryDistance;
    }
    public String getAddRight() {
        return this.addRight;
    }
    public String getAddLeft() {
        return this.addLeft;
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        builder.append(" RX: \n right: ")
                .append(this.getRight())
                .append("\n left: ")
                .append(this.getLeft())
                .append("\n pupillaryDistance: ")
                .append(this.getPupillaryDistance())
                .append("\n addRight ")
                .append(this.getAddRight())
                .append("\n addLeft: ")
                .append(this.getAddLeft())
                .append("\n");
        return builder.toString();
    }
}
