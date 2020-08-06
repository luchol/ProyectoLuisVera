module com.mycompany.proyectoluisvera {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.sql;
  
    opens com.mycompany.proyectoluisvera to javafx.fxml;
    exports com.mycompany.proyectoluisvera;
    
}
