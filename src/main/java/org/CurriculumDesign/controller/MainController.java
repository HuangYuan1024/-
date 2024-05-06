package org.CurriculumDesign.controller;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.scene.AccessibleAttribute;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.control.cell.TextFieldListCell;
import javafx.scene.layout.AnchorPane;
import javafx.scene.paint.Paint;
import org.CurriculumDesign.pojo.BillCell;
import org.CurriculumDesign.pojo.Commodity;
import org.CurriculumDesign.pojo.MemberCustomer;
import org.CurriculumDesign.pojo.Records;
import org.CurriculumDesign.service.CommodityService;
import org.CurriculumDesign.service.MemberCustomerService;
import org.CurriculumDesign.service.RecordsService;
import org.CurriculumDesign.service.impl.CommodityServiceImpl;
import org.CurriculumDesign.service.impl.MemberCustomerServiceImpl;
import org.CurriculumDesign.service.impl.RecordsServiceImpl;
import org.CurriculumDesign.util.RegExUtil;
import org.CurriculumDesign.util.StringUtil;

import java.util.ArrayList;
import java.util.List;

public class MainController {

    @FXML
    public Button cashier;

    @FXML
    public Button memberCustomer;

    @FXML
    public AnchorPane cashierPage;

    @FXML
    public AnchorPane recordsPage;

    CommodityController commodityController;

    @FXML
    public ListView<String> commodityList;

    @FXML
    public ListView<String> quantityList;

    @FXML
    public ListView<String> unitPriceList;

    @FXML
    public ListView<String> totalPriceList;

    @FXML
    public ListView<Button> deleteList;

    @FXML
    public ListView<Button> increaseList;

    @FXML
    public ListView<String> quantityList1;

    @FXML
    public ListView<String> commodityList1;

    @FXML
    public ListView<String> unitPriceList1;

    @FXML
    public ListView<String> inventoryList;

    @FXML
    public ListView<Button> categoryList;

    @FXML
    public Label total;

    @FXML
    public Label rebate;

    @FXML
    public Label receivable;

    public String payment;

    @FXML
    public AnchorPane VIPPage;

    @FXML
    public AnchorPane VIPLoginPage;

    @FXML
    public TextField cardNumber;

    @FXML
    public PasswordField cardPassword;

    @FXML
    public Label errVIPLoginInfo;

    public List<String> cardNumberList;

    public List<String> cardPasswordList;

    public List<String> VIPNameList;

    public List<String> VIPPointsList;

    @FXML
    public Label VIPName;

    @FXML
    public Label VIPCardNumber;

    @FXML
    public Label VIPPoints;

    @FXML
    public Label isLoginning;

    @FXML
    public Label isPayed;

    @FXML
    public AnchorPane PayPage;

    @FXML
    public TextField payPrice;

    @FXML
    public Label changePrice;

    @FXML
    public Label errPayInfo;

    @FXML
    public TableView<Records> recordsTable;

    @FXML
    public TableColumn<Records, String> nameColumn;

    @FXML
    public TableColumn<Records, String> cardNumberColumn;

    @FXML
    public TableColumn<Records, Float> priceColumn;

    @FXML
    public TableColumn<Records, Integer> decreasePointsColumn;

    @FXML
    public TableColumn<Records, Integer> increasePointsColumn;

    public boolean isInitialized = false;

    @FXML
    public AnchorPane searchPage;

    @FXML
    public TextField searchName;

    @FXML
    public TextField searchNumber;

    @FXML
    public TextField searchAdd;

    @FXML
    public Label searchFail;

    @FXML
    public Label searchSuccessful;

    @FXML
    public Label errSearchInfo;

