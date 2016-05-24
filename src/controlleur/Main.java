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
import java.net.PasswordAuthentication;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import vue.FenetreIdentification;
import vue.FenetreIdentification;

/**
 *
 * @author P1313115
 */
public class Main {

    //private static DaoEmploye daoEmp;
    private static DaoAdherent daoAdh;

    private enum TypeUtilisateur {

        Adherent, Employe
    };
    private static TypeUtilisateur leType;

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
                    System.out.println("erreur de connexion à la base " + ex.getMessage());
                }

                FenetreIdentification fensaisie = new FenetreIdentification(null);
                boolean etat = false;
                do {

                    PasswordAuthentication blocId = fensaisie.recuperer();
                    try {
                        int numero = Integer.parseInt(blocId.getUserName());
                        String motDePasse = new String(blocId.getPassword());

                        // recuperation du type adhérent ou employé
                        if (daoAdh.estAdherent(numero, motDePasse) == true) {
                            etat = true;
                            leType = TypeUtilisateur.Adherent;
                        }
//                        else if {
//                           les autres cas 
//                        }

                    } catch (Exception ex) {
                        System.out.println("erreur de login " + ex.getMessage());
                    }

                } while (etat == false);


                // si type adherent on lance la fenetre principale appli adhrent
                // sinon si type employé on lance la fenetre principale appli employe
                // sinon erreur
                // ModeleTable leModele = new ModeleTable(daoAdh);
                // new FenetreAffichage(leModele).setVisible(true);

                if (leType == TypeUtilisateur.Adherent) {
                    System.out.println("Type utilisateur");
                }
                
            } // run
        }
        );// new runnable

    }//fin du main

}//fin classe

