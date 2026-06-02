import java.util.ArrayList;
import java.util.Scanner;





public class App {
    
    public static void main(String[]args){
        Scanner sc = new Scanner(System.in); //criar o scanner que vai ajudar a pedir ao utilizador todos os valores

        ArrayList<Carteira> carteiras= new ArrayList<>();  //criar a lista que vai guardar as carteiras
        ArrayList<CriptoMoeda> criptomoedas = new ArrayList<>(); //criar a lista que vai guardar as criptomoedas

        CriptoMoeda bit = new CriptoMoeda("Bitcoin", "BTC", 75000.0);  //cria a criptomoeda Bitcoin
        criptomoedas.add(bit);        //adiciona a criptomoeda Bitcoin à ArrayList


        CriptoMoeda eth = new CriptoMoeda("Ethereum", "ETH", 2000.0); //cria criptomoeda Ethereum
        criptomoedas.add(eth);        //adiciona a criptomoeda Ethereum à ArrayList


        CriptoMoeda sol = new CriptoMoeda("Solana", "SOL",68.70);   //cria a criptomoeda Solana
        criptomoedas.add(sol);       //adiciona a criptomoeda Solana à ArrayList

        while (true){
            //Dar print ao menu
            System.out.println("=== SqueBank ===");

            System.out.println("1. Criar Carteira");
            System.out.println("2. Listar Carteiras");
            System.out.println("3. Depositar");
            System.out.println("4. Levantar");
            System.out.println("5. Comprar CriptoMoeda");
            System.out.println("6. Ver Criptomoedas ");

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

            }else if(opcao ==5){        //opção de comprar criptomoedas
                for(int i = 0; i < carteiras.size(); i++){
                    System.out.println(i+ " - "+carteiras.get(i).getNome());            //lista as carteiras existentes
                }
                

                System.out.print("Escolha a carteira : ");
                int numCarteira = sc.nextInt();             //pede ao utilizador e guarda o número da carteira que escolheu
                sc.nextLine();

                Carteira escolhida = carteiras.get(numCarteira);            //Vai buscar o número da carteira escolhida

                for(CriptoMoeda criptomoeda : criptomoedas){
                    System.out.println(criptomoedas.indexOf(criptomoeda)+" - "+criptomoeda.getCripto()+" ("+criptomoeda.getSimbolo()+") -> "+criptomoeda.getPreco()+" €");  //lista as criptomoedas existentes e seus atributos
                }

                System.out.print("Escolha a criptomoeda : ");
                int escolhacripto = sc.nextInt();                   //pede ao utilizador e guarda o número da criptomoeda que escolheu
                sc.nextLine();



                CriptoMoeda moedaEscolhida = criptomoedas.get(escolhacripto);               //Vai buscar a criptomoeda escolhida pelo utilizador

                System.out.print("Escolha a quantidade : ");
                Double quantidade = sc.nextDouble();                        //pede ao utilizador e guarda a quantidade da criptomoeda que o utilizador quer comprar

                Double custo = moedaEscolhida.getPreco() * quantidade;                   //vai buscar o preço da criptomoeda e multiplica pela quantidade a comprar

                if(custo > escolhida.getSaldo()){                               //Verifica se o custo que o utilizador que comprar de criptomoeda é maior que o saldo da conta
                    System.out.println("Saldo insuficiente!");                  // caso seja, imprime esta mensagem
                }else{                                                          //Caso o saldo seja suficiente faz o seguinte
                    escolhida.levantar(custo);                                  //subtrai o valor a comprar da carteira escolida                    
                    CarteiraCripto cc = new CarteiraCripto(moedaEscolhida, quantidade);
                    escolhida.comprarCripto(cc);
                    System.out.println("Compra feita com sucesso!");
                }

            }else if (opcao == 6){
                for (int i = 0 ; i < carteiras.size(); i++){
                    System.out.println(i+" - "+carteiras.get(i).getNome());
                }

                System.out.print("Escolha a carteira : ");
                int numCarteira = sc.nextInt();
                sc.nextLine();

                Carteira escolhida = carteiras.get(numCarteira);

                for(CarteiraCripto cc : escolhida.getCripto()){
                    System.out.println(cc.getMoeda().getCripto()+" --> "+cc.getMoeda().getSimbolo()+" -->"+cc.getMoeda().getPreco()+" : "+cc.getQuantidade());
                }

            }
        }
    

    }
}
