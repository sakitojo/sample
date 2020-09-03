package dao;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import model.Mutter;

public class MutterDAO {
	//DBに接続する情報
	private final String JDBC_URL=
			"jdbc:mysql://localhost/docotsubu?serverTimezone=JST&useSSL=false";
	private final String DB_USER = "root";
	private final String DB_PASS = "root";
	String drv = "com.mysql.cj.jdbc.Driver";
	private final String sql = "SELECT id, name, text FROM mutter ORDER BY ID DESC";
	
	public List<Mutter> findAll() {
		List<Mutter> mutterList = new ArrayList<>();
		
		//DBへ接続
		try{
			Class.forName(drv);
			Connection conn = DriverManager.getConnection(JDBC_URL, DB_USER, DB_PASS);
			
			System.out.println("DB接続完了");
			
			//SELECT文の準備
			PreparedStatement pStmt = conn.prepareStatement(sql);
			
			//SELECT文を実行し、ResultSetを取得
			ResultSet rs = pStmt.executeQuery();
			
			//結果をArrayListに格納
			while (rs.next() ) {
				int id = rs.getInt("ID");
				String userName = rs.getString("name");
				String text = rs.getString("text");
				
				Mutter mutter = new Mutter(id, userName, text);
				mutterList.add(mutter);
			}
		}catch(SQLException e) {
			e.printStackTrace();
			return null;
		}catch(ClassNotFoundException e) {
			e.printStackTrace();
		}
		
		for(int i = 0; i < mutterList.size(); i++) {
			Mutter sent = mutterList.get(i);
			System.out.println("sent[" + i + "] = " + sent);
		}
		
		return mutterList;
	}
	
	
	
	public boolean create(Mutter mutter) {
		//DB接続
		try {
			Class.forName(drv);
			Connection conn = DriverManager.getConnection(JDBC_URL, DB_USER, DB_PASS);
			
			
			//INSERT文の準備(idは自動連番なので指定しなくてよい）
			String sql = "INSERT INTO mutter (name, text) values (?, ?)";
			PreparedStatement pStmt = conn.prepareStatement(sql);
			
			//INSERT文の？に使用する値を設定し、SQL文を完成
			pStmt.setString(1, mutter.getUserName());
			pStmt.setString(2, mutter.getText());
			
			//INSERT文を実行(resultには追加された行数が代入される)
			int result = pStmt.executeUpdate();
			if(result != 1) {
				return false;
			}
		}catch(SQLException e) {
			e.printStackTrace();
			return false;
		}catch(ClassNotFoundException e) {
			e.printStackTrace();
		}
		return true;
	}

}
