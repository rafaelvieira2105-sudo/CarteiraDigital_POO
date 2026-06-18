import java.util.ArrayList;






public class App {
    
    public static void main(String[]args){

        ArrayList<Carteira> carteiras= new ArrayList<>();  //criar a lista que vai guardar as carteiras
        ArrayList<CriptoMoeda> criptomoedas = new ArrayList<>(); //criar a lista que vai guardar as criptomoedas
        ArrayList<Utilizador> utilizadores = new ArrayList<>(); //cria a lista que vai guardar os utilizadores

        CriptoMoeda bit = new CriptoMoeda("Bitcoin", "BTC", 75000.0);  //cria a criptomoeda Bitcoin
        criptomoedas.add(bit);        //adiciona a criptomoeda Bitcoin à ArrayList


        CriptoMoeda eth = new CriptoMoeda("Ethereum", "ETH", 2000.0); //cria criptomoeda Ethereum
        criptomoedas.add(eth);        //adiciona a criptomoeda Ethereum à ArrayList


        CriptoMoeda sol = new CriptoMoeda("Solana", "SOL",68.70);   //cria a criptomoeda Solana
        criptomoedas.add(sol);       //adiciona a criptomoeda Solana à ArrayList

        MiniMenu mm = new MiniMenu(utilizadores, carteiras, criptomoedas);
        mm.setVisible(true);

        

    

    }
}
