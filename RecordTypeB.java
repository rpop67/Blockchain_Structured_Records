

public class RecordTypeB {

	protected String name;
	protected String[] subjects=new String[3];
	protected int experience;
	
	//professor record
	public RecordTypeB()
	{
		name="Genesis Block";
		subjects=new String[] {"_","_","_"};
		experience=-1;
		
	}
	
	public RecordTypeB(String name,String[] subjects,int experience)
	{
		this.name=name;
		this.subjects=new String[subjects.length];
		for(int i=0;i<subjects.length;i++)
		{
			this.subjects[i]=subjects[i];
		}
		this.experience=experience;
	}
	
	
	//getters5
	public String getName()
	{
		return name;
	}
	
	public String[] getSubject()
	{
		return subjects;
	}
	
	public int getExperience()
	{
		return experience;
	}
	
 
	
	//setters
	
	public void setName(String name)
	{
		this.name=name;
	}
	
	public void setSubject(String[] sub)
	{
		for(int i=0;i<sub.length;i++)
		{
			this.subjects[i]=sub[i];
		}
	}
	
	public void setExperience(int experience)
	{
		this.experience=experience;
	}

	

}
