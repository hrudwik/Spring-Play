package com.foo.kindle;

public class AmazonApp {
    /*
        Insert the following :
         * insert into book (isbn, book_name, price) values ('A0', 'Harry potter', 400);
         * insert into book_stock (isbn, stock) values ('A0', 1);
         * insert into amazon_pay (username, balance) values ('Hermoine', 300), ('Ron', 1000);
         */
    public static void main(String[] args) {
        KindleService kindleService = new KindleServiceImpl();
        boolean hermoinePurchased = kindleService.purchase("A0", "Hermoine");
        System.out.println("Hermoine's purchase went through? " + hermoinePurchased);
        boolean ronPurchased = kindleService.purchase("A0", "Ron");
        System.out.println("Ron's purchase went through? " + ronPurchased);
    }
}
