#include<iostream>

using namespace std;

int giaithua(int a)
{
	if(a==1||a==0)
	{
		return 1;
	}
	else
	{
			return a*giaithua(a-1);
	}
}

int chinhHop(int a,int k)
{
	
	return giaithua(a)/giaithua(a-k);
}
int toHop(int a,int k)
{
	return chinhHop(a,k)/giaithua(k);
}

int main()
{
		int a;
		int n;
		int k;
				cout<<"Enter number a  : ";
			    cin>>a;
				cout<<"Enter number n ";
				cin>>n;
				cout<<"Enter number k : ";
				cin>>k;	

	cout<<"P"<<a<<"= "<<giaithua(a)<<endl;
	cout<<"Chinh Hop cua "<<n<<" va "<<k<<"= "<<chinhHop(n,k)<<endl;
	cout<<"To Hop cua "<<n<<" va "<<k<<" = "<<toHop(n,k)<<endl;
	return 0;
}


