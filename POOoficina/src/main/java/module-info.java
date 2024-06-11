module br.unesp.rc.poooficina {
    requires javafx.controls;
    requires javafx.fxml;

    opens br.unesp.rc.poooficina to javafx.fxml;
    exports br.unesp.rc.poooficina;
}
