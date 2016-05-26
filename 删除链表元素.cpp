#include<iostream>
#define Node struct N
#define debug
using namespace std;
Node
{
	int x;
	Node* prev;
	Node* next;
};
class Link
{
private:
	Node* head;
	Node* tail;
	int length;
public:
	Link()
	{
		head=new Node();
		head->prev=NULL;
		head->next=NULL;
		length=0;
	}
	~Link() 
	{
		Node* t=head->next;
		Node* p;
		while(t!=NULL)
		{
			p=t;
			t=t->next;
			delete p;
#ifdef debug
			cout<<"�ͷ�"<<endl;
#endif
		}
		delete head;
#ifdef debug
		cout<<"�ͷ�head"<<endl;
#endif
	}
	//���Ԫ�� 
	void add(int x)
	{
		Node* now=new Node();
		now->x=x;
		length++;
		if(length==1)
		{
			head->next=now;
			now->prev=head;
			now->next=NULL;
			tail=now;
		}
		else
		{
			tail->next=now;
			now->prev=tail;
			now->next=NULL;
			tail=now;
		}
	}
	//�õ���i��Ԫ�� 
	int get(int i)
	{
		if(i>0&&i<=length)
		{
			Node* t=head;
			for(int j=0;j<i;j++)
			{
				t=t->next;
			}
			return t->x;
		}
		else
		{
			return 0;
		}
	}
	//�õ����� 
	int getLength()
	{
		return length;
	}
	//ɾ��ֵ����x�Ľڵ� 
	void removeElements(int x)
	{
		Node* now=head->next;
		while(now!=NULL)
		{
			if(now->x==x)
			{
				Node* tmp=now;
				now=now->next;
				tmp->prev->next=now;
				//�˴�Ӧ��ע��,��Ϊnow��ʱ����ΪNULL,��Ӧ���д��ж� 
				if(now!=NULL)
					now->prev=tmp->prev;
				delete tmp;
				length--;
			}
			else
			{
				now=now->next;
			}
		}
	}
};
int main()
{
	Link s;
	s.add(1);
	s.add(2);
	s.add(3);
	s.add(3);
	s.add(4);
	s.add(5);
	s.add(3);
#ifdef debug
	for(int i=1;i<=s.getLength();i++)
	{
		cout<<s.get(i)<<endl;
	}
	cout<<"-----------------------------"<<endl;
#endif
	//ִ��ɾ������,ɾ��ֵΪ3��Ԫ�� 
	s.removeElements(3);
	for(int i=1;i<=s.getLength();i++)
	{
		cout<<s.get(i)<<endl;
	}
	return 0;
}
