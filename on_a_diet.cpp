#include <iostream>
#include<vector>
#define ll long long int
using namespace std;

int main() {
    int N,M ;
    ll K; cin>>N>>M>>K;
    vector<int> arr(N);
    vector<bool> eaten(N,false);
    for(int i=0;i<N;i++) cin>>arr[i];
        ll curr=0;
        for(int i=0;i<N;i++){
            if(i>=M){
                if(eaten[i-M]){
                    curr-=arr[i-M];
                }
            }
            if(curr+arr[i]<=K){
                eaten[i]=true;
                curr+=arr[i];
                cout<<"Yes"<<endl;
            }else{
                cout<<"No"<<endl;

            }
            }
    

    return 0;
}
