module org.curriculumdesign.supermarketcashiersystem {

    requires javafx.controls;
    requires javafx.fxml;
    requires java.sql;


    exports org.CurriculumDesign.SupermarketCashierSystem;
    opens org.CurriculumDesign.SupermarketCashierSystem to javafx.fxml;
    exports org.CurriculumDesign.controller;
    opens org.CurriculumDesign.controller to javafx.fxml;
    exports org.CurriculumDesign.pojo;
    opens org.CurriculumDesign.pojo to java.base;

}