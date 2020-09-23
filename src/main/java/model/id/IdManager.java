package model.id;

/**
 * keeps a record of the last unique id used by (@link Customer).
 */
public class IdManager {

    // all unique ids start with 1
    private int lastCustomerId = 0;

    public IdManager() {
    }

    public IdManager(int lastCustomerId) {
        this.lastCustomerId = lastCustomerId;
    }

    // getters for storage
    public int getLastCustomerId() {
        return lastCustomerId;
    }

    public int getNextCustomerId() {
        return lastCustomerId + 1;
    }

    public void setLastCustomerId(int lastId) {
        lastCustomerId = lastId;
    }

    public void lastCustomerIdPlusOne() {
        lastCustomerId++;
    }

    public boolean isFreshStart() {
        return getLastCustomerId() == 0;
    }

    public void resetIdManager() {
        setLastCustomerId(0);
    }

    /**
     * Checks if unique id is valid.
     * Unique id has to be more than or equal to zero.
     */
    public static boolean isValidId(String id) {
        try {
            int tempInt = Integer.parseInt(id);
            return (tempInt >= 0);
        } catch (NumberFormatException e) {
            return false;
        }
    }

    @Override
    public boolean equals(Object other) {
        return other == this // short circuit if same object
                || (other instanceof IdManager // instanceof handles nulls
                && getLastCustomerId() == ((IdManager)other).getLastCustomerId());
    }
}
