package storage;

import java.io.FileWriter;
import java.io.IOException;

//import org.json.simple.JSONArray;
//import org.json.simple.JSONObject;

/**
 * A class that takes in latest data at any point in time and writes it into a file for storage
 */
public class Storage {

    private CentralManager centralManager;

    public Storage() {
        this.centralManager = new CentralManager();
    }

    public Storage(CentralManager centralManager) {
        this.centralManager = centralManager;
    }
}
