package umg.dem01.DataBase.Service;

import umg.dem01.DataBase.Dao.DatosDAO;
import umg.dem01.DataBase.Dao.UserDatosDAO;
import umg.dem01.DataBase.Model.Datos;
import umg.dem01.DataBase.Model.UserDatos;

import java.sql.SQLException;
import java.util.List;

public class UserDatosService {

    private UserDatosDAO userDatosDAO= new UserDatosDAO();

    private UserDatosDAO UserDatosDAO = new UserDatosDAO();

    public boolean insertarDato(UserDatos dato) {
        return UserDatosDAO.insertar(dato);
    }

    public List<UserDatos> obtenerTodosLosDatos() {
        return UserDatosDAO.obtenerTodos();
    }
    public UserDatos obtenerPorCarne(int carne) throws SQLException  {
        return UserDatosDAO.obtenerPorCarne(carne);
    }

    public boolean actualizarDato(UserDatos dato) {
        return UserDatosDAO.actualizar(dato);
    }

    public boolean eliminarDato(int carne) {
        return UserDatosDAO.eliminar(carne);
    }
}
