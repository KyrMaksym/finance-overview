package config;

/**
 * Created by Администратор on 17.06.2017.
 */

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;

import org.apache.activemq.ActiveMQConnectionFactory;
import org.apache.activemq.camel.component.ActiveMQComponent;
import org.apache.activemq.camel.component.ActiveMQConfiguration;
import org.apache.activemq.pool.PooledConnectionFactory;
import org.apache.camel.CamelContext;
import org.apache.camel.ConsumerTemplate;
import org.apache.camel.ProducerTemplate;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.jms.annotation.EnableJms;
import org.springframework.jms.connection.JmsTransactionManager;

import javax.jms.ConnectionFactory;

/**
 * Created by Bsyvuliak on 12.06.2017.
 */
@Configuration
@EnableJms
@PropertySource("classpath:application.properties")
public class ActiveMQConfig {

    @Value("${spring.activemq.broker-url}")
    private String brokerUrl;

    @Value("${spring.activemq.pool.configuration.max-connections}")
    private Integer maxConnections;

    @Value("${producerTemplateMaximumCacheSize}")
    protected int producerTemplateMaximumCacheSize;

    @Value("${consumerTemplateMaximumCacheSize}")
    protected int consumerTemplateMaximumCacheSize;

    @Value("${jmsConcurrentConsumers}")
    protected int jmsConcurrentConsumers;


    @Bean
    public JmsTransactionManager createJmsTransactionManager(ConnectionFactory connectionFactory) {
        return new JmsTransactionManager(connectionFactory);
    }

    @Bean
    public ActiveMQComponent createJmsComponent(ActiveMQConfiguration activeMQConfiguration) {
        ActiveMQComponent activeMQComponent = new ActiveMQComponent(activeMQConfiguration);
        activeMQComponent.setMaxConcurrentConsumers(jmsConcurrentConsumers);
        return activeMQComponent;
    }

    @Bean
    public ActiveMQConfiguration createActiveMQConfiguration(ConnectionFactory connectionFactory) {
        ActiveMQConfiguration activeMQConfiguration = new ActiveMQConfiguration();
        activeMQConfiguration.setConnectionFactory(connectionFactory);
        return activeMQConfiguration;
    }

    @Bean
    public ProducerTemplate createProducerTemplate(CamelContext camelContext) {
        ProducerTemplate producerTemplate = camelContext.createProducerTemplate(producerTemplateMaximumCacheSize);
        return producerTemplate;
    }

    @Bean
    public ConsumerTemplate createConsumerTemplate(CamelContext camelContext) {
        ConsumerTemplate consumerTemplate = camelContext.createConsumerTemplate(consumerTemplateMaximumCacheSize);
        return consumerTemplate;
    }

    @Bean
    PooledConnectionFactory createPooledConnectionFactory () {

        ActiveMQConnectionFactory activeMQConnectionFactory = new ActiveMQConnectionFactory(brokerUrl);
        PooledConnectionFactory pooledConnectionFactory =new PooledConnectionFactory(activeMQConnectionFactory);
        pooledConnectionFactory.setMaxConnections(maxConnections);
        return pooledConnectionFactory;
    }

}

