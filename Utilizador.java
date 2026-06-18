import java.util.ArrayList;

public class Utilizador {
    private String email;
    private String nomeUtilizador;
    private String password;
    private ArrayList<Carteira> carteiras = new ArrayList<>();

    public Utilizador(String email, String nomeUtilizador, String password){
        this.email = email;
        this.nomeUtilizador = nomeUtilizador;
        this.password = password;
    }

    public String getEmail(){
        return email;
    }
    
    public void setEmail(String email){
        this.email = email;
    }

    
    public String getUtilizador(){
        return nomeUtilizador;
    }

    public void setUtilizador(String nomeUtilizador){
        this.nomeUtilizador = nomeUtilizador;
    }

    
    public String getPassword(){
        return password;
    }

    public void setPassword(String password){
        this.password = password;
    }


    public ArrayList<Carteira> getCarteiras(){
        return carteiras;
    }
}
