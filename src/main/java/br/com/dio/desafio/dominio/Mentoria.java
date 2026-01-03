package br.com.dio.desafio.dominio;

import br.com.dio.desafio.dominio.exception.DataExpiradaException;

import java.time.LocalDate;

public class Mentoria extends Conteudo {

    private LocalDate data;

    public Mentoria(){};
    public Mentoria(String titulo, String descricao, LocalDate data) {
        this.setTitulo(titulo);
        this.setDescricao(descricao);
        this.data = data;
    }

    @Override
    public double calcularXp() {
        return XP_PADRAO + 20d;
    }

    public LocalDate getData() { return data; }
    public void setData(LocalDate data) {
        if (data.isBefore(LocalDate.now()))
            throw new DataExpiradaException();

        this.data = data;
    }
}
