package com.mycompany.proyectoluisvera;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.control.cell.PropertyValueFactory;

public class PrimaryController {

    @FXML
    private Button btnConsulta;
    @FXML
    private TextArea txtArea;

    @FXML
    private void ConsultaBD(ActionEvent event) {

        ArrayList<String> listadatos = new ArrayList<String>();

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql://24.152.40.30:3306/examenits", "its", "12345678");
            System.out.println("OK funciona  ");
            Statement stm = con.createStatement();
            ResultSet rs = stm.executeQuery("SELECT * FROM personas");
            int acum = 0;

            while (rs.next()) {
                Integer id = rs.getInt("idpersona");
                String nombre = rs.getString("nombres");
                String apellido = rs.getString("apellidos");
                //txtArea.setText(id + "-" + nombre + "-" + apellido);

                listadatos.add(rs.getInt(1) + " " + rs.getString(2) + " " + rs.getString(3) + "  \n");
            }

        } catch (Exception ex) {
            System.out.println("Error al conectar;" + ex);
        }
         txtArea.setText(listadatos+"");
    }
}
