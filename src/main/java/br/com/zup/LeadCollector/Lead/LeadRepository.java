package br.com.zup.LeadCollector.Lead;

import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface LeadRepository extends CrudRepository<Lead, String> {
    List<Lead> findAllByProdutosDesejados(String nomeDoProduto);

}
