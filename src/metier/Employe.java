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

    private String numEmploye;
    private String nomEmploye;
    private String prenomEmploye;
    private String adresseEmploye;

    public Employe(String numEmploye, String nomEmploye, String prenomEmploye, String adresseEmploye) {
        this.numEmploye = numEmploye;
        this.nomEmploye = nomEmploye;
        this.prenomEmploye = prenomEmploye;
        this.adresseEmploye = adresseEmploye;
    }

    public Employe() {
    }

    public String getNumEmploye() {
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

    public void setNumEmploye(String numEmploye) {
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
