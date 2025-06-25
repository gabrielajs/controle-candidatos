import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;

public class ProcessoSeletivo {
    public static void main(String[] args) throws Exception {
        String [] candidatos = {"João", "Maria", "Pedro", "Ana"};

        for(String candidato : candidatos) {
            entrandoEmContato(candidato);
        }
    }

    static void analisarCandidato(double salarioPretendido){
        double salarioBase = 2000.0;

        if(salarioBase > salarioPretendido) {
            System.out.println("Ligar para o candidato!");
        } else if(salarioBase == salarioPretendido) {
            System.out.println("Ligar para o candidato e negociar!");
        } else {
            System.out.println("Aguardando resultado dos demais candidatos!");
        }

    }

    static void selecaoCandidato(){
        String[] candidatos = {"João", "Maria", "Pedro", "Ana"};

        int candidatoSelecionado = 0;
        int candidatoAtual = 0;
        double salarioBase = 2000.0;

        while (candidatoSelecionado < 2 && candidatoAtual < candidatos.length) {
            String candidato = candidatos[candidatoAtual];
            double salarioPretendido = salarioPretendido();

            System.out.println("Candidato: " + candidato + ", Salário Pretendido: " + salarioPretendido);

            if(salarioBase >= salarioPretendido) {
                System.out.println(candidato + " foi selecionado!");
                candidatoSelecionado++;
            } 
            candidatoAtual++;
        }
    }

    static double salarioPretendido(){
        return ThreadLocalRandom.current().nextDouble(1500.0, 2500.0);
    }

    static void imprimirCandidatos() {
        String [] candidatos = {"João", "Maria", "Pedro", "Ana"};

        // for (int i=0; i < candidatos.length; i++) {
        //     System.out.println("Candidato: " + (i+1) + candidatos[i]);
        // }

        //forma abreviada de for
        for(String candidato: candidatos) {
            System.out.println("Candidato: " + candidato);
        }
    }

    static boolean atender(){
        return new Random().nextInt(3)==1;
    }

    static void entrandoEmContato(String candidato){
        int tentantivas = 1;
        boolean continuar = true;
        boolean atendeu = false;

        do{
            atendeu = atender();
            continuar = !atendeu;

            if(continuar) {
                System.out.println("Tentativa " + tentantivas + " de contato com " + candidato);
                tentantivas++;
            } else {
                System.out.println("Contato realizado com sucesso!");
            }
        } while(continuar && tentantivas < 3);

        if(atender()) {
            System.out.println("Entrando em contato com " + candidato);
        } else {
            System.out.println("Não foi possível entrar em contato com " + candidato);
        }

    }
}