    @FXML
    public void SwitchPage() {
        if (!isInitialized) {
            InitialList();
            isInitialized = true;
        }

        cashier.setStyle("-fx-background-color: #4b77a1;");
        cashier.setTextFill(Paint.valueOf("#2bcdc5"));
        memberCustomer.setStyle("-fx-background-color: #4b77a1;");
        memberCustomer.setTextFill(Paint.valueOf("#2bcdc5"));

        if (cashier.isHover()) {
            cashier.setStyle("-fx-background-color: #2bcdc5;");
            cashier.setTextFill(Paint.valueOf("WHITE"));
            cashierPage.setVisible(true);
            recordsPage.setVisible(false);
        } else if (memberCustomer.isHover()) {
            memberCustomer.setStyle("-fx-background-color: #2bcdc5;");
            memberCustomer.setTextFill(Paint.valueOf("WHITE"));
            recordsPage.setVisible(true);
            cashierPage.setVisible(false);

            InitialRecordsTable();
        }
    }

    public void InitialCategory() {
        commodityController = new CommodityController();
        for (int i = 0; i < commodityController.getCategoryList().size(); i++) {
            String category = commodityController.getCategoryList().get(i);
            int j = 0;
            for (; j < categoryList.getItems().size(); j++) {
                if (categoryList.getItems().get(j).getText().equals(category)) {
                    j = -1;
                    break;
                }
            }

            if (j != -1) {
                Button button2 = new Button();
                button2.setText(category);
                button2.setOnAction(actionEvent -> {ReadDataBase(button2.getText()); SelectCategory(button2);});
                button2.getStyleClass().add("category-button");
                categoryList.getItems().add(button2);
            }
        }
    }

    public void InitialList() {
        ObservableList<String> strList1 = FXCollections.observableArrayList();
        ObservableList<String> strList2 = FXCollections.observableArrayList();
        ObservableList<String> strList3 = FXCollections.observableArrayList();
        ObservableList<String> strList4 = FXCollections.observableArrayList();
        ObservableList<Button> buttonList1 = FXCollections.observableArrayList();

        commodityList.setItems(strList1);
        commodityList.getStyleClass().add("list-view .scroll-bar:vertical");

        quantityList.setItems(strList2);
        quantityList.getStyleClass().add("list-view .scroll-bar:vertical");

        unitPriceList.setItems(strList3);
        unitPriceList.getStyleClass().add("list-view .scroll-bar:vertical");

        totalPriceList.setItems(strList4);
        totalPriceList.getStyleClass().add("list-view .scroll-bar:vertical");

        deleteList.setItems(buttonList1);
        deleteList.getStyleClass().add("list-view .scroll-bar:vertical");

        ScrollBar scrollBar1 = (ScrollBar)commodityList.queryAccessibleAttribute(AccessibleAttribute.VERTICAL_SCROLLBAR);
        ScrollBar scrollBar2 = (ScrollBar)quantityList.queryAccessibleAttribute(AccessibleAttribute.VERTICAL_SCROLLBAR);
        ScrollBar scrollBar3 = (ScrollBar)unitPriceList.queryAccessibleAttribute(AccessibleAttribute.VERTICAL_SCROLLBAR);
        ScrollBar scrollBar4 = (ScrollBar)totalPriceList.queryAccessibleAttribute(AccessibleAttribute.VERTICAL_SCROLLBAR);
        ScrollBar scrollBar5 = (ScrollBar)deleteList.queryAccessibleAttribute(AccessibleAttribute.VERTICAL_SCROLLBAR);
        if (null != scrollBar1 && null != scrollBar2 && null != scrollBar3 && null != scrollBar4) {
            scrollBar1.valueProperty().bindBidirectional(scrollBar2.valueProperty());
            scrollBar2.valueProperty().bindBidirectional(scrollBar3.valueProperty());
            scrollBar3.valueProperty().bindBidirectional(scrollBar4.valueProperty());
            scrollBar4.valueProperty().bindBidirectional(scrollBar5.valueProperty());
        }

        ObservableList<Button> buttonList2 = FXCollections.observableArrayList();
        ObservableList<String> strList5 = FXCollections.observableArrayList();
        ObservableList<String> strList6 = FXCollections.observableArrayList();
        ObservableList<String> strList7 = FXCollections.observableArrayList();
        ObservableList<String> strList8 = FXCollections.observableArrayList();

        increaseList.setItems(buttonList2);
        increaseList.getStyleClass().add("list-view .scroll-bar:vertical");
        increaseList.getStyleClass().add("list-view-item1");

        quantityList1.setItems(strList5);
        quantityList1.getStyleClass().add("list-view .scroll-bar:vertical");
        quantityList1.getStyleClass().add("list-view-item1");
        quantityList1.setCellFactory(TextFieldListCell.forListView());
        quantityList1.addEventFilter(ListView.EditEvent.ANY, new EventHandler<Event>() {
            @Override
            public void handle(Event event) {
                AddCommodity();
            }
        });

        commodityList1.setItems(strList6);
        commodityList1.getStyleClass().add("list-view .scroll-bar:vertical");
        commodityList1.getStyleClass().add("list-view-item1");

        unitPriceList1.setItems(strList7);
        unitPriceList1.getStyleClass().add("list-view .scroll-bar:vertical");
        unitPriceList1.getStyleClass().add("list-view-item1");

        inventoryList.setItems(strList8);
        inventoryList.getStyleClass().add("list-view .scroll-bar:vertical");
        inventoryList.getStyleClass().add("list-view-item1");

        ScrollBar scrollBar6 = (ScrollBar)increaseList.queryAccessibleAttribute(AccessibleAttribute.VERTICAL_SCROLLBAR);
        ScrollBar scrollBar7 = (ScrollBar) quantityList1.queryAccessibleAttribute(AccessibleAttribute.VERTICAL_SCROLLBAR);
        ScrollBar scrollBar8 = (ScrollBar)commodityList1.queryAccessibleAttribute(AccessibleAttribute.VERTICAL_SCROLLBAR);
        ScrollBar scrollBar9 = (ScrollBar)unitPriceList1.queryAccessibleAttribute(AccessibleAttribute.VERTICAL_SCROLLBAR);
        ScrollBar scrollBar10 = (ScrollBar)inventoryList.queryAccessibleAttribute(AccessibleAttribute.VERTICAL_SCROLLBAR);
        if (null != scrollBar1 && null != scrollBar2 && null != scrollBar3 && null != scrollBar4) {
            scrollBar6.valueProperty().bindBidirectional(scrollBar7.valueProperty());
            scrollBar7.valueProperty().bindBidirectional(scrollBar8.valueProperty());
            scrollBar8.valueProperty().bindBidirectional(scrollBar9.valueProperty());
            scrollBar9.valueProperty().bindBidirectional(scrollBar10.valueProperty());
        }

        ObservableList<Button> buttonList4 = FXCollections.observableArrayList();categoryList.setItems(buttonList2);
        categoryList.setItems(buttonList4);
        categoryList.getStyleClass().add("list-view .scroll-bar:vertical");
        categoryList.getStyleClass().add("list-view-item2");

        InitialCategory();
        if (categoryList.getItems().size() != 0)
            ReadDataBase(categoryList.getItems().get(0).getText());
    }

