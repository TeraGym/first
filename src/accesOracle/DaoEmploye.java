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

    public void lireEmploye(List<Employe> LesEmployes) throws SQLException {
        String requete = "select * from EMPLOYE";
        PreparedStatement pstmt = cnx.prepareStatement(requete);
        ResultSet rset = pstmt.executeQuery(requete);
        while (rset.next()) {
            int numEmploye = Integer.parseInt(rset.getString(1));
            String nomEmploye = rset.getString(2);
            String prenomEmploye = rset.getString(3);
            String adresseEmploye = rset.getString(4);

            Employe temp = new Employe(numEmploye, nomEmploye, prenomEmploye, adresseEmploye);

            LesEmployes.add(temp);

        }
        rset.close();
    }

    public boolean estEmploye(int numEmploye, String password) throws SQLException {
        String requete = "select 1 from EMPLOYE where numeroemploye = " + numEmploye + "and mdpemploye = " + password;
        PreparedStatement pstmt = cnx.prepareStatement(requete);
        ResultSet rset = pstmt.executeQuery(requete);
        boolean resultat = rset.next();
        pstmt.close();
        return resultat;
    }

    public Employe lireUnEmploye(int numEmp) throws SQLException {
        String requete = "select * from EMPLOYE where numeroEmploye = " + numEmp; 
        PreparedStatement pstmt = cnx.prepareStatement(requete);
        ResultSet rset = pstmt.executeQuery(requete);
        Employe temp = null;
        rset.next();
            int numEmploye = Integer.parseInt(rset.getString(1));
            String nomEmploye = rset.getString(2);
            String prenomEmploye = rset.getString(3);
            String adresseEmploye = rset.getString(4);
//            CPEMPLOYE
//                    TELEMPLOYE
//                    SECURITESOCIALE
//                            NUMEROPOSTE
//                            NUMEROPROFIL
//                                    NUMEROADHERENT
//                                    NUMEROACTIVITE
//                                            MDPEMPLOYE

            temp = new Employe(numEmploye, nomEmploye, prenomEmploye, adresseEmploye);
 
        rset.close();
        
        return temp;
     
        
    

        
    }//fin lireUnEmploye
}// fin dao
