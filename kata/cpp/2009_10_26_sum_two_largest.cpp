#include<iostream>
#include<vector>

using namespace std;

int main() {

        int num;
        /*
        vector<int> list;

        while (cin >> num) {
                list.push_back(num);
        }

        for (vector<int>::iterator iter = list.begin(); iter != list.end(); ++iter) {

        }
        */
        int len = 9;
        int arr[] = {1, -2, 8, 9, -15, 6, 0, 6, 4};

        int max1 = arr[0];
        int max2 = arr[0];

        for (int i=1; i<len; ++i) {
                // cout << arr[i] << " ";
                if (max1 < arr[i]) {
                        max2 = max1;
                        max1 = arr[i];
                }
        }

        cout << max1 << " " << max2 << endl;

        return 0;
}
