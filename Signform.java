import javax.swing.*;
import javax.swing.border.LineBorder;
import java.awt.event.*;
import java.util.Random;
import java.awt.*;

public class Signform extends JFrame implements ActionListener {

    private JLabel framelb = new JLabel("Criar conta");
    private JLabel nomelb = new JLabel("Nome:");
    private JLabel apelidolb = new JLabel("Apelido:");
    private JLabel genderlb = new JLabel("Genero:");
    private JLabel nuitlb = new JLabel("NUIT:");
    private JLabel idadelb = new JLabel("Idade:");
    
    private String[] cidades = {"Nasceu...","Maputo", "Beira", "Nampula", "Quelimane", "Tete"};
    private JComboBox<String> cbCidade = new JComboBox<>(cidades);

    private String[] seccao = {"Seccao","Letras com Frances", "Letras com Geografia", "Ciencia com Desenho", "Ciencia com Biologia"};
    private JComboBox<String> cbSeccao = new JComboBox<>(seccao);

    private String[] escolas = {"Ensino medio","Escola Secundária Josina Machel", "Escola Secundária Francisco Manyanga", "Escola Secundária da Matola", "Escola Secundária da Lhangene"};
    private JComboBox<String> cbEscola = new JComboBox<>(escolas);

    private JLabel bairrrolb = new JLabel("Bairro:");
    private JLabel voltarlb = new JLabel("voltar");
    private JTextField nometxt = new JTextField();
    private JTextField apelidotxt = new JTextField();
    private JTextField nuitxt = new JTextField();
    private JTextField idadetxt = new JTextField();
    private JTextField bairrotxt = new JTextField();
    private JRadioButton femRadioButton = new JRadioButton("Feminino");
    private JRadioButton mascRadioButton = new JRadioButton("Masculino");
    private ButtonGroup group = new ButtonGroup();
    private JButton graButton = new JButton("Guardar");
    


