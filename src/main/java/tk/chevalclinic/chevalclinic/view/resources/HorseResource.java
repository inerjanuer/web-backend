package tk.chevalclinic.chevalclinic.view.resources;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import tk.chevalclinic.chevalclinic.bussines.services.HorseService;
import tk.chevalclinic.chevalclinic.model.HorseEntity;
import tk.chevalclinic.chevalclinic.view.resources.vo.HorseVO;

@RestController
@RequestMapping("/api/client/{id}/horse")
@Api(tags = "horse")
public class HorseResource {
	
	private final HorseService horseService;
	
	public HorseResource ( HorseService horseService) {
		this.horseService = horseService;
	}
	
	@PostMapping
	@ApiOperation(value = "Crear Caballo", notes="Servicio para crear un nuevo caballo")
	@ApiResponses(value = {@ApiResponse(code = 201, message = "Caballo creado correctamente"),
			@ApiResponse(code=400, message="solicitud Invalida")})
	public ResponseEntity<HorseEntity> createHorse(@RequestBody HorseVO horseVo) {
		HorseEntity horse = new HorseEntity();
		horse.setTypeOfJob(horseVo.getTypeOfJob());
		horse.setSex(horseVo.getSex());
		horse.setName(horseVo.getName());
		horse.setColor(horseVo.getColor());
		horse.setAge(horseVo.getAge());
		horse.setRace(horseVo.getRace());
		horse.setParticularSigns(horseVo.getParticularSigns());
		horse.setDiet(horseVo.getDiet());
		horse.setComments(horseVo.getComments());
		horse.setImage(horseVo.getImage());
		horse.setCollectionDays(horseVo.getCollectionDays());
		//horse.setTypeStatusEntity(horse.getTypeStatusEntity());
		//horse.setClientEntity(horse.getClientEntity());
		return new ResponseEntity<>(this.horseService.create(horse), HttpStatus.CREATED);
	}
	
	@PutMapping("/{id}")
	@ApiOperation(value = "Actualizar Caballo", notes="Servicio para actualizar un nuevo caballo")
	@ApiResponses(value = {@ApiResponse(code = 201, message = "Caballo actualizado correctamente"),
			@ApiResponse(code=400, message="Caballo no Encontrado")})
	public ResponseEntity<HorseEntity> updateHorse(@PathVariable("id")int id,HorseVO horseVo) {
		HorseEntity horse = this.horseService.findById(id);
		if(horse == null) {
			return new ResponseEntity<HorseEntity>(HttpStatus.NOT_FOUND);
		} else {
			horse.setTypeOfJob(horseVo.getTypeOfJob());
			horse.setSex(horseVo.getSex());
			horse.setName(horseVo.getName());
			horse.setColor(horseVo.getColor());
			horse.setAge(horseVo.getAge());
			horse.setRace(horseVo.getRace());
			horse.setParticularSigns(horseVo.getParticularSigns());
			horse.setDiet(horseVo.getDiet());
			horse.setComments(horseVo.getComments());
			horse.setImage(horseVo.getImage());
			horse.setCollectionDays(horseVo.getCollectionDays());
			//horse.setTypeStatusEntity(horse.getTypeStatusEntity());
			//horse.setClientEntity(horse.getClientEntity());
		}
		return new ResponseEntity<>(this.horseService.update(horse), HttpStatus.OK);
	}
	
	@DeleteMapping("/{id}")
	@ApiOperation(value = "Eliminar caballo", notes="Servicio para eliminar un  caballo")
	@ApiResponses(value = {@ApiResponse(code = 201, message = "Caballo eliminado correctamente"),
			@ApiResponse(code=400, message="Caballo no Encontrado")})
	public void removeHorse(@PathVariable("id") int id) {
		HorseEntity horse = this.horseService.findById(id);
		if(horse == null) {
			this.horseService.delete(horse);
		}
	}
	
	@GetMapping
	@ApiOperation(value = "Listar Caballos", notes="Servicio para listar todos los caballos")
	@ApiResponses(value = {@ApiResponse(code = 201, message = "Caballos encontrados correctamente"),
			@ApiResponse(code=400, message="Caballos no Encontrados")})
	public ResponseEntity<List<HorseEntity>> findAll() {
		return ResponseEntity.ok(this.horseService.findAll());
	}

}
