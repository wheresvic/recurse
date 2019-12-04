#include <iostream>
#include <string>

using namespace std;

int main() {

	string line;

	while (getline(cin, line)) {

		int i = line.length();

		while (i > 0 && (line[i-1] == ' ' || line[i-1] == '\t')) {
			--i;
		}

		line.erase(i);

		cout << line << endl;
		// cout << i << endl;
	}

	return 0;
}
