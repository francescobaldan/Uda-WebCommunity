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
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
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
@Table(name = "MEMBRI")
@XmlRootElement
public class Membro implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "IdMembro")
    private Integer idMembro;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 30)
    @Column(name = "Nickname")
    private String nickname;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 15)
    @Column(name = "Password")
    private String password;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 20)
    @Column(name = "Nome")
    private String nome;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 20)
    @Column(name = "Cognome")
    private String cognome;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 40)
    @Column(name = "Mail")
    private String mail;
    @JoinTable(name = "PREFERENZE", joinColumns = {
        @JoinColumn(name = "IdMembro", referencedColumnName = "IdMembro")}, inverseJoinColumns = {
        @JoinColumn(name = "IdCategoria", referencedColumnName = "IdCategoria")})
    @ManyToMany
    private Collection<Categoria> categorieCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "membri")
    private Collection<Recensione> recensioniCollection;

    public Membro() {
    }

    public Membro(Integer idMembro) {
        this.idMembro = idMembro;
    }

    public Membro(Integer idMembro, String nickname, String password, String nome, String cognome, String mail) {
        this.idMembro = idMembro;
        this.nickname = nickname;
        this.password = password;
        this.nome = nome;
        this.cognome = cognome;
        this.mail = mail;
    }

    public Integer getIdMembro() {
        return idMembro;
    }

    public void setIdMembro(Integer idMembro) {
        this.idMembro = idMembro;
    }

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCognome() {
        return cognome;
    }

    public void setCognome(String cognome) {
        this.cognome = cognome;
    }

    public String getMail() {
        return mail;
    }

    public void setMail(String mail) {
        this.mail = mail;
    }

    @XmlTransient
    public Collection<Categoria> getCategorieCollection() {
        return categorieCollection;
    }

    public void setCategorieCollection(Collection<Categoria> categorieCollection) {
        this.categorieCollection = categorieCollection;
    }

    @XmlTransient
    public Collection<Recensione> getRecensioniCollection() {
        return recensioniCollection;
    }

    public void setRecensioniCollection(Collection<Recensione> recensioniCollection) {
        this.recensioniCollection = recensioniCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idMembro != null ? idMembro.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Membro)) {
            return false;
        }
        Membro other = (Membro) object;
        if ((this.idMembro == null && other.idMembro != null) || (this.idMembro != null && !this.idMembro.equals(other.idMembro))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Mapping.Membri[ idMembro=" + idMembro + " ]";
    }
    
}
