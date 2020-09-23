package storage;

import static java.util.Objects.requireNonNull;

import java.io.IOException;
import java.nio.file.Path;
import java.util.Optional;

/**
 * A class to access CentralManager data stored as a json file on the hard disk.
 * CentralManager contains all the managers needed.
 */
public class JsonCentralManagerStorage implements CentralManagerStorage {

    private Path filePath;

    public JsonCentralManagerStorage(Path filePath) {
        this.filePath = filePath;
    }

    public Path getManagerFilePath() {
        return filePath;
    }

    public Optional<CentralManager> readManager() throws DataCoversionException, IOException {
        return readManager(filePath);
    }

    public Optional<CentralManager> readManager(Path filePath) throws DataConversionException, IOException {
        requireNonNull(filePath);
        Optional<Json>
    }

    public void saveManager(CentralManager centralManager) throws IOException {

    }

    public void saveManager(CentralManager centralManager, Path filePath) throws IOException {

    }
}
