package main;

import java.util.NoSuchElementException;
import java.util.Optional;

/**
 * A class that manages all the data fields of a particular transaction
 */
public class DataFields {
    private PrevRX prevRX;
    private SubRX subRX;
    private FinalRX finalRX;
    private Optional<ProductRX> productRX;

    public DataFields(PrevRX prevRX, SubRX subRX, FinalRX finalRX, ProductRX productRX) {
        this.prevRX = prevRX;
        this.subRX = subRX;
        this.finalRX = finalRX;
        this.productRX = Optional.ofNullable(productRX);
    }

    public PrevRX getPrevRX() {
        return this.prevRX;
    }
    public SubRX getSubRX() {
        return this.subRX;
    }
    public FinalRX getFinalRX() {
        return this.finalRX;
    }
    public ProductRX getProductRX() throws NoSuchElementException {
        return this.productRX.get();
    }
    //neeed to know how to update data fields
    public void updateData() {

    }

    @Override
    public String toString() {
        StringBuilder dataFieldsBuilder = new StringBuilder();
        dataFieldsBuilder.append(" prevRX: \n")
                .append(this.getPrevRX())
                .append(" subRX: \n")
                .append(this.getSubRX())
                .append(" finalRX: \n")
                .append(this.getFinalRX())
                .append(" productRX: \n")
                .append(this.getProductRX())
                .append("\n");
        return dataFieldsBuilder.toString();
    }
}
