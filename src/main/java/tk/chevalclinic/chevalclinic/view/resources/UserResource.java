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
import org.springframework.web.bind.annotation.RestController;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import tk.chevalclinic.chevalclinic.bussines.services.UserService;
import tk.chevalclinic.chevalclinic.model.UserEntity;
import tk.chevalclinic.chevalclinic.view.resources.vo.UserVO;

@RestController
@RequestMapping("/api/user")
@Api(tags = "user")
public class UserResource {

	private final UserService UserService;

	public UserResource(UserService UserService) {
		this.UserService = UserService;
	}

	@PostMapping
	@CrossOrigin(origins = "http://localhost:4200")
	@ApiOperation(value = "Crear Caballo", notes = "Servicio para crear un nuevo caballo")
	@ApiResponses(value = { @ApiResponse(code = 201, message = "Caballo creado correctamente"),
			@ApiResponse(code = 400, message = "solicitud Invalida") })
	public ResponseEntity<UserEntity> createuser(@RequestBody UserVO userVO) {
		UserEntity user = new UserEntity();
		user.setName(userVO.getName());
		user.setEmail(userVO.getEmail());
		user.setPassword(userVO.getPassword());
		user.setRol(userVO.getRol());
		user.setTypeUser(userVO.getTypeUser());
		return new ResponseEntity<>(this.UserService.create(user), HttpStatus.CREATED);
	}

	@PutMapping("/{id}")
	@ApiOperation(value = "Actualizar Caballo", notes = "Servicio para actualizar un nuevo caballo")
	@ApiResponses(value = { @ApiResponse(code = 201, message = "Caballo actualizado correctamente"),
			@ApiResponse(code = 400, message = "Caballo no Encontrado") })
	public ResponseEntity<UserEntity> updateuser(@PathVariable("id") int id, UserVO userVO) {
		UserEntity user = this.UserService.findById(id);
		if (user == null) {
			return new ResponseEntity<UserEntity>(HttpStatus.NOT_FOUND);
		} else {
			user.setName(userVO.getName());
			user.setEmail(userVO.getEmail());
			user.setPassword(userVO.getPassword());
			user.setRol(userVO.getRol());
			user.setTypeUser(userVO.getTypeUser());
		}
		return new ResponseEntity<>(this.UserService.update(user), HttpStatus.OK);
	}

	@DeleteMapping("/{id}")
	@ApiOperation(value = "Eliminar caballo", notes = "Servicio para eliminar un  caballo")
	@ApiResponses(value = { @ApiResponse(code = 201, message = "Caballo eliminado correctamente"),
			@ApiResponse(code = 400, message = "Caballo no Encontrado") })
	public void removeuser(@PathVariable("id") int id) {
		UserEntity user = this.UserService.findById(id);
		if (user == null) {
			this.UserService.delete(user);
		}
	}

	@GetMapping
	@CrossOrigin(origins = "http://localhost:4200")
	@ApiOperation(value = "Listar Caballos", notes = "Servicio para listar todos los caballos")
	@ApiResponses(value = { @ApiResponse(code = 201, message = "Caballos encontrados correctamente"),
			@ApiResponse(code = 400, message = "Caballos no Encontrados") })
	public ResponseEntity<List<UserEntity>> findAll() {
		return ResponseEntity.ok(this.UserService.findAll());
	}

}