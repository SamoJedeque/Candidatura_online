import javax.swing.*;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import java.awt.event.*;
import java.awt.*;
import javax.swing.border.LineBorder;

public class ListIncritos extends JFrame implements ActionListener{

    
    private JLabel lbtitle = new JLabel("Lista de Inscritos");
    private JLabel lbid = new JLabel("ID");
    private JLabel lbnome = new JLabel("Nome");
    private JLabel lbgen = new JLabel("Genero");
    private JLabel lbBI = new JLabel("Curso");
    private JLabel lbcargo = new JLabel("Estado");
    private DefaultListModel<String> dlid = new DefaultListModel<>();
    private JList<String> lstid = new JList<>(dlid);
    private DefaultListModel<String> dlnome = new DefaultListModel<>();
    private JList<String> lstnome = new JList<>(dlnome);
    private DefaultListModel<String> dlgen = new DefaultListModel<>();
    private JList<String> lstgen = new JList<>(dlgen);
    private DefaultListModel<String> dlbi = new DefaultListModel<>();
    private JList<String> lstBI = new JList<>(dlbi);
    private DefaultListModel<String> dlcargo = new DefaultListModel<>();
    private JList<String> lstcargo = new JList<>(dlcargo);

    private JButton btnedit = new JButton("Eliminar");
    private JButton btnback = new JButton("Voltar");
    
    public ListIncritos(){
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(null);
        setSize(730, 600);
        setLocation(800,200);
        setResizable(false);
        getContentPane().setBackground(Color.decode("#191e29")) ;
        componentes();

    
        setVisible(true);

    }


