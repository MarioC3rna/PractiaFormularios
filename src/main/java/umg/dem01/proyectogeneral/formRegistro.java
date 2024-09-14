package umg.dem01.proyectogeneral;




import umg.dem01.DataBase.Model.UserDatos;
import umg.dem01.DataBase.Service.DatosService;
import umg.dem01.DataBase.Service.UserDatosService;

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
                try {

                    UserDatos userDato = new UserDatos();
                    userDato.setNombre(txtNombre.getText());
                    userDato.setCorreo(txtCorreo.getText());
                    userDato.setSeccion(txtSeccion.getText());
                    userDato.setTelegramid(txtTelegramid.getText());
                    userDato.setActivo(Boolean.parseBoolean(txtActivo.getText()));
                    userDato.setCarne(Integer.parseInt(txtCarne.getText()));

                    UserDatosService userDatosService = new UserDatosService();
                    boolean result = userDatosService.insertarDato(userDato);

                    if (result) {
                        JOptionPane.showMessageDialog(null, "Datos ingresados correctamente");
                    } else {
                        JOptionPane.showMessageDialog(null, "No se pudo guardar los datos");
                    }
                } catch (NumberFormatException ex) {
                    JOptionPane.showMessageDialog(null, "Error en el formato de los datos: " + ex.getMessage());
                } catch (Exception ex) {
                    JOptionPane.showMessageDialog(null, "Error al guardar los datos: " + ex.getMessage());
                }

            }
        });

        //------------------------------------------------
        bttonMostrar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {

                    int carne = Integer.parseInt(txtCarne.getText());

                    UserDatosService userDatosService = new UserDatosService();
                    UserDatos userDato = userDatosService.obtenerPorCarne(carne);

                    if (userDato != null) {
                        txtNombre.setText(userDato.getNombre());
                        txtCorreo.setText(userDato.getCorreo());
                        txtSeccion.setText(userDato.getSeccion());
                        txtTelegramid.setText(userDato.getTelegramid());
                        txtActivo.setText(Boolean.toString(userDato.getActivo()));
                    } else {
                        JOptionPane.showMessageDialog(null, "No se encontraron datos para el número de carne proporcionado");
                    }
                } catch (NumberFormatException ex) {
                    JOptionPane.showMessageDialog(null, "Error en el formato del número de carne: " + ex.getMessage());
                } catch (Exception ex) {
                    JOptionPane.showMessageDialog(null, "Error al obtener los datos: " + ex.getMessage());
                }

            }
        });

        //-------------------------------------------------
        bttonActualizar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    // Crear una instancia de UserDatos con los datos del formulario
                    UserDatos userDato = new UserDatos();
                    userDato.setNombre(txtNombre.getText());
                    userDato.setCorreo(txtCorreo.getText());
                    userDato.setSeccion(txtSeccion.getText());
                    userDato.setTelegramid(txtTelegramid.getText());
                    userDato.setActivo(Boolean.parseBoolean(txtActivo.getText()));
                    userDato.setCarne(Integer.parseInt(txtCarne.getText()));

                    // Crear una instancia de UserDatosService y usarla para actualizar el dato
                    UserDatosService userDatosService = new UserDatosService();
                    boolean result = userDatosService.actualizarDato(userDato);

                    if (result) {
                        JOptionPane.showMessageDialog(null, "Datos actualizados correctamente");
                    } else {
                        JOptionPane.showMessageDialog(null, "No se pudo actualizar los datos");
                    }
                } catch (NumberFormatException ex) {
                    JOptionPane.showMessageDialog(null, "Error en el formato de los datos: " + ex.getMessage());
                } catch (Exception ex) {
                    JOptionPane.showMessageDialog(null, "Error al actualizar los datos: " + ex.getMessage());
                }

            }
        });

        //---------------------------------------------------
        bttonEliminar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    int carne = Integer.parseInt(txtCarne.getText());

                    UserDatosService userDatosService = new UserDatosService();
                    boolean result = userDatosService.eliminarDato(carne);

                    if (result) {
                        JOptionPane.showMessageDialog(null, "Datos eliminados correctamente");
                    } else {
                        JOptionPane.showMessageDialog(null, "No se pudo eliminar los datos");
                    }
                } catch (NumberFormatException ex) {
                    JOptionPane.showMessageDialog(null, "Error en el formato del número de carne: " + ex.getMessage());
                } catch (Exception ex) {
                    JOptionPane.showMessageDialog(null, "Error al eliminar los datos: " + ex.getMessage());
                }

            }
        });


        //--------------------------------------------------------
        btton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                try {
                    String correo = txtCorreo.getText();

                    UserDatosService userDatosService = new UserDatosService();
                    UserDatos userDato = userDatosService.obtenerPorCorreo(correo);

                    if (userDato != null) {
                        JOptionPane.showMessageDialog(null, "El correo electrónico está registrado.");
                    } else {
                        JOptionPane.showMessageDialog(null, "El correo electrónico no está registrado.");
                    }
                } catch (Exception ex) {
                    JOptionPane.showMessageDialog(null, "Error al verificar el correo electrónico: " + ex.getMessage());
                }
            }


            } );



        }





    }

