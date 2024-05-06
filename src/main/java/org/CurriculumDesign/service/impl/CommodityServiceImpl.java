package org.CurriculumDesign.service.impl;

import org.CurriculumDesign.dao.CommodityDao;
import org.CurriculumDesign.dao.impl.CommodityDaoImpl;
import org.CurriculumDesign.pojo.Commodity;
import org.CurriculumDesign.service.CommodityService;

import java.util.List;

/**
 * 商品数据的CRUD操作的实现类
 *
 *
 */
public class CommodityServiceImpl implements CommodityService {

    public CommodityServiceImpl() {}

    // 持久层对象
    CommodityDao dao = new CommodityDaoImpl();

    /**
     * 增加数据
     *
     * @param commodity 商品
     */
    @Override
    public void insertCommodity(Commodity commodity) {
        dao.insertCommodity(commodity);
    }

    /**
     * 查找数据
     *
     * @param articleNumber 货号
     */
    @Override
    public Commodity findCommodityById(String articleNumber) {
        return dao.findCommodityById(articleNumber);
    }

    /**
     * 查找全部数据
     *
     */
    @Override
    public List<Commodity> findAllCommodity() {
        return dao.findAllCommodity();
    }

    /**
     * 修改数据
     *
     * @param commodity 商品
     */
    @Override
    public void updateCommodity(Commodity commodity) {
        dao.updateCommodity(commodity);
    }

    /**
     * 删除数据
     *
     * @param articleNumber 货号
     */
    @Override
    public void deleteCommodity(String articleNumber) {
        dao.deleteCommodity(articleNumber);
    }

}
