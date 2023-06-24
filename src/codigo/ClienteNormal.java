package codigo;

public class ClienteNormal implements ITipoCliente extends Cliente{
    public void avaliarMidia(String loginUsuario, int notaDada) {
        Avaliacao avaliacao = new Avaliacao(notaDada);
        if (notaDada > 1 && notaDada <= 5)
            this.avaliacoes.put(loginUsuario, avaliacao);
        else
            System.out.println("Nota inválida. Ela deve ser de 1 a 5.");
    }
    
}
