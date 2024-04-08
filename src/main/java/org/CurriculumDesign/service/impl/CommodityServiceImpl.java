package org.CurriculumDesign.service.impl;

import org.CurriculumDesign.dao.CommodityDao;
import org.CurriculumDesign.dao.impl.CommodityDaoImpl;
import org.CurriculumDesign.pojo.Commodity;
import org.CurriculumDesign.service.CommodityService;

/**
 * 商品数据的CRUD操作的实现类
 *
 * @author 黄愿
 *
 */
public class CommodityServiceImpl implements CommodityService {

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
