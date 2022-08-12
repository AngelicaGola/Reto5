package com.example.controller;

import java.sql.*;
import java.util.List;

import com.example.model.dao.*;
import com.example.model.vo.*;

public class ReportesController {
    private ListaLideresDao listaLideresDao;
    private ComprasPorProyectoDao comprasPorProyectoDao;
    private ProyectosDao proyectosDao;

    public ReportesController() {
        proyectosDao = new ProyectosDao();
        comprasPorProyectoDao = new ComprasPorProyectoDao();
        listaLideresDao = new ListaLideresDao();
    }

    public List<ProyectosVo> listarProyectos() throws SQLException {
        return proyectosDao.listar();
    }

    public List<ComprasPorProyectoVo> listarComprasProyectos() throws SQLException {
        return comprasPorProyectoDao.listar();
    }

    public List<ListaLideresVo> listarLideres() throws SQLException {
        return listaLideresDao.listar();
    }

}
