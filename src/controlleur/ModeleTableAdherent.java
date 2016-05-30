/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlleur;

import accesOracle.DaoAdherent;
import accesOracle.DaoEmploye;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.table.AbstractTableModel;
import metier.Adherent;

/**
 *
 * @author P1313115
 */
public class ModeleTableAdherent extends AbstractTableModel {

    private List<Adherent> leConteneur;
    private String[] nomColonnes = {"Numéro", "Nom", "Prenom", "Adresse","cp","MDP", "Telephone", "Mail",
        "Photo","Date Inscription","Id","numero Abonnement"};
    private DaoAdherent leDao;
    //private DaoEmploye leDaoEmp;

    public ModeleTableAdherent(DaoAdherent leDao) {
        this.leDao = leDao;
        leConteneur = new ArrayList<>();
        try {
            charger();
        } catch (SQLException ex) {
            Logger.getLogger(ModeleTableAdherent.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public int getRowCount() {
        return leConteneur.size();
    }

    @Override
    public int getColumnCount() {
        return nomColonnes.length;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        Adherent adh = leConteneur.get(rowIndex);
        switch (columnIndex) {
            case 0:
                return adh.getNumAdherent();
            case 1:
                return adh.getNomAdherent();
            case 2:
                return adh.getPrenomAdherent();
            case 3:
                return adh.getAdresseAdherent();
            case 4:
                return adh.getCpAdherent();
            case 5:
                return adh.getMdpAdherent();
            case 6:
                return adh.getTelAdherent();
            case 7:
                return adh.getMailAdherent();
            case 8:
                return adh.getPhotoAdherent();
            case 9:
                return adh.getDateInscriptionAdherent();
            case 10:
                return adh.getIdAdherent();
            case 11:
                return adh.getNumAbonnement();    
                        
        }
        return null;
    }

    @Override
    public String getColumnName(int col) {
        return nomColonnes[col];
    }

    public void charger() throws SQLException {
        leDao.lireAdherent(leConteneur);
        //leDaoEmp.lireEmploye(leConteneur);
        
    }

    public void supprimer(int numeroLigne) {
        leConteneur.remove(numeroLigne);
        this.fireTableDataChanged();

    }

    public void insererLigne(Adherent adh) {
        leConteneur.add(adh);
        this.fireTableDataChanged();
    }
}
