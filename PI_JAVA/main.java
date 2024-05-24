package projetoIntegrado2;

	import java.io.FileWriter;
	import java.util.*;
	import java.io.File;
	import java.io.IOException;
	


	public class main {
		public static void main(String[] args) {
	        Scanner scn = new Scanner(System.in);


	        Turma turma = new Turma();
	        Boletim boletim = new Boletim();
	        Professor professor = new Professor();
	        UnidadeCurricular unidadecurricular = new UnidadeCurricular();

	        //Realização do cadastro de alunos
	        System.out.println("Cadastrar alunos");
	        for (int i = 0; i < 5; i++) {
	            Alunos aluno = new Alunos();
	            System.out.println("Digite o nome do aluno: ");
	            aluno.setNome(Util.bloquearEspacosVazios(scn.nextLine()));
	           // scn.nextLine();
	            
	            for (int j = 1; j <= 4; j++) {
	                System.out.println("Digite a nota do  " + j + " bimestre");
	                aluno.incluirNota(scn.nextLine());
	                
	            }
	            
	            System.out.println("Digite o numero de faltas: ");
	            aluno.setFaltas(scn.nextLine());
	            scn.nextLine();
	            turma.incluirAluno(aluno);
	        }

	        System.out.println("Digite o nome da turma: ");
	        turma.setNomeTurma(Util.bloquearEspacosVazios(scn.nextLine()));
	        System.out.println("Digite o nome do professor: ");
	        professor.setNome(scn.nextLine());

	        System.out.println("Digite o nome da unidade curricular: ");
	        unidadecurricular.setNomeCurso(Util.bloquearEspacosVazios(scn.nextLine()));

	        unidadecurricular.setTurma(turma);
	        professor.setMateria(unidadecurricular);
	        turma.setProfessor(professor);

	        System.out.println("Exibir em forma 1-crescente  ou 2-descrecente ");
	        int formaExibicao = scn.nextInt();
	        scn.nextLine();

	        //Criação do arquivo C:\Users\laris\Documents\liviab

	        try {
	            File file = new File("C:\\Users\\laris\\Documents\\liviab\\boletim.txt");
	            if (file.createNewFile()) {
	                System.out.println("Arquivo com sucesso: " + file.getName());
	            } else {
	                System.out.println("Arquivo não criado");
	            }
	        } catch (IOException e) {
	            System.out.println("Ocorreu um erro ");
	            e.printStackTrace();
	        }

	        //Escritor do arquivo

	        try {
	            FileWriter myWriter = new FileWriter("C:\\Users\\laris\\\\Documents\\liviab\\boletim.txt");

	            myWriter.write("|Nome do Professor: " + turma.getProfessor().getNome() + "\t Unidade Curricular: "
	                    + turma.getProfessor().getMateria().getNomeCurso() + "\t Nome da turma: " + turma.getNomeTurma()+"|\n");

	            if (formaExibicao == 1) {
	                turma.exibirOrdemCrescente(myWriter);
	            } else if (formaExibicao == 2) {
	                turma.exibirOrdemDescrecente(myWriter);
	            }

	            myWriter.write("\n|A média geral turma: " + turma.consultarMediaGeralTurma() + "\t\t\t\t\n");
	            myWriter.write("\n|Os alunos acima da média geral da turma são: " + turma.consultarAlunosAcimaMedia() + "\t\t\t\t\n");
	            myWriter.write("\n|Os alunos abaixo da média geral da turma são: " + turma.consultarAlunosAbaixoMedia() + "\t\t\t\t\n");
	            myWriter.write("\n|O aluno com a maior média é: " + turma.consultarAlunoMaiorMedia());
	            myWriter.write("\n|O aluno com a menor média é: " + turma.consultarAlunoMenorMedia());
	            myWriter.write("O melhor Aluno da turma é " + turma.consultarAlunoMaiorMedia());

	            myWriter.close();
	            System.out.println("Arquivo escrito com sucesso !!!");
	        } catch (IOException e) {
	            System.out.println("Ocorreu um erro");
	            e.printStackTrace();
	        }
	        
	        System.out.println("\nA média geral da turma é: " + turma.consultarMediaGeralTurma());
	        System.out.println("\nOs alunos acima da média geral da turma são: " + turma.consultarAlunosAcimaMedia());
	        System.out.println("\nOs alunos abaixo da média geral da turma são: " + turma.consultarAlunosAbaixoMedia());
	        System.out.println("\nO aluno com a maior média é: " + turma.consultarAlunoMaiorMedia());
	        System.out.println("\nO aluno com a menor média é: " + turma.consultarAlunoMenorMedia());
	        System.out.println("\nO melhor aluno da turma é: " + turma.consultarAlunoMaiorMedia());




	    }
	}


