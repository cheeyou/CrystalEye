package Main;

public class PrevRX extends RX{

    //DataFields fields
    private String ocht;
    private String lens;
    private String unaided;
    private String binocular;
    private String rightVA;
    private String leftVA;
    private String unaidedRightVA;
    private String unaidedLeftVA;
    private String binocularVA;

    //Constructor
    public PrevRX(String right, String left, String ocht, String pupillaryDistance, String lens, String addRight,
                  String addLeft, String unaided, String binocular, String rightVA, String leftVA,
                  String unaidedRightVA, String unaidedLeftVA, String binocularVA) {
        super(right, left, pupillaryDistance, addRight, addLeft);
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

    public String getOcht() {
        return this.ocht;
    }
    public String getLens() {
        return this.lens;
    }
    public String getUnaided() {
        return this.unaided;
    }
    public String getBinocular() {
        return this.binocular;
    }
    public String getRightVA() {
        return this.rightVA;
    }
    public String getLeftVA() {
        return this.leftVA;
    }
    public String getUnaidedRightVA() {
        return this.unaidedRightVA;
    }
    public String getUnaidedLeftVA() {
        return this.unaidedLeftVA;
    }
    public String getBinocularVA() {
        return this.binocularVA;
    }

    // How do we implement an equal method?

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        builder.append(" prevRX: \n ocht: ")
                .append(this.getOcht())
                .append("\n lens: ")
                .append(this.getLens())
                .append("\n unaided: ")
                .append(this.getUnaided())
                .append("\n binocular ")
                .append(this.getBinocular())
                .append("\n rightVA: ")
                .append(this.getRightVA())
                .append("\n leftVA: ")
                .append(this.getLeftVA())
                .append("\n unaidedRightVA: ")
                .append(this.getUnaidedRightVA())
                .append("\n unaidedLeftVA: ")
                .append(this.getUnaidedLeftVA())
                .append("\n binocularVA: ")
                .append(this.getBinocularVA())
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
