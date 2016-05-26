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
public class Adherent {

    private int numAdherent;
    private String nomAdherent;
    private String prenomAdherent;
    private String adresseAdherent;
    private String cpAdherent;
    private String mdpAdherent;
    

    public Adherent(int numAdherent, String nomAdherent, String prenomAdherent, String adresseAdherent, String cpAdherent, String mdpAdherent) {
        this.numAdherent = numAdherent;
        this.nomAdherent = nomAdherent;
        this.prenomAdherent = prenomAdherent;
        this.adresseAdherent = adresseAdherent;
        this.cpAdherent = cpAdherent;
        this.mdpAdherent = mdpAdherent;
    }

    public Adherent() {
    }

    public int getNumAdherent() {
        return numAdherent;
    }

    public String getMdpAdherent() {
        return mdpAdherent;
    }

    public int getAdherent() {
        return numAdherent;
    }

    public String getNomAdherent() {
        return nomAdherent;
    }

    public String getPrenomAdherent() {
        return prenomAdherent;
    }

    public String getAdresseAdherent() {
        return adresseAdherent;
    }

    public String getCpAdherent() {
        return cpAdherent;
    }

    @Override
    public String toString() {
        return "Adherent{" + "numAdherent=" + numAdherent + ", nomAdherent=" + nomAdherent + ", prenomAdherent=" + prenomAdherent + ", adresseAdherent=" + adresseAdherent + '}';
    }

    public void setNumAdherent(int numAdherent) {
        this.numAdherent = numAdherent;
    }

    public void setNomAdherent(String nomAdherent) {
        this.nomAdherent = nomAdherent;
    }

    public void setPrenomAdherent(String prenomAdherent) {
        this.prenomAdherent = prenomAdherent;
    }

    public void setAdresseAdherent(String adresseAdherent) {
        this.adresseAdherent = adresseAdherent;
    }

    public void setCpAdherent(String cpAdherent) {
        this.cpAdherent = cpAdherent;
    }

    public void setMdpAdherent(String MdpAdherent) {
        this.mdpAdherent = MdpAdherent;
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
