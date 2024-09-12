package umg.dem01.proyectogeneral;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Formularios {
    private JPanel panelGeneral;
    private JButton bttonRegistro;
    private JButton bttonEquipos;
    private JButton bttoUser;


       //--------------BOTONES DE LOS FORMULARIOS---------------------

    public Formularios() {
        bttoUser.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                formUser segundo = new formUser();
                segundo.setVisible(true);
            }
        });


        //--------------------------------------------------------------------
        bttonRegistro.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                formRegistro primero = new formRegistro();
                primero.setVisible(true);
            }
        });


        //-------------------------------------------------------------------------

        bttonEquipos.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                formEquipos tercero = new formEquipos();
                tercero.setVisible(true);
            }
        });
    }
    //---------------------------------------------------------------------------------


    private void createUIComponents() {
        // TODO: place custom component creation code here
    }
}
