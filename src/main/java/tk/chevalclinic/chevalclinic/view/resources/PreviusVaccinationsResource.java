package tk.chevalclinic.chevalclinic.view.resources;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import tk.chevalclinic.chevalclinic.bussines.services.HorseService;
import tk.chevalclinic.chevalclinic.bussines.services.PreviusVaccinationsService;
import tk.chevalclinic.chevalclinic.bussines.services.VaccinationsService;
import tk.chevalclinic.chevalclinic.model.HorseEntity;
import tk.chevalclinic.chevalclinic.model.PreviusVaccinesEntity;
import tk.chevalclinic.chevalclinic.model.VaccinationsEntity;
import tk.chevalclinic.chevalclinic.view.resources.vo.PreviusVaccinesVO;

@RestController
@RequestMapping("/api/previusVaccinations")
@Api(tags = "previusVaccinations")
@CrossOrigin(origins = "http://localhost:4200", 
methods= {RequestMethod.GET,RequestMethod.POST, RequestMethod.PUT})
public class PreviusVaccinationsResource {
	
	private final PreviusVaccinationsService previusService;
	private final HorseService horseService;
	private final VaccinationsService vaccinationsService;
	
	public PreviusVaccinationsResource(PreviusVaccinationsService previusService,HorseService horseService,VaccinationsService vaccinationsService) {
		this.previusService = previusService;
		this.horseService = horseService;
		this.vaccinationsService =vaccinationsService;
	}
	
	@PostMapping
	@ApiOperation(value = "Agrega nueva relacion", notes="Servicio para agregar una relacion de vacunas para el caballo")
	@ApiResponses(value = {@ApiResponse(code = 201, message = "Agregacion creado correctamente"),
			@ApiResponse(code=400, message="solicitud Invalida")})
	public ResponseEntity<PreviusVaccinesEntity> createPrevius(@RequestBody PreviusVaccinesVO previusVo) {
		PreviusVaccinesEntity previus = new PreviusVaccinesEntity();
		HorseEntity horse = this.horseService.findById(previusVo.getIdHorse());
		VaccinationsEntity vaccinations = this.vaccinationsService.findById(previusVo.getIdVaccinations());
		if(horse == null || vaccinations == null) {
			return new ResponseEntity<PreviusVaccinesEntity>(HttpStatus.NOT_FOUND);
		}
		previus.setHorseEntity(horse);
		previus.setVaccinesEntity(vaccinations);
		return new ResponseEntity<>(this.previusService.create(previus),HttpStatus.CREATED);
	}
	
	@PutMapping("/{id}")
	@ApiOperation(value = "Actualizar la relacion", notes="Servicio para actualizar la relacion de las vacunas")
	@ApiResponses(value = {@ApiResponse(code = 201, message = "Relacion actualizada correctamente"),
			@ApiResponse(code=400, message="Relacion no Encontrado")})
	public ResponseEntity<PreviusVaccinesEntity> updatePrevius(@PathVariable("id") long id,@RequestBody PreviusVaccinesVO previusVo) {
		PreviusVaccinesEntity previus = this.previusService.findById(id);
		if(previus == null) {
			return new ResponseEntity<PreviusVaccinesEntity>(HttpStatus.NOT_FOUND);
		} else {
			HorseEntity horse = this.horseService.findById(previusVo.getIdHorse());
			VaccinationsEntity vaccinations = this.vaccinationsService.findById(previusVo.getIdVaccinations());
			if(horse == null || vaccinations == null) {
				return new ResponseEntity<PreviusVaccinesEntity>(HttpStatus.NOT_FOUND);
			}
			previus.setHorseEntity(horse);
			previus.setVaccinesEntity(vaccinations);
		}
		return new ResponseEntity<>(this.previusService.create(previus),HttpStatus.CREATED);
	}
	
	@GetMapping
	@ApiOperation(value = "Listar Relaciones", notes="Servicio para listar todas las relaciones")
	@ApiResponses(value = {@ApiResponse(code = 201, message = "Relaciones encontradas correctamente"),
			@ApiResponse(code=400, message="Relaciones no Encontrados")})
	public ResponseEntity<List<PreviusVaccinesEntity>> findAll(){
		return ResponseEntity.ok(this.previusService.finAll());
	}
	
	@GetMapping("/{id}")
	@ApiOperation(value = "Listar una relacion", notes="Servicio para listar una sola relacion")
	@ApiResponses(value = {@ApiResponse(code = 201, message = "Relaciones  encontradas correctamente"),
			@ApiResponse(code=400, message="Relaciones no Encontrado")})
	public ResponseEntity<PreviusVaccinesEntity> findById(@PathVariable("id") long id){
		return ResponseEntity.ok(this.previusService.findById(id));
	}

}
