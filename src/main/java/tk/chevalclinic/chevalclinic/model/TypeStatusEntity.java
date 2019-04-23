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
@Table(name="type_status")
public class TypeStatusEntity {

	@Id
	@Column(name="id_status")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	private String status;
	
	@JsonIgnoreProperties("typeStatusEntity")
	@OneToMany(mappedBy="typeStatusEntity",  cascade = CascadeType.ALL)
	private List<HorseEntity> horseEntityList;
	
	public TypeStatusEntity () {
		
	}
	
}
