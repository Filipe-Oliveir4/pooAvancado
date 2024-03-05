package exercicio1;

public class EmailSender extends Thread  {

    String email;
    public EmailSender(String email) {
        this.email = email;
    }
    public void run(){
        System.out.println("Preparando para enviar e-mail para: " + email);
        try {
            // Simular o tempo de envio do e-mail
            Thread.sleep(5000);
            System.err.println("E-mail enviado com sucesso para: " + email);
        } catch (InterruptedException e) {
            System.err.println("A thread foi interrompida durante a espera.");
        };
    }
    public void enviarEmail(String email) {
        System.out.println("Preparando para enviar e-mail para: " + email);
        try {
            // Simular o tempo de envio do e-mail
            Thread.sleep(5000);
            System.err.println("E-mail enviado com sucesso para: " + email);
        } catch (InterruptedException e) {
            System.err.println("A thread foi interrompida durante a espera.");
        }
    }
}
