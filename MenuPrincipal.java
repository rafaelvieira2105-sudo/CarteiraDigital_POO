import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class MenuPrincipal extends JFrame{
    JLabel menu = new JLabel("===SQUE BANK===");
    JButton btnCriarCarteira = new JButton("Criar Carteira");
    JButton btnVerCarteiras = new JButton("Ver carteiras");
    JButton btnDepositar = new JButton("Depositar");
    JButton btnLevantar = new JButton("Levantar");
    JButton btnComprarCripto = new JButton("Comprar Cripto");
    JButton btnVerCripto = new JButton("Ver cripto");
    JButton btnVenderCripto = new JButton("Vender Cripto");
    JButton btnTransferir = new JButton("Transferir");
    JButton btnSair = new JButton("Sair");
    ArrayList<Carteira> carteiras;
    ArrayList<CriptoMoeda> criptomoedas;
    
    public MenuPrincipal(ArrayList<Carteira> carteiras, ArrayList<CriptoMoeda> criptomoedas){

        this.carteiras = carteiras;
        this.criptomoedas = criptomoedas;

        setTitle("SQUE BANK");
        setSize(300,550);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(null);


        menu.setBounds(10,20,280,30);
        btnCriarCarteira.setBounds(50,70,200,35);
        btnVerCarteiras.setBounds(50,120,200,35);
        btnDepositar.setBounds(50,170,200,35);
        btnLevantar.setBounds(50,220,200,35);
        btnComprarCripto.setBounds(50,270,200,35);
        btnVerCripto.setBounds(50,320,200,35);
        btnVenderCripto.setBounds(50,370,200,35);
        btnTransferir.setBounds(50,420,200,35);
        btnSair.setBounds(50,470,200,35);

        menu.setFont(new Font("Arial", Font.BOLD, 24));
        menu.setHorizontalAlignment(JLabel.CENTER);


        add(menu);
        add(btnCriarCarteira);
        add(btnVerCarteiras);
        add(btnDepositar);
        add(btnLevantar);
        add(btnComprarCripto);
        add(btnVerCripto);
        add(btnVenderCripto);
        add(btnTransferir);
        add(btnSair);

        btnSair.addActionListener(e ->{
            System.exit(0);
        });
        


    }
}
