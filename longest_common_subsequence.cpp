#include <iostream>
#include <vector>
using namespace std;

int main() {

    string s1, s2;

    cout << "Enter first string: ";
    cin >> s1;

    cout << "Enter second string: ";
    cin >> s2;

    vector<vector<int>> dp(s2.length() + 1,
                           vector<int>(s1.length() + 1, 0));

    int maxi = 0;

    for(int row = 1; row <= s2.length(); row++) {

        for(int col = 1; col <= s1.length(); col++) {

            if(s1[col - 1] == s2[row - 1]) {

                dp[row][col] =
                    1 + dp[row - 1][col - 1];

                maxi = max(maxi, dp[row][col]);
            }
            else {

                dp[row][col] = 0;
            }
        }
    }

    cout << "Length of Longest Common Subsequence = "
         << maxi;

    return 0;
}
