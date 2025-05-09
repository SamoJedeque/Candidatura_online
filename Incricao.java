import javax.swing.*;
import javax.swing.border.LineBorder;
import java.awt.event.*;
import java.awt.*;

public class Incricao  extends JFrame implements ActionListener{

    // private JMenuBar menuBar = new JMenuBar();
    private JButton menu1 = new JButton("Voltar");

    private JLabel framelb = new JLabel("Nova inscricao");
    private JButton btnEnviar = new JButton("Enviar");

    

    private String[] cursos = {"Curso","Engenharia Informática","Engenharia Civil", "Engenharia Electrónica", "Medicina", "Direito", "Economia", "Arquitetura"};
    private JComboBox<String> cbCurso = new JComboBox<>(cursos);


     public Incricao(){
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(null);
        setSize(500,300);
        setLocation(800,100);
        setResizable(false);
        getContentPane().setBackground(Color.decode("#191e29")) ;
        componentes();
        setVisible(true);
    }   

    private void componentes(){
        
        menu1.setBounds(0,0,70, 30);
        menu1.setForeground(Color.decode("#01c380"));
        menu1.setFont(new Font("Arial", Font.PLAIN, 12)); 
        menu1.addActionListener(this);

        framelb.setBounds(0, 25, 520, 100);
        framelb.setForeground(Color.decode("#01c380"));
        framelb.setFont(new Font("Dialog", Font.BOLD, 40));
        framelb.setHorizontalAlignment(SwingConstants.CENTER);

        framelb.setBackground(Color.decode("#191e29"));
        framelb.setOpaque(true);

        cbCurso.setBounds(30, 130, 450,55); 
        cbCurso.setBackground(Color.decode("#132d46"));
        cbCurso.setForeground(Color.decode("#01c380"));
        cbCurso.setFont(new Font("Dialog", Font.PLAIN, 28));

        btnEnviar.setBounds(30, 195, 450,55);
        btnEnviar.setForeground(Color.decode("#132d46"));
        btnEnviar.setFont(new Font("Dialog", Font.BOLD, 18));
        btnEnviar.setBackground(Color.decode("#01c380"));
        btnEnviar.setBorder(new LineBorder(Color.decode("#132d46"), 1, true));
        btnEnviar.addActionListener(this);

        this.add(menu1);
        this.add(framelb);
        this.add(cbCurso);
        this.add(btnEnviar);
    }

