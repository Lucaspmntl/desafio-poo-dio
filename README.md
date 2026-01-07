# ☕ Desafio POO - Bootcamp Accenture

Este projeto implementa uma abstração de um bootcamp utilizando os quatro pilares da POO: encapsulamento, herança, polimorfismo e abstração. O sistema permite gerenciar cursos, mentorias, devs inscritos e o progresso de cada participante, com um sistema de **Ranking** baseado no cálculo automático de XP.

## 🏗️ Estrutura do Projeto

### Classes Principais

**🏆 Rank** (*Nova implementação!*)
- Responsável pela classificação dos desenvolvedores
- Utiliza `Map` para associar Devs à sua pontuação (XP)
- Exibe o ranking ordenado de forma decrescente (maior XP primeiro)

**📦 Conteudo** (abstrata)
- Classe base para todos os tipos de conteúdo do bootcamp
- Define XP padrão de 10 pontos
- Método abstrato `calcularXp()` implementado pelas subclasses

**📚 Curso**
- Herda de `Conteudo`
- Possui carga horária validada (mínimo 1h)
- XP calculado: 50 pontos (base + bônus)
- Lança `NumeroNegativoException` para cargas horárias inválidas

**👨‍🏫 Mentoria**
- Herda de `Conteudo`
- Possui data de realização
- XP calculado: 30 pontos (base + bônus)
- Valida datas futuras, lançando `DataExpiradaException` para datas passadas

**👩‍💻 Dev**
- Representa os desenvolvedores inscritos
- Gerencia conteúdos inscritos e concluídos usando `Set` para evitar duplicatas
- Método `inscreverBootcamp()` para inscrição automática
- Método `proguedir()` para progressão nos conteúdos
- Cálculo de XP total baseado nos conteúdos concluídos

**🚀 Bootcamp**
- Gerencia conteúdos, devs inscritos e agora possui uma instância de `Rank`
- Duração fixa de 45 dias
- Usa `LinkedHashSet` para manter ordem de inserção dos conteúdos

## 🧠 Conceitos Aplicados

### Abstração
A classe `Conteudo` define o contrato que todos os conteúdos devem seguir. A nova classe `Rank` abstrai a lógica de ordenação e exibição de pontuações.

### Encapsulamento
- Atributos privados com acesso controlado via getters e setters
- Validações de regra de negócio (ex: não permitir carga horária negativa)

### Herança
`Curso` e `Mentoria` herdam de `Conteudo`, reaproveitando lógica.

### Polimorfismo
O cálculo de XP varia dependendo se o objeto é um Curso ou Mentoria.

### Coleções e Ordenação
- `Set` e `LinkedHashSet`: Para listas sem duplicatas.
- `Map<Dev, Double>`: Utilizado na classe Rank para mapear o Dev ao seu XP.
- `Comparator`: Utilizado para ordenar o Map e exibir o ranking do maior para o menor XP.

## ⚙️ Como Funciona

```java
// 1. Criar um bootcamp
Bootcamp bootcamp = new Bootcamp();
bootcamp.setNome("Bootcamp Java Developer");
bootcamp.setDescricao("Aprenda Java do zero");

// 2. Adicionar conteúdos
Curso curso1 = new Curso("Java Básico", "Fundamentos de Java", 8);
Mentoria mentoria1 = new Mentoria("Carreira Dev", "Como crescer na área", LocalDate.now().plusDays(7));
bootcamp.getConteudos().add(curso1);
bootcamp.getConteudos().add(mentoria1);

// 3. Inscrever devs
Dev dev1 = new Dev();
dev1.setNome("João");
dev1.inscreverBootcamp(bootcamp);

// 4. Progredir e Calcular XP
dev1.proguedir(bootcamp); // Conclui o curso
System.out.println("XP João: " + dev1.calcularXp());

// 5. Atualizar e Exibir Ranking
bootcamp.getRank().incluirDev(dev1);
bootcamp.getRank().exibirRanking();
```

## 💻 Como Executar

```bash
# Clone o repositório
git clone https://github.com/Lucaspmntl/desafio-poo-dio.git

# Entre no diretório
cd desafio-poo-dio

# Execute o projeto
mvn clean install
java -jar target/desafio-poo-dio.jar
```

Projeto desenvolvido como parte do bootcamp da Accenture na DIO.
