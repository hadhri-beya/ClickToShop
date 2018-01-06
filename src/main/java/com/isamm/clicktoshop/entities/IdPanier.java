package com.isamm.clicktoshop.entities;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Embeddable;

@Embeddable
public class IdPanier implements Serializable {

	@Column(name = "iduser")
	private Long iduser;
	@Column(name = "idProduit")
	private Long idProduit;
	
	public IdPanier() {
		super();
		// TODO Auto-generated constructor stub
	}
	public IdPanier(Long iduser, Long idProduit) {
		super();
		this.iduser = iduser;
		this.idProduit = idProduit;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((idProduit == null) ? 0 : idProduit.hashCode());
		result = prime * result + ((iduser == null) ? 0 : iduser.hashCode());
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		IdPanier other = (IdPanier) obj;
		if (idProduit == null) {
			if (other.idProduit != null)
				return false;
		} else if (!idProduit.equals(other.idProduit))
			return false;
		if (iduser == null) {
			if (other.iduser != null)
				return false;
		} else if (!iduser.equals(other.iduser))
			return false;
		return true;
	}
	public Long getIduser() {
		return iduser;
	}
	public void setIduser(Long iduser) {
		this.iduser = iduser;
	}
	public Long getIdProduit() {
		return idProduit;
	}
	public void setIdProduit(Long idProduit) {
		this.idProduit = idProduit;
	}
	
	
	
	
}
