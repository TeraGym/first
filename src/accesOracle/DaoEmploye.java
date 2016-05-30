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
import metier.Adherent;
import metier.Employe;

/**
 *
 * @author P1313115
 */
public class DaoEmploye {

    private Connection cnx; // injection de dépendance
    private int poste;
    public DaoEmploye(Connection cnx) {
        this.cnx = cnx;
    }
    
    public void lireEmploye(List<Employe>LesEmployes)throws SQLException {
        String requete = "select * from EMPLOYE";
        PreparedStatement pstmt = cnx.prepareStatement(requete);
        ResultSet rset = pstmt.executeQuery(requete);
        while(rset.next()){
             int numEmploye = Integer.parseInt(rset.getString(1));
            String nomEmploye = rset.getString(2);
            String prenomEmploye = rset.getString(3);
            String adresseEmploye = rset.getString(4);
            String cpEmploye = rset.getString(5);
            String telEmploye = rset.getString(6);
            String securiteSocialeEmploye = rset.getString(7);
            String mdpEmploye = rset.getString(8);
            int numPoste = Integer.parseInt(rset.getString(9));
            
            Employe temp = new Employe(numEmploye,nomEmploye,prenomEmploye,adresseEmploye,
                    cpEmploye,telEmploye,securiteSocialeEmploye, mdpEmploye, numPoste);
            
            LesEmployes.add(temp);
            
        }
        rset.close();
    }
    
     public boolean estEmploye(int numEmploye, String password ) throws SQLException {
        String requete = "select 1 from EMPLOYE where numeroEmploye = " + numEmploye + "and mdpEmploye = " + password;
        PreparedStatement pstmt = cnx.prepareStatement(requete);
        ResultSet rset = pstmt.executeQuery(requete);
        boolean resultat = rset.next();
        pstmt.close();
        return resultat;
    }
     
  
    public int sonPoste(int numEmploye) throws SQLException {
        String requete = "select * from EMPLOYE where numeroemploye = " + numEmploye;
        PreparedStatement pstmt = cnx.prepareStatement(requete);
        ResultSet rset = pstmt.executeQuery(requete);
        while (rset.next()){
            int num = Integer.parseInt(rset.getString(1));
            String nomEmploye = rset.getString(2);
            String prenomEmploye = rset.getString(3);
            String adresseEmploye = rset.getString(4);
            String cpEmploye = rset.getString(5);
            String telEmploye = rset.getString(6);
            String securiteSocialeEmploye = rset.getString(7);
            String mdpEmploye = rset.getString(8);
            this.poste = Integer.parseInt(rset.getString(9));
        }
        
        pstmt.close();
        return poste;
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
            String cpEmploye = rset.getString(5);
            String telEmploye = rset.getString(6);
            String securiteSocialeEmploye = rset.getString(7);
            String mdpEmploye = rset.getString(8);
            int numPoste = Integer.parseInt(rset.getString(9));

//            Employe(numEmploye, nomEmploye, prenomEmploye, adresseEmploye,cpEmploye,telEmploye,securiteSocialeEmploye,poste);
         temp = new  Employe(numEmploye,nomEmploye,prenomEmploye,adresseEmploye,cpEmploye,telEmploye, securiteSocialeEmploye,mdpEmploye,numPoste);
        rset.close();
        
        return temp;
     
 
    }//fin lireUnEmploye
        
         public void lireAdherentCoach(List<Adherent> LesAdherents, int numero) throws SQLException {
        String requete = "select * from ADHERENT where numeroemploye = " + numero + " order by numeroadherent";
        PreparedStatement pstmt = cnx.prepareStatement(requete);
        ResultSet rset = pstmt.executeQuery(requete);
        while (rset.next()) {
            int numAdherent = Integer.parseInt(rset.getString(1));
            String nomAdherent = rset.getString(2);
            String prenomAdherent = rset.getString(3);
            String adresseAdherent = rset.getString(4);
            String cpAdherent = rset.getString(5);
            String mdpAdherent = rset.getString(6);

            Adherent temp = new Adherent(numAdherent, nomAdherent, prenomAdherent, adresseAdherent, cpAdherent, mdpAdherent);

            LesAdherents.add(temp);

        }
        rset.close();

    }

}


