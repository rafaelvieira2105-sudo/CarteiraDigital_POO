import javax.swing.*;
import java.util.ArrayList;

public class Login extends JFrame{
    ArrayList<Utilizador> utilizadores;
    ArrayList<Carteira> carteiras;
    ArrayList<CriptoMoeda> criptomoedas;

    JLabel util = new JLabel("Utilizador/email : ");
    JTextField utilizador = new JTextField();
    JLabel password = new JLabel("Password : ");
    JTextField pass = new JTextField();
    JButton login = new JButton("Login");
    JButton voltar = new JButton("Voltar");

    public Login(ArrayList<Utilizador> utilizadores, ArrayList<Carteira> carteiras, ArrayList<CriptoMoeda> criptomoedas){

        this.utilizadores = utilizadores;
        this.carteiras = carteiras;
        this.criptomoedas = criptomoedas;

        setTitle("SQUE BANK");
        setLayout(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(300,250);

        util.setBounds(10, 50, 120, 25);
        utilizador.setBounds(140, 50, 130, 25);
        password.setBounds(10, 90, 120, 25);
        pass.setBounds(140, 90, 130, 25);
        login.setBounds(50, 140, 90, 30);
        voltar.setBounds(160, 140, 80, 30);

        add(util);
        add(utilizador);
        add(password);
        add(pass);
        add(login);
        add(voltar);

        voltar.addActionListener( e->{
            MiniMenu mm = new MiniMenu(utilizadores, carteiras, criptomoedas);
            mm.setVisible(true);
            this.dispose();
        });

        login.addActionListener(e->{
            String utilizadorTxt = utilizador.getText();
            String passwordTxt = pass.getText();

            boolean encontrou = false;

            for(Utilizador u : utilizadores){
                if(u.getEmail().equals(utilizadorTxt) || u.getUtilizador().equals(utilizadorTxt)){
                    if(u.getPassword().equals(passwordTxt)){
                        encontrou = true;
                        MenuPrincipal menu = new MenuPrincipal(u.getCarteiras(), criptomoedas);
                        this.dispose();
                        break;
                    }
                }
            }

            if(!encontrou){
                JOptionPane.showMessageDialog(this, "Email/Utilizador ou password incorretos!");
            }
        });
    }
}
