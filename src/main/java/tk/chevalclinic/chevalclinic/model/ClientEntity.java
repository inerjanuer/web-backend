package tk.chevalclinic.chevalclinic.model;

//import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
//import javax.persistence.NamedQuery;
//import javax.persistence.OneToMany;
import javax.persistence.Table;

import lombok.Data;

@Data
@Entity
@Table(name = "client")
//@NamedQuery(name="Cliente.findByNombre", query="Select c from Client c where c.nombreCli = ?1")
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
	
	@OneToOne(mappedBy = "clientEntity")
	private HorseEntity horseEntity;
	
	/*@OneToMany(mappedBy="client")
	private Set<Reserva> reservas;
	*/
	public ClientEntity() {
		
	}
}
