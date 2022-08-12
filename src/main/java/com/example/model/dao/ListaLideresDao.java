package com.example.model.dao;

import java.util.ArrayList;
import java.sql.*;
import java.util.List;

import com.example.model.vo.*;
import com.example.util.JDBCUtilities;

public class ListaLideresDao {
    public List<ListaLideresVo> listar() throws SQLException {
        ArrayList<ListaLideresVo> respuesta = new ArrayList<ListaLideresVo>();

        Connection conn = JDBCUtilities.getConnection();
        Statement stm = null;
        ResultSet rs = null;
        String consulta = "SELECT ID_Lider as id, Nombre, Primer_Apellido as Apellido, Ciudad_Residencia as Ciudad "
                + " FROM Lider l"
                + " ORDER BY Ciudad_Residencia";
        try {
            stm = conn.createStatement();
            rs = stm.executeQuery(consulta);
            while (rs.next()) {
                ListaLideresVo vo = new ListaLideresVo();
                vo.setId(rs.getInt("id"));
                vo.setNombre(rs.getString("Nombre"));
                vo.setApellido(rs.getString("Apellido"));
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
