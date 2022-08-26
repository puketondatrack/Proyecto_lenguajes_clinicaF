package conexion;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class conexionOracle {
    public static Connection conectar () throws SQLException{
        try{
      
    Class.forName("oracle.jdbc.driver.OracleDriver");
    String BD = "jdbc:oracle:thin:@//localhost:1521/orcl";
    String USUARIO = "kevin";
    String PASSWORD = "alberto12345678";
            System.out.println("CONECTADO A ORACLE");
    return DriverManager.getConnection(BD, USUARIO, PASSWORD);
        }catch(ClassNotFoundException e)
        {throw new SQLException (e.getMessage());
        }
    }
}