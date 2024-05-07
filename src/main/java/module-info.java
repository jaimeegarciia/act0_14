module com.example.act0_14 {
    requires javafx.controls;
    requires javafx.fxml;

    requires org.kordamp.bootstrapfx.core;
    requires com.almasb.fxgl.all;

    opens com.example.act0_14 to javafx.fxml;
    exports com.example.act0_14;
}