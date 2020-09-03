//コンストラクタ

package model;
import java.io.Serializable;

public class User implements Serializable{
	//変数の宣言
	private String name;
	private String pass;
	
    //コンストラクタの生成
	public User() {}
	public User(String name, String pass) {
		this.name = name;
		this.pass = pass;
	}
	//getterメソッド
	public String getName() { return name; }
	public String getPass() { return pass; }

}
