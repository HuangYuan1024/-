package org.CurriculumDesign.dao;

import org.CurriculumDesign.pojo.Cashier;

import java.util.List;

/**
 * 收银员数据的CRUD操作的接口类
 *
 * @author 黄愿
 *
 */
public interface CashierDao {

    /**
     * 增加数据
     *
     * @param cashier 收银员
     */
    void insertCashier(Cashier cashier);

    /**
     * 查找数据
     *
     * @param account 账号
     */
    Cashier findCashierById(String account);

    /**
     * 查找全部数据
     *
     */
    List<Cashier> findAllCashier();

    /**
     * 修改数据
     *
     * @param cashier 收银员
     */
    void updateCashier(Cashier cashier);

    /**
     * 删除数据
     *
     * @param account 账号
     */
    void deleteCashier(String account);

}
