package br.com.zup.LeadCollector.Lead;

import br.com.zup.LeadCollector.Produto.Produto;
import br.com.zup.LeadCollector.Produto.ProdutoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class LeadService {
    @Autowired
    private LeadRepository leadRepository;
    @Autowired
    private ProdutoRepository produtoRepository;

    public Lead cadastrarLead(Lead lead){
        return leadRepository.save(lead);
    }

    public List<Produto> buscarProdutos(List<Produto> produtos){
        List<Produto> listaAtualizada = new ArrayList<>();

        for (Produto produto : produtos){
            if (produtoRepository.existByNome(produto.getNome())){
                listaAtualizada.add(produtoRepository.findByNome(produto.getNome()));
            } else {
                listaAtualizada.add(produto);
            }
        }
        return listaAtualizada;
    }

}
