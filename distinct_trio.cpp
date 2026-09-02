#include <iostream>
#include<vector>
#include<algorithm>
#define ll long long int
using namespace std;

int main() {
    int N;cin>>N;
    vector<int> a(N);
    for(int i=0;i<N;i++){
        cin>>a[i];
    }
    sort(a.begin(),a.end());
    ll ans =0;
    for(int i=1;i<N-1;i++){
        auto ubit =upper_bound(a.begin(),a.end(),a[i]);
        int x= a.end()-ubit;
        auto lbit = lower_bound(a.begin(),a.end(),a[i]);
        int y = lbit-a.begin();
        ans+=1LL*x*y;

    }
    cout<<ans<<endl;
}
