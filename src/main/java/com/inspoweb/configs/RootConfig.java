package com.inspoweb.configs;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.FilterType;
import org.springframework.dao.annotation.PersistenceExceptionTranslationPostProcessor;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.JpaVendorAdapter;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

import javax.persistence.EntityManagerFactory;
import javax.sql.DataSource;
import java.util.Properties;

import static org.springframework.orm.jpa.vendor.Database.POSTGRESQL;

/**
 * @author mmikilchenko on 24.02.2017.
 */
@Configuration
@EnableJpaRepositories(basePackages = "com.inspoDataBase.jpaUsageDataBase.jpaRepository")
@EnableTransactionManagement
@ComponentScan(basePackages = "com", excludeFilters = {@ComponentScan.Filter(type = FilterType.ANNOTATION, value = EnableWebMvc.class)})
public class RootConfig {
    @Bean
    public DataSource dataSource() {
/*        DriverManagerDataSource ds = new DriverManagerDataSource();
        ds.setDriverClassName("org.postgresql.Driver");
        ds.setUrl("jdbc:postgresql://localhost:5432/postgres");
        ds.setUsername("postgres");
        ds.setPassword("admin");
        Properties props = new Properties();
        props.setProperty("defaultAutoCommit", "true");
        ds.setConnectionProperties(props);
        return ds;*/
        DriverManagerDataSource ds = new DriverManagerDataSource();
        ds.setDriverClassName("org.postgresql.Driver");
        ds.setUrl("jdbc:postgresql://ec2-176-34-111-152.eu-west-1.compute.amazonaws.com:5432/d4lagt4sp55fs2");
        ds.setUsername("actwscmdhhlpxv");
        ds.setPassword("09115b2a249808dd6e7c6b82b293de67ec95139cf15a3ac1bb3a80d8dda93e1d");
        Properties props = new Properties();
        props.setProperty("defaultAutoCommit", "true");
        ds.setConnectionProperties(props);
        return ds;
    }

    @Bean
    @Autowired
    public EntityManagerFactory entityManagerFactory(DataSource dataSource, JpaVendorAdapter jpaVendorAdapter) {
        LocalContainerEntityManagerFactoryBean lcemfBean =
                new LocalContainerEntityManagerFactoryBean();
        lcemfBean.setDataSource(dataSource);
        lcemfBean.setJpaVendorAdapter(jpaVendorAdapter);
        lcemfBean.setPackagesToScan("com.inspoDataBase.entity");

        Properties prop = new Properties();
        prop.setProperty("javax.persistence.validation.mode", "none");
        lcemfBean.setJpaProperties(prop);

        lcemfBean.afterPropertiesSet();
        return lcemfBean.getObject();
    }

    //HibertateJpaVendorAdapter

    @Bean
    public JpaVendorAdapter jpaVendorAdapter() {
        HibernateJpaVendorAdapter jpaVendorAdapter = new HibernateJpaVendorAdapter();
        jpaVendorAdapter.setDatabase(POSTGRESQL);
        jpaVendorAdapter.setShowSql(true);
        jpaVendorAdapter.setDatabasePlatform("org.hibernate.dialect.PostgreSQLDialect");
        jpaVendorAdapter.setGenerateDdl(false);
        return jpaVendorAdapter;
    }

    @Bean
    @Autowired
    public PlatformTransactionManager transactionManager(EntityManagerFactory entityManagerFactory) {
        JpaTransactionManager txManager = new JpaTransactionManager();
        txManager.setEntityManagerFactory(entityManagerFactory);
        return txManager;
    }

    @Bean
    public PersistenceExceptionTranslationPostProcessor exceptionTranslation() {
        return new PersistenceExceptionTranslationPostProcessor();
    }

}
