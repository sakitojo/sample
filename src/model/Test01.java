package model;

import java.util.List;
import dao.MutterDAO;

public class Test01 {
	public static void main(String[] args) {
                   										//MutterDAOのfindAii()メソッドを使用して、
		MutterDAO dao = new MutterDAO();              //MUTTERテーブルの全レコードを取得し、返している
		List<Mutter> mutterList = dao.findAll();
		for(int i = 0; i < mutterList.size(); i++) {
			Mutter sent = mutterList.get(i);
			System.out.println("sent[" + i + "] = " + sent);
		}
		
	}
}
