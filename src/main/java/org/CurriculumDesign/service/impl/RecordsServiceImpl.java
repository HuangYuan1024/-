package org.CurriculumDesign.service.impl;

import org.CurriculumDesign.dao.CashierDao;
import org.CurriculumDesign.dao.RecordsDao;
import org.CurriculumDesign.dao.impl.CashierDaoImpl;
import org.CurriculumDesign.dao.impl.RecordsDaoImpl;
import org.CurriculumDesign.pojo.Records;
import org.CurriculumDesign.service.RecordsService;

import java.util.List;

/**
 * 会员消费记录数据的CRUD操作的实现类
 *
 *
 */
public class RecordsServiceImpl implements RecordsService {

    // 持久层对象
    private final RecordsDao dao = new RecordsDaoImpl();

    /**
     * 增加数据
     *
     * @param records 会员消费记录
     */
    @Override
    public void insertRecords(Records records) {
        dao.insertRecords(records);
    }

    /**
     * 查找数据
     *
     * @param cardNumber 卡号
     */
    @Override
    public Records findRecordsById(String cardNumber) {
        return dao.findRecordsById(cardNumber);
    }

    /**
     * 查找全部数据
     *
     */
    @Override
    public List<Records> findAllRecords() {
        return dao.findAllRecords();
    }

    /**
     * 修改数据
     *
     * @param records 会员消费记录
     */
    @Override
    public void updateRecords(Records records) {
        dao.updateRecords(records);
    }

    /**
     * 删除数据
     *
     * @param cardNumber 卡号
     */
    @Override
    public void deleteRecords(String cardNumber) {
        dao.deleteRecords(cardNumber);
    }

}
