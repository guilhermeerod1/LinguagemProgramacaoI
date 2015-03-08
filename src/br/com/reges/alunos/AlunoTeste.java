package br.com.reges.alunos;

/**
 * Classe que testa a implementação da Classe Aluno
 * 
 * @author Lucas Nascimento
 *
 */
public class AlunoTeste {

	/**
	 * Método principal a ser chamado na hora de terstarmos nossa implementação
	 * 
	 * @param args
	 *            Argumentos da linha de comando
	 */
	public static void main(String[] args) {

		// Testando um Aluno que seria reprovado
		Aluno aluno = new Aluno("Aluno", "Ensino Fundamental");
		aluno.notaProva = 5.5;
		System.out.println(aluno.resultado());

		// Testando um Aluno que iria para Exame
		AlunoDeGraduacao alunoGraduacao = new AlunoDeGraduacao(
				"AlunoDeGraduacao", "Graduação");
		alunoGraduacao.notaProva = 2.0;
		alunoGraduacao.notaTrabalhoPrimeiroBimstre = 3.0;
		alunoGraduacao.notaProvaSegundoBimestre = 2.0;
		alunoGraduacao.notaTrabalhoSegundoBimestre = 3.0;
		System.out.println(alunoGraduacao.resultado());

		// Testando um Aluno que seria aprovado
		AlunoDePosGraduacao alunoPosGraduacao = new AlunoDePosGraduacao(
				"AlunoDePosGraduacao", "PosGraduação");
		alunoPosGraduacao.notaProva = 5.0;
		alunoPosGraduacao.notaTrabalho = 2.0;
		System.out.println(alunoPosGraduacao.resultado());

		// Testando um Aluno de Graduação
		AlunoDeGraduacaoSemTrabalho alunoGraduacao2 = new AlunoDeGraduacaoSemTrabalho(
				"AlunoDeGraduacaoSemTrabalho", "Gradução Sem Trabalho");
		alunoGraduacao2.notaProva = 6.0;
		alunoGraduacao2.notaProvaSegundoBimestre = 8.0;
		System.out.println(alunoGraduacao2.resultado());

		// Usando polimorfismo imprimiremos uma mensagem para cada aluno
		System.out.println(montaMensagemDeResultado(aluno));
		System.out.println(montaMensagemDeResultado(alunoGraduacao));
		System.out.println(montaMensagemDeResultado(alunoPosGraduacao));
		System.out.println(montaMensagemDeResultado(alunoGraduacao2));
		
		Aluno alunoPolimofico = (Aluno) alunoPosGraduacao;
		
		if (aluno instanceof Aluno){
			//É do tipo Aluno
		}else if (aluno instanceof AlunoDeGraduacao){
			//É do tipo AlunoDeGraduacao
		}else if (aluno instanceof AlunoDePosGraduacao){
			//É do tipo AlunoDePosGraduacao
		}else if (aluno instanceof AlunoDeGraduacaoSemTrabalho){
			//É do tipo AlunoDeGraduacaoSemTrabalho
		}
		
		//Teste da fun��o do exerc�cio
		//Cria alunos: teste1 e teste2
		AlunoDeGraduacao teste1 = new AlunoDeGraduacao("Teste", "1");
		Aluno teste2 = new Aluno("Teste", "2");
		
		//Cria teste3 : polimorfico
		Aluno teste3 = teste2; 
		System.out.println(ImprimeNomeCompleto(teste3));
		
		//Usa um cast para passar o teste1 (AlunoDeGraduacao) para teste3
		teste3 = (Aluno) teste1;
		System.out.println(ImprimeNomeCompleto(teste3));
		
	}

	/**
	 * Usando polimorfismo podemos receber qualquer tipo de objeto que derive
	 * aluno e fazer uso de métodos da Classe em mais alto nível
	 * 
	 * @param aluno
	 * @return
	 */
	private static String montaMensagemDeResultado(Aluno aluno) {
		StringBuilder mensagem = new StringBuilder();
		mensagem.append("Caro aluno ").append(aluno.nome)
				.append(" seu resultado foi ").append(aluno.resultado());

		return mensagem.toString();
	}
	
	//Fun��o do exerc�cio
	private static String ImprimeNomeCompleto(Aluno aluno){
		StringBuilder mensagem = new StringBuilder();
		
		if(aluno instanceof Aluno){
			mensagem.append("Nome completo do aluno: ").append(aluno.nome + " ").append(aluno.sobrenome);
			if(aluno instanceof AlunoDeGraduacao)
				mensagem.append(" - Nota Trabalho 2 Bim: ").append(((AlunoDeGraduacao) aluno).notaTrabalhoSegundoBimestre);
		}
			
		return mensagem.toString();
	}

}
