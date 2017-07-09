package config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.*;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

import javax.sql.DataSource;

/**
 * Created by Администратор on 22.06.2017.
 */

@Configuration
@EnableJpaRepositories("repository")
@ComponentScan("service" /*, "repository"*/)
@Import(TransactionConfig.class)
@PropertySource("classpath:/application.properties")
public class JpaConfig {
    public static final String SCHEMA = "fin";

    @Value("${spring.data.db.url}")
    private String url;

    @Value("${spring.data.db.user}")
    private String user;


    @Value("${spring.data.db.password}")
    private String password;


    @Value("${spring.data.db.driver}")
    private String driverClassName;


    @Value("${spring.data.db.cp.maxSize}")
    private Integer maxPoolSize;


    @Value("${hibernate.hbm2ddl.auto}")
    private String hbm2dll;

    //@Bean
    //@Profile("Dev")
    /*
    DataSource dataSource() {
        DataSource dataSource = new MysqlDataSource();
        dataSource.setURL(url);
        dataSource.setUser(user);
        dataSource.setPassword(password);
        return dataSource;
    }
    */
}

