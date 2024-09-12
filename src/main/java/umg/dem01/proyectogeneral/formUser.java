package umg.dem01.proyectogeneral;

import umg.dem01.DataBase.Dao.DatosDAO;
import umg.dem01.DataBase.Model.Datos;
import umg.dem01.DataBase.Service.DatosService;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.Date;
import java.sql.SQLException;



public class formUser extends JFrame {
    private JPanel panelUser;
    private JTextField txtDepartamento;
    private JTextField txtNombre;
    private JButton bttonMostrar;
    private JButton bttonActualizar;
    private JTextField txtApellido;
    private JButton bttonLista;
    private JTextField txtFechaNacimiento;
    private JButton bttonEliminar;
    private JTextField txtCodigo;
    private JLabel lblCode;
    private JLabel lblNombre;
    private JLabel lblApellido;
    private JLabel lbl;
    private JLabel lblfecha;
    private JButton bttonCrear;
    private JTable jTable;





    public formUser() {

        setTitle("FormularioUser");
        setSize(400, 300);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLocationRelativeTo(null);

        bttonCrear.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {











            }
        });

        //--------------------------------------------------------
        bttonMostrar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {






            }
        });

        //--------------------------------------------------------------
        bttonActualizar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

            }
        });

        //--------------------------------------------------------
        bttonLista.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

            }
        });
        //------------------------------------------------------

    }
}