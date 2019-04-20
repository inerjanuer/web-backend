package tk.chevalclinic.chevalclinic.model;


import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OrderBy;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonManagedReference;

import lombok.Data;

@Data
@Entity
@Table(name = "client")
public class ClientEntity {
	
	@Id
	@Column(name = "id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	private String name;
	private String nick;
	private int mobile;
	private String hatchery;
	private String address;
	private int telephone;
<<<<<<< HEAD
//	
//	@OneToOne(mappedBy = "clientEntity")
//	private HorseEntity horseEntity;
=======
	
	@JsonManagedReference
	@OneToMany(mappedBy="clientEntity", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	@OrderBy("id DESC")
	private List<HorseEntity> horseEntityList;
>>>>>>> rama-iner
	
	public ClientEntity() {
		
	}
}
