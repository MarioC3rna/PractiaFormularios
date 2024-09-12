package umg.dem01.proyectogeneral;




import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;


public class formRegistro extends JFrame {
    private JButton bttonActualizar;
    private JButton bttonMostrar;
    private JButton bttonAgregar;
    private JButton bttonEliminar;
    private JLabel lblNombre;
    private JLabel lblApellido;
    private JTextField txtFecha;
    private JLabel lblFecha;
    private JTextField txtDepartamento;
    private JTextField txtApellido;
    private JTextField txtNombre;
    private JLabel lblCorreo;
    private JTextField txtCorreo;
    private JButton btton;
    private JTextField txtCodigo;
    private JLabel lblCodigo;


    public formRegistro() {
        setTitle("formRegistro");
        setSize(400, 300);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLocationRelativeTo(null);
        bttonAgregar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String nombre = txtNombre.getText();
                String apellido = txtApellido.getText();
                String departamento = txtDepartamento.getText();
                String correo = txtCorreo.getText();

                String fechaNacimiento = txtFecha.getText();
                SimpleDateFormat formatoFecha = new SimpleDateFormat("dd/MM/yyyy");
                Date fecha= null;
                try
                {
                    fecha = formatoFecha.parse(fechaNacimiento);
                }catch(ParseException ex){
                    JOptionPane.showMessageDialog(null, "Fecha incorrecta");
                    return;
                }





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



    private void createUIComponents() {
        // TODO: place custom component creation code here
    }
}
