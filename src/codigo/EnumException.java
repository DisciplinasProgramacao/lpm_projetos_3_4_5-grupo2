package codigo;

public class EnumException extends RuntimeException {

	private static final long serialVersionUID = 1L;
	
	public EnumException(String mensagem) {
		super(mensagem);
	}

	public EnumException() {
		super();
	}
}