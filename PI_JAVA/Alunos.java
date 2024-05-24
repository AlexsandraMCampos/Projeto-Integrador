package projetoIntegrado2;

	import java.util.ArrayList;
	import java.util.regex.Pattern;

	public class Alunos extends Pessoas{
		
		private int mediafinal;
	    private int faltas;

	    private ArrayList<Integer> notas = new ArrayList<>();

	    public int getMediafinal() {
	        int mf = 0;
	        for (int i = 0; i < 4; i++) {
	            mf += this.notas.get(i);
	        }
	        this.mediafinal = mf / 4;
	        return mediafinal;
	    }

	    public void setMediafinal(int mediafinal) {
	        this.mediafinal = mediafinal;
	    }

	    public int getFaltas() {
	        return faltas;
	    }

	    public void setFaltas(String faltas) {
	        int intFaltas = 0;

	        if (validarNumeros(faltas)) {
	            intFaltas = Integer.valueOf(faltas).intValue();
	        }else {
	            throw new NumberFormatException("O campo não pode ser vazio, sendo ele inteiro. Não pode conter caracteres especiais ");
	        }
			if(intFaltas > 10 ){
				throw new ArithmeticException("Numero de falta invalido !!! O valor digitado é maior que 10");
			}
			if (intFaltas < 10 && intFaltas >= 0) {
				this.faltas = intFaltas;
			}
		}


	    public static boolean validarNumeros(String input) {
	        // Use uma expressão regular para verificar se a string contém apenas números
	        String regex = "^[0-9]+$";
	        return Pattern.matches(regex, input);
	    }

	    public ArrayList<Integer> getNotas() {
	        return notas;
	    }

	    public void setNotas(ArrayList<Integer> notas) {
	        this.notas = notas;
	    }


	    public String consultarSituacaoALuno() {
	        int mf = this.getMediafinal();

	        if (mf >= 70 && faltas < 2) {
	            return "Aprovado";
	        } else if (mf >= 50 && mf < 70 || faltas < 5) {
	            return "Recuperação";
	        } else {
	            return "Reprovado";
	        }
	    }

	    public void incluirNota(String nota) {
	    	Util.bloquearEspacosVazios(nota);
	    	int intNota = Integer.valueOf(nota).intValue();
			if(intNota > 100){
				throw new ArithmeticException("Nota invalida !!! O valor digitado é maior que 100");
			}
	        if (intNota >= 0 && intNota <= 100) {
	            this.notas.add(intNota);
	        }
	    }

	    @Override
	    public String toString() {
	        return "|Nome: " + this.getNome() + ", Média final: "
	                + mediafinal +
	                ", faltas: " + faltas +
	                ", notas: " + notas +
	                ", situação: " + this.consultarSituacaoALuno() +
	                "|";
	    }

		
	}

