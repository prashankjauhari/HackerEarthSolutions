package com.hackerearth.problems;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public class BobAndAndi {


	public static Map<Character, Character> togglekeyboard(String pairs,Map<Character, Character> keyboard){
		Map<Character, Character> temp=new HashMap<Character, Character>();
		//1st
		Character a=pairs.charAt(0);
		Character b=pairs.charAt(2);

		if(keyboard.get(b)!=null){
			Character value=keyboard.get(b);
			temp.put(a, value);
		}

		if(keyboard.get(b)==null){
			temp.put(a,b);
		}
		
		Character	c=pairs.charAt(2);
		Character	d=pairs.charAt(0);

		if(keyboard.get(d)!=null){
			Character value=keyboard.get(d);
			temp.put(c, value);
		}

		if(keyboard.get(d)==null)
			keyboard.put(c,d);

		Iterator<Character> it=temp.keySet().iterator();
		while(it.hasNext()){
			Character key=it.next();
			keyboard.put(key, temp.get(key));
		}

		return keyboard;
	}


	public static void main(String args[]){
		try{
			BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream("/home/prashank/Documents/Project/HackerEarth/src/com/hackerearth/recursion/input.txt")));
			int paircount=Integer.parseInt(br.readLine().trim());
			//from,to
			Map<Character, Character> keyboard1=new HashMap<Character, Character>(paircount);
			int i=0;
			while(i<paircount){
				keyboard1=togglekeyboard(br.readLine(),keyboard1);
				i++;
			}
				System.out.println("keyboard1"+keyboard1);
			Map<Character, Character> keyboard=new HashMap<Character, Character>(paircount);
			Iterator<Character> it=keyboard1.keySet().iterator();
			while(it.hasNext()){
				Character key=it.next();
				keyboard.put(keyboard1.get(key),key);
			}	

			System.out.println("keyboard "+keyboard);
			//		System.out.println(keyboard);
			StringBuilder buff = new StringBuilder();
			String line=br.readLine();
			while(line!=null){
				for(i=0;i<line.length();i++){
					Character keystroke=line.charAt(i);
					Character actualkeystroke=keyboard.get(Character.toUpperCase(keystroke.charValue()));
					if(actualkeystroke==null){
						buff.append(keystroke);
					}else{
						if(Character.isLowerCase(keystroke.charValue()))
							buff.append(Character.toLowerCase(actualkeystroke.charValue()));
						else
							buff.append(actualkeystroke);
					}
				}
				line=br.readLine();
			}
			System.out.println(buff.toString());

		}catch(Exception e){
			e.printStackTrace();
		}
	}

}
