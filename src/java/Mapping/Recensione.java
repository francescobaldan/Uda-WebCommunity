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
 * @author Sprizzetto
 */
@Entity
@Table(name = "RECENSIONI")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Recensione.findAll", query = "SELECT r FROM Recensione r")
    , @NamedQuery(name = "Recensione.findByIdMembro", query = "SELECT r FROM Recensione r WHERE r.recensionePK.idMembro = :idMembro")
    , @NamedQuery(name = "Recensione.findByIdEvento", query = "SELECT r FROM Recensione r WHERE r.recensionePK.idEvento = :idEvento")
    , @NamedQuery(name = "Recensione.findByCommento", query = "SELECT r FROM Recensione r WHERE r.commento = :commento")
    , @NamedQuery(name = "Recensione.findByVoto", query = "SELECT r FROM Recensione r WHERE r.voto = :voto")})
public class Recensione implements Serializable {

    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected RecensionePK recensionePK;
    @Size(max = 200)
    @Column(name = "Commento")
    private String commento;
    @Basic(optional = false)
    @NotNull
    @Column(name = "Voto")
    private int voto;
    @JoinColumn(name = "IdMembro", referencedColumnName = "IdMembro", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Membro membro;
    @JoinColumn(name = "IdEvento", referencedColumnName = "IdEvento", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Evento evento;

    public Recensione() {
    }

    public Recensione(RecensionePK recensionePK) {
        this.recensionePK = recensionePK;
    }

    public Recensione(RecensionePK recensionePK, int voto) {
        this.recensionePK = recensionePK;
        this.voto = voto;
    }

    public Recensione(int idMembro, int idEvento) {
        this.recensionePK = new RecensionePK(idMembro, idEvento);
    }
    
    public Recensione(int idMembro, int idEvento, String commento, int voto) {
        this.recensionePK = new RecensionePK(idMembro, idEvento);
        this.commento=commento;
        this.voto = voto;
    }

    public RecensionePK getRecensionePK() {
        return recensionePK;
    }

    public void setRecensionePK(RecensionePK recensionePK) {
        this.recensionePK = recensionePK;
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

    public Membro getMembro() {
        return membro;
    }

    public void setMembro(Membro membro) {
        this.membro = membro;
    }

    public Evento getEvento() {
        return evento;
    }

    public void setEvento(Evento evento) {
        this.evento = evento;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (recensionePK != null ? recensionePK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Recensione)) {
            return false;
        }
        Recensione other = (Recensione) object;
        if ((this.recensionePK == null && other.recensionePK != null) || (this.recensionePK != null && !this.recensionePK.equals(other.recensionePK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Mapping.Recensione[ recensionePK=" + recensionePK + " ]";
    }
    
}