    public void ReadDataBase(String category) {
        increaseList.getItems().clear();
        quantityList1.getItems().clear();
        commodityList1.getItems().clear();
        unitPriceList1.getItems().clear();
        inventoryList.getItems().clear();

        for (int i = 0; i < commodityController.getIdList().size(); i++) {
            if (commodityController.getCategoryList().get(i).equals(category)) {
                Button button1 = new Button();
                button1.setText("取");
                button1.setOnAction(actionEvent -> {AddOneCommodity();});
                button1.getStyleClass().add("my-button");
                increaseList.getItems().add(button1);

                quantityList1.getItems().add(commodityController.getTakeList().get(i).toString());
                commodityList1.getItems().add(commodityController.getNameList().get(i));
                unitPriceList1.getItems().add(commodityController.getUnitPriceList().get(i).toString());
                int inventory = commodityController.getQuantityList().get(i) - commodityController.getTakeList().get(i);
                inventoryList.getItems().add(Integer.toString(inventory));
            }
        }
    }

    public void AddOneCommodity() {
        int id = -1;
        for (int i = 0; i < increaseList.getItems().size(); i++) {
            if (increaseList.getItems().get(i).isHover()) {
                increaseList.getSelectionModel().clearSelection();
                increaseList.getSelectionModel().select(i);
                SyncSelect2();
                id = i;
                break;
            }
        }
        if (id != -1) {
            int replaceQuantity = Integer.parseInt(quantityList1.getItems().get(id)) + 1;
            quantityList1.getItems().set(id, Integer.toString(replaceQuantity));
            for (int i = 0; i < commodityList.getItems().size(); i++) {
                if (commodityList.getItems().get(i).equals(commodityList1.getItems().get(id))){
                    quantityList.getItems().set(i, quantityList1.getItems().get(id));
                    break;
                }
            }
            AddCommodity();
        }
    }

