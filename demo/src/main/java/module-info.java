module fr.yoann.architecturemodulaire.demo {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.sql;
    requires mysql.connector.java;


    opens fr.yoann.architecturemodulaire.ihm to javafx.fxml;
    exports fr.yoann.architecturemodulaire.ihm;
}