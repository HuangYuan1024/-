package org.CurriculumDesign.dao;

import org.CurriculumDesign.pojo.MemberCustomer;

import java.util.List;

/**
 * 会员顾客数据的CRUD操作的接口类
 *
 * @author 黄愿
 *
 */
public interface MemberCustomerDao {

    /**
     * 增加数据
     *
     * @param memberCustomer 会员顾客
     */
    void insertMemberCustomer(MemberCustomer memberCustomer);

    /**
     * 查找数据
     *
     * @param cardNumber 卡号
     */
    MemberCustomer findMemberCustomerById(String cardNumber);

    /**
     * 查找全部数据
     *
     */
    List<MemberCustomer> findAllMemberCustomer();

    /**
     * 修改数据
     *
     * @param memberCustomer 会员顾客
     */
    void updateMemberCustomer(MemberCustomer memberCustomer);

    /**
     * 删除数据
     *
     * @param cardNumber 卡号
     */
    void deleteMemberCustomer(String cardNumber);

}
