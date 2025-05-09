import javax.swing.*;
import javax.swing.border.LineBorder;
import java.awt.*;
import java.awt.event.*;

public class Loginform extends JFrame implements ActionListener{

    private JLabel framelb = new JLabel("Login");
    private JLabel usulb = new JLabel("Usuario:");
    private JLabel passlb = new JLabel("Senha:");
    private JLabel signlb = new JLabel("Criar nova conta");
    private JTextField usutxt = new JTextField();
    private JPasswordField passtxt = new JPasswordField();
    private JButton loginBtn = new JButton("Login");
    private int chave;


    public int getChave(){
        return chave;
    }

    public Loginform(String user){
        System.out.println(user);
    }

    public Loginform(int chave){
        this.chave = chave;
        
    }

    public Loginform(){
        addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent e) {
                int resposta = JOptionPane.showConfirmDialog(null, "Deseja realmente sair?", "Sair", JOptionPane.YES_NO_OPTION);
                if (resposta == JOptionPane.YES_OPTION) {
                    
                    try {
                        Session.clearSession(Session.getId());
                        System.exit(0);
                    } catch (Exception e1) {
                        // TODO Auto-generated catch block
                        e1.printStackTrace();
                    }
                }
            }
        });

        setLayout(null);
        setSize(530,600);
        setLocation(800,200);
        setResizable(false);
        getContentPane().setBackground(Color.decode("#191e29")) ;
        componentes();

        setVisible(true);
    }

    private void componentes(){
        framelb.setBounds(0, 25, 520, 100);
        framelb.setForeground(Color.decode("#01c380"));
        framelb.setFont(new Font("Dialog", Font.BOLD, 40));
        framelb.setHorizontalAlignment(SwingConstants.CENTER);

        usulb.setBounds(30, 150, 450,55);
        usulb.setForeground(Color.decode("#01c380"));
        usulb.setFont(new Font("Dialog", Font.PLAIN, 18));

        usutxt.setBounds(30, 195, 450, 55);
        usutxt.setBackground(Color.decode("#132d46"));
        usutxt.setForeground(Color.decode("#01c380"));
        usutxt.setFont(new Font("Dialog", Font.PLAIN, 28));
        usutxt.setBorder(new LineBorder(Color.decode("#01c380"), 1, true));

        passlb.setBounds(30, 275, 450,55);
        passlb.setForeground(Color.decode("#01c380"));
        passlb.setFont(new Font("Dialog", Font.PLAIN, 18));

        passtxt.setBounds(30,315, 450,55);
        passtxt.setBackground(Color.decode("#132d46"));
        passtxt.setForeground(Color.decode("#01c380"));
        passtxt.setFont(new Font("Dialog", Font.PLAIN, 28));
        passtxt.setBorder(new LineBorder(Color.decode("#01c380"), 1, true));

        loginBtn.setBounds(30, 420, 450,55);
        loginBtn.setForeground(Color.decode("#132d46"));
        loginBtn.setFont(new Font("Dialog", Font.BOLD, 18));
        loginBtn.setBackground(Color.decode("#01c380"));
        loginBtn.setBorder(new LineBorder(Color.decode("#132d46"), 1, true));
        loginBtn.setCursor(new Cursor(Cursor.HAND_CURSOR));
        loginBtn.addActionListener(this);

        signlb.setBounds(30, 500, 450,55);
        signlb.setForeground(Color.decode("#01c380"));
        signlb.setFont(new Font("Dialog", Font.BOLD, 18));
        signlb.setHorizontalAlignment(SwingConstants.CENTER);
        signlb.setCursor(new Cursor(Cursor.HAND_CURSOR));
        signlb.addMouseListener(new MouseAdapter(){
            public void mouseClicked(MouseEvent e){
                new Signform();
                dispose();
            }
        });

        this.add(framelb);
        this.add(usulb);
        this.add(usutxt);
        this.add(passlb);
        this.add(passtxt);
        this.add(loginBtn);
        this.add(signlb);
    }

    @Override
    public void actionPerformed(ActionEvent ae){
        
        if (ae.getSource() == loginBtn) {

            if (usutxt.getText().equals("") || String.valueOf(passtxt.getPassword()).equals("")) {
                JOptionPane.showMessageDialog(this, "Preencha todos os campos");
                     
            }else{
                String user = usutxt.getText();
                String pass = String.valueOf(passtxt.getPassword());
                Connetor con = new Connetor();
                if (con.search(user, pass) == null) {
                    JOptionPane.showMessageDialog(this, "Usuario ou senha invalidos");
                
                    
                }else if (con.search(user, pass).equals("admin")) {
                    new Menu();
                    dispose();
                }else if (con.search(user, pass).equals("candidato")) {
                    new Principal();
                    Session.creatSession(con.getId(), user);
                    dispose();
                }

            }
            
        }else if (ae.getSource() == signlb) {
            new Signform();
            dispose();

        }
    }
}       