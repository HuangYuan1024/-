package org.CurriculumDesign.dao.impl;

import org.CurriculumDesign.dao.CashierDao;
import org.CurriculumDesign.pojo.Cashier;

import java.util.List;

import static org.CurriculumDesign.util.CRUDUtil.update;
import static org.CurriculumDesign.util.CRUDUtil.query;

/**
 * 收银员数据的CRUD操作的实现类
 *
 * @author 黄愿
 *
 */
public class CashierDaoImpl implements CashierDao {

    /**
     * 增加数据
     *
     * @param cashier 收银员
     */
    @Override
    public void insertCashier(Cashier cashier) {
        String sql = "INSERT INTO Cashier(name, account, password) VALUES('" + cashier.getName() + "','" + cashier.getAccount() + "','" + cashier.getPassword() + "')";
        Object[] objects = new Object[] {};
        update(sql, objects);
    }

    /**
     * 查找数据
     *
     * @param account 账号
     */
    @Override
    public Cashier findCashierById(String account) {
        String sql = "SELECT * FROM Cashier WHERE account = '" + account + "'";
        Object[] objects = new Object[] {};
        List<Cashier> list = query(Cashier.class, sql, objects);
        return list.get(0);
    }

    /**
     * 修改数据
     *
     * @param cashier 收银员
     */
    @Override
    public void updateCashier(Cashier cashier) {
        String sql = "UPDATE Cashier SET name = '" + cashier.getName() + "', account = '" + cashier.getAccount() + "', password = '" + cashier.getPassword() + "' WHERE account = '" + cashier.getAccount() + "'";
        Object[] objects = new Object[] {};
        update(sql, objects);
    }

    /**
     * 删除数据
     *
     * @param account 账号
     */
    @Override
    public void deleteCashier(String account) {
        String sql = "DELETE FROM Cashier WHERE account = '" + account + "'";
        Object[] objects = new Object[] {};
        update(sql, objects);
    }

}
