package rest.resouce;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import rest.model.Aluno;

@RestController
public class AlunoResouce {
	private Map<Integer, Aluno> alunos;

	public AlunoResouce() {
		alunos = new HashMap<Integer, Aluno>();

		Aluno aluno1 = new Aluno(1, "Ricardo", "001", 7.5, 8.8);
		Aluno aluno2 = new Aluno(2, "Roberto", "002", 7.0, 8.5);
		Aluno aluno3 = new Aluno(3, "Mike", "003", 8.0, 10.0);

		alunos.put(1, aluno1);
		alunos.put(2, aluno2);
		alunos.put(3, aluno3);

	}

	@RequestMapping(value = "/alunos", method = RequestMethod.GET)
	public ResponseEntity<List<Aluno>> listar() {
		return new ResponseEntity<List<Aluno>>(new ArrayList<Aluno>(alunos.values()),
				HttpStatus.OK);

	}

	@RequestMapping(value = "/alunos/{id}", method = RequestMethod.GET)
	public ResponseEntity<Aluno> buscar(@PathVariable("id") Integer id) {
		Aluno aluno = alunos.get(id);

		if (aluno == null) {
			return new ResponseEntity<Aluno>(HttpStatus.NOT_FOUND);
		}

		return new ResponseEntity<Aluno>(aluno, HttpStatus.OK);

	}
	
	@RequestMapping(value = "/alunos", method = RequestMethod.PUT, consumes = "application/json")
	public ResponseEntity<Aluno> editar(@RequestBody Aluno aluno) {
		Aluno al = alunos.get(aluno.getId());

		if (al == null) {
			return new ResponseEntity<Aluno>(HttpStatus.NOT_FOUND);
		}

		alunos.put(aluno.getId(), aluno);

		return new ResponseEntity<Aluno>(aluno, HttpStatus.OK);

	}


	@RequestMapping(value = "/alunos/{id}", method = RequestMethod.DELETE)
	public ResponseEntity<?> deletar(@PathVariable("id") int id) {
		Aluno aluno = alunos.remove(id);

		if (aluno == null) {
			return new ResponseEntity<Object>(HttpStatus.NOT_FOUND);
		}

		return new ResponseEntity<Object>(alunos.values(), HttpStatus.OK);
	}
	
	@RequestMapping(value = "/alunos", method = RequestMethod.POST,
			consumes = "application/json")
	public ResponseEntity<Aluno> criar(@RequestBody Aluno aluno) {
		Integer id = alunos.size()+1;
		aluno.setId(id);
		alunos.put(id, aluno);

		return new ResponseEntity<Aluno>(aluno, HttpStatus.CREATED);
	}

}
