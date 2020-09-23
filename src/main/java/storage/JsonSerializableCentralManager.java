package storage;


import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonRootName;

/**
 * Contains all managaers that are serializable to JSON format.
 */
@JsonRootName(value = "CrystalEye")
public class JsonSerializableCentralManager {

    public static final String MESSAGE_DUPLICATE_ENTITY = "%1$s's list contains duplicate(s).";



}
