//package tk.chevalclinic.chevalclinic.model;
//
//import java.util.Date;
//
//import javax.persistence.CascadeType;
//import javax.persistence.Column;
//import javax.persistence.Entity;
//import javax.persistence.GeneratedValue;
//import javax.persistence.GenerationType;
//import javax.persistence.Id;
//import javax.persistence.JoinColumn;
//import javax.persistence.OneToOne;
//import javax.persistence.Table;
//
//import lombok.Data;
//
//@Data
//@Entity
//@Table(name="daily_work")
//public class DailyWorkEntity {
//
//	@Id
//	@Column(name="id")
//	@GeneratedValue(strategy = GenerationType.IDENTITY)
//	private long id;
//	@Column(columnDefinition = "TEXT")
//	private String comments;
//	private Date datecreated;
//	@Column(columnDefinition = "TEXT")
//	private String observations;
//	private String washeddat;
//	private String transfer;
//	@Column(name="pregnancy_test")
//	private String pregnancyTest;
//	
//	@OneToOne(cascade = CascadeType.ALL)
//	@JoinColumn(unique=true)
//	private HorseEntity horseEntity;
//	
//	public DailyWorkEntity() {
//		
//	}
//}