    public void actionPerformed(ActionEvent ae){
        String curso = (String) cbCurso.getSelectedItem();

        if (ae.getSource() == btnEnviar) {

            if ( curso.equals("curso") || curso.equals("")) {
                JOptionPane.showMessageDialog(null, "Preencha todos os campos", "Erro", JOptionPane.ERROR_MESSAGE);
                return;
                
            }else{
                

                if(curso.equals("Engenharia Informática") || curso.equals("Engenharia Civil") || curso.equals("Engenharia Electrónica")){
                    Connetor con = new Connetor();
                    String disciplina = "Matematica";
                    String disciplina2 = "Fisica";
                    int capacidade = 0;
                    int capacidade2 = 0;
                    try {
                        con.ps = con.con.prepareStatement("SELECT capacidade FROM salas WHERE tipo = ?");
                        con.ps.setString(1, disciplina);
                        con.rs = con.ps.executeQuery();
                        if (con.rs.next()) {
                             capacidade = con.rs.getInt("capacidade");
                           
                        }
                    } catch (Exception e) {
                        e.printStackTrace();
                    }

                    try {
                        con.ps = con.con.prepareStatement("SELECT capacidade FROM salas WHERE tipo = ?");
                        con.ps.setString(1, disciplina2);
                        con.rs = con.ps.executeQuery();
                        if (con.rs.next()) {
                             capacidade2 = con.rs.getInt("capacidade");
                           
                        }
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                    if(capacidade > 0 || capacidade2 > 0){
                        capacidade = capacidade - 1;
                        capacidade2 = capacidade2 - 1;
                        try {
                            con.ps = con.con.prepareStatement("UPDATE salas SET capacidade = ? WHERE tipo = ?");
                            con.ps.setInt(1, capacidade);
                            con.ps.setString(2, disciplina);
                            con.ps.executeUpdate();
                            
                            con.ps = con.con.prepareStatement("UPDATE salas SET capacidade = ? WHERE tipo = ?");
                            con.ps.setInt(1, capacidade2);
                            con.ps.setString(2, disciplina2);
                            con.ps.executeUpdate();
                            
                            con.insertInscricao(Session.getId(), curso);
                            JOptionPane.showMessageDialog(null, "Inscrição realizada com sucesso!\n\n" +
                                "Curso: " + curso, "Sucesso", JOptionPane.INFORMATION_MESSAGE);
                        } catch (Exception e) {
                            e.printStackTrace();
                        }
                    }else{
                        JOptionPane.showMessageDialog(null, "Inscrição não realizada com sucesso!\n\n" +
                                "Curso: " + curso, "Sucesso", JOptionPane.INFORMATION_MESSAGE);
                    }

                }else if(curso.equals("Medicina")) {
                    Connetor con = new Connetor();
                    String disciplina = "Biologia";
                    String disciplina2 = "Quimica";
                    int capacidade = 0;
                    int capacidade2 = 0;
                    try {
                        con.ps = con.con.prepareStatement("SELECT capacidade FROM salas WHERE tipo = ?");
                        con.ps.setString(1, disciplina);
                        con.rs = con.ps.executeQuery();
                        if (con.rs.next()) {
                             capacidade = con.rs.getInt("capacidade");
                           
                        }
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                    
                    try {
                        con.ps = con.con.prepareStatement("SELECT capacidade FROM salas WHERE tipo = ?");
                        con.ps.setString(1, disciplina2);
                        con.rs = con.ps.executeQuery();
                        if (con.rs.next()) {
                             capacidade2 = con.rs.getInt("capacidade");
                           
                        }
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                    if(capacidade > 0 || capacidade2 > 0){
                        
                        capacidade = capacidade - 1;
                        capacidade2 = capacidade2 - 1;

                        try {
                            con.ps = con.con.prepareStatement("UPDATE salas SET capacidade = ? WHERE tipo = ?");
                            con.ps.setInt(1, capacidade);
                            con.ps.setString(2, disciplina);
                            con.ps.executeUpdate();
                            
                            con.ps = con.con.prepareStatement("UPDATE salas SET capacidade = ? WHERE tipo = ?");
                            con.ps.setInt(1, capacidade2);
                            con.ps.setString(2, disciplina2);
                            con.ps.executeUpdate();
                            
                            con.insertInscricao(Session.getId(), curso);
                            JOptionPane.showMessageDialog(null, "Inscrição realizada com sucesso!\n\n" +
                                "Curso: " + curso, "Sucesso", JOptionPane.INFORMATION_MESSAGE);
                        } catch (Exception e) {
                            e.printStackTrace();
                        }

                    }else{
                        JOptionPane.showMessageDialog(null, "Inscrição não realizada com sucesso!\n\n" +
                                "Curso: " + curso, "Sucesso", JOptionPane.INFORMATION_MESSAGE);
                    }

                }else if(curso.equals("Direito")) {
                    Connetor con = new Connetor();
                    String disciplina = "Portugues";
                    String disciplina2 = "Historia";
                    int capacidade = 0; 
                    int capacidade2 = 0;

                    try {
                        con.ps = con.con.prepareStatement("SELECT capacidade FROM salas WHERE tipo = ?");
                        con.ps.setString(1, disciplina);
                        con.rs = con.ps.executeQuery();
                        if (con.rs.next()) {
                             capacidade = con.rs.getInt("capacidade");
                           
                        }
                    } catch (Exception e) {
                        e.printStackTrace();
                    }

                    try {
                        con.ps = con.con.prepareStatement("SELECT capacidade FROM salas WHERE tipo = ?");
                        con.ps.setString(1, disciplina2);
                        con.rs = con.ps.executeQuery();
                        if (con.rs.next()) {
                             capacidade2 = con.rs.getInt("capacidade");
                           
                        }
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                    if(capacidade > 0 || capacidade2 > 0){
                        
                        capacidade = capacidade - 1;
                        capacidade2 = capacidade2 - 1;
                        try {
                            con.ps = con.con.prepareStatement("UPDATE salas SET capacidade = ? WHERE tipo = ?");
                            con.ps.setInt(1, capacidade);
                            con.ps.setString(2, disciplina);
                            con.ps.executeUpdate();
                            
                            con.ps = con.con.prepareStatement("UPDATE salas SET capacidade = ? WHERE tipo = ?");
                            con.ps.setInt(1, capacidade2);
                            con.ps.setString(2, disciplina2);
                            con.ps.executeUpdate();
                            
                            con.insertInscricao(Session.getId(), curso);
                            JOptionPane.showMessageDialog(null, "Inscrição realizada com sucesso!\n\n" +
                                "Curso: " + curso, "Sucesso", JOptionPane.INFORMATION_MESSAGE);
                        } catch (Exception e) {
                            e.printStackTrace();
                        }

                    }else{
                        JOptionPane.showMessageDialog(null, "Inscrição não realizada com sucesso!\n\n" +
                                "Curso: " + curso, "Sucesso", JOptionPane.INFORMATION_MESSAGE);
                    }
                    
                }else if(curso.equals("Economia")) {
                    
                    Connetor con = new Connetor();
                    String disciplina = "Matematica";
                    String disciplina2 = "Historia";
                    int capacidade = 0;
                    int capacidade2 = 0;
                    try {
                        con.ps = con.con.prepareStatement("SELECT capacidade FROM salas WHERE tipo = ?");
                        con.ps.setString(1, disciplina);
                        con.rs = con.ps.executeQuery();
                        if (con.rs.next()) {
                             capacidade = con.rs.getInt("capacidade");
                           
                        }
                    } catch (Exception e) {
                        e.printStackTrace();
                    }

                    try {
                        con.ps = con.con.prepareStatement("SELECT capacidade FROM salas WHERE tipo = ?");
                        con.ps.setString(1, disciplina2);
                        con.rs = con.ps.executeQuery();
                        if (con.rs.next()) {
                             capacidade2 = con.rs.getInt("capacidade");
                           
                        }
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                    if(capacidade > 0 || capacidade2 > 0){
                        capacidade = capacidade - 1;
                        capacidade2 = capacidade2 - 1;
                        try {
                            con.ps = con.con.prepareStatement("UPDATE salas SET capacidade = ? WHERE tipo = ?");
                            con.ps.setInt(1, capacidade);
                            con.ps.setString(2, disciplina);
                            con.ps.executeUpdate();
                            con.insertInscricao(Session.getId(), curso);
                            JOptionPane.showMessageDialog(null, "Inscrição realizada com sucesso!\n\n" +
                                "Curso: " + curso, "Sucesso", JOptionPane.INFORMATION_MESSAGE);
                        } catch (Exception e) {
                            e.printStackTrace();
                        }
                    }else{
                        JOptionPane.showMessageDialog(null, "Inscrição não realizada com sucesso!\n\n" +
                                "Curso: " + curso, "Sucesso", JOptionPane.INFORMATION_MESSAGE);
                    }

                }else if(curso.equals("Arquitetura")) {
                    
                    Connetor con = new Connetor();
                    String disciplina = "Matematica";
                    String disciplina2 = "Fisica";
                    String disciplina3 = "Desenho";
                    int capacidade = 0;
                    int capacidade2 = 0;
                    int capacidade3 = 0;
                    try {
                        con.ps = con.con.prepareStatement("SELECT capacidade FROM salas WHERE tipo = ?");
                        con.ps.setString(1, disciplina);
                        con.rs = con.ps.executeQuery();
                        if (con.rs.next()) {
                             capacidade = con.rs.getInt("capacidade");
                           
                        }
                    } catch (Exception e) {
                        e.printStackTrace();
                    }

                    try {
                        con.ps = con.con.prepareStatement("SELECT capacidade FROM salas WHERE tipo = ?");
                        con.ps.setString(1, disciplina2);
                        con.rs = con.ps.executeQuery();
                        if (con.rs.next()) {
                             capacidade2 = con.rs.getInt("capacidade");
                           
                        }
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                    try {
                        con.ps = con.con.prepareStatement("SELECT capacidade FROM salas WHERE tipo = ?");
                        con.ps.setString(1, disciplina3);
                        con.rs = con.ps.executeQuery();
                        if (con.rs.next()) {
                             capacidade3 = con.rs.getInt("capacidade");
                           
                        }
                    } catch (Exception e) {
                        e.printStackTrace();
                    }

                    if(capacidade > 0 || capacidade2 > 0 || capacidade3 > 0){
                        capacidade = capacidade - 1;
                        capacidade2 = capacidade2 - 1;
                        capacidade3 = capacidade3 - 1;
                        try {
                            con.ps = con.con.prepareStatement("UPDATE salas SET capacidade = ? WHERE tipo = ?");
                            con.ps.setInt(1, capacidade);
                            con.ps.setString(2, disciplina);
                            con.ps.executeUpdate();
                            
                            con.ps = con.con.prepareStatement("UPDATE salas SET capacidade = ? WHERE tipo = ?");
                            con.ps.setInt(1, capacidade2);
                            con.ps.setString(2, disciplina2);
                            con.ps.executeUpdate();
                            
                            con.ps = con.con.prepareStatement("UPDATE salas SET capacidade = ? WHERE tipo = ?");
                            con.ps.setInt(1, capacidade3);
                            con.ps.setString(2, disciplina3);
                            con.ps.executeUpdate();
                            
                            con.insertInscricao(Session.getId(), curso);
                            JOptionPane.showMessageDialog(null, "Inscrição realizada com sucesso!\n\n" +
                                "Curso: " + curso, "Sucesso", JOptionPane.INFORMATION_MESSAGE);
                        } catch (Exception e) {
                            e.printStackTrace();
                        }

                    }else{
                        JOptionPane.showMessageDialog(null, "Inscrição não realizada com sucesso!\n\n" +
                                "Curso: " + curso, "Sucesso", JOptionPane.INFORMATION_MESSAGE);
                    }
                }
            }

            
            
        }else if(ae.getSource() == menu1) {
            dispose();
        
            new Principal();
        }
    } 
    
}
