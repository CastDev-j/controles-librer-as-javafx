module com.libraries {
    requires transitive javafx.controls;
    requires transitive com.dlsc.formsfx;
    requires transitive org.controlsfx.controls;
    requires javafx.fxml;
    requires org.kordamp.bootstrapfx.core;
    requires org.kordamp.ikonli.core;
    requires org.kordamp.ikonli.javafx;

    opens com.libraries to javafx.fxml;

    exports com.libraries;
}