    public void AddCommodity() {
        int id = -1;
        for (int i = 0; i < increaseList.getItems().size(); i++) {
            if (increaseList.getItems().get(i).isHover()) {
                id = i;
                break;
            } else if (quantityList1.getSelectionModel().isSelected(i)) {
                id = i;
                break;
            }
        }

        if (id != -1) {

            if (RegExUtil.Find("[^0-9]", quantityList1.getItems().get(id))) {
                quantityList1.getItems().set(id, "0");
                return;
            }

            if (!RegExUtil.Regex("^\\d{1,9}$", quantityList1.getItems().get(id))) {
                quantityList1.getItems().set(id, quantityList1.getItems().get(id).substring(0, 9));
            }

            int replaceInventory = 0;
            for (int j = 0; j < commodityController.getNameList().size(); j++) {
                if (commodityController.getNameList().get(j).equals(commodityList1.getItems().get(id))) {
                    commodityController.getTakeList().set(j, Integer.parseInt(quantityList1.getItems().get(id)));
                    replaceInventory = commodityController.getQuantityList().get(j) - commodityController.getTakeList().get(j);
                    break;
                }
            }
            if (replaceInventory < 0) {
                for (int j = 0; j < commodityController.getNameList().size(); j++) {
                    if (commodityController.getNameList().get(j).equals(commodityList1.getItems().get(id))) {
                        quantityList1.getItems().set(id, commodityController.getQuantityList().get(j).toString());
                        commodityController.getTakeList().set(j, Integer.parseInt(quantityList1.getItems().get(id)));
                        replaceInventory = commodityController.getQuantityList().get(j) - commodityController.getTakeList().get(j);
                        inventoryList.getItems().set(id, Integer.toString(replaceInventory));
                        break;
                    }
                }
            } else {
                inventoryList.getItems().set(id, Integer.toString(replaceInventory));
            }

            int i = 0;
            for (; i < commodityList.getItems().size(); i++) {
                if (commodityList.getItems().get(i).equals(commodityList1.getItems().get(id))) {
                    UpdateCommodity(i, id);
                    i = -1;
                    break;
                }
            }
            if (i == -1)
                return;

            float fTotalPrice = Float.parseFloat(quantityList1.getItems().get(id)) * Float.parseFloat(unitPriceList1.getItems().get(id));
            if(fTotalPrice <= 0)
                return;

            AddBillCell(new BillCell(commodityList1.getItems().get(id), quantityList1.getItems().get(id), unitPriceList1.getItems().get(id), Float.toString(fTotalPrice)));

            CalculatePrice();
        }
    }

    public void UpdateCommodity(int i, int id) {
        float fTotalPrice = Float.parseFloat(quantityList1.getItems().get(id)) * Float.parseFloat(unitPriceList1.getItems().get(id));
        if (fTotalPrice <= 0) {
            DeleteBillCell(i);
        } else {
            totalPriceList.getItems().set(i, Float.toString(fTotalPrice));
        }
        CalculatePrice();
    }

    public void DeleteCommodity() {
        int id = -1;
        for (int i = 0; i < deleteList.getItems().size(); i++) {
            if (deleteList.getItems().get(i).isHover()) {
                id = i;
                break;
            }
        }

        if (id != -1)
            DeleteBillCell(id);
    }

    public void DeleteAllCommodity() {
        while (commodityList.getItems().size() > 0) {
            DeleteBillCell(0);
        }
    }

