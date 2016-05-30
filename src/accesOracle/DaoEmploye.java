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

    //générer un identifiant unique
        public void IdEmployeGenerator(int numEmp) throws SQLException {
        String prerequete = "select nomemploye, prenomemploye from employe where numeroemploye = " + numEmp;
        PreparedStatement pstmt1 = cnx.prepareStatement(prerequete);
        ResultSet rset1 = pstmt1.executeQuery(prerequete);
        pstmt1.close();
                while (rset1.next()){
            String nomEmploye = rset1.getString(1);
            String prenomEmploye = rset1.getString(2);
        String requete="";
        if(numEmp >=0 && numEmp <10){
             requete = "update Employe "
                + "Set identifiantEmploye='"+prenomEmploye+"."+nomEmploye+"' "
                + "where numeroEmploye="+numEmp;
        } else if(numEmp >=10 && numEmp <100){
            requete = "update Employe "
                + "Set identifiantEmploye='"+prenomEmploye+"."+nomEmploye+"' "
                + "where numeroaEmploye="+numEmp;
        }else if(numEmp >=100 && numEmp <1000){
            requete = "update Employe "
                + "Set identifiantEmploye='"+prenomEmploye+"."+nomEmploye+"' "
                + "where numeroEmploye="+numEmp;
        }
        PreparedStatement pstmt = cnx.prepareStatement(requete);
        ResultSet rset = pstmt.executeQuery(requete);
      }
    }
        
        //créer un employe
        //supprimer un employe
        //modifier un employe
   
}


