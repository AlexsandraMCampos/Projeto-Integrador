package projetoIntegrado2;

	import java.io.FileWriter;
	import java.io.IOException;

	public class Turma {
		//Atributos
		private Alunos[] listaAlunos = new Alunos[5];
	    private String nomeTurma;

	    private Professor professor;

	    public Professor getProfessor() {
	        return professor;
	    }

	    public void setProfessor(Professor professor) {
	        this.professor = professor;
	    }

	    public String getNomeTurma() {
	        return nomeTurma;
	    }

	    public void setNomeTurma(String nomeTurma) {
	        this.nomeTurma = nomeTurma;
	    }

	    public Alunos[] getListaAlunos() {
	        return listaAlunos;
	    }

	    public void setListaAlunos(Alunos[] listaAlunos) {
	        this.listaAlunos = listaAlunos;
	    }

	    public int consultarMediaGeralTurma() {
	        int somageral = 0;
	        int tamanholista = this.listaAlunos.length;
	        for (int i = 0; i < tamanholista; i++) {
	            Alunos aluno = this.listaAlunos[i];
	            if (aluno != null)
	                somageral += aluno.getMediafinal();
	        }
	        return somageral / tamanholista;
	    }

	    public int consultarAlunosAcimaMedia() {
	        int mediaGeral = this.consultarMediaGeralTurma();
	        int quantidadeAcimaMedia = 0;
	        int tamanhoLista = this.listaAlunos.length;
	        for (int i = 0; i < tamanhoLista; i++) {
	            Alunos aluno = this.listaAlunos[i];

	            if (aluno != null && aluno.getMediafinal() > mediaGeral) {
	                quantidadeAcimaMedia++;
	            }

	        }
	        return quantidadeAcimaMedia;
	    }

	    public int consultarAlunosAbaixoMedia() {
	        int mediaGeral = this.consultarMediaGeralTurma();
	        int quantidadeAbaixoMedia = 0;
	        int tamanhoLista = this.listaAlunos.length;
	        for (int i = 0; i < tamanhoLista; i++) {
	            Alunos aluno = this.listaAlunos[i];

	            if (aluno != null && aluno.getMediafinal() < mediaGeral) {
	                quantidadeAbaixoMedia++;
	            }
	        }
	        return quantidadeAbaixoMedia;
	    }

	    public Alunos consultarAlunoMaiorMedia() {
	        int maiorMedia = 0;
	        Alunos alunoMaiorMedia = null;
	        int tamanhoLista = this.listaAlunos.length;
	        for (int i = 0; i < tamanhoLista; i++) {
	            Alunos aluno = this.listaAlunos[i];

	            if (aluno != null && aluno.getMediafinal() > maiorMedia) {
	                maiorMedia = aluno.getMediafinal();
	                alunoMaiorMedia = aluno;
	            }
	        }
	        return alunoMaiorMedia;
	    }

	    public Alunos consultarAlunoMenorMedia() {
	        int menorMedia = 100;
	        Alunos alunoMenorMedia = null;
	        int tamanhoLista = this.listaAlunos.length;
	        for (int i = 0; i < tamanhoLista; i++) {
	            Alunos aluno = this.listaAlunos[i];

	            if (aluno != null && aluno.getMediafinal() < menorMedia) {
	                menorMedia = aluno.getMediafinal();
	                alunoMenorMedia = aluno;
	            }
	        }
	        return alunoMenorMedia;
	    }

	    public void exibirOrdemCrescente(FileWriter myWriter) throws IOException {
	        Alunos aux = null;
	        for (int i = 0; i < this.listaAlunos.length; i++) {
	            for (int j = i; j < this.listaAlunos.length; j++) {
	                Alunos primeiroAluno = this.listaAlunos[i];
	                Alunos segundoAluno = this.listaAlunos[j];
	                if (primeiroAluno != null && segundoAluno != null && primeiroAluno.getMediafinal() > segundoAluno.getMediafinal()) {
	                    aux = primeiroAluno;
	                    this.listaAlunos[i] = this.listaAlunos[j];
	                    this.listaAlunos[j] = aux;
	                }
	            }
	        }
	        for (Alunos aluno : this.listaAlunos) {
	            if (aluno != null) {
	                System.out.println(aluno);
	                myWriter.write(
	                        "\n|Nome: " + aluno.getNome() + "|\n" +
	                                "|Média Final: " + aluno.getMediafinal() + "|\n" +
	                                "|Faltas: " + aluno.getFaltas() + "|\n" +
	                                "|Notas por bimestre: " + aluno.getNotas() + "|\n"
	                );
	            }
	        }

	    }

	    public void exibirOrdemDescrecente(FileWriter myWriter) throws IOException {
	        Alunos aux = null;
	        for (int i = 0; i < this.listaAlunos.length; i++) {
	            for (int j = i; j < this.listaAlunos.length; j++) {
	                Alunos primeiroAluno = this.listaAlunos[i];
	                Alunos segundoAluno = this.listaAlunos[j];
	                if (primeiroAluno.getMediafinal() < segundoAluno.getMediafinal()) {
	                    aux = primeiroAluno;
	                    this.listaAlunos[i] = this.listaAlunos[j];
	                    this.listaAlunos[j] = aux;
	                }
	            }
	        }
	        for (Alunos aluno : this.listaAlunos) {
	            System.out.println(aluno.toString());
	            myWriter.write(
	                    "Nome:   " + aluno.getNome() + "|\n" +
	                            " Média Final:  " + aluno.getMediafinal() + "|\n" +
	                            "Faltas:  " + aluno.getFaltas() + "|\n" +
	                            "Notas por bimestre:  " + aluno.getNotas() + "|\n"
	            );
	        }
	    }

	    public void incluirAluno(Alunos aluno) {
	        for (int i = 0; i < listaAlunos.length; i++) {
	            if (listaAlunos[i] == null) {
	                listaAlunos[i] = aluno;
	                break;
	            }
	        }

	    }
	}

