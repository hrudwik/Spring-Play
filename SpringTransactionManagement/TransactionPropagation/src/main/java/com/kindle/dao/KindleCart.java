package com.kindle.dao;

import java.util.List;

public interface KindleCart {
    public void checkout(List<String> isbns, String username);
}
