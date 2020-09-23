package storage;

import java.io.FileWriter;
import java.io.IOException;

//import org.json.simple.JSONArray;
//import org.json.simple.JSONObject;


public interface Storage extends Centra{

    private CentralManager centralManager;

    public Storage() {
        this.centralManager = new CentralManager();
    }

    public Storage(CentralManager centralManager) {
        this.centralManager = centralManager;
    }
}
