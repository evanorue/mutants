package com.meli.mutants.service;

import com.meli.mutants.model.ADNBase;
import com.meli.mutants.model.Mutant;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class ADNService implements IADNService {

    @Autowired
    GraphService graphService = null;

    @Autowired
    Mutant mutantModel = null;

    public void setMutantModel(Mutant mutantModel) {
        this.mutantModel = mutantModel;
    }

    public void setGraphService(GraphService graphService) {
        this.graphService = graphService;
    }

    public ADNBase processDna(ADNBase dna) {

        int[][] a = graphService.generateAdjacencyMatrix(dna.getData());
        Map<String, List<Integer>> m;
        boolean isMutant = false;
        if(a != null){
            m = new HashMap<String, List<Integer>>();
            m = graphService.calculateMatrixDegrees(a);
            isMutant = mutantModel.isMutant(m,dna.getData());

            if(isMutant){
                dna.setKind("MUTANTE");
            }else {
                dna.setKind("POSIBLEMENTE HUMANO");
            }
        }else {
            dna.setKind("ERORR DE ENTRADA");
        }

        return dna;
    }
}
