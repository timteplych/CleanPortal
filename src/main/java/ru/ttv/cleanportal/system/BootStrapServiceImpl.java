package ru.ttv.cleanportal.system;

import org.springframework.stereotype.Component;
import ru.ttv.cleanportal.api.BootStrapService;

/**
 * @author Timofey Teplykh
 */
@Component
public class BootStrapServiceImpl implements BootStrapService {

    @Override
    public void init() {
        System.out.println("it's working");
    }
}