    private void componentes(){

        
        lbtitle.setBounds(130, 10, 450, 50);
        lbtitle.setHorizontalAlignment(SwingConstants.CENTER);
        lbtitle.setForeground(Color.decode("#01c380"));
        lbtitle.setFont(new Font("Dialog", Font.BOLD, 40));
        this.add(lbtitle);

        lbid.setBounds(25, 120, 50, 50);
        lbid.setForeground(Color.decode("#01c380"));
        lbid.setFont(new Font("Dialog", Font.BOLD, 18));

        lbnome.setBounds(80, 120, 100, 50);
        lbnome.setForeground(Color.decode("#01c380"));
        lbnome.setFont(new Font("Dialog", Font.BOLD, 18));

        lbgen.setBounds(290, 120, 200, 50);
        lbgen.setForeground(Color.decode("#01c380"));
        lbgen.setFont(new Font("Dialog", Font.BOLD, 18));

        lbBI.setBounds(490, 120, 150, 50);
        lbBI.setForeground(Color.decode("#01c380"));
        lbBI.setFont(new Font("Dialog", Font.BOLD, 18));

        lbcargo.setBounds(600, 120, 200, 50);
        lbcargo.setForeground(Color.decode("#01c380"));
        lbcargo.setFont(new Font("Dialog", Font.BOLD, 18));

        this.add(lbid);
        this.add(lbnome);
        this.add(lbgen);
        this.add(lbBI);
        this.add(lbcargo);

        lstid.setBounds(20, 180, 50, 300);
        lstid.setBackground(Color.decode("#132d46"));
        lstid.setForeground(Color.decode("#01c380"));
        lstid.addListSelectionListener(new ListSelectionListener(){
            @Override
            public void valueChanged(ListSelectionEvent e) {
                lstnome.setSelectedIndex(lstid.getSelectedIndex());
                lstgen.setSelectedIndex(lstid.getSelectedIndex());
                lstBI.setSelectedIndex(lstid.getSelectedIndex());
                lstcargo.setSelectedIndex(lstid.getSelectedIndex());

                
            }
        });

        lstnome.setBounds(80, 180, 200, 300);
        lstnome.setBackground(Color.decode("#132d46"));
        lstnome.setForeground(Color.decode("#01c380"));
        lstnome.addListSelectionListener(new ListSelectionListener(){
            @Override
            public void valueChanged(ListSelectionEvent e) {
                lstid.setSelectedIndex(lstnome.getSelectedIndex());
                lstgen.setSelectedIndex(lstnome.getSelectedIndex());
                lstBI.setSelectedIndex(lstnome.getSelectedIndex());
                lstcargo.setSelectedIndex(lstnome.getSelectedIndex());
            }
        });

        lstgen.setBounds(290, 180, 180, 300);
        lstgen.setBackground(Color.decode("#132d46"));
        lstgen.setForeground(Color.decode("#01c380"));
        lstgen.addListSelectionListener(new ListSelectionListener(){
            @Override
            public void valueChanged(ListSelectionEvent e) {
                lstid.setSelectedIndex(lstgen.getSelectedIndex());
                lstnome.setSelectedIndex(lstgen.getSelectedIndex());
                lstBI.setSelectedIndex(lstgen.getSelectedIndex());
                lstcargo.setSelectedIndex(lstgen.getSelectedIndex());
                
            }
        });

        lstBI.setBounds(480, 180, 100, 300);
        lstBI.setBackground(Color.decode("#132d46"));
        lstBI.setForeground(Color.decode("#01c380"));
        lstBI.addListSelectionListener(new ListSelectionListener(){
            @Override
            public void valueChanged(ListSelectionEvent e) {
                lstid.setSelectedIndex(lstBI.getSelectedIndex());
                lstnome.setSelectedIndex(lstBI.getSelectedIndex());
                lstgen.setSelectedIndex(lstBI.getSelectedIndex());
                lstcargo.setSelectedIndex(lstBI.getSelectedIndex());
                
            }
        });

        lstcargo.setBounds(590, 180, 100, 300);
        lstcargo.setBackground(Color.decode("#132d46"));
        lstcargo.setForeground(Color.decode("#01c380"));
        lstcargo.addListSelectionListener(new ListSelectionListener(){
            @Override
            public void valueChanged(ListSelectionEvent e) {
                lstid.setSelectedIndex(lstcargo.getSelectedIndex());
                lstnome.setSelectedIndex(lstcargo.getSelectedIndex());
                lstgen.setSelectedIndex(lstcargo.getSelectedIndex());
                lstBI.setSelectedIndex(lstcargo.getSelectedIndex());
                
            }
        });

        this.add(lstid);
        this.add(lstnome);
        this.add(lstgen);
        this.add(lstBI);
        this.add(lstcargo);

        btnback.setBounds(590, 490, 100, 50);
        btnback.setForeground(Color.decode("#132d46"));
        btnback.setFont(new Font("Dialog", Font.BOLD, 18)); 
        btnback.setBackground(Color.decode("#01c380"));
        btnback.setBorder(new LineBorder(Color.decode("#132d46"), 1, true));
        btnback.setFocusable(false);
        btnback.setCursor(new Cursor(Cursor.HAND_CURSOR));  
        btnedit.setBounds(480, 490, 100, 50);
        btnedit.addActionListener(this);
        btnback.addActionListener(this);
        this.add(btnback);
        this.add(btnedit);

        Connetor con;

        try {
            con = new Connetor();
            con.ps= con.con.prepareStatement("SELECT * FROM candidato WHERE nivel_de_acesso = ?");
            con.ps.setString(1, "candidato");
            con.rs = con.ps.executeQuery();
            while (con.rs.next()) {
                dlid.addElement(con.rs.getString("user_id"));
                dlnome.addElement(con.rs.getString("nome"));
                dlgen.addElement(con.rs.getString("genero"));
                con.ps = con.con.prepareStatement("SELECT * FROM inscricao WHERE cand_id = ?");
                con.ps.setInt(1, con.rs.getInt("user_id"));
                con.rs2 = con.ps.executeQuery();
                while (con.rs2.next()) {
                    dlbi.addElement(con.rs2.getString("curso"));
                    dlcargo.addElement(con.rs2.getString("status"));
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        
    }

    @Override

    

    public void actionPerformed(ActionEvent ae) {
        if (ae.getSource() == btnback) {
            dispose();
            new Menu();
        }else if (ae.getSource() == btnedit) {

            int resposta = JOptionPane.showConfirmDialog(null, "Deseja remover o inscrito?");
            if (resposta == JOptionPane.YES_OPTION) {

                String nome = lstnome.getSelectedValue();
                
                if (nome == null) {
                    JOptionPane.showMessageDialog(null, "Erro ao remover inscrito");
                    
                    return;
                    
                }else{ 
                    
                    JOptionPane.showMessageDialog(null, "Inscrito removido com sucesso");
                    Connetor con = new Connetor();
                    con.delete(Integer.parseInt(lstid.getSelectedValue()));
                    con.deleteInscricao(Integer.parseInt(lstid.getSelectedValue()));
                    dlid.remove(lstid.getSelectedIndex());
                    dlcargo.remove(lstcargo.getSelectedIndex());
                    dlbi.remove(lstBI.getSelectedIndex());
                    dlgen.remove(lstgen.getSelectedIndex());
                    dlnome.remove(lstnome.getSelectedIndex());
                    
                }
            }
        }
    }

}
