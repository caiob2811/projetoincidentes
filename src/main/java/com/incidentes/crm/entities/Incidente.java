package com.incidentes.crm.entities;

import java.io.Serializable;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import org.springframework.web.bind.annotation.GetMapping;

@Entity
@Table(name ="tb_incidente")
public class Incidente implements Serializable {
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id_incident;
	private String closed_at;
	private String creat_at;
	private String description_incident;
	private String name;
	private String update_at;
	private String status;
	

	public Incidente() {
	}

	public Incidente(Long id_incident, String closed_at, String creat_at, String description_incident, String name,
			String update_at, String status) {
		super();
		this.id_incident = id_incident;
		this.closed_at = closed_at;
		this.creat_at = creat_at;
		this.description_incident = description_incident;
		this.name = name;
		this.update_at = update_at;
		this.status = status;
	}

	public Long getId_incident() {
		return id_incident;
	}

	public void setId_incident(Long id_incident) {
		this.id_incident = id_incident;
	}

	public String getClosed_at() {
		return closed_at;
	}

	public void setClosed_at(String closed_at) {
		this.closed_at = closed_at;
	}

	public String getCreat_at() {
		return creat_at;
	}

	public void setCreat_at(String creat_at) {
		this.creat_at = creat_at;
	}

	public String getDescription_incident() {
		return description_incident;
	}

	public void setDescription_incident(String description_incident) {
		this.description_incident = description_incident;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getUpdate_at() {
		return update_at;
	}

	public void setUpdate_at(String update_at) {
		this.update_at = update_at;
	}

	public String getStatus(){
		return status;
	}
	public void setStatus(String status){
		this.status = status;
	}


	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id_incident == null) ? 0 : id_incident.hashCode());
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
		Incidente other = (Incidente) obj;
		if (id_incident == null) {
			if (other.id_incident != null)
				return false;
		} else if (!id_incident.equals(other.id_incident))
			return false;
		return true;
	}
}
