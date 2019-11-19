import java.util.ArrayList;
import com.google.gson.*;
import java.io.*;


public class Dumplingchain {
	public static ArrayList<Block> blockchain=new ArrayList<Block>();
	//setting difficulty for mining
	public static int difficulty=5;
	
	
	public static void main(String[] args) throws IOException
	{
		
		addBlockToChain(new Block(new RecordTypeC("Genesis","Genesis role not defined",0),"0"));
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		System.out.println("How many blocks do you want to add at the moment?");
		int blocks=Integer.parseInt(br.readLine());
		for(int i=0;i<blocks;i++)
		{
			System.out.println("Enter data for block....");
			String jsonInput=br.readLine();
			Gson g=new Gson();
			RecordTypeA dataA =g.fromJson(jsonInput, RecordTypeA.class);
			RecordTypeB dataB=g.fromJson(jsonInput, RecordTypeB.class);
			RecordTypeC dataC =g.fromJson(jsonInput,RecordTypeC.class);
			if(dataA.course!=null && dataA.marks.length>0 && dataA.name!=null && dataA.course!=null)
			{
				System.out.println(dataA.getName()+" "+dataA.getCourse()+" "+dataA.getId()+" end--");
				addBlockToChain(new Block(dataA,blockchain.get(blockchain.size()-1).hash));
			}
			else if(dataB.experience!=-1 && dataB.name!=null && dataB.subjects.length>0)
			{
				//System.out.println(dataB.getName()+" "+dataB.getSubject()+" "+dataB.getExperience()+" end--");
				addBlockToChain(new Block(dataB,blockchain.get(blockchain.size()-1).hash));
			}
			else if(dataC.role!=null && dataC.id> 0 && dataC.name!=null )
			{
				//System.out.println(dataC.getName()+" "+dataC.getRole()+" "+dataC.getId()+" end--");
				addBlockToChain(new Block(dataC,blockchain.get(blockchain.size()-1).hash));
			}
			else
			{
				System.out.println("This content structure cannot be added to the block.Please restructure your data ");
			}
		}
		
		
		//addBlockToChain(new Block("This is block2 ",blockchain.get(blockchain.size()-1).hash));
		
		
		String blockchainJson=StringUtil.getJson(blockchain);
		System.out.println(blockchainJson);
		if(isChainValid()==true)
		{
			System.out.println("Chain is fully secure");
			
		}
		else
			System.out.println("Chain was attacked by hacker");
		
	}
   
	public static boolean isChainValid() {
		Block currentBlock;
		Block previousBlock;
		String targetHash=new String(new char[difficulty]).replace('\0', '0');
		
		for(int i=1;i<blockchain.size();i++)
		{
			currentBlock=blockchain.get(i);
			previousBlock=blockchain.get(i-1);
			if(!currentBlock.hash.equals(currentBlock.calculateHash()))
			{
				System.out.println("Current hashes not equal");
				return false;
			}
			
			//compare prev Block
			if(!currentBlock.prevHash.equals(previousBlock.hash))
			{
				System.out.println("Previous hashes not equal");
				return false;
			}
			
			//check if block is mined and target hash is achieved
			if(!currentBlock.hash.substring(0,difficulty).equals(targetHash))
				{
					System.out.println("This block has not been mined. Difficulty Target not achieved");
					return false;
				}
		}
		return true;
	}
	
	/*
	 * JSon FORMAT
	 * FOR DATA
	 * {"name":"Akanksha","course":"MCA","id":"23","marks":["23","43","11"]}
	 * {"name":"Sujoy Saha","subjects":["Networking","Discrete Math","System Software"],"experience":"10"}
	 * {"name":"Anay Paul","role":"Student Dealing","id":"678"}
	 */
	
	public static void addBlockToChain(Block newBlock)
	{
		newBlock.mineBlock(difficulty);
		blockchain.add(newBlock);
	}
	
}
