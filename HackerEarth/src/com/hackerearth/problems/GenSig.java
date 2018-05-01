package com.hackerearth.problems;
import java.security.KeyFactory;
import java.security.PrivateKey;
import java.security.Signature;
import java.security.spec.PKCS8EncodedKeySpec;
import java.security.spec.X509EncodedKeySpec;
import java.util.Base64;

class GenSig {

    public static void main(String[] args) {

        /* Generate a DSA signature */
/*
        if (args.length != 1) {
            System.out.println("Usage: GenSig nameOfFileToSign");
        }
        else */try {
        	String pk="MIIBVQIBADANBgkqhkiG9w0BAQEFAASCAT8wggE7AgEAAkEAkf1+rcXuVxQrk5paZ2ruNPqPoVXUnSC0ypyEvfxPOVk22Y6oxGLPo5g7A4pGUtBI9PMO/692ukeZ19aSc0Cz/wIDAQABAkAYmpVP6gy6Bj812AymY0IUEapFMXbsqEdv4iMI9c3QRzSk83ZpofKMI7bGJVXk6IPah+okAxnO+XWRJR/6xS+BAiEAxnNPJEEoul5PPHoXUrIRxXBI5rxTablVSi6XDgXMu0ECIQC8U5xQRHPoZW1FDB+gTDRyzk5nTwkf2HjA8NQhk4HfPwIgTtIRxwaSVKOMuSqNBO1xHYhhjDOUtdNEyvgCSzGGhYECIQC5CJFRkCAt2tHEgIfmUFlL34XLHS2C24axUy2pm6uDswIhALzjuJKc2A0/D4DMN2c8PO3Vtmt8YcvI4TvkWEIrUENd";
        	String pb="MFwwDQYJKoZIhvcNAQEBBQADSwAwSAJBAJH9fq3F7lcUK5OaWmdq7jT6j6FV1J0gtMqchL38TzlZNtmOqMRiz6OYOwOKRlLQSPTzDv+vdrpHmdfWknNAs/8CAwEAAQ==";

        	
        	PKCS8EncodedKeySpec spec = new PKCS8EncodedKeySpec(Base64.getDecoder().decode(pk));
        	KeyFactory keyFactory = KeyFactory.getInstance("RSA");
    		PrivateKey prvk= keyFactory.generatePrivate(spec);
   
    		Signature dsa = Signature.getInstance("SHA1withRSA");
    		dsa.initSign(prvk);
    		String message=(System.currentTimeMillis()+"");
    		byte[] data=message.getBytes();
    		dsa.update(data,0,data.length);
            byte[] sign=dsa.sign();
            
            X509EncodedKeySpec pubKeySpec = new X509EncodedKeySpec(Base64.getDecoder().decode(pb));
            KeyFactory keyFactory1 = KeyFactory.getInstance("RSA");

            Signature verifier = Signature.getInstance("SHA1withRSA");
            verifier.initVerify(keyFactory1.generatePublic(pubKeySpec));
            verifier.update(message.getBytes(),0,message.length());
            
            System.out.println(Base64.getEncoder().encodeToString(sign));
            
             System.out.println(message);
             
            System.out.println("signature verifies: " + verifier.verify(sign));
            
        } catch (Exception e) {
            System.err.println("Caught exception " + e.toString());
        }
    }
}


