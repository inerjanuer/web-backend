package tk.chevalclinic.chevalclinic.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.Data;

@Data
@Entity
@Table(name="contracts")
public class ContractsEntity {
	
	@Id
	@Column(name = "id_contract")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	
	@Temporal(TemporalType.DATE)
	private Date datecreated;
	
	@JsonIgnoreProperties("contractsMaleEntityList")
	@ManyToOne(fetch=FetchType.EAGER)
	@JoinColumn(name="id_male_horse", nullable =true)
	private HorseEntity horseMaleEntity;
	
	@JsonIgnoreProperties("contractsFemaleEntityList")
	@ManyToOne(fetch=FetchType.EAGER)
	@JoinColumn(name="id_female_horse", nullable =true)
	private HorseEntity horseFemaleEntity;
	
}
