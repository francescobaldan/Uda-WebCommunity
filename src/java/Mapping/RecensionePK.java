/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Mapping;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.validation.constraints.NotNull;

/**
 *
 * @author Sprizzetto
 */
@Embeddable
public class RecensionePK implements Serializable {

    @Basic(optional = false)
    @NotNull
    @Column(name = "IdMembro")
    private int idMembro;
    @Basic(optional = false)
    @NotNull
    @Column(name = "IdEvento")
    private int idEvento;

    public RecensionePK() {
    }

    public RecensionePK(int idMembro, int idEvento) {
        this.idMembro = idMembro;
        this.idEvento = idEvento;
    }

    public int getIdMembro() {
        return idMembro;
    }

    public void setIdMembro(int idMembro) {
        this.idMembro = idMembro;
    }

    public int getIdEvento() {
        return idEvento;
    }

    public void setIdEvento(int idEvento) {
        this.idEvento = idEvento;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (int) idMembro;
        hash += (int) idEvento;
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof RecensionePK)) {
            return false;
        }
        RecensionePK other = (RecensionePK) object;
        if (this.idMembro != other.idMembro) {
            return false;
        }
        if (this.idEvento != other.idEvento) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Mapping.RecensionePK[ idMembro=" + idMembro + ", idEvento=" + idEvento + " ]";
    }
    
}
