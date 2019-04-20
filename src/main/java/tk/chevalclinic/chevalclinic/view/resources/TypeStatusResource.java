package tk.chevalclinic.chevalclinic.view.resources;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import tk.chevalclinic.chevalclinic.bussines.services.TypeStatusService;
import tk.chevalclinic.chevalclinic.model.TypeStatusEntity;

@RestController
@RequestMapping("/api/typeStatus")
@Api(tags = "typeStatus")
@CrossOrigin(origins = "http://localhost:4200", methods= {RequestMethod.GET})
public class TypeStatusResource {
	
	private final TypeStatusService typeStatusService;
	
	public TypeStatusResource(TypeStatusService typeStatusService) {
		this.typeStatusService = typeStatusService;
	}
	
	@GetMapping
	@ApiOperation(value = "Listar Cliente", notes="Servicio para listar todos los clientes")
	@ApiResponses(value = {@ApiResponse(code = 201, message = "Clientes encontrados correctamente"),
			@ApiResponse(code=400, message="Clientes no Encontrados")})
	public ResponseEntity<List<TypeStatusEntity>> findAll() {
		return ResponseEntity.ok(this.typeStatusService.findAll());
	}

}
