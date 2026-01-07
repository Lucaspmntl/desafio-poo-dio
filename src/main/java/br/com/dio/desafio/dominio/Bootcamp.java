package br.com.dio.desafio.dominio;

import java.time.LocalDate;
import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.Objects;
import java.util.Set;

public class Bootcamp {

    private String nome;
    private String descricao;
    private final LocalDate dataInicio = LocalDate.now();
    private final LocalDate dataFim = dataInicio.plusDays(60);

    private final Rank rank = new Rank(this);

    private Set<Dev> devs = new HashSet<>();
    private Set<Conteudo> conteudos = new LinkedHashSet<>();

    public Bootcamp() {}

    public void incluirDev(Dev dev){
        this.devs.add(dev);
    }

    public Rank getRank() {return rank;}

    public String getNome() {return nome;}
    public void setNome(String nome) {this.nome = nome;}

    public String getDescricao() {return descricao;}
    public void setDescricao(String descricao) {this.descricao = descricao;}

    public Set<Dev> getDevs() {return devs;}
    public void setDevs(Set<Dev> devs) {this.devs = devs;}

    public Set<Conteudo> getConteudos() {return conteudos;}
    public void setConteudos(Set<Conteudo> conteudos) {this.conteudos = conteudos;}

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Bootcamp bootcamp = (Bootcamp) o;
        return Objects.equals(nome, bootcamp.nome) && Objects.equals(descricao, bootcamp.descricao);
    }

    @Override
    public int hashCode() {
        return Objects.hash(nome, descricao);
    }

    @Override
    public String toString() {
        return "Bootcamp{" +
                "descricao='" + descricao + '\'' +
                ", nome='" + nome + '\'' +
                '}';
    }
}
