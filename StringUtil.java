import java.security.MessageDigest;
import com.google.gson.*;


public class StringUtil {

		public static String applySHA256(String input)
		{
			try {
				
				MessageDigest digest=MessageDigest.getInstance("SHA-256");
				byte[] hash=digest.digest(input.getBytes("UTF-8"));//String is encoded to byte array
				StringBuffer hexString=new StringBuffer();
				for(int i=0;i<hash.length;i++)
				{
					String hex=Integer.toHexString(0xff & hash[i]);
					if(hex.length()==1) hexString.append('0');
					hexString.append(hex);
				}
				return hexString.toString();
			}
			catch(Exception e) {
				throw new RuntimeException(e);
			}
			
		}
		
		
		//function to turn object into a json object		
		public static String getJson(Object o) {
			Gson gson = new Gson(); 
			String json = gson.toJson(o);
			return json;
			//return new GsonBuilder().setPrettyPrinting().create().toJson(o);
		}
		
		//target string
		public static String getDifficultyTarget(int difficulty)
		{
			return new String(new char[difficulty]).replace('\0','0');
		}
}
