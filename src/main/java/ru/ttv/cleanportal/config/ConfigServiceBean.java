package ru.ttv.cleanportal.config;

import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;
import ru.ttv.cleanportal.api.ConfigService;

/**
 * @author Timofey Teplykh
 */
@Component
@PropertySource(value = "classpath:app.properties")
public class ConfigServiceBean implements ConfigService {

}
