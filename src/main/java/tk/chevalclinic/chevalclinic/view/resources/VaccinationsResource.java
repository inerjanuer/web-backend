package tk.chevalclinic.chevalclinic.view.resources;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
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
import tk.chevalclinic.chevalclinic.bussines.services.VaccinationsService;
import tk.chevalclinic.chevalclinic.model.VaccinationsEntity;
import tk.chevalclinic.chevalclinic.view.resources.vo.VaccinationsVO;

@RestController
@RequestMapping("/api/vaccinations")
@Api(tags = "vaccinations")
@CrossOrigin(origins = "http://localhost:4200", 
methods= {RequestMethod.GET,RequestMethod.POST,RequestMethod.DELETE, RequestMethod.PUT})
public class VaccinationsResource {
	
	private final VaccinationsService vaccinationsService;
	
	public VaccinationsResource(VaccinationsService vaccinationsService) {
		this.vaccinationsService = vaccinationsService;
	}
	
	@PostMapping
	@ApiOperation(value = "Crear vacuna", notes="Servicio para crear una nueva vacuna")
	@ApiResponses(value = {@ApiResponse(code = 201, message = "Vacuna creado correctamente"),
			@ApiResponse(code=400, message="solicitud Invalida")})
	public ResponseEntity<VaccinationsEntity> createVaccinations(@RequestBody VaccinationsVO vaccinationsVo){
		VaccinationsEntity vaccinations = new VaccinationsEntity();
		vaccinations.setName(vaccinationsVo.getName());
		return new ResponseEntity<>(this.vaccinationsService.create(vaccinations),HttpStatus.CREATED);
	}
	
	@PutMapping("/{id}")
	@ApiOperation(value = "Actualizar vacuna", notes="Servicio para actualizar una vacuna")
	@ApiResponses(value = {@ApiResponse(code = 201, message = "Vacuna actualizado correctamente"),
			@ApiResponse(code=400, message="Vacuna no Encontrado")})
	public ResponseEntity<VaccinationsEntity> updateVaccinations(@PathVariable("id")long id,@RequestBody VaccinationsVO vaccinationsVo){
		VaccinationsEntity vaccinations = this.vaccinationsService.findById(id);
		if(vaccinations == null) {
			return new ResponseEntity<VaccinationsEntity>(HttpStatus.NOT_FOUND);
		} else {
			vaccinations.setName(vaccinationsVo.getName());
		}
		return new ResponseEntity<>(this.vaccinationsService.create(vaccinations),HttpStatus.CREATED);
	}
	
	@DeleteMapping("/{id}")
	@ApiOperation(value = "Eliminar vacuna", notes="Servicio para eliminar una vacuna")
	@ApiResponses(value = {@ApiResponse(code = 201, message = "Vacuan eliminada correctamente"),
			@ApiResponse(code=400, message="Vacuna no Encontrado")})
	public void deleteVaccinations(@PathVariable("id") long id) {
		VaccinationsEntity vaccinations = this.vaccinationsService.findById(id);
		if(vaccinations!= null) {
			this.vaccinationsService.delete(vaccinations);
		}
	}
	
	@GetMapping
	@ApiOperation(value = "Listar vacunas", notes="Servicio para listar todas las vacunas")
	@ApiResponses(value = {@ApiResponse(code = 201, message = "Vacunas encontrados correctamente"),
			@ApiResponse(code=400, message="Vacunas no Encontrados")})
	public ResponseEntity<List<VaccinationsEntity>> findAll(){
		return ResponseEntity.ok(this.vaccinationsService.findAll());
	}
	
	@GetMapping("/{id}")
	@ApiOperation(value = "Listar un Vacuna", notes="Servicio para listar una sola vacuna")
	@ApiResponses(value = {@ApiResponse(code = 201, message = "Vacuna  encontrado correctamente"),
			@ApiResponse(code=400, message="Vacuna no Encontrado")})
	public ResponseEntity<VaccinationsEntity> findById(@PathVariable("id") long id) {
		return ResponseEntity.ok(this.vaccinationsService.findById(id));
	}

}
