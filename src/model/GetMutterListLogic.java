package model;

import java.util.List;
import dao.MutterDAO;

public class GetMutterListLogic {
	public List<Mutter> execute() {                   //MutterDAOのfindAii()メソッドを使用して、
		MutterDAO dao = new MutterDAO();              //MUTTERテーブルの全レコードを取得し、返している
		List<Mutter> mutterList = dao.findAll();
		return mutterList;
	}


}
