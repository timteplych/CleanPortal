package ru.ttv.cleanportal;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import ru.ttv.cleanportal.api.BootStrapService;
import ru.ttv.cleanportal.config.AppConfig;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        ApplicationContext ctx = new AnnotationConfigApplicationContext(AppConfig.class);
        BootStrapService bootStrapService = ctx.getBean("bootStrapServiceImpl", BootStrapService.class);
        bootStrapService.init();
    }
}
