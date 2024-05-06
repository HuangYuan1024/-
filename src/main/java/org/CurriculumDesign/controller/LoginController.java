package org.CurriculumDesign.controller;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import org.CurriculumDesign.SupermarketCashierSystem.SupermarketCashierSystemApplication;
import org.CurriculumDesign.pojo.Cashier;
import org.CurriculumDesign.service.CashierService;
import org.CurriculumDesign.service.impl.CashierServiceImpl;
import org.CurriculumDesign.util.RegExUtil;
import org.CurriculumDesign.util.StringUtil;

import java.util.ArrayList;
import java.util.List;

public class LoginController {

    @FXML
    private TextField account;

    @FXML
    private PasswordField password;

    @FXML
    private Label errInfo;

    private List<String> accountList;

    private List<String> passwordList;

    @FXML
    public void initialize() {}

    public void InitialList() {
        accountList = new ArrayList<>();
        passwordList = new ArrayList<>();

        CashierService cashierService = new CashierServiceImpl();
        List<Cashier> dataList = cashierService.findAllCashier();
        for (Cashier cashier : dataList) {
            accountList.add(cashier.getAccount());
            passwordList.add(cashier.getPassword());
        }
    }

    @FXML
    public void doLogin() {
        String accountText = account.getText();
        String passwordText = password.getText();

        if (StringUtil.isEmpty(accountText) || StringUtil.isEmpty(passwordText)) {
            errInfo.setText("账号或密码不能为空!");
            errInfo.setVisible(true);
        } else if (!RegExUtil.Regex("^\\d{6}$", accountText) || !RegExUtil.Regex("^\\d{6}$", passwordText)) {
            errInfo.setText("输入必须为6位阿拉伯数字!");
            errInfo.setVisible(true);
        } else {
            if (accountList == null && passwordList == null)
                InitialList();
            for (int i = 0; i < accountList.size(); i++) {
                if (accountList.get(i).equals(accountText) && passwordList.get(i).equals(passwordText)) {
                    SupermarketCashierSystemApplication.changeView("fxml/main.fxml");
                    break;
                } else if (i == accountList.size() - 1) {
                    errInfo.setText("账号或密码输入错误!");
                    errInfo.setVisible(true);
                }
            }
        }
    }

    @FXML
    public void doNotLogin() {
        SupermarketCashierSystemApplication.StopRunDataBase();
        System.exit(0);
    }

}