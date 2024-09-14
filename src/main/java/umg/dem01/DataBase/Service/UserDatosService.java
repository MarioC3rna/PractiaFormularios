package umg.dem01.DataBase.Service;

import umg.dem01.DataBase.Dao.DatosDAO;
import umg.dem01.DataBase.Dao.UserDatosDAO;
import umg.dem01.DataBase.Model.Datos;
import umg.dem01.DataBase.Model.UserDatos;

import java.sql.SQLException;
import java.util.List;

public class UserDatosService {

    private UserDatosDAO userDatosDAO = new UserDatosDAO(); // Mantener solo una instancia y usar camelCase

    public boolean insertarDato(UserDatos dato) {
        return userDatosDAO.insertar(dato); // Usar la instancia correcta
    }

    public List<UserDatos> obtenerTodosLosDatos() {
        return userDatosDAO.obtenerTodos();
    }

    public UserDatos obtenerPorCorreo(String correo) throws SQLException {
        return userDatosDAO.obtenerPorCorreo(correo);
    }

    public boolean actualizarDato(UserDatos dato) {
        return userDatosDAO.actualizar(dato);
    }

    public boolean eliminarDato(int carne) {
        return userDatosDAO.eliminar(carne);
    }

    public UserDatos obtenerPorCarne(int carne) throws SQLException {
        return userDatosDAO.obtenerPorCarne(carne);
    }
}