    public Signform(){
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(null);
        setSize(500,1000);
        setLocation(800,10);
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

        nomelb.setBounds(30, 150, 220,55);
        nomelb.setForeground(Color.decode("#01c380"));
        nomelb.setFont(new Font("Dialog", Font.PLAIN, 18));

        nometxt.setBounds(30, 195, 200, 55);
        nometxt.setBackground(Color.decode("#132d46"));
        nometxt.setForeground(Color.decode("#01c380"));
        nometxt.setFont(new Font("Dialog", Font.PLAIN, 28));
        nometxt.setBorder(new LineBorder(Color.decode("#01c380"), 1, true));

        apelidolb.setBounds(250, 150, 200,55);
        apelidolb.setForeground(Color.decode("#01c380"));
        apelidolb.setFont(new Font("Dialog", Font.PLAIN, 18));

        apelidotxt.setBounds(250,195, 220,55);
        apelidotxt.setBackground(Color.decode("#132d46"));
        apelidotxt.setForeground(Color.decode("#01c380"));
        apelidotxt.setFont(new Font("Dialog", Font.PLAIN, 28));
        apelidotxt.setBorder(new LineBorder(Color.decode("#01c380"), 1, true));

        idadelb.setBounds(30, 260, 220,55);
        idadelb.setForeground(Color.decode("#01c380"));
        idadelb.setFont(new Font("Dialog", Font.PLAIN, 18));

        idadetxt.setBounds(30, 305, 200, 55);
        idadetxt.setBackground(Color.decode("#132d46"));
        idadetxt.setForeground(Color.decode("#01c380"));
        idadetxt.setFont(new Font("Dialog", Font.PLAIN, 28));
        idadetxt.setBorder(new LineBorder(Color.decode("#01c380"), 1, true));

        bairrrolb.setBounds(250, 260, 200,55);
        bairrrolb.setForeground(Color.decode("#01c380"));
        bairrrolb.setFont(new Font("Dialog", Font.PLAIN, 18));

        bairrotxt.setBounds(250,305, 220,55);
        bairrotxt.setBackground(Color.decode("#132d46"));
        bairrotxt.setForeground(Color.decode("#01c380"));
        bairrotxt.setFont(new Font("Dialog", Font.PLAIN, 28));
        bairrotxt.setBorder(new LineBorder(Color.decode("#01c380"), 1, true));

        cbEscola.setBounds(30, 370, 450, 55);
        cbEscola.setBackground(Color.decode("#132d46"));
        cbEscola.setForeground(Color.decode("#01c380"));
        cbEscola.setFont(new Font("Dialog", Font.PLAIN, 28));
        cbEscola.setBorder(new LineBorder(Color.decode("#01c380"), 1, true));
        cbEscola.setFocusable(false); 
        
        cbSeccao.setBounds(30, 430, 450, 55);
        cbSeccao.setBackground(Color.decode("#132d46"));    
        cbSeccao.setForeground(Color.decode("#01c380"));
        cbSeccao.setFont(new Font("Dialog", Font.PLAIN, 28));
        cbSeccao.setBorder(new LineBorder(Color.decode("#01c380"), 1, true));
        cbSeccao.setFocusable(false);

        cbCidade.setBounds(30, 490, 450, 55);
        cbCidade.setBackground(Color.decode("#132d46"));
        cbCidade.setForeground(Color.decode("#01c380"));
        cbCidade.setFont(new Font("Dialog", Font.PLAIN, 28));
        cbCidade.setBorder(new LineBorder(Color.decode("#01c380"), 1, true));
        cbCidade.setFocusable(false);
        

        genderlb.setBounds(30, 555, 450,55);
        genderlb.setForeground(Color.decode("#01c380"));
        genderlb.setFont(new Font("Dialog", Font.PLAIN, 18));

        femRadioButton.setBounds(30, 600, 210, 55);
        femRadioButton.setBackground(Color.decode("#132d46"));
        femRadioButton.setForeground(Color.decode("#01c380"));
        femRadioButton.setFont(new Font("Dialog", Font.PLAIN, 28));

        mascRadioButton.setBounds(250, 600, 210, 55);
        mascRadioButton.setBackground(Color.decode("#132d46"));
        mascRadioButton.setForeground(Color.decode("#01c380"));
        mascRadioButton.setFont(new Font("Dialog", Font.PLAIN, 28));
        group.add(femRadioButton);
        group.add(mascRadioButton);

        nuitlb.setBounds(30, 680, 450,55);
        nuitlb.setForeground(Color.decode("#01c380"));
        nuitlb.setFont(new Font("Dialog", Font.PLAIN, 18));

        nuitxt.setBounds(30, 725, 450, 55);
        nuitxt.setBackground(Color.decode("#132d46"));
        nuitxt.setForeground(Color.decode("#01c380"));
        nuitxt.setFont(new Font("Dialog", Font.PLAIN, 28));
        nuitxt.setBorder(new LineBorder(Color.decode("#01c380"), 1, true));

        graButton.setBounds(30, 800, 450,55);
        graButton.setForeground(Color.decode("#132d46"));
        graButton.setFont(new Font("Dialog", Font.BOLD, 18));
        graButton.setBackground(Color.decode("#01c380"));
        graButton.setBorder(new LineBorder(Color.decode("#132d46"), 1, true));
        graButton.addActionListener(this);

        voltarlb.setBounds(30, 870, 450,55);
        voltarlb.setForeground(Color.decode("#01c380"));
        voltarlb.setFont(new Font("Dialog", Font.BOLD, 18));
        voltarlb.setHorizontalAlignment(SwingConstants.CENTER);
        voltarlb.addMouseListener(new MouseAdapter(){
            public void mouseClicked(MouseEvent e){
                new Loginform();
                dispose();
            }
        });

        this.add(framelb);
        this.add(nomelb);
        this.add(nometxt);
        this.add(apelidolb);
        this.add(apelidotxt);
        this.add(idadelb);
        this.add(idadetxt);
        this.add(bairrrolb);
        this.add(bairrotxt);
        this.add(genderlb);
        this.add(femRadioButton);
        this.add(mascRadioButton);
        this.add(cbEscola);
        this.add(cbSeccao);
        this.add(cbCidade);
        this.add(nuitlb);
        this.add(nuitxt);
        this.add(voltarlb);
        this.add(graButton);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        
        String nome;
        String genero;
        String apelido;
        String bairro;
        String cidade;
        String escola;
        String seccao;
        int idade;
        String nuit;
        String username;
        String userPass;
        if(e.getSource() == graButton){

            if (nometxt.getText().equals("") || apelidotxt.getText().equals("") || nuitxt.getText().equals("") || 
            idadetxt.getText().equals("") || bairrotxt.getText().equals("") || group.getSelection() == null) {

                JOptionPane.showMessageDialog(null, "Preencha todos os campos", "Erro", JOptionPane.ERROR_MESSAGE);
                
            }else{
                
                nome = nometxt.getText();
                apelido = apelidotxt.getText();
                idade = Integer.parseInt(idadetxt.getText());
                bairro = bairrotxt.getText();
                cidade = (String) cbCidade.getSelectedItem();
                escola = (String) cbEscola.getSelectedItem();
                seccao = (String) cbSeccao.getSelectedItem();
                nuit = nuitxt.getText();
                if(femRadioButton.isSelected()){
                    genero = "Feminino";
                }else{  
                    genero = "Masculino";
                }


                username = apelido + "_" + idade + "_" + new Random().nextInt(1000);
                userPass = apelido + "_"  + new Random().nextInt(1000);

                Connetor con = new Connetor();
                con.insert(nome, apelido, idade, genero, bairro, cidade, escola, seccao, nuit, username, userPass);
                JOptionPane.showMessageDialog(null, "Conta criada com sucesso! \n Username: " + username + "\n Password: " + userPass, "Sucesso", JOptionPane.INFORMATION_MESSAGE);
               
                
                new Loginform();
                dispose();
            }
        }
    }

  
    
}
