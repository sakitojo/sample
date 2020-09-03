//コンストラクタ

package model;
import java.io.Serializable;

//変数の宣言
public class Mutter implements Serializable{
	private int id;
	private String userName;
	private String text;
	
	//コンストラクタの生成
	public Mutter() {}
	public Mutter(String userName, String text) {
		this.userName = userName;
		this.text = text;
	}
	public Mutter(int id, String userName, String text) {
		this.id = id;
		this.userName = userName;
		this.text = text;
	}
	
	//getterメソッド
	public int getId() { return id; }
	public String getUserName() { return userName; }
	public String getText()     { return text; }

}
