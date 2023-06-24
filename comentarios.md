# Comentários - Projeto 4 (31/05)

## Nota base: 11,75

### Comentários

- Backlog não preenchido
- Instruções de uso muito superficial
- Diagrama desatualizado
- Documentação do código parcialmente realizada
- Não realizaram video de apresentação
- Como realizar login de um usuário que irá acessar a plataforma pela primeira vez?
- A plataforma não possibilita o processo de assistir uma midia, inviabilizando o processo de classificação e validação do usuário especialista
- Rever necessidade do metodo ehAdmin()
- Remover trechos de código comentados
- Não entendi o metodo avaliar() vazio em PlataformaStreaming
- Uma possível solução ao implementar a classe Avaliacao seria definir uma interface de Avaliadores para diferenciar os Clientes
- Utilizem enumeradores quando necessário
- Realmente existe necessidade de todos esses if's?
       
       if (clienteAtual != null) System.out.println("*  1. Filtrar mídias por nome na lista 'Para Ver'   *");
        if (clienteAtual != null) System.out.println("*  2. Filtrar mídias por nome na lista 'Já Vistas'  *");
        if (clienteAtual != null) System.out.println("*  3. Filtrar mídias por nome no catálogo geral     *");
        if (clienteAtual != null) System.out.println("*  4. Filtrar mídias por gênero na lista 'Para Ver' *");
        if (clienteAtual != null) System.out.println("*  5. Filtrar mídias por gênero na lista 'Já Vistas'*");
        if (clienteAtual != null) System.out.println("*  6. Filtrar mídias por gênero no catálogo geral   *");
        if (clienteAtual != null) System.out.println("*  7. Filtrar mídias por idioma na lista 'Para Ver' *");
        if (clienteAtual != null) System.out.println("*  8. Filtrar mídias por idioma na lista 'Já Vistas'*");
        if (clienteAtual != null) System.out.println("*  9. Filtrar mídias por idioma no catálogo geral   *");
----
	
- Aderência às classes do diagrama: 1/2 pontos
- Requisitos de corretamente implementados: 9/14 pontos
    - só pode avaliar o que tiver visto		2/2 pontos
    - avaliar, calcular e exibir media 		2/2 pontos
    - cliente não pode avaliar 2x			2/3 pontos
    - especialistas podem comentar			1,5/4 pontos
    - verificação de especialistas			1,5/3 pontos
	
- Documentação de código: 1/2 pontos

- Implementação na aula inicial: 0,75/2 pontos (02/05)
    - arquivos JavaDoc  
    - diagrama atualizado 
    - backlog de pendências

----