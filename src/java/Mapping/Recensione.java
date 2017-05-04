/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Mapping;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author FSEVERI\sbrizza3331
 */
@Entity
@Table(name = "RECENSIONI")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Recensioni.findAll", query = "SELECT r FROM Recensioni r"),
    @NamedQuery(name = "Recensioni.findByIdMembro", query = "SELECT r FROM Recensioni r WHERE r.recensioniPK.idMembro = :idMembro"),
    @NamedQuery(name = "Recensioni.findByIdEvento", query = "SELECT r FROM Recensioni r WHERE r.recensioniPK.idEvento = :idEvento"),
    @NamedQuery(name = "Recensioni.findByCommento", query = "SELECT r FROM Recensioni r WHERE r.commento = :commento"),
    @NamedQuery(name = "Recensioni.findByVoto", query = "SELECT r FROM Recensioni r WHERE r.voto = :voto")})
public class Recensione implements Serializable {
    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected RecensionePK recensioniPK;
    @Size(max = 200)
    @Column(name = "Commento")
    private String commento;
    @Basic(optional = false)
    @NotNull
    @Column(name = "Voto")
    private int voto;
    @JoinColumn(name = "IdMembro", referencedColumnName = "IdMembro", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Membro membri;
    @JoinColumn(name = "IdEvento", referencedColumnName = "IdEvento", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Evento eventi;

    public Recensione() {
    }

    public Recensione(RecensionePK recensioniPK) {
        this.recensioniPK = recensioniPK;
    }

    public Recensione(RecensionePK recensioniPK, int voto) {
        this.recensioniPK = recensioniPK;
        this.voto = voto;
    }

    public Recensione(int idMembro, int idEvento) {
        this.recensioniPK = new RecensionePK(idMembro, idEvento);
    }
    
    public Recensione(int idMembro, int idEvento, String commento, int voto) {
        this.recensioniPK = new RecensionePK(idMembro, idEvento);
        this.commento=commento;
        this.voto=voto;
    }

    public RecensionePK getRecensioniPK() {
        return recensioniPK;
    }

    public void setRecensioniPK(RecensionePK recensioniPK) {
        this.recensioniPK = recensioniPK;
    }

    public String getCommento() {
        return commento;
    }

    public void setCommento(String commento) {
        this.commento = commento;
    }

    public int getVoto() {
        return voto;
    }

    public void setVoto(int voto) {
        this.voto = voto;
    }

    public Membro getMembri() {
        return membri;
    }

    public void setMembri(Membro membri) {
        this.membri = membri;
    }

    public Evento getEventi() {
        return eventi;
    }

    public void setEventi(Evento eventi) {
        this.eventi = eventi;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (recensioniPK != null ? recensioniPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Recensione)) {
            return false;
        }
        Recensione other = (Recensione) object;
        if ((this.recensioniPK == null && other.recensioniPK != null) || (this.recensioniPK != null && !this.recensioniPK.equals(other.recensioniPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Mapping.Recensioni[ recensioniPK=" + recensioniPK + " ]";
    }
    
}
