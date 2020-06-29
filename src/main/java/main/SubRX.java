package main;

public class SubRX extends RX {

    //DataFields fields
    private String binocular;
    private String rightVA;
    private String leftVA;
    private String binocularVA;

    //Constructor
    public SubRX(String right, String left, String pupillaryDistance, String addRight, String addLeft, String binocular,
                 String rightVA, String leftVA, String binocularVA) {
        super(right, left, pupillaryDistance, addRight, addLeft);
        this.binocular = binocular;
        this.rightVA = rightVA;
        this.leftVA = leftVA;
        this.binocularVA = binocularVA;
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
    public String getBinocularVA() {
        return this.binocularVA;
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        builder.append(" subRX: \n binocular ")
                .append(this.getBinocular())
                .append("\n rightVA: ")
                .append(this.getRightVA())
                .append("\n leftVA: ")
                .append(this.getLeftVA())
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
