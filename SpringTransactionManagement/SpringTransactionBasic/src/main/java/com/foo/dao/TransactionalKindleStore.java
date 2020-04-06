package com.foo.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Profile;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.support.JdbcDaoSupport;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.TransactionDefinition;
import org.springframework.transaction.TransactionStatus;
import org.springframework.transaction.support.DefaultTransactionDefinition;

import javax.sql.DataSource;

@Profile("kindleStoreWithTransactionManagerAPI")
@Repository
public class TransactionalKindleStore extends JdbcDaoSupport implements KindleStore {

    @Autowired
    private PlatformTransactionManager platformTransactionManager;

    @Autowired
    public TransactionalKindleStore(DataSource dataSource) {
        setDataSource(dataSource);
    }

    @Override
    public void purchase(String isbn, String userName) {
        TransactionDefinition definition = new DefaultTransactionDefinition();
        TransactionStatus status = platformTransactionManager.getTransaction(definition);

        try {
            purchaseDaoActions(isbn, userName);
            platformTransactionManager.commit(status);
        } catch (Throwable e) {
            platformTransactionManager.rollback(status);
            throw e;
        }

    }
}
