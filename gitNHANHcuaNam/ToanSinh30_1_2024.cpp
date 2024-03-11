#include<iostream>

using namespace std;

void xuat(int n,int a[])
{
	for(int  i=0;i<n;i++)
	{
		cout<<a[i]<<endl;
	}
}
int main()
{
	int a[4]={1,2,3,4};
	int n=4;
	for(int i=0;i<n;i++)
	{
		cout<<a[i]<<endl;
		
		for(int j=i+1;j<n;j++)
		{
			
			cout<<a[i]<<a[j]<<endl;
		
			
			if(j<4)
			{
				for(int k=j+1;k<n;k++)
				{
					cout<<a[i]<<a[j]<<a[k]<<endl;
				}
			}
			
		}
	}
	return 0;
}
