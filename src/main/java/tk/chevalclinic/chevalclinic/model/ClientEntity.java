package tk.chevalclinic.chevalclinic.model;


import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.Data;

@Data
@Entity
@Table(name = "client")
public class ClientEntity {
	
	@Id
	@Column(name = "id_client")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	private String name;
	private String nick;
	private int mobile;
	private String hatchery;
	private String address;
	private int telephone;
	
	@JsonIgnoreProperties("clientEntity")
	@OneToMany(mappedBy="clientEntity", cascade = CascadeType.ALL)
	private List<HorseEntity> horseEntityList;
	
	public ClientEntity() {
		
	}
}
