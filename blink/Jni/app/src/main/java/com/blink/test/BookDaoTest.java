package com.blink.test;

import com.blink.bean.BookHS;
import com.blink.dao.BookDao;
import com.blink.exception.OnExceptionListener;

import java.sql.SQLException;
import java.util.ArrayList;

/**
 * Created by abu on 2016/8/29 15:42.
 */
public class BookDaoTest {

    public static void main(String[] args) {
        /**
         * book query list
         */
        ArrayList<BookHS> list;
        list = BookDao.queryByUserId(30, new OnExceptionListener() {
            @Override
            public void onSQLException(SQLException e) {
                super.onSQLException(e);
                System.out.println("Exception:" + e.toString());
            }
        });
        if(list != null)
            for(BookHS u:list)
                System.out.println("abu::"+u.toString());
        /**
         * book update
         */
        BookHS book = new BookHS();
        book.setBkImg("https://www.baidu.com");
        book.setBkName("loveless");
        book.setBkShare("httpjlnkll");
        book.setBkUnderstanding("最终幻想-克劳德");
        book.setU_id(30);
        book.setBkId(3);
        System.out.println("::"+ BookDao.update(book, new OnExceptionListener() {
            @Override
            public void onSQLException(SQLException e) {
                super.onSQLException(e);
                System.out.println("Exception:" + e.toString());
            }
        }));
        /**
         * book delete
         */
        System.out.println("::"+ BookDao.deleteById(2, new OnExceptionListener() {
            @Override
            public void onSQLException(SQLException e) {
                super.onSQLException(e);
                System.out.println("Exception:" + e.toString());
            }
        }));
        /**
         * book insert
         */
        BookHS book1 = new BookHS();
        book1.setBkImg("https://www.baidu.com");
        book1.setBkName("loveless");
        book1.setBkShare("httpjlnkll");
        book1.setBkUnderstanding("最终幻想-沙菲罗斯");
        book1.setU_id(30);
        System.out.println("::" + BookDao.insert(book1, new OnExceptionListener() {
            @Override
            public void onSQLException(SQLException e) {
                super.onSQLException(e);
                System.out.println("Exception:" + e.toString());
            }
        }));
    }
}
