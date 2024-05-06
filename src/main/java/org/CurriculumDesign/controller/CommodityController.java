package org.CurriculumDesign.controller;

import org.CurriculumDesign.pojo.Commodity;
import org.CurriculumDesign.service.CommodityService;
import org.CurriculumDesign.service.impl.CommodityServiceImpl;

import java.util.ArrayList;
import java.util.List;

public class CommodityController {

    private List<String> idList;
    private List<String> nameList;
    private List<String> categoryList;
    private List<Integer> quantityList;
    private List<Float> unitPriceList;
    private List<Float> totalPriceList;

    private List<Integer> takeList;

    public CommodityController() {
        InitialList();
    }

    public List<String> getIdList() {
        return idList;
    }

    public void setIdList(List<String> idList) {
        this.idList = idList;
    }

    public List<String> getNameList() {
        return nameList;
    }

    public void setNameList(List<String> nameList) {
        this.nameList = nameList;
    }

    public List<String> getCategoryList() {
        return categoryList;
    }

    public void setCategoryList(List<String> categoryList) {
        this.categoryList = categoryList;
    }

    public List<Integer> getQuantityList() {
        return quantityList;
    }

    public void setQuantityList(List<Integer> quantityList) {
        this.quantityList = quantityList;
    }

    public List<Float> getUnitPriceList() {
        return unitPriceList;
    }

    public void setUnitPriceList(List<Float> unitPriceList) {
        this.unitPriceList = unitPriceList;
    }

    public List<Float> getTotalPriceList() {
        return totalPriceList;
    }

    public void setTotalPriceList(List<Float> totalPriceList) {
        this.totalPriceList = totalPriceList;
    }

    public List<Integer> getTakeList() {
        return takeList;
    }

    public void setTakeList(List<Integer> takeList) {
        this.takeList = takeList;
    }

    public void InitialList() {
        idList = new ArrayList<>();
        nameList = new ArrayList<>();
        categoryList = new ArrayList<>();
        quantityList = new ArrayList<>();
        unitPriceList = new ArrayList<>();
        totalPriceList = new ArrayList<>();
        takeList = new ArrayList<>();

        CommodityService commodityService = new CommodityServiceImpl();
        List<Commodity> dataList = commodityService.findAllCommodity();
        for (Commodity commodity : dataList) {
            idList.add(commodity.getArticleNumber());
            nameList.add(commodity.getName());
            categoryList.add(commodity.getCategory());
            quantityList.add(commodity.getQuantity());
            unitPriceList.add(commodity.getUnitPrice());
            totalPriceList.add(commodity.getUnitPrice());
            takeList.add(commodity.getTake());
        }
    }


}
