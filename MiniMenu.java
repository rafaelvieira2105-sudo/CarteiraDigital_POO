import javax.swing.*;
import java.util.ArrayList;

public class MiniMenu extends JFrame {
    JButton login = new JButton("Login");
    JButton registar = new JButton("Registar");
    JLabel titulo = new JLabel("Bem vindo ao SQUEBANK");

    ArrayList<Utilizador> utilizadores;
    ArrayList<Carteira> carteiras;
    ArrayList< CriptoMoeda> criptomoedas;


    public MiniMenu(ArrayList<Utilizador> utilizadores, ArrayList<Carteira> carteiras, ArrayList<CriptoMoeda> criptomoedas){

        this.utilizadores = utilizadores;
        this.carteiras = carteiras;
        this.criptomoedas = criptomoedas;


        setTitle("SQUE BANK");
        setSize(250,200);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(null);
      

        titulo.setBounds(10,10,220,20);
        registar.setBounds(10,40,100, 20);
        login.setBounds(10,70,100,20);

        add(login);
        add(registar);
        add(titulo);

        registar.addActionListener(e -> {
            Registo r = new Registo(utilizadores, carteiras, criptomoedas);
            r.setVisible(true);
            this.dispose();
        });


        login.addActionListener(e ->{
            Login l = new Login(utilizadores, carteiras, criptomoedas);
            l.setVisible(true);
            this.dispose();
        });
        
    }
}
