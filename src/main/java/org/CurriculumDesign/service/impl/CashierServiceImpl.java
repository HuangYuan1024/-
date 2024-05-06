package org.CurriculumDesign.service.impl;

import org.CurriculumDesign.dao.CashierDao;
import org.CurriculumDesign.dao.impl.CashierDaoImpl;
import org.CurriculumDesign.pojo.Cashier;
import org.CurriculumDesign.service.CashierService;

import java.util.List;

/**
 * 收银员数据的CRUD操作的实现类
 *
 *
 */
public class CashierServiceImpl implements CashierService {

    // 持久层对象
    private final CashierDao dao = new CashierDaoImpl();

    /**
     * 增加数据
     *
     * @param cashier 收银员
     */
    @Override
    public void insertCashier(Cashier cashier) {
        dao.insertCashier(cashier);
    }

    /**
     * 查找数据
     *
     * @param account 账号
     */
    @Override
    public Cashier findCashierById(String account) {
        return dao.findCashierById(account);
    }

    /**
     * 查找全部数据
     *
     */
    @Override
    public List<Cashier> findAllCashier() {
        return dao.findAllCashier();
    }

    /**
     * 修改数据
     *
     * @param cashier 收银员
     */
    @Override
    public void updateCashier(Cashier cashier) {
        dao.updateCashier(cashier);
    }

    /**
     * 删除数据
     *
     * @param account 账号
     */
    @Override
    public void deleteCashier(String account) {
        dao.deleteCashier(account);
    }

}
