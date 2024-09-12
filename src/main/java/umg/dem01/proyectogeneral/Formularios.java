package umg.dem01.proyectogeneral;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Formularios extends JFrame {
    private JPanel panelGeneral;
    private JButton bttonUsuario;
    private JButton bttonRegistro;
    private JButton bttonEquipos;



    public Formularios() {
        bttonUsuario.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                formUser primero = new formUser();
                primero.setVisible(true);
            }
        });


        bttonRegistro.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                formRegistro segundo = new formRegistro();
                segundo.setVisible(true);


            }
        });



        bttonEquipos.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                formEquipos tercero = new formEquipos();
                tercero.setVisible(true);

            }
        });
    }

    public static void main(String[] args) {
        JFrame frame = new JFrame("FormulariosPrincipal");
        frame.setContentPane(new Formularios().panelGeneral);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
    }


}
