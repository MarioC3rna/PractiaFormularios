package umg.dem01.proyectogeneral;

import umg.dem01.DataBase.Model.Datos;
import umg.dem01.DataBase.Service.DatosService;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;


import static java.sql.Date.valueOf;

public class formUser extends JFrame {

    private JPanel panelUser;
    public static void main(String[] args) {
        JFrame frame = new JFrame("frmUsuarios");
        frame.setContentPane(new formUser().panelUser);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
    }
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
    private JList JList;
    private JButton bttonLimpiar;
    private JTable jTable;





    public formUser() {
        setContentPane(panelUser);
        setTitle("FormularioUser");
        setSize(400, 300);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLocationRelativeTo(null);

        bttonCrear.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Datos Datos = new Datos();
                Datos.setNombre(txtNombre.getText());
                Datos.setApellido(txtApellido.getText());
                Datos.setDepartamento(txtDepartamento.getText());
                String fechaTexto = txtFechaNacimiento.getText();
                SimpleDateFormat formato = new SimpleDateFormat("dd/MM/yyyy"); // Ajusta el formato según el input
                try {
                    try {
                        Date fechaUtil = formato.parse(fechaTexto);
                        java.sql.Date fechaSql = new java.sql.Date(fechaUtil.getTime());
                        Datos.setFechaNacimiento(fechaSql);
                        System.out.println("Fecha convertida: " + fechaUtil);
                    } catch (ParseException ex) {
                        System.out.println("Error: Formato de fecha incorrecto.");
                        JOptionPane.showMessageDialog(null, "Error: Formato de fecha incorrecto.");
                        return; // Salir del método si hay un error de fecha
                    }
                    // Bloque para la inserción en la base de datos
                    new DatosService().insertarDato(Datos);
                    JOptionPane.showMessageDialog(null, "Datos ingresado");

                } catch (Exception ex) {
                    JOptionPane.showMessageDialog(null, "Error al guardar datos: " + ex.getMessage());
                    ex.printStackTrace();
                }


            }
        });

        //--------------------------------------------------------
        bttonMostrar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                int idDato = txtCodigo.getText().isEmpty() ? 0 : Integer.parseInt(txtCodigo.getText());
                try{
                    Datos UsuarioEncontrado = new DatosService().obtenerPorId(idDato);
                    if (UsuarioEncontrado != null) {
                        txtCodigo.setText(Integer.toString(UsuarioEncontrado.getCodigo()));
                        txtNombre.setText(UsuarioEncontrado.getNombre());
                        txtApellido.setText(UsuarioEncontrado.getApellido());
                        txtDepartamento.setText(UsuarioEncontrado.getDepartamento());
                        Date date = UsuarioEncontrado.getFechaNacimiento();
                        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
                        String fechaTexto = sdf.format(date);
                        txtFechaNacimiento.setText(fechaTexto);
                    } else {
                        JOptionPane.showMessageDialog(null, "No se encontro el Usuario");
                    }
                } catch (Exception ex){
                    JOptionPane.showMessageDialog(null,"Error al obtener el usuario"+ ex.getMessage());
                }

            }
        });

        //--------------------------------------------------------------
        bttonActualizar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                try {
                    int codigo = Integer.parseInt(txtCodigo.getText());
                    String nombre = txtNombre.getText();
                    String apellido = txtApellido.getText();
                    String departamento = txtDepartamento.getText();

                    SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
                    java.util.Date utilDate = sdf.parse(txtFechaNacimiento.getText());
                    java.sql.Date sqlDate = new java.sql.Date(utilDate.getTime());

                    Datos dato = new Datos(codigo, nombre, apellido, departamento, sqlDate);
                    DatosService DatosService = new DatosService();

                    boolean actualizado = DatosService.actualizarDato(dato);

                    if (actualizado) {
                        JOptionPane.showMessageDialog(null, "Registro actualizado con éxito");
                    } else {
                        JOptionPane.showMessageDialog(null, "No se pudo actualizar el registro");
                    }
                } catch (NumberFormatException ex) {
                    JOptionPane.showMessageDialog(null, "Error: El ID debe ser un número válido");
                } catch (ParseException ex) {
                    JOptionPane.showMessageDialog(null, "Error: Formato de fecha inválido. Use dd/MM/yyyy");
                } catch (Exception ex) {
                    JOptionPane.showMessageDialog(null, "Error al actualizar: " + ex.getMessage());
                }

            }
        });

        //--------------------------------------------------------


        bttonEliminar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    // Asumimos que hay un campo de texto para el ID
                    String idText = txtCodigo.getText();

                    if (idText.isEmpty()) {
                        JOptionPane.showMessageDialog(null, "Por favor, ingrese un ID para eliminar.");
                        return;
                    }

                    int codigo = Integer.parseInt(idText);

                    // Confirmación antes de eliminar
                    int confirm = JOptionPane.showConfirmDialog(
                            null,
                            "¿Está seguro de que desea eliminar el registro con ID " + codigo + "?",
                            "Confirmar Eliminación",
                            JOptionPane.YES_NO_OPTION
                    );

                    if (confirm == JOptionPane.YES_OPTION) {
                        DatosService tbDatosService = new DatosService();
                        boolean eliminado = tbDatosService.eliminarDato(codigo);

                        if (eliminado) {
                            JOptionPane.showMessageDialog(null, "Registro eliminado con éxito");
                            // Opcionalmente, limpiar los campos después de eliminar
                            limpiarCampos();
                        } else {
                            JOptionPane.showMessageDialog(null, "No se pudo eliminar el registro");
                        }
                    }
                } catch (NumberFormatException ex) {
                    JOptionPane.showMessageDialog(null, "Error: El ID debe ser un número válido");
                } catch (Exception ex) {
                    JOptionPane.showMessageDialog(null, "Error al eliminar: " + ex.getMessage());
                }
            }

            // Método para limpiar los campos después de eliminar
            private void limpiarCampos() {
                txtCodigo.setText("");
                txtNombre.setText("");
                txtApellido.setText("");
                txtDepartamento.setText("");
                txtFechaNacimiento.setText("");
            }


        });
        bttonLimpiar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                txtCodigo.setText("");
                txtNombre.setText("");
                txtApellido.setText("");
                txtDepartamento.setText("");
                txtFechaNacimiento.setText("");
            }


        });
    }


}