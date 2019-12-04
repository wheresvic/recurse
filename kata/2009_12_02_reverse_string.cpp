/**
 * Write a C++ function to reverse a string (without using reverse) without using any temporary variables.
 */

#include <iostream>

using namespace std;

void reverse (string &s, int start, int end) {

	while (start < end) {
		s[start] = s[start] + s[end];
		s[end] = s[start] - s[end];
		s[start] = s[start] - s[end];
		start++;
		end--;
	}
}

void recursive_reverse (const char* str) {
	
	if (*str == '\0') {
		return;
	}

	recursive_reverse (str + 1);
	cout << *str;

}

void ez_string (const char* str, char* ez) {
	
	while (*str != '\0') {
		*ez = *str; 			// seg fault here because ez was never allocated!
		str++; 
		ez++;
	}
	*ez = '\0';
}

void recursive_ez_reverse (char* str) {

	if (*str == '\0') {
		return;
	}

}


int main() {

	string str;

	getline(cin, str);

	// reverse (str, 0, (str.length()-1));
	// cout << str << endl << endl << endl;

	cout << "Reversed string" << endl;
	const char* string = str.c_str();
	recursive_reverse(string);
	cout << endl;

	cout << "Converting to non-const" << endl;
	char* ez = new char[100];
	ez_string (string, ez);
	cout << ez << endl;

	

	return 0;
}
