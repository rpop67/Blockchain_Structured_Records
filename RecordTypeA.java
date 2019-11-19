

public class RecordTypeA {

	protected String name;
	protected String course;
	protected int id;
	protected int[] marks=new int[3];
	
	//student record
	public RecordTypeA()
	{
		name="Genesis Block";
		course=null;
		id=0;
		marks=new int[] {-1,-1,-1};
	}
	
	public RecordTypeA(String name,String course,int id,int[] marks)
	{
		this.name=name;
		this.course=course;
		this.id=id;
		for(int i=0;i<marks.length;i++)
		{
			this.marks[i]=marks[i];
		}
	}
	
	
	//getters5
	public String getName()
	{
		return name;
	}
	
	public String getCourse()
	{
		return course;
	}
	
	public int getId()
	{
		return id;
	}
	
   public int[] getMarks()
	{
		return marks;
	}
	
	//setters
	
	public void setName(String name)
	{
		this.name=name;
	}
	
	public void setCourse(String course)
	{
		this.course=course;
	}
	
	public void setId(int id)
	{
		this.id=id;
	}
	
	public void setMarks(int[] arr)
	{
		for(int i=0;i<arr.length;i++)
		{
			this.marks[i]=arr[i];
		}
	}
	

}
