module projetointegrador.visual.projectkanbanrev00 {
    requires javafx.controls;
    requires javafx.fxml;


    opens projetointegrador.visual to javafx.fxml;
    exports projetointegrador.visual;
    exports projetointegrador.Controller;
    opens projetointegrador.Controller to javafx.fxml;

}