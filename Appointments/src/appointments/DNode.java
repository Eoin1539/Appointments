package appointments;

public class DNode {

	static int noOfLinkedList = 0;
	
	String name;
        String email;
        String priority;
	String dob;
        int ID;
        
	DNode previousNode;
	DNode nextNode;
	
	DNode(int ID, String name, String email, String priority, String dob){
		
		this.name = name;
                this.email= email;
                this.priority=priority;
                this.dob=dob;
                 this.ID=ID;
                 
		noOfLinkedList++;
		
	}
	
}