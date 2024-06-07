package BackEndC3.ClinicaOdontologica.dao;

import BackEndC3.ClinicaOdontologica.model.Domicilio;
import BackEndC3.ClinicaOdontologica.model.Odontologo;
import BackEndC3.ClinicaOdontologica.model.Paciente;
import org.apache.log4j.Logger;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import static BackEndC3.ClinicaOdontologica.dao.BD.getConnection;

public class OdontologoDaoH2 implements iDao<Odontologo> {

    private final static String DB_JDBC_DRIVER = "org.h2.Driver";
    private final static String DB_URL = "jdbc:h2:~/db_odontologos_clinica_dental";
    private final static String DB_USER ="sa";
    private final static String DB_PASSWORD = "sa";

    //Sentencias SQL
    private final static String SQL_CREATE_TABLE = "CREATE TABLE IF NOT EXISTS odontologos"
            + "("
            + " id INT PRIMARY KEY AUTO_INCREMENT,"
            + " MATRICULA INT NOT NULL,"
            + " NOMBRE varchar(25) NOT NULL,"
            + " APELLIDO varchar(25) NOT NULL"
            + ");";

    //SQL para insertar registros
    private final static String SQL_INSERT = "INSERT INTO ODONTOLOGOS ( matricula, nombre, apellido) VALUES (?,?,?)";

    //SQL para listar todos los odontólogos
    private final static String SQL_FINDALL="SELECT * FROM ODONTOLOGOS ";
    private static final String SQL_SELECT_ONE="SELECT * FROM ODONTOLOGOS WHERE ID=?";

    private static final Logger logger = Logger.getLogger(OdontologoDaoH2.class);



    @Override
    public Odontologo guardar(Odontologo odontologo) {
        PreparedStatement psInsert=null;
        Connection connection =null;
        //1 Levantar el driver y conectarnos
        try {

            //2 Crear una sentencia
            connection = BD.getConnection();
            psInsert=getConnection().prepareStatement(SQL_INSERT);
            psInsert.setInt(1,odontologo.getMatricula());
            psInsert.setString(2,odontologo.getNombre());
            psInsert.setString(3,odontologo.getApellido());

            //3 Ejecutar la setencia

            psInsert.execute();
            logger.info("se ha insertado el registro con matricula " + odontologo.getMatricula()+ " correspondiente a "+odontologo.getNombre()+odontologo.getApellido()+" en la BD");
          //  psInsert.close();

        } catch (SQLException e) {
            e.printStackTrace();
            logger.error("error en la inserción del registro a la BD");

        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        return odontologo;
    }

    @Override
    public Odontologo buscarPorId(Integer id) {
        logger.info("iniciando la operacion de buscado de un odontologo con id : "+id);
        Connection connection= null;
        Odontologo odontologo= null;
        try{
            connection= getConnection();
            Statement statement= connection.createStatement();
            PreparedStatement psSElectOne= connection.prepareStatement(SQL_SELECT_ONE);
            psSElectOne.setInt(1,id);
            ResultSet rs= psSElectOne.executeQuery();
            OdontologoDaoH2 daoAux= new OdontologoDaoH2();
            while(rs.next()){
                odontologo= new Odontologo(rs.getInt(1),rs.getInt(2),rs.getString(3),rs.getString(4));
            }


        }catch (Exception e){
            logger.error(e.getMessage());
        }


        return odontologo;
    }

    @Override
    public List<Odontologo> buscarTodos() {
        logger.info("iniciando las operaciones de:  listado de todos los odontologos");
        List<Odontologo> listaOdontologos= new ArrayList<>();
        Odontologo odontologo= null;
        Connection connection= null;
        try{
            connection= getConnection();
            Statement statement= connection.createStatement();
            ResultSet rs= statement.executeQuery(SQL_FINDALL);
            while (rs.next()){
                //construir el odontologo
                odontologo= new Odontologo(rs.getInt(1), rs.getInt(2), rs.getString(3), rs.getString(4));
                //solo me resta agregarselo a la lista.
                listaOdontologos.add(odontologo);
            }

        }catch (Exception e){
            logger.error(e.getMessage());
        }
        return listaOdontologos;
    }

    @Override
    public void eliminar(Integer id) {

    }

    @Override
    public void actualizar(Odontologo odontologo) {

    }

    @Override
    public Odontologo buscarPorString(String string) {
        Connection connection=null;
        Odontologo odontologo= null;

        return odontologo;
    }
}

