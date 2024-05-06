package org.CurriculumDesign.pojo;

public class Records {

    public String name;

    public String cardNumber;

    public float price;

    public int decreasePoints;

    public int increasePoints;

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

    public Float getPrice() {
        return price;
    }

    public void setPrice(Float price) {
        this.price = price;
    }

    public int getDecreasePoints() {
        return decreasePoints;
    }

    public void setDecreasePoints(int decreasePoints) {
        this.decreasePoints = decreasePoints;
    }

    public int getIncreasePoints() {
        return increasePoints;
    }

    public void setIncreasePoints(int increasePoints) {
        this.increasePoints = increasePoints;
    }

}
