package br.com.dio.desafio.dominio;

import java.time.LocalDate;
import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.Set;

public class Bootcamp {

    private String nome;
    private String descricao;
    private final LocalDate dataInicio = LocalDate.now();
    private final LocalDate dataFim = dataInicio.plusDays(45);
    private Set<Dev> devs = new HashSet<>();
    private Set<Conteudo> conteudos = new LinkedHashSet<>();

    public Bootcamp() {}

    public String getNome() {return nome;}
    public void setNome(String nome) {this.nome = nome;}

    public String getDescricao() {return descricao;}
    public void setDescricao(String descricao) {this.descricao = descricao;}

    public Set<Dev> getDevs() {return devs;}
    public void setDevs(Set<Dev> devs) {this.devs = devs;}

    public Set<Conteudo> getConteudos() {return conteudos;}
    public void setConteudos(Set<Conteudo> conteudos) {this.conteudos = conteudos;}
}
