import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.*;

public class Menu extends JFrame implements ActionListener{
    
    private JMenuBar menuBar = new JMenuBar();
    private JMenu menu1 = new JMenu("Inscritos");
    private JMenu menu2 = new JMenu("Salas");

    private JMenuItem item1 = new JMenuItem("Lista de Inscritos");
    private JMenuItem item2 = new JMenuItem("criar Salas");
    private JMenuItem item4 = new JMenuItem("Lista de Salas");
    private JMenuItem item3 = new JMenuItem("Sair");

    public Menu(){
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(null);
        setSize(400,300);
        setLocation(800,200);
        setResizable(false);
        getContentPane().setBackground(Color.decode("#191e29")) ;
        componentes();
        checkSession();


        setVisible(true);
    }

    //metodo para adicionar os componentes ao JFrame
    private void componentes(){
        setJMenuBar(menuBar);
        menuBar.setBackground(Color.decode("#191e29"));
        menuBar.add(menu1);
        menuBar.add(menu2);

        menu1.setForeground(Color.decode("#01c380"));
        menu2.setForeground(Color.decode("#01c380"));

        item1.setForeground(Color.decode("#01c380"));
        item2.setForeground(Color.decode("#01c380"));
        item3.setForeground(Color.decode("#01c380"));
        item4.setForeground(Color.decode("#01c380"));

        menu1.setBackground(Color.decode("#191e29"));   
        menu2.setBackground(Color.decode("#191e29"));

        item1.setBackground(Color.decode("#191e29"));
        item2.setBackground(Color.decode("#191e29"));
        item3.setBackground(Color.decode("#191e29"));
        item4.setBackground(Color.decode("#191e29"));
        
        item1.addActionListener(this);
        item2.addActionListener(this);
        item3.addActionListener(this);
        item4.addActionListener(this);

        menu1.setFont(new Font("Arial", Font.PLAIN, 20)); 
        menu2.setFont(new Font("Arial", Font.PLAIN, 20));
        
        item1.setFont(new Font("Arial", Font.PLAIN, 20));
        item2.setFont(new Font("Arial", Font.PLAIN, 20));
        item3.setFont(new Font("Arial", Font.PLAIN, 20));
        item4.setFont(new Font("Arial", Font.PLAIN, 20));

        
        menu1.add(item1);
        menu1.add(item3);
        
        menu2.add(item2);
        menu2.add(item4);
    }

    //metodo para thread de para verificar se o usuario 

    private void checkSession(){
        
        int id = Session.getId();
        if (id == 0) {
            System.out.println("Usuario nao logado!");
            return;
        }else if (id > 0) {
            System.out.println("Usuario logado!");
        }
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == item1) {
            this.dispose();
           new ListIncritos();
        } else if (e.getSource() == item2) {
            this.dispose();
            new CriarSalas();
        }else if(e.getSource() == item3){
            this.dispose();
            new Loginform();
        }else if(e.getSource() == item4){
            this.dispose();
            new ListaSala();
        }
    }
    public static void main(String[] args) {
        new Menu();
    }
}
