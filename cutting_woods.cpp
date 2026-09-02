#include <iostream>
#include<vector>
#include<set>
using namespace std;

int main() {
    int L,Q ; cin>>L>>Q;
    set<int> s;
    s.insert(0);
    s.insert(L);
    vector<int> ans;
    while(Q--){
        int qt,x; cin>> qt>>x;
        if(qt==1){
            s.insert(x);
        }else{
            auto it = s.upper_bound(x);
            
            ans.push_back(*it - *(prev(it)));
        }
    }
    for (int i:ans ){
        cout<<i<<endl;
    }


    return 0;
}
