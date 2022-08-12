package com.example.model.dao;

import java.util.ArrayList;
import java.sql.*;
import java.util.List;

import com.example.model.vo.*;
import com.example.util.JDBCUtilities;

public class ComprasPorProyectoDao {
    public List<ComprasPorProyectoVo> listar() throws SQLException {
        ArrayList<ComprasPorProyectoVo> respuesta = new ArrayList<ComprasPorProyectoVo>();

        Connection conn = JDBCUtilities.getConnection();
        Statement stm = null;
        ResultSet rs = null;
        String consulta = "SELECT ID_Compra as id, p.Constructora , p.Banco_Vinculado"
                + " FROM Compra c "
                + " JOIN Proyecto p "
                + " ON c.ID_Proyecto = p.ID_Proyecto"
                + " WHERE Proveedor = 'Homecenter' AND p.Ciudad = 'Salento'";
        try {
            stm = conn.createStatement();
            rs = stm.executeQuery(consulta);

            while (rs.next()) {
                ComprasPorProyectoVo vo = new ComprasPorProyectoVo();
                vo.setId(rs.getInt("id"));
                vo.setConstructora(rs.getString("Constructora"));
                vo.setBancoVinculado(rs.getString("Banco_Vinculado"));
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
