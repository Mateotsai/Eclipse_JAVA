package tw.mateo0730.javaClass;

public class variableLesson {

	public static void main(String[] args) {
		// 整數: byte, short, int, long 全包含正負號
		byte var1; //2^8 => -128 ~ 127
		var1 = 12;
		byte var2 = 123;  //[a-zA-Z$_][a-zA-Z0-9$_]*   <<<正規表示法
		byte $_$ = 123;
		System.out.println($_$);
		/*
		 變數名稱規則: 上面用[]正規表示法
		 >>>開頭字符可以用字母、底線、$，不可以用數字 
		 >>>後續字符可以用字母、底線、$，另外可以用數字
		 */
		short var3 = 10000; //2^16 => -32768 ~ 32767
		int var4 = 123; //2^32 => 42億多，電腦的語言=4G
		long var5 = 123; //2^64
	}

}
