import java.util.ArrayList;
import java.util.Scanner;





public class App {
    
    public static void main(String[]args){
        Scanner sc = new Scanner(System.in); //criar o scanner que vai ajudar a pedir ao utilizador todos os valores

        ArrayList<Carteira> carteiras= new ArrayList<>();  //criar a lista que vai guardar as carteiras
        ArrayList<Criptomoeda> criptomoedas = new ArrayList<>(); //criar a lista que vai guardar as criptomoedas

        Criptomoeda bit = new Criptomoeda("Bitcoin", "BTC", 75000);  //cria a criptomoeda Bitcoin
        criptomoedas.add(bit);        //adiciona a criptomoeda Bitcoin à ArrayList


        Criptomoeda eth = new Criptomoeda("Ethereum", "ETH", 2000); //cria criptomoeda Ethereum
        criptomoedas.add(eth);        //adiciona a criptomoeda Ethereum à ArrayList


        Criptomoeda sol = new Criptomoeda("Solana", "SOL",68.70);   //cria a criptomoeda Solana
        criptomeodas.add(sol);       //Adiciona a criptomoeda Solana à ArrayList

        while (true){
            //Dar print ao menu
            System.out.println("=== SqueBank ===");

            System.out.println("1. Criar Carteira");
            System.out.println("2. Listar Carteiras");
            System.out.println("3. Depositar");
            System.out.println("4. Levantar");
            System.out.println("5. Sair");

            System.out.print("Escolha uma opção : ");
            int opcao = sc.nextInt();                   //Criar a variavel opcao que vai levar o utilizador ao resto das operações
            sc.nextLine();

            //ciclo if que vai rodar as operações escolhidas pelo utilizador
            if(opcao == 1){                     //opção 1 o utilizador cria a carteira
                System.out.print("Digite o seu nome : ");
                String dono = sc.nextLine(); 
                
                System.out.print("Digite o nome da Carteira : ");
                String nome = sc.nextLine();
                
                Carteira c1 = new Carteira(dono,nome,0.0);     //adiciona a carteira criada pelo utilizador à lista (ArrayList)
                carteiras.add(c1);


                System.out.println("Carteira criada com sucesso!");

            }else if(opcao == 2){    //esta opção lista as carteiras criadas pelo utilizador
                for(Carteira carteira : carteiras){
                    System.out.println(carteira.getDono()+" --> "+carteira.getNome()+" - Saldo : "+ carteira.getSaldo()+"€");
                }   
            }else if (opcao == 3){  //esta opção faz o depósito do valor que o utilizador inserir

                for(int i = 0; i < carteiras.size(); i++){    
                    
                    System.out.println(i + " - "+ carteiras.get(i).getNome()); //Lista as carteiras 
                }
                
                System.out.print("Escolha a carteira : ");
                int numeroEscolhido = sc.nextInt();             //guarda o numero da carteira escolhido pelo utilizador
                sc.nextLine();

                Carteira escolhida = carteiras.get(numeroEscolhido);      //vai buscar a carteira escolhida pelo utilizador à Lista  

                System.out.print("Valor a depositar : ");
                Double valor = sc.nextDouble();                 //lê o valor a depositar

                escolhida.depositar(valor);                     //aplicar o método 'depositar' do ficheiro 'Carteira.java'

                System.out.println("Depósito efetuado com sucesso!");  


            }else if(opcao == 4){     // esta opção faz o levantamento do valo que o utilizador inserir
                
                for(int i = 0; i < carteiras.size(); i++){
                    System.out.println(i + " - "+ carteiras.get(i).getNome());    //Lista as carteiras
                } 

                System.out.print("Escolha a carteira : ");
                int numeroEscolhido = sc.nextInt();                //guarda o número da carteira escolhida pelo utilizador
                sc.nextLine();

                Carteira escolhida = carteiras.get(numeroEscolhido);     //vai buscar a carteira à Lista

                System.out.print("Valor a levantar : ");
                Double valor = sc.nextDouble();                    //lê o valor a depositar
                
                if(escolhida.levantar(valor)){                                           //este if liga puxa o resultado o ciclo if do método boolean levantar 
                    System.out.println("Levantamento feito com sucesso!");
                } else {
                    System.out.println("Saldo insuficiente!");
                }

            }else{
                break;   //este é a opção 'sair' que acaba com o programa
            }
        }
    

    }
}
