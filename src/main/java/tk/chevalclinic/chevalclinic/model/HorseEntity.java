package tk.chevalclinic.chevalclinic.model;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonBackReference;

import lombok.Data;

@Data
@Entity
@Table(name="horse")
public class HorseEntity {

	@Id
	@Column(name="id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	
	@Column(name="type_of_job")
	private String typeOfJob;
	private String sex;
	private String name;
	private String color;
	private String age;
	private String race;
	@Column(name="particular_signs")
	private String particularSigns;
	private String diet;
	@Column(columnDefinition = "TEXT")
	private String comments;
	private String image;
	@Column(name="collection_days")
	private String collectionDays;
	
<<<<<<< HEAD
//	@OneToOne(cascade = CascadeType.ALL)
//	@JoinColumn(unique=false)
//	private TypeStatusEntity typeStatusEntity;
//	
//	@OneToOne(cascade = CascadeType.ALL)
//	@JoinColumn(unique=false)
//	private ClientEntity clientEntity;
=======
	@JsonBackReference
	@ManyToOne
	@JoinColumn(name="client_id", nullable =false)
	private ClientEntity clientEntity;
	
	@JsonBackReference
	@ManyToOne
	@JoinColumn(name="status_id", nullable =false)
	private TypeStatusEntity typeStatusEntity;
	

>>>>>>> rama-iner
	
//	@OneToOne(mappedBy = "horseEntity")
//	private DailyWorkEntity dailyWorkEntity;
//	
//	@OneToMany(mappedBy = "horseEntity", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
//	private List<PreviusVaccinesEntity> previusVaccinesEntityList;
//	
//	@OneToMany(mappedBy = "horseMaleEntity", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
//	private List<ContractsEntity> ContractsMaleEntityList;
//	
//	@OneToMany(mappedBy = "horseFemaleEntity", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
//	private List<ContractsEntity> ContractsFemaleEntityList;
//	
	public HorseEntity() {
		
	}
	
}
