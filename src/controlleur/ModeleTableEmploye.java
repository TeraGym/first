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
import metier.Employe;

/**
 *
 * @author P1313115
 */
public class ModeleTableEmploye extends AbstractTableModel {

    private List<Employe> leConteneur;
    private String[] nomColonnes = {"Numéro","Nom", "Prenom","Adresse","Code postale","Telephone","Securite Sociale","MDP","numPoste"};
    private DaoEmploye leDao;
    //private DaoEmploye leDaoEmp;

    public ModeleTableEmploye(DaoEmploye leDao) {
        this.leDao = leDao;
        leConteneur = new ArrayList<>();
        try {
           charger();
        } catch (SQLException ex) {
            Logger.getLogger(ModeleTableEmploye.class.getName()).log(Level.SEVERE, null, ex);
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
        Employe emp = leConteneur.get(rowIndex);
        switch (columnIndex) {
            case 0:
                return emp.getNumEmploye();
            case 1:
                return emp.getNomEmploye();
            case 2:
                return emp.getPrenomEmploye();
            case 3:
                return emp.getAdresseEmploye();
            case 4:
                return emp.getCpEmploye();
            case 5:
                return emp.getTelEmploye();
            case 6:
                return emp.getSecuriteSocialeEmploye();
            case 7:
                return emp.getMdpEmploye();  
            case 8:
                return emp.getNumPoste();  
                        
        }
        return null;
    }

    @Override
    public String getColumnName(int col) {
        return nomColonnes[col];
    }

    public void charger() throws SQLException {
        leDao.lireEmploye(leConteneur);
        //leDaoEmp.lireEmploye(leConteneur);
        
    }

    public void supprimer(int numeroLigne) {
        leConteneur.remove(numeroLigne);
        this.fireTableDataChanged();

    }

    public void insererLigne(Employe emp) {
        leConteneur.add(emp);
        this.fireTableDataChanged();
    }
}
