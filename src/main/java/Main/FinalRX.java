package Main;

public class FinalRX extends RX{

    //DataFields fields
    private String ocht;
    private String lens;
    private String rightVA;
    private String leftVA;
    private String frame;
    private String retinoscopy;
    private String keratometry;
    private String history;

    //Constructor
    public FinalRX(String right, String left, String ocht, String pupillaryDistance, String lens, String addRight,
                   String addLeft, String rightVA, String leftVA, String frame, String retinoscopy, String keratometry,
                   String history) {
        super(right, left, pupillaryDistance, addRight, addLeft);
        this.ocht = ocht;
        this.lens = lens;
        this.rightVA = rightVA;
        this.leftVA = leftVA;
        this.frame = frame;
        this.retinoscopy = retinoscopy;
        this.keratometry = keratometry;
        this.history = history;
    }

    public String getOcht() {
        return this.ocht;
    }
    public String getLens() {
        return this.lens;
    }
    public String getRightVA() {
        return this.rightVA;
    }
    public String getLeftVA() {
        return this.leftVA;
    }
    public String getFrame() {
        return this.frame;
    }
    public String getRetinoscopy() {
        return this.retinoscopy;
    }
    public String getKeratometry() {
        return this.keratometry;
    }
    public String getHistory() {
        return this.history;
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        builder.append(" finalRX: \n ocht: ")
                .append(this.getOcht())
                .append("\n lens: ")
                .append(this.getLens())
                .append("\n rightVA: ")
                .append(this.getRightVA())
                .append("\n leftVA: ")
                .append(this.getLeftVA())
                .append("\n frame: ")
                .append(this.getFrame())
                .append("\n retinoscopy: ")
                .append(this.getRetinoscopy())
                .append("\n keratometry: ")
                .append(this.getKeratometry())
                .append("\n history: ")
                .append(this.getHistory())
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
