package com.hackerearth.problems;
import java.security.InvalidKeyException;
import java.security.KeyFactory;
import java.security.NoSuchAlgorithmException;
import java.security.PublicKey;
import java.security.Signature;
import java.security.SignatureException;
import java.security.spec.InvalidKeySpecException;
import java.security.spec.X509EncodedKeySpec;
import java.util.Base64;



class GenSig {

    public static void main(String[] args) {

        /* Generate a DSA signature */

        	try {
        
        	String pk="MIIBVQIBADANBgkqhkiG9w0BAQEFAASCAT8wggE7AgEAAkEAkf1+rcXuVxQrk5paZ2ruNPqPoVXUnSC0ypyEvfxPOVk22Y6oxGLPo5g7A4pGUtBI9PMO/692ukeZ19aSc0Cz/wIDAQABAkAYmpVP6gy6Bj812AymY0IUEapFMXbsqEdv4iMI9c3QRzSk83ZpofKMI7bGJVXk6IPah+okAxnO+XWRJR/6xS+BAiEAxnNPJEEoul5PPHoXUrIRxXBI5rxTablVSi6XDgXMu0ECIQC8U5xQRHPoZW1FDB+gTDRyzk5nTwkf2HjA8NQhk4HfPwIgTtIRxwaSVKOMuSqNBO1xHYhhjDOUtdNEyvgCSzGGhYECIQC5CJFRkCAt2tHEgIfmUFlL34XLHS2C24axUy2pm6uDswIhALzjuJKc2A0/D4DMN2c8PO3Vtmt8YcvI4TvkWEIrUENd";
        	String pb="MFwwDQYJKoZIhvcNAQEBBQADSwAwSAJBAJXY7C+hcmVq0ET05/0Ev66bDCfasOF0E56QYhcA/91kyeosTuZj6NzdVtZhevwGTa7tTZCNNypwX/5t9fnxqwUCAwEAAQ==";
    		String message="1526903162052";
    		System.out.println(verify(pb, message,"nU56BbAdjNsDlWtrDAVhnDBzIZ/1DJjdy3dlIl6lVMpL53gIrfD22po3oZXtvgyXiZURjfRHL84FLvpaVhVAJQ=="));
/*        	
        	PKCS8EncodedKeySpec spec = new PKCS8EncodedKeySpec(Base64.getDecoder().decode(pk));
        	KeyFactory keyFactory = KeyFactory.getInstance("RSA");
    		PrivateKey prvk= keyFactory.generatePrivate(spec);
   //nU56BbAdjNsDlWtrDAVhnDBzIZ/1DJjdy3dlIl6lVMpL53gIrfD22po3oZXtvgyXiZURjfRHL84FLvpaVhVAJQ==
    		Signature dsa = Signature.getInstance("SHA1withRSA");
    		dsa.initSign(prvk);
    		String message="1526903162052";
    		Signature dsa = Signature.getInstance("SHA1withRSA");
    		byte[] data=message.getBytes();
    		dsa.update(data,0,data.length);
            byte[] sign=dsa.sign();
            
            byte decodeSign[]=Base64.getDecoder().decode("nU56BbAdjNsDlWtrDAVhnDBzIZ/1DJjdy3dlIl6lVMpL53gIrfD22po3oZXtvgyXiZURjfRHL84FLvpaVhVAJQ==".getBytes());
            
            X509EncodedKeySpec pubKeySpec = new X509EncodedKeySpec(Base64.getDecoder().decode(pb));
            KeyFactory keyFactory1 = KeyFactory.getInstance("RSA");

 * verifier.initVerify(pubKey);
			verifier.update(data.getBytes(),0,data.length());
 
            Signature verifier = Signature.getInstance("SHA1withRSA");
            verifier.initVerify(keyFactory1.generatePublic(pubKeySpec));
            verifier.update(message.getBytes(),0,message.length());
            
            System.out.println(Base64.getEncoder().encodeToString(sign));
            
             System.out.println(message);
             
            System.out.println("signature verifies: " + verifier.verify(decodeSign));*/
            
        } catch (Exception e) {
        	e.printStackTrace();
            System.err.println("Caught exception " + e.toString());
        }
    }

    
    public static Boolean verify(String base64EncodePublicKey,String data,String sign){
    	byte decodePublicKey[] = Base64.getDecoder().decode(base64EncodePublicKey);
		byte decodeSign[]=Base64.getDecoder().decode(sign.getBytes());
		KeyFactory keyFactory=null;
		try {
			keyFactory = KeyFactory.getInstance("RSA");
		} catch (NoSuchAlgorithmException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		X509EncodedKeySpec pubKeySpec = new X509EncodedKeySpec(decodePublicKey);
		try {
			PublicKey pubKey =keyFactory.generatePublic(pubKeySpec);
			Signature verifier = Signature.getInstance("SHA1withRSA");
			verifier.initVerify(pubKey);
			verifier.update(data.getBytes(),0,data.length());
			return verifier.verify(decodeSign);
		} catch(IllegalArgumentException e){
			try {
				throw new Exception(e.getMessage());
			} catch (Exception e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		}catch (NoSuchAlgorithmException | InvalidKeySpecException | InvalidKeyException | SignatureException e) {
			//logger.debug("exception while verification for signature",e);
			return null;
		}
		return null;
    }
        
	
/*	public static void main(String args[] ) throws Exception 
	{ // //BufferedReader 
		//there should not be any other printing statement if question does not specify it. 
	   //System.out.println("Enter arrayy length: \n"); 
	   Scanner in = new Scanner(System.in); 
	   int size = in.nextInt();
	   //System.out.println("size is: "+ size +"\n"); 
	   int[] arr = new int[size]; 
	   //System.out.println("Enter arrayy elements: \n"); 
	   for(int i = 0; i < size; i++){ 

	      BufferedReader num = new BufferedReader(new InputStreamReader(System.in)); 
		     arr[i]=Integer.parseInt(num.readLine());
	      //you have to read data from buffer reader 
	      arr[i] = in.nextInt();
 
	     }

	      // Writing output to STDOUT // Write your code here 
	      for(int i = (arr.length - 1); i >=0; i--){ System.out.println(arr[i]); } 

	 }*/
	
 /*	public static void main(String args[] ) throws Exception {
//      //BufferedReader
		//System.out.println("Enter arrayy length: \n");
		FileInputStream stream=new FileInputStream(new File("/home/prashank/Documents/Project/HackerEarthSolutions/HackerEarth/src/com/hackerearth/problems/input.txt"));
 		Scanner in = new Scanner(stream);
		int size = in.nextInt();
     // System.out.println("size is: "+ size +"\n");
      int[] arr = new int[size];
//      in.close();
      
      //System.out.println("Enter arrayy elements: \n");
	  BufferedReader num=null;
	  try{
	     num = new BufferedReader(new InputStreamReader(new FileInputStream(new File("/home/prashank/Documents/Project/HackerEarthSolutions/HackerEarth/src/com/hackerearth/problems/input.txt")))); 
	  }catch(Exception e){
		  e.printStackTrace();
	  }

      for(int i = 0; i < size; i++){
      //	sysou
      	String temp=num.readLine();
      	System.out.println("readLine is "+temp);
      	//System.out.println("sc : "+in.nextInt());
      arr[i] = Integer.parseInt(temp);
    	 // arr[i] = in.nextInt();
      }   // Writing output to STDOUT
      //System.out.println("abc");
      // Write your code here
      for(int i = (arr.length - 1); i >=0; i--){
          System.out.println(arr[i]);
      }
		
		
  }*/
}


