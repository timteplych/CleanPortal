package ru.ttv.cleanportal;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import ru.ttv.cleanportal.api.ConfigService;
import ru.ttv.cleanportal.config.AppConfig;

/**
 * @author Timofey Teplykh
 */

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = AppConfig.class)
public class PropertiesAccessTest {

    @Autowired
    private ConfigService configService;

    @Test
    public void testTargetDir(){
        Assert.assertEquals(configService.getTargetDir(),"c:/FolderForCleaning");
    }

    @Test
    public void testServiceDir(){
        Assert.assertEquals(configService.getServiceDir(),"c:/ServiceDir");
    }
}
