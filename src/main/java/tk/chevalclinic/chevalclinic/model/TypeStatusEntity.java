package tk.chevalclinic.chevalclinic.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import lombok.Data;

@Data
@Entity
@Table(name="type_status")
public class TypeStatusEntity {

	@Id
	@Column(name="id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	private String status;
	
	@OneToOne(mappedBy = "typeStatusEntity")
	private HorseEntity horseEntity;
	
	public TypeStatusEntity () {
		
	}
	
}
