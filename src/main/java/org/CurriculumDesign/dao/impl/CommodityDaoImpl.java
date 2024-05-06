package org.CurriculumDesign.dao.impl;

import org.CurriculumDesign.dao.CommodityDao;
import org.CurriculumDesign.pojo.Commodity;

import java.util.List;

import static org.CurriculumDesign.util.CRUDUtil.query;
import static org.CurriculumDesign.util.CRUDUtil.update;

/**
 * 商品数据的CRUD操作的实现类
 *
 *
 */
public class CommodityDaoImpl implements CommodityDao {

    /**
     * 增加数据
     *
     * @param commodity 商品
     */
    @Override
    public void insertCommodity(Commodity commodity) {
        String sql = "INSERT INTO Commodity(articleNumber, name, category, quantity, unitPrice, take) VALUES('" + commodity.getArticleNumber() + "','" + commodity.getName() + "','" + commodity.getCategory() + "','" + commodity.getQuantity() + "','" + commodity.getUnitPrice() + "','" + commodity.getTake() + "')";
        Object[] objects = new Object[] {};
        update(sql, objects);
    }

    /**
     * 查找数据
     *
     * @param articleNumber 货号
     */
    @Override
    public Commodity findCommodityById(String articleNumber) {
        String sql = "SELECT * FROM Commodity WHERE articleNumber = '" + articleNumber + "'";
        Object[] objects = new Object[] {};
        List<Commodity> list = query(Commodity.class, sql, objects);
        return list.get(0);
    }

    /**
     * 查找全部数据
     *
     */
    @Override
    public List<Commodity> findAllCommodity() {
        String sql = "SELECT * FROM Commodity";
        Object[] objects = new Object[] {};
        List<Commodity> list = query(Commodity.class, sql, objects);
        return list;
    }

    /**
     * 修改数据
     *
     * @param commodity 商品
     */
    @Override
    public void updateCommodity(Commodity commodity) {
        String sql = "UPDATE Commodity SET articleNumber = '" + commodity.getArticleNumber() + "', name = '" + commodity.getName() + "', category = '" + commodity.getCategory() + "', quantity = '" + commodity.getQuantity() + "', unitPrice = '" + commodity.getUnitPrice() + "', take = '" + commodity.getTake() + "' WHERE articleNumber = '" + commodity.getArticleNumber() + "'";
        Object[] objects = new Object[] {};
        update(sql, objects);
    }

    /**
     * 删除数据
     *
     * @param articleNumber 货号
     */
    @Override
    public void deleteCommodity(String articleNumber) {
        String sql = "DELETE FROM Commodity WHERE articleNumber = '" + articleNumber + "'";
        Object[] objects = new Object[] {};
        update(sql, objects);
    }

}
