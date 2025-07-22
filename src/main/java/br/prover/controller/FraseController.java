package br.prover.controller;

import br.prover.service.FraseService;

import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;
import java.io.Serializable;
import java.util.Map;

    @Named("fraseController")
    @ViewScoped
    public class FraseController implements Serializable {
        private String frase;
        @Inject
        private FraseService fraseService;

        public FraseController() {
            System.out.println("FraseController instanciado");
        }

        private Map<String, Integer> resultado;

        public void analisar() {
            resultado = fraseService.analisarFrase(frase);
        }

        public int getQtdPalavrasDistintas() {
            return resultado != null ? resultado.size() : 0;
        }

        public String getFrase() { return frase; }
        public void setFrase(String frase) { this.frase = frase; }
        public Map<String, Integer> getResultado() { return resultado; }
    }
