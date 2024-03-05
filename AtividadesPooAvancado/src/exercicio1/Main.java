package exercicio1;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String email;
        List<String> listaEmails = new ArrayList<>();
        List<Thread> threadsRodando = new ArrayList<>();
        boolean podeFinalizar =true;
        do {
            System.out.println("Digite os endereços de e-mail para envio (digite 'SAIR' para finalizar e enviar os emails):");
            email = scanner.nextLine();
            // Apenas enviar o e-mail se o usuário não digitou "SAIR"
            if (!email.equalsIgnoreCase("SAIR")) {
                listaEmails.add(email);
            }

        } while (!email.equalsIgnoreCase("SAIR"));
        Iterator<String> it = listaEmails.iterator();
        while (it.hasNext()){
            var emailSender = new EmailSender(it.next());
            emailSender.start();
            threadsRodando.add(emailSender);
        }
        while(podeFinalizar){
            boolean algumaThreadRodando = true;
            for (Thread thread:threadsRodando){
                algumaThreadRodando = algumaThreadRodando && thread.isAlive();
            }
            podeFinalizar=algumaThreadRodando?true:false;
        }
        System.out.println("Finalizado. Todos os e-mails foram enviados (ou pelo menos tentamos).");
    }
}
