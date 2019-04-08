package tk.chevalclinic.chevalclinic.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import lombok.Data;

@Data
@Entity
@Table(name ="previus_vaccines")
public class PreviusVaccinesEntity {

	@Id
	@Column(name="id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	
	@ManyToOne
	@JoinColumn(name = "vaccinations_id", nullable = false)
	private VaccinationsEntity vaccinationsEntity;
	
	@ManyToOne
	@JoinColumn(name = "horse_id", nullable = false)
	private HorseEntity horseEntity;
	
	public PreviusVaccinesEntity () {
		
	}
}
