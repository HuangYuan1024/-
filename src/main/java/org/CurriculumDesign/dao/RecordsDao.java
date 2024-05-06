package org.CurriculumDesign.dao;


import org.CurriculumDesign.pojo.Records;

import java.util.List;

/**
 * 会员消费记录数据的CRUD操作的接口类
 *
 * @author 黄愿
 *
 */
public interface RecordsDao {

    /**
     * 增加数据
     *
     * @param records 会员消费记录
     */
    void insertRecords(Records records);

    /**
     * 查找数据
     *
     * @param cardNumber 卡号
     */
    Records findRecordsById(String cardNumber);

    /**
     * 查找全部数据
     *
     */
    List<Records> findAllRecords();

    /**
     * 修改数据
     *
     * @param records 会员消费记录
     */
    void updateRecords(Records records);

    /**
     * 删除数据
     *
     * @param cardNumber 卡号
     */
    void deleteRecords(String cardNumber);

}
