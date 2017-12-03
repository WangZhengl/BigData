package com.city.train.java8;


public class StringToken {

	public static void main(String[] args) {
		String str=",, ccc ,,";
		String[] strings = str.split(",",-1);
		System.out.println(strings.length);
		for(String s:strings){
			System.out.println("length:"+s.length()+" "+"value:"+s);
		}
		/*StringTokenizer st=new StringTokenizer(str, ",",true);
		System.out.println(st.countTokens());
		while(st.hasMoreTokens()){
			String nextToken =(String) st.nextElement();
			System.out.println(nextToken.length()+"****"+nextToken);
		}*/
	}

}
