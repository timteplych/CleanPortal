package ru.ttv.cleanportal.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;
import ru.ttv.cleanportal.api.ConfigService;

/**
 * @author Timofey Teplykh
 */
@Component
@PropertySource(value = "app.properties")
public class ConfigServiceBean implements ConfigService {

    @Value("${targetDir}")
    private String targetDir;

    @Value("${serviceDir}")
    private String serviceDir;

    @Override
    public String getTargetDir() {
        return targetDir;
    }

    @Override
    public String getServiceDir() {
        return serviceDir;
    }
}
