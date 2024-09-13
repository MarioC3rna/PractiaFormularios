package umg.dem01.DataBase.Dao;

import umg.dem01.DataBase.DataConnection.DatabaseConnection;
import umg.dem01.DataBase.Model.Datos;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class DatosDAO {


    public boolean insertar(Datos dato) {
        String sql = "INSERT INTO tb_datos (nombre, apellido, departamento, fecha_nacimiento) VALUES (?, ?, ?, ?)";
        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1, dato.getNombre());
            pstmt.setString(2, dato.getApellido());
            pstmt.setString(3, dato.getDepartamento());
            pstmt.setDate(4, dato.getFechaNacimiento());
            pstmt.executeUpdate();
            return true;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    public List<Datos> obtenerTodos() {
        List<Datos> datos = new ArrayList<>();
        String sql = "SELECT * FROM tb_datos";
        try (Connection conn = DatabaseConnection.getConnection();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {

            while (rs.next()) {
                Datos dato = new Datos();
                dato.setCodigo(rs.getInt("codigo"));
                dato.setNombre(rs.getString("nombre"));
                dato.setApellido(rs.getString("apellido"));
                dato.setDepartamento(rs.getString("departamento"));
                dato.setFechaNacimiento(rs.getDate("fecha_nacimiento"));
                datos.add(dato);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return datos;
    }
    public Datos obtenerPorId(int id) throws SQLException {
        String sql = "SELECT * FROM tb_datos WHERE codigo = ?";
        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setInt(1, id);
            try (ResultSet rs = pstmt.executeQuery()) {
                if (rs.next()) {
                    return new Datos(
                            rs.getInt("codigo"),
                            rs.getString("nombre"),
                            rs.getString("apellido"),
                            rs.getString("departamento"),
                            rs.getDate("fecha_nacimiento")
                    );
                }
            }
        }
        return null;
    }



    public boolean actualizar(Datos dato) {
        String sql = "UPDATE tb_datos SET nombre = ?, apellido = ?, departamento = ?, fecha_nacimiento = ? WHERE codigo = ?";
        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1, dato.getNombre());
            pstmt.setString(2, dato.getApellido());
            pstmt.setString(3, dato.getDepartamento());
            pstmt.setDate(4, dato.getFechaNacimiento());
            pstmt.setInt(5, dato.getCodigo());
            pstmt.executeUpdate();
            return true;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    public boolean eliminar(int codigo) {
        String sql = "DELETE FROM tb_datos WHERE codigo = ?";
        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setInt(1, codigo);
            pstmt.executeUpdate();
            return true;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }
}