package br.com.zup.LeadCollector.Lead;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class LeadService {
    @Autowired
    private LeadRepository leadRepository;


}
