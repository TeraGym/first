/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package accesOracle;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import javax.swing.ImageIcon;
import metier.Adherent;

/**
 *
 * @author P1313115
 */
public class DaoAdherent {

    private final Connection cnx; // injection de dépendance
    private ImageIcon photoAdherent;
    public DaoAdherent(Connection cnx) {
        this.cnx = cnx;
    }
    
    public void lireAdherent(List<Adherent>LesAdherents)throws SQLException {
        String requete = "select * from ADHERENT";
        PreparedStatement pstmt = cnx.prepareStatement(requete);
        ResultSet rset = pstmt.executeQuery(requete);
        while(rset.next()){
            int numAdherent = Integer.parseInt(rset.getString(1));
            String nomAdherent = rset.getString(2);
            String prenomAdherent = rset.getString(3);
            String adresseAdherent = rset.getString(4);
            String cpAdherent = rset.getString(5);
            String mdpAdherent = rset.getString(6);
            String telAdherent = rset.getString(7);
            String mailAdherent = rset.getString(8);
            String photoAdherent = rset.getString(9);
            Date dateInscriptionAdherent = rset.getDate(10);
            String IdAdherent = rset.getString(11);
            int numAbonnement = Integer.parseInt(rset.getString(12));
            
            
            
            Adherent temp = new Adherent(numAdherent,nomAdherent,prenomAdherent,adresseAdherent,cpAdherent,mdpAdherent,telAdherent,
            mailAdherent,photoAdherent,dateInscriptionAdherent,IdAdherent,numAbonnement);
            
            LesAdherents.add(temp);
            
        }
        rset.close();

        
    }
    
    public boolean estAdherent(int numAdherent, String password ) throws SQLException {
        String requete = "select 1 from ADHERENT where numeroadherent = " + numAdherent + "and mdpadherent = " + password;
        PreparedStatement pstmt = cnx.prepareStatement(requete);
        ResultSet rset = pstmt.executeQuery(requete);
        boolean resultat = rset.next();
        pstmt.close();
        return resultat;
    }
    
//    public ImageIcon saPhoto(int numAdherent) throws SQLException {
//         String requete = "select nomadherent, photoadherent from ADHERENT where numeroadherent = " + numAdherent;
//        PreparedStatement pstmt = cnx.prepareStatement(requete);
//        ResultSet rset = pstmt.executeQuery(requete);
//        
//        while(rset.next()){
//            String nom = rset.getString(1);
//            String photo = rset.getString(2);
//            
//            
//        }
//        pstmt.close();
//         rset.close();
//        return photo.pitt.jpg;
//    }
    
    
    //générer un identifiant unique 
    public void IdAdherentGenerator(int numAdh) throws SQLException {
        String prerequete = "select nomadherent, prenomadherent from ADHERENT where numeroadherent = " + numAdh;
        PreparedStatement pstmt1 = cnx.prepareStatement(prerequete);
        ResultSet rset1 = pstmt1.executeQuery(prerequete);
        pstmt1.close();
                while (rset1.next()){
            String nomAdherent = rset1.getString(1);
            String prenomAdherent = rset1.getString(2);
         
        String requete="";
        if(numAdh >=0 && numAdh <10){
             requete = "update ADHERENT "
                + "Set identifiantAdherent='"+prenomAdherent+"."+nomAdherent+"' "
                + "where numeroadherent="+numAdh;
        } else if(numAdh >=10 && numAdh <100){
            requete = "update ADHERENT "
                + "Set identifiantAdherent='"+prenomAdherent+"."+nomAdherent+"' "
                + "where numeroadherent="+numAdh;
        }else if(numAdh >=100 && numAdh <1000){
            requete = "update ADHERENT "
                + "Set identifiantAdherent='"+prenomAdherent+"."+nomAdherent+"' "
                + "where numeroadherent="+numAdh;
        }
        PreparedStatement pstmt = cnx.prepareStatement(requete);
        ResultSet rset = pstmt.executeQuery(requete);
         rset.close();
        }
                 rset1.close();
    }
    
   //créer un adherent
   //supprimer un adherent
   //modifier un adherent
   
}


