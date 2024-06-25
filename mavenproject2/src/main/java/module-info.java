module com.mycompany.mavenproject2 {
    requires javafx.controls;
    requires javafx.fxml;
    requires javafx.web;
    requires org.graalvm.sdk;

    exports com.mycompany.mavenproject2;

    opens com.mycompany.mavenproject2 to javafx.fxml;
}
