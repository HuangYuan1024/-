package org.CurriculumDesign.pojo;

/**
 * 会员顾客类
 *
 * @author 黄愿
 */
public class MemberCustomer {

    // 姓名
    private String name;
    // 卡号
    private String cardNumber;
    // 密码
    private String cardPassword;
    // 积分
    private Integer points;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCardNumber() {
        return cardNumber;
    }

    public void setCardNumber(String cardNumber) {
        this.cardNumber = cardNumber;
    }

    public String getCardPassword() {
        return cardPassword;
    }

    public void setCardPassword(String cardPassword) {
        this.cardPassword = cardPassword;
    }

    public Integer getPoints() {
        return points;
    }

    public void setPoints(Integer points) {
        this.points = points;
    }

}
