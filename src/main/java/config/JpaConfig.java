package config;

import java.sql.*;

import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;
import oracle.jdbc.pool.OracleDataSource;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.*;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.orm.jpa.JpaVendorAdapter;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.Database;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;

import javax.sql.DataSource;

/**
 * Created by Администратор on 22.06.2017.
 */

@Configuration
@EnableJpaRepositories("repository")
@ComponentScan({"service", "repository"})
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

    @Bean
    //@Profile("Dev")
    DataSource dataSource() throws SQLException {
        OracleDataSource dataSource = new OracleDataSource();
        dataSource.setURL(url);
        dataSource.setUser(user);
        dataSource.setPassword(password);
        /*
        ds.setDriverType("thin");
        ds.setServerName("dssw2k01");
        ds.setPortNumber(1521);
        ds.setDatabaseName("orcl"); // sid
        ds.setUser("scott");
        ds.setPassword("tiger");
        */
        return dataSource;
    }

    //@Bean
    //@Profile("Dev")                                                                                                                                                                                                                        b b
    DataSource pooledDataSource(HikariConfig config) {
        return new HikariDataSource(config);
    }

    @Bean
    //@Profile("Dev")
    HikariConfig hikariConfig() {
        System.out.println("hikariConfig");
        HikariConfig hikariConfig = new HikariConfig();
        hikariConfig.setJdbcUrl(url);
        hikariConfig.setUsername(user);
        hikariConfig.setPassword(password);
        hikariConfig.setDriverClassName(driverClassName);
        hikariConfig.setMaximumPoolSize(maxPoolSize);
        hikariConfig.setPoolName("springHikariCP");
        hikariConfig.setConnectionTestQuery("SELECT 1");
        System.out.println("end hikariConfig");
        return hikariConfig;
    }

    @Bean
    //@Profile("Dev")
    JpaVendorAdapter jpaVendorAdapter() {
        System.out.println("jpaVendorAdapter");
        HibernateJpaVendorAdapter adapter = new HibernateJpaVendorAdapter();
        adapter.setDatabase(Database.ORACLE);
        adapter.setShowSql(true);

        adapter.setGenerateDdl(false);
        adapter.setDatabasePlatform("org.hibernate.dialect.Oracle12cDialect");

        return adapter;
    }

    @Bean("entityManagerFactory")
    //@Profile("Dev")
    LocalContainerEntityManagerFactoryBean localContainerEMF(DataSource dataSource, JpaVendorAdapter jpaVendorAdapter) {
        System.out.println("entityManagerFactory");
        LocalContainerEntityManagerFactoryBean lcmfb = new LocalContainerEntityManagerFactoryBean();
        lcmfb.setDataSource(dataSource);
        lcmfb.setJpaVendorAdapter(jpaVendorAdapter);
        lcmfb.setPersistenceUnitName("oraclePersistence");
        lcmfb.setPackagesToScan("persistence");

        return lcmfb;
    }
}

