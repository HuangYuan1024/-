package org.CurriculumDesign.dao;

import org.CurriculumDesign.pojo.Commodity;

/**
 * 商品数据的CRUD操作的接口类
 *
 * @author 黄愿
 *
 */
public interface CommodityDao {

    /**
     * 增加数据
     *
     * @param commodity 商品
     */
    void insertCommodity(Commodity commodity);

    /**
     * 查找数据
     *
     * @param articleNumber 货号
     */
    Commodity findCommodityById(String articleNumber);

    /**
     * 修改数据
     *
     * @param commodity 商品
     */
    void updateCommodity(Commodity commodity);

    /**
     * 删除数据
     *
     * @param articleNumber 货号
     */
    void deleteCommodity(String articleNumber);

}
