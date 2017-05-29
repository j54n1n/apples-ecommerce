package helpers;

import java.security.InvalidKeyException;
import java.security.KeyFactory;
import java.security.KeyRep;
import java.security.NoSuchAlgorithmException;
import java.security.PublicKey;
import java.security.spec.InvalidKeySpecException;
import java.security.spec.X509EncodedKeySpec;

import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;

import org.apache.axis.encoding.Base64;

public class KeyHelper {
	private String publicKey;

	public KeyHelper(String publicKey){
		this.publicKey = publicKey;
	}
	
	public String encryptString(String toEncrpy){
		byte[] pBytes = Base64.decode(publicKey);
		String result = "";
	    X509EncodedKeySpec X509publicKey = new X509EncodedKeySpec(pBytes);

	    try {
			KeyFactory kf = KeyFactory.getInstance("RSA");
		    PublicKey pKey = kf.generatePublic(X509publicKey);
		    Cipher cipher = Cipher.getInstance("RSA");   
		    cipher.init(Cipher.ENCRYPT_MODE, pKey);  
		    result =  Base64.encode(cipher.doFinal(toEncrpy.getBytes()));
			
		} catch (NoSuchAlgorithmException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (InvalidKeySpecException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IllegalBlockSizeException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (BadPaddingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (InvalidKeyException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (NoSuchPaddingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	    	return result;
	}
	
	
	
}
