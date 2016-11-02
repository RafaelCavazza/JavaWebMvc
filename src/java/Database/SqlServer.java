package Database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class SqlServer {

    private final Connection conn;

    public SqlServer() throws SQLException {
        this.conn = DriverManager.getConnection("dbc:sqlserver://ec2-52-67-112-140.sa-east-1.compute.amazonaws.com:1433", "sa", "A1a2$bcde");
    }

    public int BuscarIdArtista(String nome) {
        try (Statement stmt = conn.createStatement()) {
            ResultSet resultado = stmt.executeQuery("SELECT Id FROM Artista WHERE Nome LIKE" + nome);
            return resultado.getInt("Id");
        } catch (SQLException e) {
            System.err.println(e);
            return 0;
        }
    }

    public void GravarArtista(String nome) {
        try (Statement stmt = conn.createStatement()) {
            stmt.executeQuery("INSERT INTO Artista(Nome) VALUES(" + nome + ")");
        } catch (SQLException e) {
            System.err.println(e);
        }
    }

    public void DeletarArtista(int id) {
        try (Statement stmt = conn.createStatement()) {
            stmt.executeQuery("DELETE FROM Artista WHERE Id = " + id);
        } catch (SQLException e) {
            System.err.println(e);
        }
    }

    public void DeletarTodosArtistas() {
        try (Statement stmt = conn.createStatement()) {
            stmt.executeQuery("DELETE FROM Artista");
        } catch (SQLException e) {
            System.err.println(e);
        }
    }

}
