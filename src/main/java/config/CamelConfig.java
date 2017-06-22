package config;

import org.apache.camel.CamelContext;
import org.apache.camel.impl.DefaultCamelContext;
import org.apacheextras.camel.jboss.JBossPackageScanClassResolver;
import org.springframework.context.annotation.*;

/**
 * Created by Администратор on 17.06.2017.
 */
@Configuration
@Import(ActiveMQConfig.class)
public class CamelConfig {

    //@Profile("jboss")
    @Bean
    public CamelContext camelContext() {
        System.out.println("CamelContext is up!!!!!!");
        final CamelContext context =  new DefaultCamelContext();
        //context.setPackageScanClassResolver(new JBossPackageScanClassResolver());
        return context;
    }

}
