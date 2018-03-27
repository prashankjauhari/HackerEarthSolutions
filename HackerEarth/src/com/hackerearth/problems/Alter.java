package com.hackerearth.problems;


import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;

public class Alter {

	public static void main(String args[]){
		try {
			FileInputStream inputstream=new FileInputStream("/home/prashank/MyGit/BelerumCodebase/KycMangement/db_script/insert_script/country_insert_statement.sql");
			BufferedReader br = new BufferedReader(new InputStreamReader(inputstream));
			BufferedReader console = new BufferedReader(new InputStreamReader(System.in));
			StringBuffer input=null;
			String data=null;
			do{
			data=br.readLine();	
	          
			if(data!=null && data.length()>0 && data.charAt(0)!='/'){
				input=new StringBuffer(data);
			int i=input.lastIndexOf("(");

			int j=input.lastIndexOf(")");
             System.out.println(input.substring(i,j+1));
			}
			}while(data!=null);
			
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
