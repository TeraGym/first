/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package metier;

import java.sql.Date;

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
    private String telAdherent ;
    private String mailAdherent;
    private String photoAdherent;
    private Date dateInscriptionAdherent;
    private String IdAdherent;
    private int numAbonnement;

    public Adherent(int numAdherent, String nomAdherent, String prenomAdherent, String adresseAdherent, String cpAdherent, String mdpAdherent,
           String telAdherent, String mailAdherent, String photoAdherent, Date dateInscriptionAdherent, String IdAdherent,int numAbonnement) {
        this.numAdherent = numAdherent;
        this.nomAdherent = nomAdherent;
        this.prenomAdherent = prenomAdherent;
        this.adresseAdherent = adresseAdherent;
        this.cpAdherent = cpAdherent;
        this.mdpAdherent = mdpAdherent;
        this.telAdherent=telAdherent ;
        this.mailAdherent=mailAdherent;
        this.photoAdherent=photoAdherent;
        this.dateInscriptionAdherent=dateInscriptionAdherent;
        this.IdAdherent=IdAdherent;
        this.numAbonnement=numAbonnement;
        
    }

    public String getTelAdherent() {
        return telAdherent;
    }

    public void setTelAdherent(String telAdherent) {
        this.telAdherent = telAdherent;
    }

    public String getMailAdherent() {
        return mailAdherent;
    }

    public void setMailAdherent(String mailAdherent) {
        this.mailAdherent = mailAdherent;
    }

    public String getPhotoAdherent() {
        return photoAdherent;
    }
    
    

    public void setPhotoAdherent(String photoAdherent) {
        this.photoAdherent = photoAdherent;
    }

    public Date getDateInscriptionAdherent() {
        return dateInscriptionAdherent;
    }

    public void setDateInscriptionAdherent(Date dateInscriptionAdherent) {
        this.dateInscriptionAdherent = dateInscriptionAdherent;
    }

    public String getIdAdherent() {
        return IdAdherent;
    }

    public void setIdAdherent(String IdAdherent) {
        this.IdAdherent = IdAdherent;
    }

    public int getNumAbonnement() {
        return numAbonnement;
    }

    public void setNumAbonnement(int numAbonnement) {
        this.numAbonnement = numAbonnement;
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
