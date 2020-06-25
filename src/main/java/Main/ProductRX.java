package Main;

public class ProductRX extends RX{

    //DataFields fields
    private String ocht;

    //Constructor
    public ProductRX(String right, String left, String ocht, String pupillaryDistance, String addRight,
                     String addLeft) {
        super(right, left, pupillaryDistance, addRight, addLeft);
        this.ocht = ocht;
    }

    public String getOcht() {
        return this.ocht;
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        builder.append(" productRX: \n ocht: ")
                .append(this.getOcht())
                .append("\n right: ")
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
