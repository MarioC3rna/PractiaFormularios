package umg.dem01.DataBase.Service;

import umg.dem01.DataBase.Dao.DatosDAO;
import umg.dem01.DataBase.Model.Datos;

import java.sql.SQLException;
import java.util.List;

public class DatosService {

    private DatosDAO datosDAO= new DatosDAO();

    private DatosDAO DatosDAO = new DatosDAO();

    public boolean insertarDato(Datos dato) {
        return DatosDAO.insertar(dato);
    }

    public List<Datos> obtenerTodosLosDatos() {
        return DatosDAO.obtenerTodos();
    }
    public Datos obtenerPorId(int id) throws SQLException {
        return DatosDAO.obtenerPorId(id);
    }

    public boolean actualizarDato(Datos dato) {
        return DatosDAO.actualizar(dato);
    }

    public boolean eliminarDato(int codigo) {
        return DatosDAO.eliminar(codigo);
    }


}
