package codigo;

import java.io.Serial;

/**
 * A classe EnumException representa uma exceção específica para enumerações.
 * Ela é uma subclasse de RuntimeException.
 */

public class EnumException extends RuntimeException {

	@Serial
	private static final long serialVersionUID = 1L;

	/**
	 * Constrói uma nova EnumException com a mensagem de erro especificada.
	 *
	 * @param mensagem - a mensagem de erro
	 */

	public EnumException(String mensagem) {
		super(mensagem);
	}
}