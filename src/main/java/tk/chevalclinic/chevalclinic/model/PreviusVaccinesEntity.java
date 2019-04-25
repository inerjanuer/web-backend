package tk.chevalclinic.chevalclinic.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.Data;

@Data
@Entity
@Table(name ="previus_vaccines")
public class PreviusVaccinesEntity {

	@Id
	@Column(name="id_previus")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	
	@JsonIgnoreProperties("previusVaccinesEntityList")
	@ManyToOne(fetch=FetchType.EAGER)
	@JoinColumn(name="id_vaccinations", nullable =true)
	private VaccinationsEntity vaccinesEntity;
	
	@JsonIgnoreProperties("previusVaccinesEntityHoList")
	@ManyToOne(fetch=FetchType.EAGER)
	@JoinColumn(name="id_horse", nullable =true)
	private HorseEntity horseEntity;
	
	public PreviusVaccinesEntity () {
		
	}
}
