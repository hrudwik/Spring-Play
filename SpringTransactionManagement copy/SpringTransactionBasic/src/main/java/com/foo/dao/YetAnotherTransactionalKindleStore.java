package com.foo.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Profile;
import org.springframework.jdbc.core.support.JdbcDaoSupport;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.transaction.annotation.Transactional;

import javax.sql.DataSource;

@Repository
@Profile("kindleStoreWithTransactionalAnnotation")
public class YetAnotherTransactionalKindleStore extends JdbcDaoSupport implements KindleStore {

    @Autowired
    public YetAnotherTransactionalKindleStore(DataSource dataSource) {
        setDataSource(dataSource);
    }

    @Override
    @Transactional
    public void purchase(String isbn, String userName) {
        purchaseDaoActions(isbn, userName);
    }
}
