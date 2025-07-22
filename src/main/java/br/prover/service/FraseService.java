package br.prover.service;

import javax.enterprise.context.ApplicationScoped;
import java.util.HashMap;
import java.util.Map;

@ApplicationScoped
public class FraseService {
    public synchronized Map<String, Integer> analisarFrase(String frase) {
        Map<String, Integer> mapaDePalavras = new HashMap<>();

        //Retorna o proprio map vazio se frase for nula ou vazia após tratamento de espaço em branco
        if (frase == null || frase.trim().isEmpty()) {
            return mapaDePalavras;
        }

        // Remove pontuação e deixa tudo minúsculo
        frase = frase.toLowerCase().replaceAll("[^a-zà-ú0-9 ]", "");

        // Divide a frase em palavras usando espaço como separador
        String[] palavras = frase.split("\\s+");

        // Loop que irá verificar se a palavra será repetida ou não.
        for (String palavra : palavras) {
            if (mapaDePalavras.containsKey(palavra)) {
                int contagemAtual = mapaDePalavras.get(palavra);
                mapaDePalavras.put(palavra, contagemAtual + 1);
            } else {
                mapaDePalavras.put(palavra, 1);
            }
        }
        return mapaDePalavras;
    }
}
