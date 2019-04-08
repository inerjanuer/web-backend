package tk.chevalclinic.chevalclinic.bussines.services;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import tk.chevalclinic.chevalclinic.bussines.repository.ClientRepository;
import tk.chevalclinic.chevalclinic.model.ClientEntity;

@Service
@Transactional(readOnly = true)
public class ClientService {
	private final ClientRepository clientRepository;
	
	public ClientService(ClientRepository clientRepository) {
		// TODO Auto-generated constructor stub
		this.clientRepository = clientRepository;
	}
	@Transactional
	public ClientEntity create (ClientEntity client) {
		return this.clientRepository.save(client);
	}
	
	@Transactional
	public ClientEntity update (ClientEntity client) {
		return this.clientRepository.save(client);
	}
	
	@Transactional
	public void delete (ClientEntity client) {
		this.clientRepository.delete(client);
	}
	public ClientEntity findById(long id) {
		return this.clientRepository.findById(id);
	}
	
	public List<ClientEntity> findAll() {
		return this.clientRepository.findAll();
	}
	
	/*public Cliente finByNombre(String nombreCli) {
		return this.clientRepository.finByNombre(nombreCli);
	}*/
}
