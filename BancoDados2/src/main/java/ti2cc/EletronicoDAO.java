package ti2cc;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class EletronicoDAO extends DAO {
	
	public EletronicoDAO() {
		super();
		conectar();
	}

	public void finalize() {
		close();
	}
	
	public boolean insert(Eletronico eletronico) {
		boolean status = false;
		try {
			Statement st = conexao.createStatement();
			String sql = "INSERT INTO eletronico (codigo, nome, valor, quantidade) VALUES (" 
			           + eletronico.getCodigo() + ", '" 
			           + eletronico.getNome() + "', " 
			           + eletronico.getValor() + ", " 
			           + eletronico.getQuantidade() + ");";
			System.out.println(sql);
			st.executeUpdate(sql);
			st.close();
			status = true;
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
		return status;
	}

	public Eletronico get(int codigo) {
		Eletronico eletronico = null;
		try {
			Statement st = conexao.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
			String sql = "SELECT * FROM eletronico WHERE codigo = " + codigo;
			System.out.println(sql);
			ResultSet rs = st.executeQuery(sql);	
	        if (rs.next()) {            
	        	 eletronico = new Eletronico(
	        		 rs.getInt("codigo"), 
	        		 rs.getString("nome"), 
	        		 rs.getDouble("valor"), 
	        		 rs.getInt("quantidade"));
	        }
	        st.close();
		} catch (Exception e) {
			System.err.println(e.getMessage());
		}
		return eletronico;
	}
	
	public List<Eletronico> get() {
		return get("");
	}

	public List<Eletronico> getOrderByCodigo() {
		return get("codigo");		
	}
	
	private List<Eletronico> get(String orderBy) {	
		List<Eletronico> eletronicos = new ArrayList<Eletronico>();
		
		try {
			Statement st = conexao.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
			String sql = "SELECT * FROM eletronico" + 
			            (orderBy.trim().length() == 0 ? "" : " ORDER BY " + orderBy);
			System.out.println(sql);
			ResultSet rs = st.executeQuery(sql);	           
	        while (rs.next()) {	            	
	        	Eletronico e = new Eletronico(
	        		rs.getInt("codigo"), 
	        		rs.getString("nome"), 
	        		rs.getDouble("valor"), 
	        		rs.getInt("quantidade"));
	            eletronicos.add(e);
	        }
	        st.close();
		} catch (Exception e) {
			System.err.println(e.getMessage());
		}
		return eletronicos;
	}

	public boolean update(Eletronico eletronico) {
		boolean status = false;
		try {
			Statement st = conexao.createStatement();
			String sql = "UPDATE eletronico SET nome = '" + eletronico.getNome() 
					   + "', valor = " + eletronico.getValor()
					   + ", quantidade = " + eletronico.getQuantidade()
					   + " WHERE codigo = " + eletronico.getCodigo();
			System.out.println(sql);
			st.executeUpdate(sql);
			st.close();
			status = true;
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
		return status;
	}
	
	public boolean delete(int codigo) {
		boolean status = false;
		try {
			Statement st = conexao.createStatement();
			String sql = "DELETE FROM eletronico WHERE codigo = " + codigo;
			System.out.println(sql);
			st.executeUpdate(sql);
			st.close();
			status = true;
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
		return status;
	}
}
