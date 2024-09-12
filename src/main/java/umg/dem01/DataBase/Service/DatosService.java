package umg.dem01.DataBase.Service;

import umg.dem01.DataBase.Dao.DatosDAO;
import umg.dem01.DataBase.Model.Datos;

import java.sql.SQLException;
import java.util.List;

public class DatosService {

    private DatosDAO datosDAO;

    public DatosService() {
        datosDAO = new DatosDAO();
    }

    public void createDatos(Datos datos) throws SQLException {
        datosDAO.create(datos);
    }

    public Datos getDatos(int codigo) throws SQLException {
        return datosDAO.read(codigo);
    }

    public void updateDatos(Datos datos) throws SQLException {
        datosDAO.update(datos);
    }

    public void deleteDatos(int codigo) throws SQLException {
        datosDAO.delete(codigo);
    }

    public List<Datos> getAllDatos() throws SQLException {
        return datosDAO.getAll();
    }



}
