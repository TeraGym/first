/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlleur;

import accesOracle.DaoAdherent;
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
public class ModeleTableCoach extends AbstractTableModel {

    private List<Adherent> leConteneur;
    private String[] nomColonnes = {"Numéro","Nom", "Prenom"};
    private DaoAdherent leDao;
    private int numero=0;
    //private DaoEmploye leDaoEmp;

    public ModeleTableCoach(DaoAdherent leDao,int num) {
        this.leDao = leDao;
        this.numero=num;
        leConteneur = new ArrayList<>();
//        try {
//            charger(numero);
//        } catch (SQLException ex) {
//            Logger.getLogger(ModeleTableCoach.class.getName()).log(Level.SEVERE, null, ex);
//        }
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
           
                        
        }
        return null;
    }

    @Override
    public String getColumnName(int col) {
        return nomColonnes[col];
    }

    public void charger(int numero) throws SQLException {
        leDao.lireAdherentEmp(leConteneur,numero);
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
