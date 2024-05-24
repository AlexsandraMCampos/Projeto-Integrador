package projetoIntegrado2;

public class Util {
	
	public static String  bloquearEspacosVazios(String text){
		if(text == null || text.trim().isEmpty()) {
			throw new RuntimeException("Não pode espaço em branco!!!!!!");
		}
		return text;
	}

}
