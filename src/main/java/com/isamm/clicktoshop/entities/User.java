package com.isamm.clicktoshop.entities;

import java.util.Collection;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.Size;
import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.NotEmpty;

@Entity
@Table(name="users")
public  class User {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Long iduser;
	@NotEmpty
	@Size(min=4,max=15)
	@Column(unique = true)
	private String username;
	@NotEmpty
	private String password;
	private boolean actived = true ;
	@Email
    @NotEmpty
    private String email;
	@OneToMany(cascade=CascadeType.ALL , fetch=FetchType.EAGER)
	@JoinColumn(name="iduser" )
	private Collection<Role> roles ;
	
	@OneToMany(mappedBy="acheteur")
	private Collection<Commande> commandes ;
	
	@OneToOne(mappedBy = "vendeur", cascade=CascadeType.ALL)
    private Boutique boutique;
	
	
	
	private String adresse ;
	private String tel ;
	public User() {
		super();
		// TODO Auto-generated constructor stub
	}
	

	


	public User(String username, String password, boolean actived, String email, Collection<Role> roles, String adresse,
			String tel) {
		super();
		this.username = username;
		this.password = password;
		this.actived = actived;
		this.email = email;
		this.roles = roles;
		this.adresse = adresse;
		this.tel = tel;
	}





	public Long getIduser() {
		return iduser;
	}
	public void setIduser(Long iduser) {
		this.iduser = iduser;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public boolean isActived() {
		return actived;
	}
	public void setActived(boolean actived) {
		this.actived = actived;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public Collection<Role> getRoles() {
		return roles;
	}
	public void setRoles(Collection<Role> roles) {
		this.roles = roles;
	}


	public String getAdresse() {
		return adresse;
	}


	public void setAdresse(String adresse) {
		this.adresse = adresse;
	}


	public String getTel() {
		return tel;
	}


	public void setTel(String tel) {
		this.tel = tel;
	}





	public Collection<Commande> getCommandes() {
		return commandes;
	}





	public void setCommandes(Collection<Commande> commandes) {
		this.commandes = commandes;
	}





	public Boutique getBoutique() {
		return boutique;
	}





	public void setBoutique(Boutique boutique) {
		this.boutique = boutique;
	}





	
	
	

}
