package ru.ttv.cleanportal.api;

import java.io.IOException;
import java.nio.file.Path;

/**
 * @author Timofey Teplykh
 */
public interface FileService {

    void findAndProcess();

    void processFile(Path file) throws IOException;

    Path getNewPath(Path sourcePath);

}
