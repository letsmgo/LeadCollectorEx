package br.com.zup.LeadCollector.Lead;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/leads")
public class LeadController {
    @Autowired
    private LeadService leadService;

    @PostMapping
    public Lead cadastrarLead(@RequestBody Lead lead){
        return leadService.cadastrarLead(lead);
    }

    @GetMapping
    public List<Lead> buscarProdutos(@RequestParam String nomeDoProduto){
        return  leadService.buscarTodosPeloNomeDoProduto(nomeDoProduto);
    }

}
