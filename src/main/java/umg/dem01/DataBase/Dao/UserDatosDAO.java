package umg.dem01.DataBase.Dao;

import umg.dem01.DataBase.DataConnection.DatabaseConnection;
import umg.dem01.DataBase.Model.UserDatos;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;


public class UserDatosDAO {

    public boolean insertar(UserDatos dato) {
        String sql = "INSERT INTO tb_user(carne, nombre, correo, seccion, telegramid, activo) VALUES (?, ?, ?, ?, ?, ?)";
        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setInt(1, dato.getCarne());
            pstmt.setString(2, dato.getNombre());
            pstmt.setString(3, dato.getCorreo());
            pstmt.setString(4, dato.getSeccion());
            pstmt.setString(5, dato.getTelegramid());
            pstmt.setBoolean(6, dato.getActivo());
            pstmt.executeUpdate();
            return true;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    public List<UserDatos> obtenerTodos() {
        List<UserDatos> datos = new ArrayList<>();
        String sql = "SELECT * FROM tb_user";
        try (Connection conn = DatabaseConnection.getConnection();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {

            while (rs.next()) {
                UserDatos userdatos = new UserDatos();
                userdatos.setCarne(rs.getInt("carne"));
                userdatos.setNombre(rs.getString("nombre"));
                userdatos.setSeccion(rs.getString("seccion"));
                userdatos.setCorreo(rs.getString("correo"));
                userdatos.setTelegramid(rs.getString("telegramid"));
                userdatos.setActivo(rs.getBoolean("activo"));

                datos.add(userdatos);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return datos;
    }

    public UserDatos obtenerPorCorreo(String correo) throws SQLException {
        String sql = "SELECT * FROM tb_user WHERE correo = ?";
        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1, correo);
            try (ResultSet rs = pstmt.executeQuery()) {
                if (rs.next()) {
                    return new UserDatos(
                            rs.getInt("carne"),
                            rs.getString("nombre"),
                            rs.getString("seccion"),
                            rs.getString("correo"),
                            rs.getString("telegramid"),
                            rs.getBoolean("activo")
                    );
                }
            }
        }
        return null;
    }

    public boolean actualizar(UserDatos dato) {
        String sql = "UPDATE tb_user SET nombre = ?, seccion = ?, correo = ?, telegramid = ?, activo = ? WHERE carne = ?";
        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1, dato.getNombre());
            pstmt.setString(2, dato.getSeccion());
            pstmt.setString(3, dato.getCorreo());
            pstmt.setString(4, dato.getTelegramid());
            pstmt.setBoolean(5, dato.getActivo());
            pstmt.setInt(6, dato.getCarne());
            pstmt.executeUpdate();
            return true;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    public boolean eliminar(int carne) {
        String sql = "DELETE FROM tb_user WHERE carne = ?";
        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setInt(1, carne);
            pstmt.executeUpdate();
            return true;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    public UserDatos obtenerPorCarne(int carne) throws SQLException {
        String sql = "SELECT * FROM tb_user WHERE carne = ?";
        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setInt(1, carne);
            try (ResultSet rs = pstmt.executeQuery()) {
                if (rs.next()) {
                    return new UserDatos(
                            rs.getInt("carne"),
                            rs.getString("nombre"),
                            rs.getString("seccion"),
                            rs.getString("correo"),
                            rs.getString("telegramid"),
                            rs.getBoolean("activo")
                    );
                }
            }
        }
        return null;
    }
}
