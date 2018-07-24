package item;

public enum CategoriasEnum {
	
	ALIMENTO_INDUSTRIALIZADO("alimento industrializado"), ALIMENTO_NAO_INDUSTRIALIZADO("alimento nao industrializado"), LIMPEZA("limpeza"), HIGIENE_PESSOAL("higiene pessoal");
	
	private final String valor;
	
	CategoriasEnum (String valor) {
		this.valor = valor;
	}
	
	public String toString() {
		return valor;
	}
	
	
}
