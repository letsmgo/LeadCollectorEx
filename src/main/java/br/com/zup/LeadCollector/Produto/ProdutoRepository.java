package br.com.zup.LeadCollector.Produto;

import org.springframework.data.repository.CrudRepository;

public interface ProdutoRepository extends CrudRepository<Produto, Integer> {
    Boolean existByNome(String nome);
}
