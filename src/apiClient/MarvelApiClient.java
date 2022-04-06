package apiClient;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.sql.Timestamp;

import interfaces.APIClient;

public class MarvelApiClient implements APIClient {

	String type;
	String apikey;
	String privateKey;
	Timestamp timestamp = new Timestamp(System.currentTimeMillis());
	String hash;
	

	
	public MarvelApiClient(String apikey, String pk) {
		 this.apikey = apikey;
		 this.privateKey = pk;
		 this.hash = "1" + "abcd" + "12345";
	};

	
	
	@Override
	public String getBody() throws IOException, InterruptedException {
		try {
			System.out.println("old hash = [B@13c27452");
			generateHash();
		} catch (UnsupportedEncodingException | NoSuchAlgorithmException e) {
			e.printStackTrace();
		}
		
		return null;
	}

	
	private byte[] generateHash() throws UnsupportedEncodingException, NoSuchAlgorithmException {
		System.out.println("hash =  "+ hash);
		byte[] bytesOfMessage = hash.getBytes("UTF-8");
		MessageDigest md = MessageDigest.getInstance("MD5");
		byte[] theMD5digest = md.digest(bytesOfMessage);
		
		System.out.println(theMD5digest);
		
		return theMD5digest;

	}
	
	@Override
	public String type() {
		// TODO Auto-generated method stub
		return type;
	}

}
