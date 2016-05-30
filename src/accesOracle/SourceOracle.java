/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package accesOracle;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;

/**
 *
 * @author P1313115
 */
public class SourceOracle {

    public static Connection getConnexion() throws FileNotFoundException, IOException, SQLException {

        java.util.Properties props;
        props = new java.util.Properties();
        java.io.FileInputStream fichier;
        fichier = new java.io.FileInputStream("./src/accesOracle/connexion.properties");
        props.load(fichier);
        oracle.jdbc.pool.OracleDataSource ods;
        ods = new oracle.jdbc.pool.OracleDataSource();
        ods.setDriverType(props.getProperty("pilote"));
        ods.setPortNumber(Integer.parseInt(props.getProperty("port")));
        ods.setDatabaseName(props.getProperty("service"));
        ods.setUser(props.getProperty("user"));
        ods.setPassword(props.getProperty("pwd"));
        ods.setServerName(props.getProperty("serveur"));

        return ods.getConnection();

    }

}
