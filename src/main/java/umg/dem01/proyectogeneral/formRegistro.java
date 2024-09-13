package umg.dem01.proyectogeneral;




import umg.dem01.DataBase.Model.UserDatos;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class formRegistro extends JFrame {
    private JButton bttonActualizar;
    private JButton bttonMostrar;
    private JButton bttonAgregar;
    private JButton bttonEliminar;
    private JLabel lblNombre;
    private JTextField txtDepartamento;
    private JTextField txtApellido;
    private JTextField txtNombre;
    private JLabel lblCorreo;
    private JTextField txtCorreo;
    private JButton btton;
    private JTextField txtCarne;
    private JLabel lblCarne;
    private JPanel panelRegistro;
    private JLabel lblSeccion;
    private JTextField txtSeccion;
    private JTextField txtTelegramid;
    private JLabel lblTelegramid;
    private JLabel lblActivo;
    private JTextField txtActivo;


    public formRegistro() {
        setContentPane(panelRegistro);
        setTitle("formRegistro");
        setSize(400, 300);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLocationRelativeTo(null);


        //___________________________________________________________
        bttonAgregar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e)
            {
                UserDatos Datos = new UserDatos();
                UserDatos.setCarne(textCorreo)
                UserDatos.setNombre(txtNombre.getText());
                Datos.setApellido(txtApellido.getText());
                Datos.setDepartamento(txtDepartamento.getText());






            }
        });

        //------------------------------------------------
        bttonMostrar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

            }
        });

        //-------------------------------------------------
        bttonActualizar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

            }
        });

        //---------------------------------------------------
        bttonEliminar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

            }
        });


        //--------------------------------------------------------
        btton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

            }
        });
    }




}
