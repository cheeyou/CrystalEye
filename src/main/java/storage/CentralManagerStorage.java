package storage;

import javax.management.modelmbean.InvalidTargetObjectTypeException;
import java.io.IOException;
import java.nio.file.Path;
import java.util.Optional;

/**
 * Represents a storage for (@link CentralManager).
 */
public interface CentralManagerStorage {

    /**
     * Returns the file path of the data file.
     */
    Path getManagerFilePath();

    /**
     * Returns CentralManagar as a (link ReadOnlyCentralManager). Returns
     * (@code Optional.empty()) if storage file is not found.
     *
     * @throws DataConversionException if the data in storage is not in the expected format.
     * @throws IOException if there was any problem when reading from the storage.
     *
     */
    Optional<CentralManager> readManager() throws DataConversionException, IOException;

    /**
     * @see #readManager()
     */
    Optional<CentralManager> readManager(Path filePath) throws DataConversionException, IOException;

    /**
     * Saves the given (@linl ReadOnlyCentralManager) to the storage.
     *
     * @param centralManager cannot be null
     * @throws IOException if there was any problem writing to the file.
     */
    void saveManager(CentralManager centralManager) throws IOException;

    /**
     *
     * @see #saveManager(CentralManager)
     */
    void saveManager(CentralManager centralManager, Path filePath) throws IOException;
}
