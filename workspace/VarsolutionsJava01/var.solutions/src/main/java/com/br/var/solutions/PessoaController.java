package com.br.var.solutions;

import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Objects;

@RestController
@RequestMapping("/pessoa")
@CrossOrigin(origins = "*")
@Slf4j
public class PessoaController {
    //         1          2                          3                4
    // publico || privado //tipo de retorno // nome de metodo // parãmetros

    //Endpoint

    @GetMapping
    public ResponseEntity<Object> get() {
        PessoaRequest pessoaRequest1 = new PessoaRequest();
        pessoaRequest1.setNome("kaua");
        pessoaRequest1.setSobrenome("ferreria");
        pessoaRequest1.setEndereco("Avenida CASTELO");
        pessoaRequest1.setIdade(17);
        return ResponseEntity.ok(pessoaRequest1);

    }

    @GetMapping("/resumo")
//                                                   tipo/objeto    apelido
    public ResponseEntity<Object> getPessoa(@RequestBody PessoaRequest pessoinha) {
       String Imc = null;
       int anonascimento = 0;
       String ImpostoRenda = null;
       String validaMundial = null;

        if(!pessoinha.getNome().isEmpty()) {

            log.info("iniciando o processo de resumo da pessoa:", pessoinha);

            if (Objects.nonNull(pessoinha.getPeso()) && Objects.nonNull(pessoinha.getAltura())){
                log.info("iniciando o calculo do IMC");
                 Imc = calcularImc(pessoinha.getPeso(),pessoinha.getAltura());
            }

            if (Objects.nonNull(pessoinha.getIdade())) {
                log.info("Iniciando calculo do ano de nascimento");
                anonascimento = calculaAnoNascimento(pessoinha.getIdade());
            }

            if(Objects.nonNull((pessoinha.getSalario()))){
                log.info("Iniciando calculo do imposto de renda");
                ImpostoRenda = calculaFaixaImpostoRenda(pessoinha.getSalario());
            }

            if(Objects.nonNull(pessoinha.getTime())) {

                log.info("Validando s e o time de coração tem mundial");
                validaMundial = calcularMundial(pessoinha.getTime());
            }

            if(Objects.nonNull(pessoinha.getSaldo())) {

                log.info("convertendo real em Dolar");
                validaMundial = converteSaldoDolar(pessoinha.getSaldo());
            }

            log.info("montando objeto de retorno para o front-end");
            Object resumo = complementarRespostaFrontEnd(Imc, anonascimento, ImpostoRenda, validaMundial);

            return ResponseEntity.ok(resumo);
        }
        return ResponseEntity.noContent().build();
    }

    private String converteSaldoDolar(double saldo) {
        return null;
    }

    private Object complementarRespostaFrontEnd(String imc, int anonascimento, String impostoRenda, String validaMundial) {
        return null;
    }

    private String calcularMundial(String time) {
        return null;
    }

    private String calculaFaixaImpostoRenda(double salario) {
        return null;
    }

    private int calculaAnoNascimento(int idade) {
        return  0;
    }

    private String calcularImc(double peso, double altura) {
        return null;
    }
}
