package com.asierg.spring.configuration;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabase;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseBuilder;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseType;
import org.springframework.orm.hibernate4.HibernateExceptionTranslator;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.JpaVendorAdapter;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.Database;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import javax.persistence.EntityManagerFactory;
import javax.sql.DataSource;
import java.util.Properties;

@Configuration
@EnableJpaRepositories(basePackages = {"com.asierg.spring"})
@EnableTransactionManagement
public class DataConfig {

    @Configuration
    @Profile("standard")
    static class StandardProfile {

        // Sample
        @Value("${sample.jdbc.driverClassName}")
        private String sampleDriverClassName;
        @Value("${sample.db.url}")
        private String sampleUrl;
        @Value("${sample.db.username}")
        private String sampleUsername;
        @Value("${sample.db.password}")
        private String samplePassword;

        // Hibernate
        @Value("${sample.hibernate.hbm2ddl.auto}")
        private String hibernateAuto;
        @Value("${sample.hibernate.show_sql}")
        private Boolean hibernateShowSql;
        @Value("${sample.jdbc.dialect}")
        private String jdbcDialect;

        @Bean(name = "dataSource")
        public DriverManagerDataSource dataSource() {
            DriverManagerDataSource dataSource = new DriverManagerDataSource();
            dataSource.setDriverClassName(sampleDriverClassName);
            dataSource.setUrl(sampleUrl);
            dataSource.setUsername(sampleUsername);
            dataSource.setPassword(samplePassword);
            return dataSource;
        }

        @Bean
        public JdbcTemplate jdbcTemplate() {
            JdbcTemplate jdbcTemplate = new JdbcTemplate();
            jdbcTemplate.setDataSource(this.dataSource());
            return jdbcTemplate;
        }

        @Bean
        public Properties jpaProperties() {
            Properties ps = new Properties();
            ps.put("hibernate.dialect", jdbcDialect);
            ps.put("hibernate.hbm2ddl.auto", hibernateAuto);
            ps.put("hibernate.show_sql", hibernateShowSql);
            return ps;
        }

        @Bean
        public JpaVendorAdapter jpaVendorAdapter() {
            HibernateJpaVendorAdapter hibernateJpaVendorAdapter = new HibernateJpaVendorAdapter();
            hibernateJpaVendorAdapter.setShowSql(hibernateShowSql);
            hibernateJpaVendorAdapter.setGenerateDdl(true);
            // hibernateJpaVendorAdapter.setDatabase(Database.POSTGRESQL);
            return hibernateJpaVendorAdapter;
        }

        @Bean
        public EntityManagerFactory entityManagerFactory() {

            LocalContainerEntityManagerFactoryBean lcemfb = new LocalContainerEntityManagerFactoryBean();

            lcemfb.setDataSource(this.dataSource());
            lcemfb.setJpaVendorAdapter(this.jpaVendorAdapter());
            lcemfb.setJpaProperties(this.jpaProperties());

            lcemfb.setPackagesToScan(new String[]{"com.asierg.spring"});
            lcemfb.afterPropertiesSet();
            return lcemfb.getObject();
        }

        @Bean
        public PlatformTransactionManager transactionManager() {
            JpaTransactionManager transactionManager = new JpaTransactionManager();
            transactionManager.setEntityManagerFactory(entityManagerFactory());
            return transactionManager;
        }

    }

    @Configuration
    @Profile("test")
    static class TestProfile {

        // Hibernate
        @Value("${sample.hibernate.hbm2ddl.auto}")
        private String hibernateAuto;
        @Value("${sample.hibernate.show_sql}")
        private Boolean hibernateShowSql;
        @Value("${sample.jdbc.dialect}")
        private String jdbcDialect;

        @Bean
        public DataSource dataSource() {
            EmbeddedDatabaseBuilder builder = new EmbeddedDatabaseBuilder();
            EmbeddedDatabase db = builder.setType(EmbeddedDatabaseType.HSQL).build();
            return db;
        }

        @Bean
        public JdbcTemplate jdbcTemplate() {
            JdbcTemplate jdbcTemplate = new JdbcTemplate();
            jdbcTemplate.setDataSource(this.dataSource());
            return jdbcTemplate;
        }

        @Bean
        public Properties jpaProperties() {
            Properties ps = new Properties();
            ps.put("hibernate.hbm2ddl.auto", hibernateAuto);
            ps.put("hibernate.show_sql", hibernateShowSql);
            return ps;
        }

        @Bean
        public JpaVendorAdapter jpaVendorAdapter() {
            HibernateJpaVendorAdapter hibernateJpaVendorAdapter = new HibernateJpaVendorAdapter();
            hibernateJpaVendorAdapter.setShowSql(hibernateShowSql);
            hibernateJpaVendorAdapter.setGenerateDdl(true);
            hibernateJpaVendorAdapter.setDatabase(Database.HSQL);
            return hibernateJpaVendorAdapter;
        }

        @Bean
        public EntityManagerFactory entityManagerFactory() {

            LocalContainerEntityManagerFactoryBean lcemfb = new LocalContainerEntityManagerFactoryBean();

            lcemfb.setDataSource(this.dataSource());
            lcemfb.setJpaVendorAdapter(this.jpaVendorAdapter());
            lcemfb.setJpaProperties(this.jpaProperties());

            lcemfb.setPackagesToScan(new String[]{"com.asierg.spring"});
            lcemfb.afterPropertiesSet();
            return lcemfb.getObject();
        }

        @Bean
        public PlatformTransactionManager transactionManager() {
            JpaTransactionManager transactionManager = new JpaTransactionManager();
            transactionManager.setEntityManagerFactory(entityManagerFactory());
            return transactionManager;
        }

    }

    @Bean
    public HibernateExceptionTranslator hibernateExceptionTranslator() {
        return new HibernateExceptionTranslator();
    }

}