    public void AddBillCell(BillCell billCell) {
        commodityList.getItems().add(billCell.getCommodity());
        quantityList.getItems().add(billCell.getQuantity());
        unitPriceList.getItems().add(billCell.getUnitPrice());
        totalPriceList.getItems().add(billCell.getTotalPrice());
        Button button = new Button();
        button.setText("X");
        button.setOnAction(actionEvent -> {DeleteCommodity();});
        button.getStyleClass().add("my-button");
        deleteList.getItems().add(button);

        CalculatePrice();
    }

    public void DeleteBillCell(int id) {
        for (int i = 0; i < commodityController.getNameList().size(); i++) {
            if (commodityList.getItems().get(id).equals(commodityController.getNameList().get(i))) {
                commodityController.getTakeList().set(i, 0);
                for (int j = 0; j < quantityList1.getItems().size(); j++) {
                    if (commodityList.getItems().get(id).equals(commodityList1.getItems().get(j))) {
                        quantityList1.getItems().set(j, "0");
                        inventoryList.getItems().set(j, commodityController.getQuantityList().get(i).toString());
                        break;
                    }
                }
                break;
            }
        }

        commodityList.getItems().remove(id);
        quantityList.getItems().remove(id);
        unitPriceList.getItems().remove(id);
        totalPriceList.getItems().remove(id);
        deleteList.getItems().remove(id);

        CalculatePrice();
    }

    public void SelectCategory(Button button) {
        categoryList.getSelectionModel().clearSelection();
        categoryList.getSelectionModel().select(button);
    }

    public void SyncSelect1() {
        int id = -1;

        if (commodityList.isHover()) {
            id = commodityList.getSelectionModel().getSelectedIndex();
        } else if (quantityList.isHover()) {
            id = quantityList.getSelectionModel().getSelectedIndex();
        } else if (unitPriceList.isHover()) {
            id = unitPriceList.getSelectionModel().getSelectedIndex();
        } else if (totalPriceList.isHover()) {
            id = totalPriceList.getSelectionModel().getSelectedIndex();
        } else if (deleteList.isHover()) {
            id = deleteList.getSelectionModel().getSelectedIndex();
        }

        commodityList.getSelectionModel().clearSelection();
        quantityList.getSelectionModel().clearSelection();
        unitPriceList.getSelectionModel().clearSelection();
        totalPriceList.getSelectionModel().clearSelection();
        deleteList.getSelectionModel().clearSelection();

        commodityList.getSelectionModel().select(id);
        quantityList.getSelectionModel().select(id);
        unitPriceList.getSelectionModel().select(id);
        totalPriceList.getSelectionModel().select(id);
        deleteList.getSelectionModel().select(id);
    }

    public void SyncSelect2() {
        int id = -1;

        if (increaseList.isHover()) {
            id = increaseList.getSelectionModel().getSelectedIndex();
        } else if (quantityList1.isHover()) {
            id = quantityList1.getSelectionModel().getSelectedIndex();
        } else if (commodityList1.isHover()) {
            id = commodityList1.getSelectionModel().getSelectedIndex();
        } else if (unitPriceList1.isHover()) {
            id = unitPriceList1.getSelectionModel().getSelectedIndex();
        } else if (inventoryList.isHover()) {
            id = inventoryList.getSelectionModel().getSelectedIndex();
        }

        increaseList.getSelectionModel().clearSelection();
        quantityList1.getSelectionModel().clearSelection();
        commodityList1.getSelectionModel().clearSelection();
        unitPriceList1.getSelectionModel().clearSelection();
        inventoryList.getSelectionModel().clearSelection();

        increaseList.getSelectionModel().select(id);
        quantityList1.getSelectionModel().select(id);
        commodityList1.getSelectionModel().select(id);
        unitPriceList1.getSelectionModel().select(id);
        inventoryList.getSelectionModel().select(id);
    }

    public void VIP() {
        VIPPage.setVisible(true);
        if (isLoginning.isVisible())
            return;
        VIPLoginPage.setVisible(true);
    }

    public void notVIP() {
        VIPPage.setVisible(false);
        CalculatePrice();
    }

    public void doVIPLogout() {
        isLoginning.setVisible(false);
        VIPName.setText("未填写");
        VIPCardNumber.setText("未填写");
        VIPPoints.setText("0");
        VIPPage.setVisible(false);
        CalculatePrice();
    }

