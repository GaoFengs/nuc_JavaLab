package ʵ����ÿ��һ��;

public class ListNode {
	int vol;
	ListNode next=null;
	public ListNode(int x) {
			vol=x;
	}//���ӽڵ�
	public void add(int x){
		ListNode newNode=new ListNode(x);
		if(this.next==null){
			this.next=newNode;
		}else {
			this.next.add(x);
		}
	}
	
	public void display(){//��ʾ�ڵ�
		if(this.next != null){
			System.out.print(this.vol + "->");
			this.next.display();
			}else{
			System.out.print(this.vol + "\n");
			}
	}
	public void del(int x){
		if(this.next.vol==x){
			this.next=this.next.next;
		}
		if(this.next!=null)
		this.next.del(x);
	}
	public  static void  main(String arg[]){
		ListNode a=new ListNode(2);
		a.add(1);
		a.add(3);
		a.add(4);
		a.add(3);
		a.del(3);
		a.display();
	}
	}
