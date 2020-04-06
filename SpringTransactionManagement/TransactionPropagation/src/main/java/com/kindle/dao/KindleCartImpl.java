package com.kindle.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Component
public class KindleCartImpl implements KindleCart {

    @Autowired
    private KindleStore kindleStore;

    @Override
    @Transactional
    public void checkout(List<String> isbns, String username) {
        for(String isbn : isbns) {
            kindleStore.purchase(isbn, username);
        }
    }
}
