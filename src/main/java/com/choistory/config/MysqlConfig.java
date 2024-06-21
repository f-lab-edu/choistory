package com.choistory.config;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.jdbc.datasource.LazyConnectionDataSourceProxy;

import javax.sql.DataSource;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

@Configuration
public class MysqlConfig {
    public final String SOURCE_DATASOURCE="sourceDataSource";
    public final String REPLICA_DATASOURCE="replicaDataSource";

    @Value("${spring.datasource.source.hikari.driver-class-name}")
    private String sourceDriverClassName;

    @Value("${spring.datasource.source.hikari.url}")
    private String sourceJdbcUrl;

    @Value("${spring.datasource.source.hikari.username}")
    private String sourceUsername;

    @Value("${spring.datasource.source.hikari.password}")
    private String sourcePassword;

    @Value("${spring.datasource.replica.hikari.driver-class-name}")
    private String replicaDriverClassName;

    @Value("${spring.datasource.replica.hikari.url}")
    private String replicaJdbcUrl;

    @Value("${spring.datasource.replica.hikari.username}")
    private String replicaUsername;

    @Value("${spring.datasource.replica.hikari.password}")
    private String replicaPassword;

    @Bean(SOURCE_DATASOURCE)
    public DataSource masterDataSource() {
        return DataSourceBuilder.create()
            .driverClassName(sourceDriverClassName)
            .url(sourceJdbcUrl)
            .username(sourceUsername)
            .password(sourcePassword)
            .build();
    }

    @Bean(REPLICA_DATASOURCE)
    public DataSource slaveDataSource() {
        return DataSourceBuilder.create()
            .driverClassName(replicaDriverClassName)
            .url(replicaJdbcUrl)
            .username(replicaUsername)
            .password(replicaPassword)
            .build();
    }

    @Bean
    public DataSource routingDataSource(@Qualifier(SOURCE_DATASOURCE) DataSource sourceDataSource,
                                        @Qualifier(REPLICA_DATASOURCE) DataSource replicaDataSource) {

        RoutingDataSource routingDataSource = new RoutingDataSource();

        Map<Object, Object> dataSourceMap = new HashMap<>();
        dataSourceMap.put("source", sourceDataSource);
        dataSourceMap.put("replica", replicaDataSource);

        Map<Object, Object> immutableDataSourceMap = Collections.unmodifiableMap(dataSourceMap);

        routingDataSource.setTargetDataSources(immutableDataSourceMap);
        routingDataSource.setDefaultTargetDataSource(sourceDataSource);

        return routingDataSource;
    }

    @Primary
    @Bean
    public DataSource dataSource(@Qualifier("routingDataSource") DataSource routingDataSource) {
        return new LazyConnectionDataSourceProxy(routingDataSource);
    }
}
