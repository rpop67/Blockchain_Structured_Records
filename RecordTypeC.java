

public class RecordTypeC {

	protected String name;
	protected String role;
	protected int id;
	
	//staff record
	public RecordTypeC()
	{
		name="Genesis Block";
		role=null;
		id=0;
	}
	
	public RecordTypeC(String name,String role,int id)
	{
		this.name=name;
		this.role=role;
		this.id=id;	
	}
	
	
	//getters5
	public String getName()
	{
		return name;
	}
	
	public String getRole()
	{
		return role;
	}
	
	public int getId()
	{
		return id;
	}
	
   
	//setters
	
	public void setName(String name)
	{
		this.name=name;
	}
	
	public void setRole(String role)
	{
		this.role=role;
	}
	
	public void setId(int id)
	{
		this.id=id;
	}
	


}
