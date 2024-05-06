package org.CurriculumDesign.service.impl;

import org.CurriculumDesign.dao.MemberCustomerDao;
import org.CurriculumDesign.dao.impl.MemberCustomerDaoImpl;
import org.CurriculumDesign.pojo.MemberCustomer;
import org.CurriculumDesign.service.MemberCustomerService;

import java.util.List;

/**
 * 会员顾客数据的CRUD操作的实现类
 *
 *
 */
public class MemberCustomerServiceImpl implements MemberCustomerService {

    // 持久层对象
    private final MemberCustomerDao dao = new MemberCustomerDaoImpl();

    /**
     * 增加数据
     *
     * @param memberCustomer 会员顾客
     */
    @Override
    public void insertMemberCustomer(MemberCustomer memberCustomer) {
        dao.insertMemberCustomer(memberCustomer);
    }

    /**
     * 查找数据
     *
     * @param cardNumber 卡号
     */
    @Override
    public MemberCustomer findMemberCustomerById(String cardNumber) {
        return dao.findMemberCustomerById(cardNumber);
    }

    /**
     * 查找全部数据
     *
     */
    @Override
    public List<MemberCustomer> findAllMemberCustomer() {
        return dao.findAllMemberCustomer();
    }

    /**
     * 修改数据
     *
     * @param memberCustomer 会员顾客
     */
    @Override
    public void updateMemberCustomer(MemberCustomer memberCustomer) {
        dao.updateMemberCustomer(memberCustomer);
    }

    /**
     * 删除数据
     *
     * @param cardNumber 卡号
     */
    @Override
    public void deleteMemberCustomer(String cardNumber) {
        dao.deleteMemberCustomer(cardNumber);
    }

}
