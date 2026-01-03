import br.com.dio.desafio.dominio.*;

import java.time.LocalDate;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

public class Main {
    public static void main(String[] args) {

        Curso introJava = new Curso();
        introJava.setTitulo("Introdução ao Java");
        introJava.setDescricao("Introdução a sintaxe e lógica com Java");
        introJava.setCargaHoraria(4);

        Curso introPython = new Curso();
        introPython.setTitulo("Introdução Python");
        introPython.setDescricao("Introdução a sintaxe e lógica com Python");
        introPython.setCargaHoraria(3);

        Mentoria JavaIA = new Mentoria();
        JavaIA.setTitulo("Java IA");
        JavaIA.setDescricao("Introdução a IA com Java");
        JavaIA.setData(LocalDate.now().plusDays(7));

        Bootcamp bootcampAccenture = new Bootcamp();
        bootcampAccenture.setNome("Bootcamp Accenture");
        bootcampAccenture.setDescricao("Bootcamp Accenture com java e python");

        Set<Conteudo> conteudosAccenture = new HashSet<>();
        conteudosAccenture.add(introJava);
        conteudosAccenture.add(introPython);
        conteudosAccenture.add(JavaIA);
        bootcampAccenture.setConteudos(conteudosAccenture);

        Dev Ciclano = new Dev();
        Ciclano.setNome("Ciclano");
        Ciclano.inscreverBootcamp(bootcampAccenture);

        Dev fulano = new Dev();
        fulano.setNome("Fulano");
        fulano.inscreverBootcamp(bootcampAccenture);
        fulano.proguedir(bootcampAccenture);
    }
}
