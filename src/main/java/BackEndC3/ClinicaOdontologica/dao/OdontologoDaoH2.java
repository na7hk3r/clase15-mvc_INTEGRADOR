package BackEndC3.ClinicaOdontologica.dao;

import BackEndC3.ClinicaOdontologica.model.Domicilio;
import BackEndC3.ClinicaOdontologica.model.Odontologo;
import BackEndC3.ClinicaOdontologica.model.Paciente;
import org.apache.log4j.Logger;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class OdontologoDaoH2 implements iDao<Odontologo> {

    private final static String DB_JDBC_DRIVER = "org.h2.Driver";
    private final static String DB_URL = "jdbc:h2:~/db_odontologos_clinica_dental";
    private final static String DB_USER ="sa";
    private final static String DB_PASSWORD = "sa";

    //Sentencias SQL
    private final static String SQL_CREATE_TABLE = "CREATE TABLE IF NOT EXISTS odontologos"
            + "("
            + " id INT PRIMARY KEY AUTO_INCREMENT,"
            + " nroMatricula INT NOT NULL,"
            + " nombre varchar(25) NOT NULL,"
            + " apellido varchar(25) NOT NULL"
            + ");";

    //SQL para insertar registros
    private final static String SQL_INSERT = "INSERT INTO ODONTOLOGOS ( nroMatricula, nombre, apellido) VALUES (?,?,?)";

    //SQL para listar todos los odontólogos
    private final static String SQL_FINDALL="SELECT * FROM ODONTOLOGOS ";
    private static final String SQL_SELECT_ONE="SELECT * FROM ODONTOLOGOS WHERE ID=?";

    private static final Logger logger = Logger.getLogger(OdontologoDaoH2.class);

    public static Connection getConnection()  {
        Connection connection = null;
        try {
            Class.forName(DB_JDBC_DRIVER);
            connection= DriverManager.getConnection(DB_URL,DB_USER,DB_PASSWORD);

            Statement statement = connection.createStatement();
            logger.info("Conexión exitosa a la tabla");
            statement.execute(SQL_CREATE_TABLE);

        }  catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
            logger.error("error de conexión a la BD");
        }
        return connection;
    }


    @Override
    public Odontologo guardar(Odontologo odontologo) {
        PreparedStatement psInsert=null;
        //1 Levantar el driver y conectarnos
        try {

            //2 Crear una sentencia
            psInsert=getConnection().prepareStatement(SQL_INSERT);
            psInsert.setInt(1,odontologo.getNroMatricula());
            psInsert.setString(2,odontologo.getNombre());
            psInsert.setString(3,odontologo.getApellido());

            //3 Ejecutar la setencia

            psInsert.execute();
            logger.info("se ha insertado el registro con matricula " + odontologo.getNroMatricula()+ " correspondiente a "+odontologo.getNombre()+odontologo.getApellido()+" en la BD");
            psInsert.close();

        } catch (SQLException e) {
            e.printStackTrace();
            logger.error("error en la inserción del registro a la BD");

        }
        return odontologo;
    }

    @Override
    public Odontologo buscarPorId(Integer id) {
        logger.info("iniciando la operacion de buscado de un odontologo con id : "+id);
        Connection connection= null;
        Odontologo odontologo= null;
        try{
            connection= BD.getConnection();
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
        PreparedStatement psBuscarTodos=null;
        List<Odontologo> odontologos=new ArrayList<>();
        Odontologo odontologo=null;

        try {

            //1 conectarme y crear sentencia
            psBuscarTodos=getConnection().prepareStatement(SQL_FINDALL);

            //3 Ejecutar la setencia

            ResultSet rs = psBuscarTodos.executeQuery();

            //Armar objeto con datos obtenidos
            while (rs.next()) {
                logger.info("buscando la información del odontólogo");

                Integer idOdontologo = rs.getInt(1);
                Integer nroMatricula = rs.getInt(2);
                String nombre = rs.getString(3);
                String apellido = rs.getString(4);

                odontologo = new Odontologo( idOdontologo,nroMatricula,nombre, apellido );

                odontologos.add(odontologo);
            }
            logger.info("la lista de odontólogos es "+odontologos);
            psBuscarTodos.close();

        } catch (SQLException e) {
            e.printStackTrace();
            logger.error("error buscando los odontólogos en la BD");

        }

        return odontologos;
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

