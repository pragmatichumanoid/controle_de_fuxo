package candidatura;

import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;

public class ProcessoSeletivo {
    public static void main(String[] args) {
        String [] candidatos = { "FELIPE", "MARCIA", "JULIA", "PAULO", "AUGUSTO"};
        for(String candidato:candidatos){
              entrandoEmContato(candidato);
        }
    }
    static boolean atender(){ //metodo auxiliar
        return new Random().nextInt(3)==1;
    }
    static void entrandoEmContato(String candidato){
        int tentativasRealizadas = 1;
        boolean continuarTentando = true;
        boolean atendeu = false;
        do{
            atendeu = atender();
            continuarTentando = !atendeu;
            if(continuarTentando){
                tentativasRealizadas++;
            }else{
                System.out.println("Chamada realizada com sucesso");
            }

        
        }while(continuarTentando  && tentativasRealizadas<3);
         if(atendeu){
            System.out.println("Conseguimos contato com o candidato "+ candidato+ "na"+ tentativasRealizadas + " tentativa");
         }else{
            System.out.println("Não conseguimos contato com o candidato "+candidato+" após o  número máximo de tentativas.");
         }
    }
    static void imprimirSelecionados(){
        String [] candidatos = { "FELIPE", "MARCIA", "JULIA", "PAULO", "AUGUSTO"};
        for (int i=0 ; i< candidatos.length;i++){
            System.out.println("O candidato de n* "+ (i+1) +" é: "+candidatos[i]);
        }
    }
    static void selecionarCandidatos() {
        String[] candidatos = { "FELIPE", "MARCIA", "JULIA", "PAULO", "AUGUSTO", "MÔNICA", "FABRICIO",
                "JORGE", "LUCAS", "DAVI" };
        int candidatoSelecionado = 0;
        double salarioBase = 2000.0;
        int candidatoAtual = 0;
        while (candidatoSelecionado < 5 && candidatoAtual  < candidatos.length) {
            String candidato = candidatos[candidatoAtual];
            double salarioPretendido = valorPretendido();
            System.out.println("O candidato " + candidato + " solicitou esse valor de salário: " + salarioPretendido);
            if (salarioBase > salarioPretendido) {
                System.out.println("O candidato " + candidato + " foi selecionado para a vaga");
                candidatoSelecionado++;
            }
            candidatoAtual++;
        }

    }

    static double valorPretendido() {
        return ThreadLocalRandom.current().nextDouble(1800, 2200);
    }

    static void analisarCandidato(double salarioPretendido) {
        double salarioBase = 2000.0;
        if (salarioBase > salarioPretendido) {
            System.out.println("LIGAR PARA O CANDIDATO");
        } else if (salarioBase == salarioPretendido) {
            System.out.println("LIGAR PARA O CANDIDATO COM CONTRA PROPOSTA");
        } else {
            System.out.println("AGUARDANDO RESULTADO DOS DEMAIS CANDIDATOS");
        }
    }

}
