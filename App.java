import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;







public class App {
    
    public static void main(String[]args){

        ArrayList<Carteira> carteiras= new ArrayList<>();  //criar a lista que vai guardar as carteiras
        ArrayList<CriptoMoeda> criptomoedas = new ArrayList<>(); //criar a lista que vai guardar as criptomoedas
        ArrayList<Utilizador> utilizadores = App.carregar(); //cria a lista que vai guardar os utilizadores

        CriptoMoeda bit = new CriptoMoeda("Bitcoin", "BTC", 75000.0);  //cria a criptomoeda Bitcoin
        criptomoedas.add(bit);        //adiciona a criptomoeda Bitcoin à ArrayList


        CriptoMoeda eth = new CriptoMoeda("Ethereum", "ETH", 2000.0); //cria criptomoeda Ethereum
        criptomoedas.add(eth);        //adiciona a criptomoeda Ethereum à ArrayList


        CriptoMoeda sol = new CriptoMoeda("Solana", "SOL",68.70);   //cria a criptomoeda Solana
        criptomoedas.add(sol);       //adiciona a criptomoeda Solana à ArrayList

        MiniMenu mm = new MiniMenu(utilizadores, carteiras, criptomoedas);
        mm.setVisible(true);

        

    

    }

    //guarda os utilizadores registados
    public static void guardar(ArrayList<Utilizador> utilizadores){
        try {
            ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream("dados.bin"));
            out.writeObject(utilizadores);
            out.close();
        } catch(Exception e){
            e.printStackTrace();
        }
    
    }
    
    //vai buscar os utilizadores guardados quando o programa arranca
    public static ArrayList<Utilizador> carregar(){
        try {
            ObjectInputStream in = new ObjectInputStream(new FileInputStream("dados.bin"));
            ArrayList<Utilizador> utilizadores = (ArrayList<Utilizador>) in.readObject();
            in.close();
            return utilizadores;
        } catch(Exception e){
            return new ArrayList<>();
        }
    }
}
