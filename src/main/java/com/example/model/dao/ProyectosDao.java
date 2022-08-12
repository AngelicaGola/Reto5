package com.example.model.dao;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import com.example.model.vo.*;
import com.example.util.JDBCUtilities;

public class ProyectosDao {

    public List<ProyectosVo> listar() throws SQLException {
        ArrayList<ProyectosVo> respuesta = new ArrayList<ProyectosVo>();

        Connection conn = JDBCUtilities.getConnection();
        Statement stm = null;
        ResultSet rs = null;
        String consulta = "SELECT ID_Proyecto as id, Constructora, Numero_Habitaciones as Habitaciones, Ciudad"
                + " FROM Proyecto p "
                + " WHERE Clasificacion = 'Casa Campestre' and ciudad in ('Santa Marta', 'Cartagena', 'Barranquilla')";
        try {
            stm = conn.createStatement();
            rs = stm.executeQuery(consulta);

            while (rs.next()) {
                ProyectosVo vo = new ProyectosVo();
                vo.setId(rs.getInt("id"));
                vo.setConstructora(rs.getString("Constructora"));
                vo.setHabitaciones(rs.getInt("Habitaciones"));
                vo.setCiudad(rs.getString("Ciudad"));

                respuesta.add(vo);
            }
        } finally {
            if (rs != null) {
                rs.close();
            }
            if (stm != null) {
                stm.close();
            }
            if (conn != null) {
                conn.close();
            }
        }
        return respuesta;
    }
}
