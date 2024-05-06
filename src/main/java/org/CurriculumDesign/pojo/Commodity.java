package org.CurriculumDesign.pojo;

/**
 * 商品类
 *
 * @author 黄愿
 */
public class Commodity {

    // 货号
    public String articleNumber;
    // 名称
    public String name;
    // 类别
    public String category;
    // 数量/质量
    public int quantity;
    // 单价
    public float unitPrice;
    // 拿取数量
    public int take;

    public String getArticleNumber() {
        return articleNumber;
    }

    public void setArticleNumber(String articleNumber) {
        this.articleNumber = articleNumber;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public float getUnitPrice() {
        return unitPrice;
    }

    public void setUnitPrice(float unitPrice) {
        this.unitPrice = unitPrice;
    }

    public int getTake() {
        return take;
    }

    public void setTake(int take) {
        this.take = take;
    }

}