    public void doVIPLogin() {
        String cardNumberText = cardNumber.getText();
        String cardPasswordText = cardPassword.getText();

        if (StringUtil.isEmpty(cardNumberText) || StringUtil.isEmpty(cardPasswordText)) {
            errVIPLoginInfo.setText("卡号或密码不能为空!");
            errVIPLoginInfo.setVisible(true);
        } else if (!RegExUtil.Regex("^\\d{6}$", cardNumberText) || !RegExUtil.Regex("^\\d{6}$", cardPasswordText)) {
            errVIPLoginInfo.setText("输入必须为6位阿拉伯数字!");
            errVIPLoginInfo.setVisible(true);
        } else {
            if (cardNumberList == null && cardPasswordList == null)
                InitialVIPList();
            for (int i = 0; i < cardNumberList.size(); i++) {
                if (cardNumberList.get(i).equals(cardNumberText) && cardPasswordList.get(i).equals(cardPasswordText)) {
                    VIPName.setText(VIPNameList.get(i));
                    VIPCardNumber.setText(cardNumberList.get(i));
                    VIPPoints.setText(VIPPointsList.get(i));
                    VIPLoginPage.setVisible(false);
                    errVIPLoginInfo.setVisible(false);
                    isLoginning.setVisible(true);
                    CalculatePrice();
                    break;
                } else if (i == cardNumberList.size() - 1) {
                    errVIPLoginInfo.setText("卡号或密码输入错误!");
                    errVIPLoginInfo.setVisible(true);
                }
            }
        }
    }

    public void doNotVIPLogin() {
        VIPPage.setVisible(false);
        VIPLoginPage.setVisible(false);
        CalculatePrice();
    }

    public void InitialVIPList() {
        cardNumberList = new ArrayList<>();
        cardPasswordList = new ArrayList<>();
        VIPNameList = new ArrayList<>();
        VIPPointsList = new ArrayList<>();

        MemberCustomerService memberCustomerService = new MemberCustomerServiceImpl();
        List<MemberCustomer> dataList = memberCustomerService.findAllMemberCustomer();
        for (MemberCustomer memberCustomer1 : dataList) {
            cardNumberList.add(memberCustomer1.getCardNumber());
            cardPasswordList.add(memberCustomer1.getCardPassword());
            VIPNameList.add(memberCustomer1.getName());
            VIPPointsList.add(memberCustomer1.getPoints().toString());
        }
    }

    public void CalculatePrice() {
        if (totalPriceList.getItems().size() == 0) {
            total.setText("0.00");
            rebate.setText("0.00");
            receivable.setText(("0.00"));
            return;
        }

        float totalPrice = 0;
        for (int i = 0; i < totalPriceList.getItems().size(); i++) {
            totalPrice += Float.parseFloat(totalPriceList.getItems().get(i));
        }
        total.setText(Float.toString(totalPrice));
        int rebatePrice = Integer.parseInt(VIPPoints.getText()) / 10;
        while (rebatePrice > totalPrice / 10) {
            rebatePrice--;
        }
        rebate.setText(Float.toString(rebatePrice));
        receivable.setText(Float.toString(totalPrice - rebatePrice));
    }

    public void inBalance() {
        PayPage.setVisible(true);
    }

    public void outBalance() {
        PayPage.setVisible(false);
    }

    public void doPay() {
        String payPriceText = payPrice.getText();

        if (Float.parseFloat(receivable.getText()) <= 0) {
            errPayInfo.setText("尚未添加商品，无需结算!");
            errPayInfo.setVisible(true);
        } else if (StringUtil.isEmpty(payPriceText)) {
            errPayInfo.setText("支付输入不能为空!");
            errPayInfo.setVisible(true);
        } else if (!RegExUtil.Regex("^\\d*\\.?\\d+$", payPriceText) && RegExUtil.Find("[^0-9]", payPriceText)) {
            errPayInfo.setText("支付输入必须是正整数或正浮点数!");
            errPayInfo.setVisible(true);
        } else {
            if (Float.parseFloat(payPriceText) < Float.parseFloat(receivable.getText())) {
                errPayInfo.setText("支付金额不足!");
                errPayInfo.setVisible(true);
            } else {
                payment = payPrice.getText();
                payPrice.setText("");
                isPayed.setVisible(true);
                PayPage.setVisible(false);
                pay();
            }
        }
    }

