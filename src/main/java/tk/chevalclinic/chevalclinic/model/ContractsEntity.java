package tk.chevalclinic.chevalclinic.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import lombok.Data;

@Data
@Entity
@Table(name="reserva")
public class ContractsEntity {
	
	@Id
	@Column(name = "id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	@Temporal(TemporalType.DATE)
	private Date datecreated;
	
	@ManyToOne
	@JoinColumn(name = "horse_male_id", nullable = false)
	private HorseEntity horseMaleEntity;
	
	@ManyToOne
	@JoinColumn(name = "horse_female_id", nullable = false)
	private HorseEntity horseFemaleEntity;
	/*@ManyToOne
	@JoinColumn(name="id")
	private Cliente client;
	*/
	
}
