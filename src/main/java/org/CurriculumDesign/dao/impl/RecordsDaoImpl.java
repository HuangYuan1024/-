package org.CurriculumDesign.dao.impl;

import org.CurriculumDesign.dao.RecordsDao;
import org.CurriculumDesign.pojo.Cashier;
import org.CurriculumDesign.pojo.Records;

import java.util.List;

import static org.CurriculumDesign.util.CRUDUtil.query;
import static org.CurriculumDesign.util.CRUDUtil.update;

/**
 * 会员消费记录数据的CRUD操作的实现类
 *
 *
 */
public class RecordsDaoImpl implements RecordsDao {

    /**
     * 增加数据
     *
     * @param records 会员消费记录
     */
    @Override
    public void insertRecords(Records records) {
        String sql = "INSERT INTO Records(name, cardNumber, price, decreasePoints, increasePoints) VALUES('" + records.getName() + "','" + records.getCardNumber() + "','" + records.getPrice() + "','" + records.getDecreasePoints() + "','" + records.getIncreasePoints() + "')";
        Object[] objects = new Object[] {};
        update(sql, objects);
    }

    /**
     * 查找数据
     *
     * @param cardNumber 卡号
     */
    @Override
    public Records findRecordsById(String cardNumber) {
        String sql = "SELECT * FROM Records WHERE cardNumber = '" + cardNumber + "'";
        Object[] objects = new Object[] {};
        List<Records> list = query(Records.class, sql, objects);
        return list.get(0);
    }

    /**
     * 查找全部数据
     *
     */
    @Override
    public List<Records> findAllRecords() {
        String sql = "SELECT * FROM Records";
        Object[] objects = new Object[] {};
        List<Records> list = query(Records.class, sql, objects);
        return list;
    }

    /**
     * 修改数据
     *
     * @param records 会员消费记录
     */
    @Override
    public void updateRecords(Records records) {
        String sql = "UPDATE Records SET cardNumber = '" + records.getCardNumber() + "', name = '" + records.getName() + "', price = '" + records.getPrice() + "', decreasePoints = '" + records.getDecreasePoints() + "', increasePoints = '" + records.getIncreasePoints() + "' WHERE cardNumber = '" + records.getCardNumber() + "'";
        Object[] objects = new Object[] {};
        update(sql, objects);
    }

    /**
     * 删除数据
     *
     * @param cardNumber 卡号
     */
    @Override
    public void deleteRecords(String cardNumber) {
        String sql = "DELETE FROM Records WHERE cardNumber = '" + cardNumber + "'";
        Object[] objects = new Object[] {};
        update(sql, objects);
    }
}
