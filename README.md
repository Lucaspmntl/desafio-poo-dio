# ☕ Desafio POO - Bootcamp Accenture

Este projeto implementa uma abstração de um bootcamp utilizando os quatro pilares da POO: encapsulamento, herança, polimorfismo e abstração. O sistema permite gerenciar cursos, mentorias, devs inscritos e o progresso de cada participante, incluindo cálculo automático de XP.

## 🏗️ Estrutura do Projeto

### Classes Principais

**Conteudo** (abstrata)
- Classe base para todos os tipos de conteúdo do bootcamp
- Define XP padrão de 10 pontos
- Método abstrato `calcularXp()` implementado pelas subclasses

**Curso**
- Herda de `Conteudo`
- Possui carga horária validada (mínimo 1h)
- XP calculado: 50 pontos (base + bônus)
- Lança `NumeroNegativoException` para cargas horárias inválidas

**Mentoria**
- Herda de `Conteudo`
- Possui data de realização
- XP calculado: 30 pontos (base + bônus)
- Valida datas futuras, lançando `DataExpiradaException` para datas passadas

**Dev**
- Representa os desenvolvedores inscritos
- Gerencia conteúdos inscritos e concluídos usando `Set` para evitar duplicatas
- Método `inscreverBootcamp()` para inscrição automática
- Método `proguedir()` para progressão nos conteúdos (primeiro a entrar, primeiro a sair)
- Cálculo de XP total baseado nos conteúdos concluídos

**Bootcamp**
- Gerencia todos os conteúdos oferecidos
- Controla devs inscritos
- Duração fixa de 45 dias a partir da data de início
- Usa `LinkedHashSet` para manter ordem de inserção dos conteúdos

## 🧠 Conceitos Aplicados

###  Abstração
A classe `Conteudo` define o contrato que todos os conteúdos devem seguir, sem implementar detalhes específicos. Cada tipo de conteúdo implementa seu próprio cálculo de XP.

### Encapsulamento
- Atributos privados com acesso controlado via getters e setters
- Validações nos setters (carga horária, datas)
- Uso de `final` para atributos imutáveis (datas do bootcamp)

### Herança
`Curso` e `Mentoria` herdam de `Conteudo`, reaproveitando atributos comuns (título, descrição) e a constante `XP_PADRAO`.

### Polimorfismo
O método `calcularXp()` é implementado de forma diferente em cada subclasse:
- Curso: 50 XP
- Mentoria: 30 XP

### Tratamento de Exceções
Exceções customizadas para regras de negócio:
- `NumeroNegativoException`: quando carga horária é inválida
- `DataExpiradaException`: quando data da mentoria é anterior ao dia atual

### Coleções e Streams
- `Set` para evitar duplicatas de devs e conteúdos
- `LinkedHashSet` para manter ordem de inserção
- Streams para cálculo funcional de XP total

## ⚙️ Como Funciona

```java
// Criar um bootcamp
Bootcamp bootcamp = new Bootcamp();
bootcamp.setNome("Bootcamp Java Developer");
bootcamp.setDescricao("Aprenda Java do zero");

// Adicionar conteúdos
Curso curso1 = new Curso("Java Básico", "Fundamentos de Java", 8);
Mentoria mentoria1 = new Mentoria("Carreira Dev", "Como crescer na área", LocalDate.now().plusDays(7));

bootcamp.getConteudos().add(curso1);
bootcamp.getConteudos().add(mentoria1);

// Inscrever devs
Dev dev1 = new Dev();
dev1.setNome("João");
dev1.inscreverBootcamp(bootcamp);

// Progredir nos conteúdos
dev1.proguedir(bootcamp); // Conclui o primeiro conteúdo

// Calcular XP
System.out.println("XP Total: " + dev1.calcularXp());
```

Fluxo:
1. Criar bootcamp com nome e descrição
2. Adicionar cursos e mentorias ao bootcamp
3. Devs se inscrevem através do método `inscreverBootcamp()`
4. Devs progridem usando `proguedir()`, que move conteúdos de "inscritos" para "concluídos"
5. XP é calculado automaticamente somando os pontos de todos os conteúdos concluídos

## 🛠️ Próximos Passos

Este projeto foi desenvolvido como exercício de POO e serviu e serviu muito bem para revisar conteúdos e conceitos deste paradigma. Por ter sido relativamente simples de implementar, algumas possíveis evoluções planejadas incluem:

- Sistema de certificados com validação de conclusão total
- Badges e conquistas para diferentes marcos (50% concluído, primeiro curso, etc)
- Desafios práticos que valem XP extra
- Sistema de ranking entre devs
- Testes unitários

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
