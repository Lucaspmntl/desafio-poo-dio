package br.com.dio.desafio.dominio;

import br.com.dio.desafio.dominio.exception.NumeroNegativoException;

public class Curso extends Conteudo {

    private Integer cargaHoraria;

    public Curso(){};


    @Override
    public double calcularXp() {
        return XP_PADRAO + 40d;
    }

    public Curso(String titulo, String descricao, Integer cargaHoraria){
        this.setTitulo(titulo);
        this.setDescricao(descricao);
        setCargaHoraria(cargaHoraria);
    }

    public Integer getCargaHoraria() { return cargaHoraria; }
    public void setCargaHoraria(Integer cargaHoraria) {
        if (cargaHoraria <= 0)
            throw new NumeroNegativoException();

        this.cargaHoraria = cargaHoraria;
    }
}
