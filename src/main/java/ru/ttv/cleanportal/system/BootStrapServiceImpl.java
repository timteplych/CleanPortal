package ru.ttv.cleanportal.system;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import ru.ttv.cleanportal.api.BootStrapService;
import ru.ttv.cleanportal.api.FileService;

/**
 * @author Timofey Teplykh
 */
@Component
public class BootStrapServiceImpl implements BootStrapService {

    private final FileService fileService;

    @Autowired
    public BootStrapServiceImpl(FileService fileService) {
        this.fileService = fileService;
    }

    @Override
    public void init() {
        fileService.findAndProcess();
    }
}
