package umg.dem01.DataBase.Dao;

import umg.dem01.DataBase.Conexion.Conexion;
import umg.dem01.DataBase.Model.Datos;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class DatosDAO {

    private Connection connection;

    public DatosDAO() {
        connection = Conexion.getConnection();
    }

    public void create() throws SQLException {
        create(null);
    }

    public void create(Datos datos) throws SQLException {
        String sql = "INSERT INTO tb_datos (nombre, apellido, departamento, fecha_nacimiento) VALUES (?, ?, ?, ?)";
        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setString(1, datos.getNombre());
            stmt.setString(2, datos.getApellido());
            stmt.setString(3, datos.getDepartamento());
            stmt.setDate(4, new Date(datos.getFechaNacimiento().getTime()));
            stmt.executeUpdate();
        }
    }

    public Datos read(int codigo) throws SQLException {
        String sql = "SELECT * FROM tb_datos WHERE codigo = ?";
        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setInt(1, codigo);
            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                Datos datos = new Datos();
                datos.setCodigo(rs.getInt("codigo"));
                datos.setNombre(rs.getString("nombre"));
                datos.setApellido(rs.getString("apellido"));
                datos.setDepartamento(rs.getString("departamento"));
                datos.setFechaNacimiento(rs.getDate("fecha_nacimiento"));
                return datos;
            }
        }
        return null;
    }

    public void update(Datos datos) throws SQLException {
        String sql = "UPDATE tb_datos SET nombre = ?, apellido = ?, departamento = ?, fecha_nacimiento = ? WHERE codigo = ?";
        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setString(1, datos.getNombre());
            stmt.setString(2, datos.getApellido());
            stmt.setString(3, datos.getDepartamento());
            stmt.setDate(4, new Date(datos.getFechaNacimiento().getTime()));
            stmt.setInt(5, datos.getCodigo());
            stmt.executeUpdate();
        }
    }

    public void delete(int codigo) throws SQLException {
        String sql = "DELETE FROM tb_datos WHERE codigo = ?";
        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setInt(1, codigo);
            stmt.executeUpdate();
        }
    }

    public List<Datos> getAll() throws SQLException {
        List<Datos> listaDatos = new ArrayList<>();
        String sql = "SELECT * FROM tb_datos";
        try (Statement stmt = connection.createStatement(); ResultSet rs = stmt.executeQuery(sql)) {
            while (rs.next()) {
                Datos datos = new Datos();
                datos.setCodigo(rs.getInt("codigo"));
                datos.setNombre(rs.getString("nombre"));
                datos.setApellido(rs.getString("apellido"));
                datos.setDepartamento(rs.getString("departamento"));
                datos.setFechaNacimiento(rs.getDate("fecha_nacimiento"));
                listaDatos.add(datos);
            }
        }
        return listaDatos;
    }


}
