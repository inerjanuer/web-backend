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
import tk.chevalclinic.chevalclinic.bussines.services.DailyWorkService;
import tk.chevalclinic.chevalclinic.model.DailyWorkEntity;
import tk.chevalclinic.chevalclinic.view.resources.vo.DailyWorkVO;

@RestController
@RequestMapping("/api/dailyWork")
@Api(tags = "dailyWork")
@CrossOrigin(origins = "http://localhost:4200", 
methods= {RequestMethod.GET,RequestMethod.POST,RequestMethod.DELETE, RequestMethod.PUT})
public class DailyWorkResource {
	
	private final DailyWorkService dailyWorkService;
	
	public DailyWorkResource ( DailyWorkService dailyWorkService ) {
		this.dailyWorkService = dailyWorkService;
	}
	
	@PostMapping
	@ApiOperation(value = "Crear dia de trabajo", notes="Servicio para crear un nuevo dia de trabajo")
	@ApiResponses(value = {@ApiResponse(code = 201, message = "Dia de trabajo creado correctamente"),
			@ApiResponse(code=400, message="solicitud Invalida")})
	public ResponseEntity<DailyWorkEntity> createDailyWork (@RequestBody DailyWorkVO dailyWrokVo ) {
		DailyWorkEntity dailyWork = new DailyWorkEntity();
		dailyWork.setComments(dailyWrokVo.getComments());
		dailyWork.setObservations(dailyWrokVo.getObservations());
		dailyWork.setWasheddat(dailyWrokVo.getWasheddat());
		dailyWork.setTransfer(dailyWrokVo.getTransfer());
		dailyWork.setPregnancyTest(dailyWrokVo.getPregnancyTest());
		return new ResponseEntity<>(this.dailyWorkService.create(dailyWork),HttpStatus.CREATED);
	}
	
	@PutMapping("/{id}")
	@ApiOperation(value = "Actualizar dia de trabajo", notes="Servicio para actualizar un nuevo dia de trabajo")
	@ApiResponses(value = {@ApiResponse(code = 201, message = "Dia de trabajo actualizado correctamente"),
			@ApiResponse(code=400, message="solicitud Invalida")})
	public ResponseEntity<DailyWorkEntity> updateDailyWork (@PathVariable("id")long id, @RequestBody DailyWorkVO dailyWrokVo ) {
		DailyWorkEntity dailyWork = this.dailyWorkService.findById(id);
		if( dailyWork == null ) {
			return new ResponseEntity<DailyWorkEntity>(HttpStatus.NOT_FOUND);
		} else {
			dailyWork.setComments(dailyWrokVo.getComments());
			dailyWork.setObservations(dailyWrokVo.getObservations());
			dailyWork.setWasheddat(dailyWrokVo.getWasheddat());
			dailyWork.setTransfer(dailyWrokVo.getTransfer());
			dailyWork.setPregnancyTest(dailyWrokVo.getPregnancyTest());
		}
		return new ResponseEntity<>(this.dailyWorkService.update(dailyWork),HttpStatus.CREATED);
	}
	
	@DeleteMapping("/{id}")
	@ApiOperation(value = "Eliminar dia de trabajo", notes="Servicio para eliminar un  dia de trabajo")
	@ApiResponses(value = {@ApiResponse(code = 201, message = "Dia de trabajo eliminado correctamente"),
			@ApiResponse(code=400, message="Caballo no Encontrado")})
	public void removeDaily(@PathVariable("id") long id) {
		DailyWorkEntity dailyWork = this.dailyWorkService.findById(id);
		if (dailyWork != null ) {
			this.dailyWorkService.delete(dailyWork);
		}
	}
	
	@GetMapping
	@ApiOperation(value = "Listar dias de trabajo", notes="Servicio para listar todos los dias de trabajo")
	@ApiResponses(value = {@ApiResponse(code = 201, message = "Dias de trabajo encontrados correctamente"),
			@ApiResponse(code=400, message="Caballos no Encontrados")})
	public ResponseEntity<List<DailyWorkEntity>> findAll() {
		return ResponseEntity.ok(this.dailyWorkService.findAll());
	}
	
	@GetMapping("/{id}")
	@ApiOperation(value = "Listar un dia de trabajo", notes="Servicio para listar un solo dia de trabajo")
	@ApiResponses(value = {@ApiResponse(code = 201, message = "Dia de trabajo  encontrado correctamente"),
			@ApiResponse(code=400, message="Caballo no Encontrado")})
	public ResponseEntity<DailyWorkEntity> findById(@PathVariable("id") long id) {
		return ResponseEntity.ok(this.dailyWorkService.findById(id));
	}

}
