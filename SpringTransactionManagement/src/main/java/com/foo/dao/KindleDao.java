package com.foo.dao;

import com.foo.domain.AmazonPay;
import com.foo.domain.Book;
import com.foo.domain.BookStock;

import java.util.List;

public interface KindleDao {
    boolean insertBook(Book book);

    boolean insertBookStock(BookStock bookStock);

    boolean insertAccount(AmazonPay amazonPay);

    void deleteAllBookAndStock();

    void deleteAllAccounts();

    List<Book> selectAllBooks();

    List<BookStock> selectAllBookStocks();

    List<AmazonPay> selectAllAmazonPay();
}