    public void ChangePrice () {
        String payPriceText = payPrice.getText();
        if (Float.parseFloat(receivable.getText()) <= 0) {
            errPayInfo.setText("尚未添加商品，无需结算!");
            errPayInfo.setVisible(true);
        } else if (StringUtil.isEmpty(payPriceText)) {
            changePrice.setText("0.00");
        } else if (!RegExUtil.Regex("^\\d*\\.?\\d+$", payPriceText) && RegExUtil.Find("[^0-9]", payPriceText)) {
            errPayInfo.setText("支付输入必须是正整数或正浮点数!");
            errPayInfo.setVisible(true);
        } else {
            if (Float.parseFloat(payPriceText) < Float.parseFloat(receivable.getText())) {
                changePrice.setText("0.00");
                errPayInfo.setText("支付金额不足!");
                errPayInfo.setVisible(true);
            } else {
                changePrice.setText(Float.toString(Float.parseFloat(payPriceText) - Float.parseFloat(receivable.getText())));
                errPayInfo.setVisible(false);
            }
        }
    }

    public void InitialRecordsTable() {
        ObservableList<Records> list = FXCollections.observableArrayList();
        recordsTable.setItems(list);

        nameColumn.setCellValueFactory(new PropertyValueFactory<>("name"));
        cardNumberColumn.setCellValueFactory(new PropertyValueFactory<>("cardNumber"));
        priceColumn.setCellValueFactory(new PropertyValueFactory<>("price"));
        decreasePointsColumn.setCellValueFactory(new PropertyValueFactory<>("decreasePoints"));
        increasePointsColumn.setCellValueFactory(new PropertyValueFactory<>("increasePoints"));

        RecordsService recordsService = new RecordsServiceImpl();
        List<Records> recordsList = recordsService.findAllRecords();
        list.addAll(recordsList);
        recordsTable.refresh();
    }

    public void pay() {
        CommodityService commodityService = new CommodityServiceImpl();
        RecordsService recordsService = new RecordsServiceImpl();
        MemberCustomerService memberCustomerService = new MemberCustomerServiceImpl();

        for (int i = 0; i < commodityController.getNameList().size(); i++) {
            if (commodityController.getTakeList().get(i) != 0) {
                Commodity commodity = commodityService.findCommodityById(commodityController.getIdList().get(i));
                commodity.setQuantity(commodityController.getQuantityList().get(i) - commodityController.getTakeList().get(i));
                commodityService.updateCommodity(commodity);
            }
        }

        if (isLoginning.isVisible()) {
            Records records = new Records();
            records.setName(VIPName.getText());
            records.setCardNumber(VIPCardNumber.getText());
            records.setPrice(Float.parseFloat(total.getText()));
            records.setDecreasePoints((int)Float.parseFloat(rebate.getText()) * 10);
            records.setIncreasePoints((int)records.getPrice().floatValue() / 20);
            recordsService.insertRecords(records);

            MemberCustomer memberCustomer1 = memberCustomerService.findMemberCustomerById(records.getCardNumber());
            memberCustomer1.setPoints(memberCustomer1.getPoints() - records.getDecreasePoints() + records.getIncreasePoints());
            memberCustomerService.updateMemberCustomer(memberCustomer1);

            InitialVIPList();
        }

        doVIPLogout();
        isPayed.setVisible(false);

        DeleteAllCommodity();
        InitialList();
    }

    public void Search() {
        searchPage.setVisible(true);
    }

