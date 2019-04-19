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
import tk.chevalclinic.chevalclinic.bussines.services.ClientService;
import tk.chevalclinic.chevalclinic.model.ClientEntity;
import tk.chevalclinic.chevalclinic.view.resources.vo.ClientVO;

@RestController
@RequestMapping("/api/client")
@Api(tags = "client")
public class ClientResource {

	private final ClientService clientService;
	
	public ClientResource(ClientService clientService) {
		this.clientService = clientService;
	}
	
	@PostMapping
	@ApiOperation(value = "Crear Cliente", notes="Servicio para crear un nuevo cliente")
	@ApiResponses(value = {@ApiResponse(code = 201, message = "Cliente creado correctamente"),
			@ApiResponse(code=400, message="solicitud Invalida")})
	public ResponseEntity<ClientEntity> createCliente(@RequestBody ClientVO clientVo) {
		ClientEntity client = new ClientEntity();
		client.setName(clientVo.getName());
		client.setNick(clientVo.getNick());
		client.setMobile(clientVo.getMobile());
		client.setHatchery(clientVo.getHatchery());
		client.setAddress(clientVo.getAddress());
		client.setTelephone(clientVo.getTelephone());
		return new ResponseEntity<>(this.clientService.create(client), HttpStatus.CREATED);
	}
	
	@PutMapping("/{id}")
	@ApiOperation(value = "Actualizar Cliente", notes="Servicio para actualizar un nuevo cliente")
	@ApiResponses(value = {@ApiResponse(code = 201, message = "Cliente actualizado correctamente"),
			@ApiResponse(code=400, message="Cliente no Encontrado")})
	public ResponseEntity<ClientEntity> updateCliente(@PathVariable("id") long id, ClientVO clientVo) {
		ClientEntity client = this.clientService.findById(id);
		if(client == null ) {
			return new ResponseEntity<ClientEntity>(HttpStatus.NOT_FOUND);
		} else {
			client.setName(clientVo.getName());
			client.setNick(clientVo.getNick());
			client.setMobile(clientVo.getMobile());
			client.setHatchery(clientVo.getHatchery());
			client.setAddress(clientVo.getAddress());
			client.setTelephone(clientVo.getTelephone());
		}
		return new ResponseEntity<>(this.clientService.update(client), HttpStatus.OK);
	}
	
	@DeleteMapping("/{id}")
	@ApiOperation(value = "Eliminar Cliente", notes="Servicio para eliminar un nuevo cliente")
	@ApiResponses(value = {@ApiResponse(code = 201, message = "Cliente eliminado correctamente"),
			@ApiResponse(code=400, message="Cliente no Encontrado")})
	public void deleteClient(@PathVariable("id") long id) {
		ClientEntity client = this.clientService.findById(id);
		if(client == null) {
			this.clientService.delete(client);
		}
	}
	
	
	@GetMapping
	@CrossOrigin(origins = "http://localhost:4200")
	@ApiOperation(value = "Listar Cliente", notes="Servicio para listar todos los clientes")
	@ApiResponses(value = {@ApiResponse(code = 201, message = "Clientes encontrados correctamente"),
			@ApiResponse(code=400, message="Clientes no Encontrados")})
	public ResponseEntity<List<ClientEntity>> findAll() {
		return ResponseEntity.ok(this.clientService.findAll());
	}
}
