#include <iostream>
#include <string>

using namespace std;

void reverse_string(string &strOriginal, string &strReversed, int pos) {

    if (pos == -1) {
        return;
    }

    strReversed += strOriginal.at(pos);

    reverse_string(strOriginal, strReversed, --pos);
}


int main() {

	string a = "test 123";
	string b = "";

	reverse_string(a, b, a.length() - 1);

	cout << a << " " << b;

	return 0;

}
