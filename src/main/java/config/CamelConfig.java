package config;

import org.apache.camel.CamelContext;
import org.apache.camel.impl.DefaultCamelContext;
import org.apache.camel.spring.javaconfig.CamelConfiguration;
import org.apacheextras.camel.jboss.JBossPackageScanClassResolver;
import org.springframework.context.annotation.*;

/**
 * Created by Администратор on 17.06.2017.
 */
@Configuration
@ComponentScan("route")
@Import(ActiveMQConfig.class)
public class CamelConfig extends CamelConfiguration{

    //@Profile("jboss")
    /*@Bean
    public CamelContext camelContext() {
        System.out.println("CamelContext is up!!!!!!");
        final CamelContext context =  new DefaultCamelContext();
        //context.setPackageScanClassResolver(new JBossPackageScanClassResolver());
        return context;
    }*/

}
