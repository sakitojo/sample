package model;
import java.util.List;
import dao.MutterDAO;

public class PostMutterLogic {
	//Mutter型mutterを宣言
	public void execute(Mutter mutter) {
		MutterDAO dao = new MutterDAO();
		dao.create(mutter);

	}
}
