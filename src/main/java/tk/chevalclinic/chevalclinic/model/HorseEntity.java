package tk.chevalclinic.chevalclinic.model;


import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.Data;

@Data
@Entity
@Table(name="horse")
public class HorseEntity {

	@Id
	@Column(name="id_horse")
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
	
	@JsonIgnoreProperties("horseEntityList")
	@ManyToOne(fetch=FetchType.EAGER)
	@JoinColumn(name="id_client", nullable =true)
	private ClientEntity clientEntity;
	
	@JsonIgnoreProperties("horseEntityList")
	@ManyToOne(fetch=FetchType.EAGER)
	@JoinColumn(name="id_status", nullable =true)
	private TypeStatusEntity typeStatusEntity;
	
	@JsonIgnoreProperties("horseEntity")
	@OneToMany(mappedBy="horseEntity", cascade = CascadeType.ALL)
	private List<PreviusVaccinesEntity> previusVaccinesEntityHoList;
	
	@JsonIgnoreProperties("horseMaleEntity")
	@OneToMany(mappedBy="horseMaleEntity", cascade = CascadeType.ALL)
	private List<ContractsEntity> contractsMaleEntityList;
	
	@JsonIgnoreProperties("horseFemaleEntity")
	@OneToMany(mappedBy="horseFemaleEntity", cascade = CascadeType.ALL)
	private List<ContractsEntity> contractsFemaleEntityList;
	

	
	public HorseEntity() {
		
	}
	
}
