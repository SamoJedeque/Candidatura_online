
import java.sql.*;

public class Connetor {

    Connection con;
    PreparedStatement ps;
    private int id;
    ResultSet rs;
    ResultSet rs2;

    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }

    public Connetor() {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/academia", "root", "");
            System.out.println("Conectado com sucesso!");
        } catch (ClassNotFoundException | SQLException e) {
            System.out.println("Erro ao conectar: " + e.getMessage());
        }
    }

    public void close() {
        try {
            if (rs != null) rs.close();
            if (ps != null) ps.close();
            if (con != null) con.close();
        } catch (SQLException e) {
            System.out.println("Erro ao fechar: " + e.getMessage());
        }
    }

    // CRUD para o candidato
    public void insert(String nome, String apelido, int idade, String genero, String bairro,String cidade,String escola,String seccao, String nuit, String username, String userPass) {
        try {
            ps = con.prepareStatement("INSERT INTO candidato(nome, sobrenome, idade, genero, bairro, cidade, escola, seccao, nuit, username, senha) VALUES(?,?,?,?,?,?,?,?,?,?,?)");
            ps.setString(1, nome);
            ps.setString(2, apelido);
            ps.setInt(3, idade);
            ps.setString(4, genero);
            ps.setString(5, bairro);
            ps.setString(6,cidade);
            ps.setString(7,escola);
            ps.setString(8,seccao);
            ps.setString(9, nuit);
            ps.setString(10, username);
            ps.setString(11, userPass);
            System.out.println("Inserindo...");
            ps.executeUpdate();
        } catch (SQLException e) {
            System.out.println("Erro ao inserir: " + e.getMessage());
        }
        
    }

    public String search(String username, String userPass) {
        try {
            ps = con.prepareStatement("SELECT * FROM candidato WHERE username = ? AND senha = ?");
            ps.setString(1, username);
            ps.setString(2, userPass);
            rs = ps.executeQuery();
            if (rs.next()) {
                int id = rs.getInt("user_id");
                setId(id);
                return rs.getString("nivel_de_acesso");
            } else {
                return null;
            }
        } catch (SQLException e) {
            System.out.println("Erro ao buscar: " + e.getMessage());
        }

        return null;
    }

    


    public void update(String username, String userPass) {
        try {
            ps = con.prepareStatement("UPDATE candidato SET senha = ? WHERE username = ?");
            ps.setString(1, userPass);
            ps.setString(2, username);
            ps.executeUpdate();
        } catch (SQLException e) {
            System.out.println("Erro ao atualizar: " + e.getMessage());
        }
    }

    public void delete(int user_id) {
        try {
            ps = con.prepareStatement("DELETE FROM candidato WHERE user_id = ?");
            ps.setInt(1, user_id);
            ps.executeUpdate();
        } catch (SQLException e) {
            System.out.println("Erro ao deletar: " + e.getMessage());
        }
    }

    // CRUD para as inscricoes

    public void insertInscricao(int user_id, String curso) {
        try {
            ps = con.prepareStatement("INSERT INTO inscricao(cand_id, curso) VALUES(?,?)");
            ps.setInt(1, user_id);
            ps.setString(2, curso);
            System.out.println("Inserindo...");
            ps.executeUpdate();
        } catch (SQLException e) {
            System.out.println("Erro ao inserir: " + e.getMessage());
        }
    }
    public void updateInscricao(String nome, String curso, String status) {
        try {
            ps = con.prepareStatement("UPDATE inscricao SET curso = ?, status = ? WHERE nome = ?");
            ps.setString(1, curso);
            ps.setString(2, status);
            ps.setString(3, nome);
            ps.executeUpdate();
        } catch (SQLException e) {
            System.out.println("Erro ao atualizar: " + e.getMessage());
        }
    }

    public void insertSala(String nome , int capacidade, String tipo, String local) {
        try {
            ps = con.prepareStatement("INSERT INTO salas(nome , capacidade , tipo, localizacao) VALUES(?,?,?,?)");
            ps.setString(1, nome);
            ps.setInt(2, capacidade);
            ps.setString(3, tipo);
            ps.setString(4, local);
            System.out.println("Inserindo...");
            ps.executeUpdate();
        } catch (SQLException e) {
            System.out.println("Erro ao inserir: " + e.getMessage());
        }
    }
    
    public void deleteInscricao(int user_id) {
        try {
            ps = con.prepareStatement("DELETE FROM inscricao WHERE cand_id = ?");
            ps.setInt(1, user_id);
            ps.executeUpdate();
        } catch (SQLException e) {
            System.out.println("Erro ao deletar: " + e.getMessage());
        }
    }
}
