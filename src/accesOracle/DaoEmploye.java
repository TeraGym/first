/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package accesOracle;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import metier.Employe;

/**
 *
 * @author P1313115
 */
public class DaoEmploye {

    private Connection cnx; // injection de dépendance

    public DaoEmploye(Connection cnx) {
        this.cnx = cnx;
    }
    
    public void lireEmploye(List<Employe>LesEmployes)throws SQLException {
        String requete = "select * from EMPLOYE";
        PreparedStatement pstmt = cnx.prepareStatement(requete);
        ResultSet rset = pstmt.executeQuery(requete);
        while(rset.next()){
            String numEmploye = rset.getString(1);
            String nomEmploye = rset.getString(2);
            String prenomEmploye = rset.getString(3);
            String adresseEmploye = rset.getString(4);
            
            Employe temp = new Employe(numEmploye,nomEmploye,prenomEmploye,adresseEmploye);
            
            LesEmployes.add(temp);
            
        }
        rset.close();
    }
}


