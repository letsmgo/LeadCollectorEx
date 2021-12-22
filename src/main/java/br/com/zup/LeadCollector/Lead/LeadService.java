package br.com.zup.LeadCollector.Lead;

import br.com.zup.LeadCollector.Produto.Produto;
import br.com.zup.LeadCollector.Produto.ProdutoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class LeadService {
    private LeadRepository leadRepository;
    private ProdutoRepository produtoRepository;

    @Autowired
    public LeadService(LeadRepository leadRepository, ProdutoRepository produtoRepository){
        this.leadRepository = leadRepository;
        this.produtoRepository = produtoRepository;
}

    public Lead cadastrarLead(Lead lead) {
        List<Produto> produtos = buscarProdutos(lead.getProdutosDesejados());

        Optional<Lead> leadOptional = leadRepository.findById(lead.getEmail());
        if (leadOptional.isPresent()) {
            Lead leadDoBanco = leadOptional.get();
            for (Produto produto : produtos) {
                if (!leadDoBanco.getProdutosDesejados().contains(produto)) {
                    leadDoBanco.getProdutosDesejados().add(produto);
                }
            }
            return leadRepository.save(leadDoBanco);
        }
        lead.setProdutosDesejados(produtos);
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

    public List<Lead> buscarTodosPeloNomeDoProduto(String nomeDoProduto){
        return leadRepository.findAllByProdutosDesejados(nomeDoProduto);
    }

}

