package commons.core;

import java.util.logging.Logger;

/**
 * Configures and manages loggers and handlers, including their logging level
 * Named {@link Logger}s can be obtained from this class<br>
 * These loggers have been configured to output messages to the console and a {@code .log} file by default,
 *   at the {@code INFO} level. A new {@code .log} file with a new numbering will be created after the log
 *   file reaches 5MB big, up to a maximum of 5 files.<br>
 */
public class LogsCenter {
}
