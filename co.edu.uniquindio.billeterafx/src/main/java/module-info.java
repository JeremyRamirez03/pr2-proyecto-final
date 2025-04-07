module co.edu.uniquindio.billetera.billetera {
    requires javafx.controls;
    requires javafx.fxml;

    requires org.controlsfx.controls;

    opens co.edu.uniquindio.billetera.billetera to javafx.fxml;
    exports co.edu.uniquindio.billetera.billetera;

    opens co.edu.uniquindio.billetera.billetera.viewcontroller to javafx.fxml;
    exports co.edu.uniquindio.billetera.billetera.viewcontroller;
}