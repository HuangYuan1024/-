package org.CurriculumDesign.dao.impl;

import org.CurriculumDesign.dao.MemberCustomerDao;
import org.CurriculumDesign.pojo.MemberCustomer;

import java.util.List;

import static org.CurriculumDesign.util.CRUDUtil.query;
import static org.CurriculumDesign.util.CRUDUtil.update;

/**
 * 会员顾客数据的CRUD操作的实现类
 *
 *
 */
public class MemberCustomerDaoImpl implements MemberCustomerDao {

    /**
     * 增加数据
     *
     * @param memberCustomer 会员顾客
     */
    @Override
    public void insertMemberCustomer(MemberCustomer memberCustomer) {
        String sql = "INSERT INTO MemberCustomer(name, cardNumber, cardPassword, points) VALUES('" + memberCustomer.getName() + "','" + memberCustomer.getCardNumber() + "','" + memberCustomer.getCardPassword() + "','" + memberCustomer.getPoints() + "')";
        Object[] objects = new Object[] {};
        update(sql, objects);
    }

    /**
     * 查找数据
     *
     * @param cardNumber 卡号
     */
    @Override
    public MemberCustomer findMemberCustomerById(String cardNumber) {
        String sql = "SELECT * FROM MemberCustomer WHERE cardNumber = '" + cardNumber + "'";
        Object[] objects = new Object[] {};
        List<MemberCustomer> list = query(MemberCustomer.class, sql, objects);
        return list.get(0);
    }

    /**
     * 查找全部数据
     *
     */
    @Override
    public List<MemberCustomer> findAllMemberCustomer() {
        String sql = "SELECT * FROM MemberCustomer";
        Object[] objects = new Object[] {};
        List<MemberCustomer> list = query(MemberCustomer.class, sql, objects);
        return list;
    }

    /**
     * 修改数据
     *
     * @param memberCustomer 会员顾客
     */
    @Override
    public void updateMemberCustomer(MemberCustomer memberCustomer) {
        String sql = "UPDATE MemberCustomer SET name = '" + memberCustomer.getName() + "', cardNumber = '" + memberCustomer.getCardNumber() + "', cardPassword = '" + memberCustomer.getCardPassword() + "', points = '" + memberCustomer.getPoints() + "' WHERE cardNumber = '" + memberCustomer.getCardNumber() + "'";
        Object[] objects = new Object[] {};
        update(sql, objects);
    }

    /**
     * 删除数据
     *
     * @param cardNumber 卡号
     */
    @Override
    public void deleteMemberCustomer(String cardNumber) {
        String sql = "DELETE FROM MemberCustomer WHERE cardNumber = '" + cardNumber + "'";
        Object[] objects = new Object[] {};
        update(sql, objects);
    }

}