    public void SearchCommodity() {
        String searchNameText = searchName.getText();
        String searchNumberText = searchNumber.getText();

        if (StringUtil.isEmpty(searchNameText) && StringUtil.isEmpty(searchNumberText)) {
            return;
        } else if (searchNameText.length() > 31 && StringUtil.isEmpty(searchNumberText)) {
            searchName.setText("");
            errSearchInfo.setText("商品名称输入过长!");
            errSearchInfo.setVisible(true);
            return;
        } else if (RegExUtil.Find("[^0-9]", searchNumberText) && StringUtil.isEmpty(searchNameText)) {
            searchNumber.setText("");
            errSearchInfo.setText("货号输入必须为6位阿拉伯数字!");
            errSearchInfo.setVisible(true);
            return;
        } else if (!RegExUtil.Regex("^\\d{6}$", searchNumberText) && StringUtil.isEmpty(searchNameText)) {
            searchNumber.setText("");
            errSearchInfo.setText("货号输入必须为6位阿拉伯数字!");
            errSearchInfo.setVisible(true);
            return;
        } else if (!StringUtil.isEmpty(searchNameText)) {
            searchFail.setVisible(true);
            for (int i = 0; i < commodityController.getNameList().size(); i++) {
                if (commodityController.getNameList().get(i).equals(searchNameText)) {
                    searchNumber.setText(commodityController.getIdList().get(i));
                    searchFail.setVisible(false);
                    searchSuccessful.setVisible(true);
                    errSearchInfo.setVisible(false);
                    break;
                }
            }
        } else if (!StringUtil.isEmpty(searchNumberText)) {
            searchFail.setVisible(true);
            for (int i = 0; i < commodityController.getIdList().size(); i++) {
                if (commodityController.getIdList().get(i).equals(searchNumberText)) {
                    searchName.setText(commodityController.getNameList().get(i));
                    searchFail.setVisible(false);
                    searchSuccessful.setVisible(true);
                    errSearchInfo.setVisible(false);
                    break;
                }
            }
        }
    }

    @FXML
    public void doSearch() {
        String searchAddText = searchAdd.getText();

        if (!searchSuccessful.isVisible()) {
            errSearchInfo.setText("未找到该商品!");
            errSearchInfo.setVisible(true);
        } else if (StringUtil.isEmpty(searchAddText)) {
            errSearchInfo.setText("添加数量不能为空!");
            errSearchInfo.setVisible(true);
        } else if (RegExUtil.Find("[^0-9]", searchAddText)) {
            errSearchInfo.setText("添加数量输入必须为正数的阿拉伯数字!");
            errSearchInfo.setVisible(true);
        } else if (RegExUtil.Regex("^\\\\d{1,9}$", searchAddText)) {
            errSearchInfo.setText("添加数量不得超过9位数");
            errSearchInfo.setVisible(true);
        } else if (Integer.parseInt(searchAddText) == 0) {
            errSearchInfo.setText("不能添加零个商品!");
            errSearchInfo.setVisible(true);
        } else {
            for (int i = 0; i < commodityController.getNameList().size(); i++) {
                if (commodityController.getNameList().get(i).equals(searchName.getText())) {
                    commodityController.getTakeList().set(i, Integer.parseInt(searchAddText));
                    ReadDataBase(commodityController.getCategoryList().get(i));
                    for (int j = 0; j < commodityList1.getItems().size(); j++) {
                        if (commodityList1.getItems().get(j).equals(commodityController.getNameList().get(i))) {
                            commodityList1.scrollTo(j);

                            increaseList.getSelectionModel().clearSelection();
                            quantityList1.getSelectionModel().clearSelection();
                            commodityList1.getSelectionModel().clearSelection();
                            unitPriceList1.getSelectionModel().clearSelection();
                            inventoryList.getSelectionModel().clearSelection();
                            increaseList.getSelectionModel().select(j);
                            quantityList1.getSelectionModel().select(j);
                            commodityList1.getSelectionModel().select(j);
                            unitPriceList1.getSelectionModel().select(j);
                            inventoryList.getSelectionModel().select(j);

                            AddCommodity();

                            break;
                        }
                    }
                    break;
                }
            }
            searchName.setText("");
            searchNumber.setText("");
            searchAdd.setText("");

            searchPage.setVisible(false);
            searchSuccessful.setVisible(false);
            errSearchInfo.setVisible(false);
        }
    }

    @FXML
    public void doNotSearch() {
        searchPage.setVisible(false);
    }

}
