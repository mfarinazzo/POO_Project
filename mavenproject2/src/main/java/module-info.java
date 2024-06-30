module com.mycompany.mavenproject2 {
    requires javafx.controls;
    requires javafx.fxml;
    requires javafx.web;
    requires org.graalvm.sdk;

    opens com.mycompany.mavenproject2 to javafx.fxml;
    exports com.mycompany.mavenproject2;

    requires kernel;
    requires layout;
    requires html2pdf;
    requires javafx.graphics;
    
}
