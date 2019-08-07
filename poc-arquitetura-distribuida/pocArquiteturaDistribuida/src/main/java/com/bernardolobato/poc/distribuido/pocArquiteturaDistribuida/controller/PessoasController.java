package com.bernardolobato.poc.distribuido.pocArquiteturaDistribuida.controller;


import javax.validation.Valid;
import com.bernardolobato.poc.distribuido.pocArquiteturaDistribuida.controller.dto.PessoaDTO;
import com.bernardolobato.poc.distribuido.pocArquiteturaDistribuida.controller.form.PessoaForm;
import com.bernardolobato.poc.distribuido.pocArquiteturaDistribuida.modelo.Pessoa;
import com.bernardolobato.poc.distribuido.pocArquiteturaDistribuida.repository.PessoaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;
import java.net.URI;

@RestController
@RequestMapping("/pessoas")
public class PessoasController {

    @Autowired
    private PessoaRepository pessoaRepository;

    @GetMapping
    @Cacheable(value = "listaDePessoas")
    public Page<PessoaDTO> lista(@RequestParam(required = false) String nome,
            @PageableDefault(sort = "id", direction = Direction.ASC) Pageable paginacao) {
        Page<Pessoa> pessoas;

        // Pageable paginacao = PageRequest.of(pagina, quantidade, Direction.ASC, ordenacao);

        if (nome == null) {
            pessoas = this.pessoaRepository.findAll(paginacao);
        } else {
            pessoas = this.pessoaRepository.findByNome(nome, paginacao);
        }

        return PessoaDTO.convert(pessoas);
    }

    @PostMapping
    @CacheEvict(value = "listaDePessoas", allEntries = true)
    public ResponseEntity<PessoaDTO> save(@RequestBody @Valid PessoaForm form,
            UriComponentsBuilder uriBuilder) {
        Pessoa p = form.convert();
        this.pessoaRepository.save(p);

        URI uri = uriBuilder.path("/pessoas/{id}").buildAndExpand(p.getId()).toUri();
        return ResponseEntity.created(uri).body(new PessoaDTO(p));
    }

    @GetMapping("/{id}")
    public PessoaDTO detalhar(@PathVariable Long id) {
        Pessoa pessoa = pessoaRepository.getOne(id);
        return new PessoaDTO(pessoa);

    }

}
