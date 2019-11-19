
import java.util.Date;

public class Block {
	public String hash;
	public String prevHash;
	private RecordTypeA dataA=new RecordTypeA();
	private RecordTypeB dataB=new RecordTypeB();
	private RecordTypeC dataC=new RecordTypeC();
	private long timestamp;
	private int nonce;
	
	//calculating hash based on contents of block
	public String calculateHash()
	{
		String hash;
		if(dataA!=null)
		{
			hash=StringUtil.applySHA256(
					prevHash+
					Long.toString(timestamp)+
					Integer.toString(nonce)+
					dataA
					);
		}
		else if(dataB!=null) {
			hash=StringUtil.applySHA256(
					prevHash+
					Long.toString(timestamp)+
					Integer.toString(nonce)+
					dataB
					);
			
		}
		else
		{
			hash=StringUtil.applySHA256(
					prevHash+
					Long.toString(timestamp)+
					Integer.toString(nonce)+
					dataC
					);
		}
		
		return hash;
	}
	
	//constructor
	public Block(RecordTypeA dataA,String prevHash)
	{
		System.out.println(" - - -  Structure matched for Record Type A -> Student Record");
		this.dataB=null;
		this.dataC=null;
		this.dataA.setName(dataA.getName());

		this.dataA.setCourse(dataA.getCourse());

		this.dataA.setId(dataA.getId());

		this.dataA.setMarks(dataA.getMarks());

		this.prevHash=prevHash;

		this.timestamp=new Date().getTime();//returns no of millisecs

		this.hash=calculateHash();
	
		
	}
	
	//constructor for RecordTypeB
	
	public Block(RecordTypeB dataB,String prevHash)
	{
		System.out.println(" - - -  Structure matched for Record Type B -> Teacher Record");
		this.dataA=null;
		this.dataC=null;
		this.dataB.setName(dataB.getName());
		this.dataB.setSubject(dataB.getSubject());
		this.dataB.setExperience(dataB.getExperience());
		this.prevHash=prevHash;
		this.timestamp=new Date().getTime();//returns no of millisecs
		this.hash=calculateHash();
	}
	
	public Block(RecordTypeC dataC,String prevHash)
	{
		System.out.println(" - - -  Structure matched for Record Type C -> Staff Record");
		this.dataB=null;
		this.dataA=null;
		this.dataC.setName(dataC.getName());
		this.dataC.setRole(dataC.getRole());
		this.dataC.setId(dataC.getId());
		this.prevHash=prevHash;
		this.timestamp=new Date().getTime();//returns no of millisecs
		
		this.hash=calculateHash();
		
	}
	
	
	
	public void mineBlock(int difficulty)
	{
		System.out.println("Mining block.. ");
		String target=StringUtil.getDifficultyTarget(difficulty);
		while(!hash.substring(0,difficulty).equals(target))
			{
				//System.out.println("..updating nonce to achieve Difficulty target");
				nonce++;
				hash=calculateHash();
			}
		System.out.println("Block Mined!!! : " + hash);
	}
	
	
	
}
