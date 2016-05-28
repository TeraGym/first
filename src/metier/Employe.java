/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package metier;

/**
 *
 * @author Administrateur
 */
public class Employe {

    private int numEmploye;
    private String nomEmploye;
    private String prenomEmploye;
    private String adresseEmploye;
    private String cpEmploye;
    private String telEmploye;
    private String securiteSocialeEmploye;
    private String mdpEmploye;
    private int numPoste;


    public Employe(int numEmploye, String nomEmploye, String prenomEmploye, String adresseEmploye, String cpEmploye,
            String telEmploye, String securiteSocialeEmploye, String mdpEmploye, int numPoste) {
        this.numEmploye = numEmploye;
        this.nomEmploye = nomEmploye;
        this.prenomEmploye = prenomEmploye;
        this.adresseEmploye = adresseEmploye;
        this.cpEmploye = cpEmploye;
        this.telEmploye = telEmploye;
        this.securiteSocialeEmploye = securiteSocialeEmploye;
        this.mdpEmploye = mdpEmploye;
        this.numPoste = numPoste;
    }

    public int getNumPoste() {
        return numPoste;
    }

    public void setNumPoste(int numPoste) {
        this.numPoste = numPoste;
    }

    public String getSecuriteSocialeEmploye() {
        return securiteSocialeEmploye;
    }

    public void setSecuriteSocialeEmploye(String securiteSocialeEmploye) {
        this.securiteSocialeEmploye = securiteSocialeEmploye;
    }

    public String getCpEmploye() {
        return cpEmploye;
    }

    public void setCpEmploye(String cpEmploye) {
        this.cpEmploye = cpEmploye;
    }

    public String getTelEmploye() {
        return telEmploye;
    }

    public void setTelEmploye(String telEmploye) {
        this.telEmploye = telEmploye;
    }

    public String getMdpEmploye() {
        return mdpEmploye;
    }

    public void setMdpEmploye(String mdpEmploye) {
        this.mdpEmploye = mdpEmploye;
    }

    public Employe() {
    }

    public int getNumEmploye() {
        return numEmploye;
    }

    public String getNomEmploye() {
        return nomEmploye;
    }

    public String getPrenomEmploye() {
        return prenomEmploye;
    }

    public String getAdresseEmploye() {
        return adresseEmploye;
    }

    @Override
    public String toString() {
        return "Employe{" + "numEmploye=" + numEmploye + ", nomEmploye=" + nomEmploye + ", prenomEmploye=" + prenomEmploye + ", adresseEmploye=" + adresseEmploye + '}';
    }

    public void setNumEmploye(int numEmploye) {
        this.numEmploye = numEmploye;
    }

    public void setNomEmploye(String nomEmploye) {
        this.nomEmploye = nomEmploye;
    }

    public void setPrenomEmploye(String prenomEmploye) {
        this.prenomEmploye = prenomEmploye;
    }

    public void setAdresseEmploye(String adresseEmploye) {
        this.adresseEmploye = adresseEmploye;
    }

 

    public class Erreur extends Exception {

        private String message;

        public Erreur(String message) {
            this.message = message;
        }

        public String getMessage() {
            return message;
        }

        public void setMessage(String message) {
            this.message = message;
        }
    } // class Erreur
}
