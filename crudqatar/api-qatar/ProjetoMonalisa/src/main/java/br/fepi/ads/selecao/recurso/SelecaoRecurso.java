package br.fepi.ads.selecao.recurso;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestAttribute;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.HttpClientErrorException.NotFound;

import br.fepi.ads.selecao.dominio.Selecao;
import br.fepi.ads.selecao.repositorio.SelecaoRepositorio;

@RestController
public class SelecaoRecurso {
	
	@Autowired
	private SelecaoRepositorio repositorio;
	
	@RequestMapping(value = "/selecoes", method = RequestMethod.GET)
	public List<Selecao> listar() {
		return repositorio.findAll();
	}
	
	@RequestMapping(value = "/selecoes/{id}", method = RequestMethod.GET)
	public ResponseEntity<Selecao> selecaoPeloId(@PathVariable Long id) {
		Selecao selecaoPeloId = repositorio.findById(id).orElse(null);
		
		if(selecaoPeloId == null) return new ResponseEntity<Selecao>(HttpStatus.NOT_FOUND);
		
		return new ResponseEntity<Selecao>(selecaoPeloId, HttpStatus.OK); 
	}
	
	@RequestMapping(value = "/selecoes", method = RequestMethod.POST)
	public Selecao inserir(@RequestBody Selecao selecao) {
		return repositorio.save(selecao);
	}
	
	@RequestMapping(value = "/selecoes/{id}", method = RequestMethod.PUT)
	public ResponseEntity<Selecao> atualizar(@RequestBody Selecao selecao, @PathVariable Long id) {
		Selecao selecaoPeloId = repositorio.findById(id).orElse(null);
		
		if(selecaoPeloId == null) return new ResponseEntity<Selecao>(HttpStatus.NOT_FOUND);
		
		selecaoPeloId.setNome(selecao.getNome());
		selecaoPeloId.setNumeroCopas(selecao.getNumeroCopas());
		selecaoPeloId.setCorCamisaPrincipal(selecao.getCorCamisaPrincipal());
		selecaoPeloId.setCorCamisaSecundaria(selecao.getCorCamisaSecundaria());
		selecaoPeloId.setFavorita(selecao.isFavorita());
		
		repositorio.save(selecaoPeloId);
		
		return new ResponseEntity<Selecao>(selecaoPeloId, HttpStatus.OK);
	}
	
	@RequestMapping(value = "/selecoes/{id}", method = RequestMethod.DELETE)
	public ResponseEntity deletar(@PathVariable Long id) {
		Selecao selecaoPeloId = repositorio.findById(id).orElse(null);
		
		if(selecaoPeloId == null) return new ResponseEntity(HttpStatus.NOT_FOUND);
		
		repositorio.delete(selecaoPeloId);
		
		return new ResponseEntity(HttpStatus.OK);
		
	}

}
