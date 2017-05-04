/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Mapping;

import java.io.Serializable;
import java.util.Collection;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author FSEVERI\sbrizza3331
 */
@Entity
@Table(name = "CATEGORIE")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Categorie.findAll", query = "SELECT c FROM Categorie c"),
    @NamedQuery(name = "Categorie.findByIdCategoria", query = "SELECT c FROM Categorie c WHERE c.idCategoria = :idCategoria"),
    @NamedQuery(name = "Categorie.findByNome", query = "SELECT c FROM Categorie c WHERE c.nome = :nome"),
    @NamedQuery(name = "Categorie.findByDescrizione", query = "SELECT c FROM Categorie c WHERE c.descrizione = :descrizione")})
public class Categoria implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "IdCategoria")
    private Integer idCategoria;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 20)
    @Column(name = "Nome")
    private String nome;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 150)
    @Column(name = "Descrizione")
    private String descrizione;
    @ManyToMany(mappedBy = "categorieCollection")
    private Collection<Membro> membriCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "categoria")
    private Collection<Evento> eventiCollection;

    public Categoria() {
    }

    public Categoria(Integer idCategoria) {
        this.idCategoria = idCategoria;
    }

    public Categoria(Integer idCategoria, String nome, String descrizione) {
        this.idCategoria = idCategoria;
        this.nome = nome;
        this.descrizione = descrizione;
    }

    public Integer getIdCategoria() {
        return idCategoria;
    }

    public void setIdCategoria(Integer idCategoria) {
        this.idCategoria = idCategoria;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getDescrizione() {
        return descrizione;
    }

    public void setDescrizione(String descrizione) {
        this.descrizione = descrizione;
    }

    @XmlTransient
    public Collection<Membro> getMembriCollection() {
        return membriCollection;
    }

    public void setMembriCollection(Collection<Membro> membriCollection) {
        this.membriCollection = membriCollection;
    }

    @XmlTransient
    public Collection<Evento> getEventiCollection() {
        return eventiCollection;
    }

    public void setEventiCollection(Collection<Evento> eventiCollection) {
        this.eventiCollection = eventiCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idCategoria != null ? idCategoria.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Categoria)) {
            return false;
        }
        Categoria other = (Categoria) object;
        if ((this.idCategoria == null && other.idCategoria != null) || (this.idCategoria != null && !this.idCategoria.equals(other.idCategoria))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Mapping.Categorie[ idCategoria=" + idCategoria + " ]";
    }
    
}
