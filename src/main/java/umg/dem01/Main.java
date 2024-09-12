package umg.dem01;

import umg.dem01.proyectogeneral.formUser;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {

    public static void main(String[] args) {
        // Establecer el estilo de la interfaz (opcional)
        try {
            javax.swing.UIManager.setLookAndFeel(javax.swing.UIManager.getSystemLookAndFeelClassName());
        } catch (Exception e) {
            e.printStackTrace();
        }

        // Ejecutar el formulario formUser
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new formUser().setVisible(true);  // Asegúrate de que el nombre de la clase sea el correcto
            }
        });
    }

}