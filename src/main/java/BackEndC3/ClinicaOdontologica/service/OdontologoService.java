package BackEndC3.ClinicaOdontologica.service;

import BackEndC3.ClinicaOdontologica.dao.BD;
import BackEndC3.ClinicaOdontologica.dao.OdontologoDaoH2;
import BackEndC3.ClinicaOdontologica.dao.iDao;
import BackEndC3.ClinicaOdontologica.model.Odontologo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.List;

public class OdontologoService {

    private iDao<Odontologo> odontologoiDao;

    public OdontologoService() {
        odontologoiDao= new OdontologoDaoH2();
    }

    public iDao<Odontologo> getOdontologoIDao() {
        return odontologoiDao;
    }

    public void setOdontologoIDao(iDao<Odontologo> odontologoiDao) {
        this.odontologoiDao = odontologoiDao;
    }

    public Odontologo guardar(Odontologo odontologo){
        //delegarle la responsabilidad de guardar al DAO
        return  odontologoiDao.guardar(odontologo);
    }

    public List<Odontologo> buscarTodos(){
        //delegarle la responsabilidad de listarTodos al DAO
        return odontologoiDao.buscarTodos();
    }

    public Odontologo buscarPorId(Integer id) {
        return odontologoiDao.buscarPorId(id);
    }
}
