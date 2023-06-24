package codigo;

public class ClienteEspecialista implements ITipoCliente extends Cliente {
    @Override
        public void avaliarMidia(String loginUsuario, int notaDada, String comentario) {
        Avaliacao avaliacao = new Avaliacao(notaDada, comentario);
        if (notaDada > 1 && notaDada <= 5)
            this.avaliacoes.put(loginUsuario, avaliacao);
        else
            System.out.println("Nota inválida. Ela deve ser de 1 a 5.");
    }

    
}
