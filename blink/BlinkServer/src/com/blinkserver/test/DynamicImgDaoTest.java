package com.blinkserver.test;

import com.blinkserver.bean.DynamicImgHS;
import com.blinkserver.dao.DynamicImgDao;
import com.blinkserver.exception.OnExceptionListener;

import java.sql.SQLException;

/**
 * Created by abu on 2016/8/29 15:46.
 */
public class DynamicImgDaoTest {

    public static void main(String[] args) {
        final long startTime = System.currentTimeMillis();
        System.out.println("start");

        /**
         * query
         */
        for(DynamicImgHS dynamicImg: DynamicImgDao.queryByDynamicId(3, new OnExceptionListener() {
            @Override
            public void onSQLException(SQLException e) {
                super.onSQLException(e);
                System.out.println("Exception:" + e.toString());
            }
        }))
                System.out.println(dynamicImg.toString());

        /**
         * delete
         */
        System.out.println("result:"+ DynamicImgDao.deleteById(2, new OnExceptionListener() {
            @Override
            public void onSQLException(SQLException e) {
                super.onSQLException(e);
                System.out.println("Exception:" + e.toString());
            }
        }));

        /**
         * insert
         */
        DynamicImgHS dynamicImg = new DynamicImgHS();
        dynamicImg.setDnc_id(3);
        dynamicImg.setDImg_img("www2");
        System.out.println("result:"+ DynamicImgDao.insert(dynamicImg, new OnExceptionListener() {
            @Override
            public void onSQLException(SQLException e) {
                super.onSQLException(e);
                System.out.println("Exception:" + e.toString());
            }
        }));

        System.out.println("end\ntime consuming:"+(System.currentTimeMillis()-startTime));
    }
}
