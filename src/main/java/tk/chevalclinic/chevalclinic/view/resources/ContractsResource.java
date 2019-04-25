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
import tk.chevalclinic.chevalclinic.bussines.services.ContractsService;
import tk.chevalclinic.chevalclinic.bussines.services.HorseService;
import tk.chevalclinic.chevalclinic.model.ContractsEntity;
import tk.chevalclinic.chevalclinic.model.HorseEntity;
import tk.chevalclinic.chevalclinic.view.resources.vo.ContractsVO;

@RestController
@RequestMapping("/api/contract")
@Api(tags = "contract")
@CrossOrigin(origins = "http://localhost:4200", 
methods= {RequestMethod.GET,RequestMethod.POST,RequestMethod.DELETE, RequestMethod.PUT})
public class ContractsResource {
	
	private final ContractsService contractsService;
	private final HorseService horseService;
	private HorseEntity horse, horseFe;
	
	public ContractsResource( ContractsService contractsService, HorseService horseService ) {
		this.contractsService = contractsService;
		this.horseService = horseService;
	}
	
	@PostMapping
	@ApiOperation(value = "Crear Contrato", notes="Servicio para crear un nuevo contrato")
	@ApiResponses(value = {@ApiResponse(code = 201, message = "Contrato creado correctamente"),
			@ApiResponse(code=400, message="solicitud Invalida")})
	public ResponseEntity<ContractsEntity> createContracts(@RequestBody ContractsVO contractsVo) {
		ContractsEntity contracts = new ContractsEntity();
		contracts.setDatecreated(contractsVo.getDatecreated());
		horse = this.horseService.findById(contractsVo.getIdMale());
		horseFe = this.horseService.findById(contractsVo.getIdFemale());
		if(horse == null || horseFe == null) {
			return new ResponseEntity<ContractsEntity>(HttpStatus.NOT_FOUND);
		}
		contracts.setHorseMaleEntity(horse);
		contracts.setHorseFemaleEntity(horseFe);
		return new ResponseEntity<>(this.contractsService.create(contracts), HttpStatus.CREATED);
	}
	
	@PutMapping("/{id}")
	@ApiOperation(value = "Actualizar contrato", notes="Servicio para actualizar un nuevo contrato")
	@ApiResponses(value = {@ApiResponse(code = 201, message = "Contrato actualizado correctamente"),
			@ApiResponse(code=400, message="Caballo no Encontrado")})
	public ResponseEntity<ContractsEntity> updateContracts(@PathVariable("id")long id,@RequestBody ContractsVO contractsVo) {
		ContractsEntity contracts = this.contractsService.findById(id);
		if ( contracts == null ) {
			return new ResponseEntity<ContractsEntity>(HttpStatus.NOT_FOUND);
		} else {
			contracts.setDatecreated(contractsVo.getDatecreated());
			horse = this.horseService.findById(contractsVo.getIdMale());
			horseFe = this.horseService.findById(contractsVo.getIdFemale());
			if(horse == null || horseFe == null) {
				return new ResponseEntity<ContractsEntity>(HttpStatus.NOT_FOUND);
			}
			contracts.setHorseMaleEntity(horse);
			contracts.setHorseFemaleEntity(horseFe);
		}
		return new ResponseEntity<>(this.contractsService.update(contracts), HttpStatus.OK);
	}
	
	@DeleteMapping("/{id}")
	@ApiOperation(value = "Eliminar contrato", notes="Servicio para eliminar un  contrato")
	@ApiResponses(value = {@ApiResponse(code = 201, message = "Contrato eliminado correctamente"),
			@ApiResponse(code=400, message="Caballo no Encontrado")})
	public void removeContracts(@PathVariable("id") long id) {
		ContractsEntity contracts = this.contractsService.findById(id);
		if(contracts != null ) {
			this.contractsService.delete(contracts);
		}
	}
	
	@GetMapping
	@ApiOperation(value = "Listar Contratos", notes="Servicio para listar todos los contratos")
	@ApiResponses(value = {@ApiResponse(code = 201, message = "Contratos encontrados correctamente"),
			@ApiResponse(code=400, message="Caballos no Encontrados")})
	public ResponseEntity<List<ContractsEntity>> findAll() {
		return ResponseEntity.ok(this.contractsService.findAll());
	}
	
	@GetMapping("/{id}")
	@ApiOperation(value = "Listar un Contrato", notes="Servicio para listar un solo contrato")
	@ApiResponses(value = {@ApiResponse(code = 201, message = "Contrato  encontrado correctamente"),
			@ApiResponse(code=400, message="Caballo no Encontrado")})
	public ResponseEntity<ContractsEntity> findById(@PathVariable("id") long id) {
		return ResponseEntity.ok(this.contractsService.findById(id));
	}

}
