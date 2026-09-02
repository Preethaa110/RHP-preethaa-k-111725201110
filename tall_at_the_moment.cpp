#include <iostream>
#include<algorithm>
#include<vector>
using namespace std;

int main() {
    int n;cin>>n;
    vector<pair<int,int>> takh(n);
    while(n--){
        int h,l; cin>>h>>l;
        takh.push_back(make_pair(h,l));

    }
    sort(takh.begin(),takh.end(),greater<>());
    int prevt=0;
    vector<int> ltarr,htarr;
    for(auto [ht,lt]: takh){
        if (lt>prevt){
            prevt=lt;
            ltarr.push_back(lt);
            htarr.push_back(ht);
        }
    }
    int Q;cin>>Q;
    while(Q--){
        int t;cin>>t;
        auto it =upper_bound(ltarr.begin(),ltarr.end(),t);
        int ind=it-ltarr.begin();
        cout<<htarr[ind]<<endl;
    }



    return 0;
}
