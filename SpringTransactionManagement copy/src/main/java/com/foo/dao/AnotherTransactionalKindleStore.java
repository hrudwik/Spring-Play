package com.foo.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Profile;
import org.springframework.jdbc.core.support.JdbcDaoSupport;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.TransactionStatus;
import org.springframework.transaction.support.TransactionCallbackWithoutResult;
import org.springframework.transaction.support.TransactionTemplate;

import javax.sql.DataSource;

@Repository
@Profile("kindleStoreWithTransactionTemplate")
public class AnotherTransactionalKindleStore extends JdbcDaoSupport implements KindleStore {

    @Autowired
    private TransactionTemplate transactionTemplate;

    @Autowired
    public AnotherTransactionalKindleStore(DataSource dataSource) {
        setDataSource(dataSource);
    }

    @Override
    public void purchase(String isbn, String userName) {
        // Here we have no value to return so TransactionCallbackWithoutResult is fine.
        transactionTemplate.execute(new TransactionCallbackWithoutResult() {

            @Override
            protected void doInTransactionWithoutResult(TransactionStatus status) {
                purchaseDaoActions(isbn, userName);
            }
        });
    }
}
