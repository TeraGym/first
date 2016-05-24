/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlleur;

import accesOracle.DaoAdherent;
import accesOracle.DaoEmploye;
import accesOracle.SourceOracle;
import vue.FenetreAffichage;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author P1313115
 */
public class Main {

    //private static DaoEmploye daoEmp;
    private static DaoAdherent daoAdh;
    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(FenetreAffichage.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(FenetreAffichage.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(FenetreAffichage.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(FenetreAffichage.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }

       

        //</editor-fold>

        /* Create and display the form */
         java.awt.EventQueue.invokeLater(new Runnable() {
         public void run() {
        
             try {
                 Connection cnx = SourceOracle.getConnexion();
                 daoAdh = new DaoAdherent(cnx);
                 System.out.println("connecté");
                
                 
             } catch (Exception ex) {
                 System.out.println("erreur" + ex.getMessage());
             } 
             
              ModeleTable leModele = new ModeleTable(daoAdh);
              new FenetreAffichage(leModele).setVisible(true);
           

         
         }
         });
    }//fin du main
    // TODO code application logic here
}//fin classe

