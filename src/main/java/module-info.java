module org.curriculumdesign.supermarketcashiersystem {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.sql;


    opens org.CurriculumDesign.SupermarketCashierSystem to javafx.fxml;
    exports org.CurriculumDesign.SupermarketCashierSystem;
}