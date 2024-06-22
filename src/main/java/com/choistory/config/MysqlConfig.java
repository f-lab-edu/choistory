package com.choistory.config;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.jdbc.datasource.LazyConnectionDataSourceProxy;

import javax.sql.DataSource;
import java.util.Map;

@Configuration
public class MysqlConfig {
    public final String SOURCE_DATASOURCE="sourceDataSource";
    public final String REPLICA_DATASOURCE="replicaDataSource";

    @Bean(SOURCE_DATASOURCE)
    @ConfigurationProperties(prefix = "spring.datasource.source.hikari")
    public DataSource sourceDataSource() {
        return DataSourceBuilder.create().build();
    }

    @Bean(REPLICA_DATASOURCE)
    @ConfigurationProperties(prefix = "spring.datasource.replica.hikari")
    public DataSource replicaDataSource() {
        return DataSourceBuilder.create().build();
    }

    @Bean
    public DataSource routingDataSource(@Qualifier(SOURCE_DATASOURCE) DataSource sourceDataSource,
                                        @Qualifier(REPLICA_DATASOURCE) DataSource replicaDataSource) {

        RoutingDataSource routingDataSource = new RoutingDataSource();
        Map<Object, Object> immutableDataSourceMap = Map.of("source", sourceDataSource, "replica", replicaDataSource);

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
