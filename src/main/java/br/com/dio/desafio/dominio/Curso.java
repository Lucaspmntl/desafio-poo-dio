package br.com.dio.desafio.dominio;

import br.com.dio.desafio.dominio.exception.NumeroNegativoException;

public class Curso {

    private String titulo;
    private String descricao;
    private Integer cargaHoraria;

    public Curso(){};

    public Curso(String titulo, String descricao, Integer cargaHoraria){
        this.titulo = titulo;
        this.descricao = descricao;
        setCargaHoraria(cargaHoraria);
    }

    public String getTitulo() { return titulo; }
    public void setTitulo(String titulo) { this.titulo = titulo; }

    public String getDescricao() { return descricao; }
    public void setDescricao(String descricao) { this.descricao = descricao; }

    public Integer getCargaHoraria() { return cargaHoraria; }
    public void setCargaHoraria(Integer cargaHoraria) {
        if (cargaHoraria <= 0)
            throw new NumeroNegativoException();

        this.cargaHoraria = cargaHoraria;
    }
}
