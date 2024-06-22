package com.choistory.config;

import org.springframework.jdbc.datasource.lookup.AbstractRoutingDataSource;
import org.springframework.transaction.support.TransactionSynchronizationManager;

public class RoutingDataSource extends AbstractRoutingDataSource {

    @Override
    // 현재 데이터베이스 연결을 결정하기 위해 호출하는 메서드
    protected Object determineCurrentLookupKey() {
        // 현재 트랜잭션이 읽기 전용인지 여부를 판단합니다.
        boolean isReadOnly = TransactionSynchronizationManager.isCurrentTransactionReadOnly();
        return isReadOnly ? "replica" : "source";
    }
}