#include <iostream>
using namespace std;

int main() {

	const char* constStringPtr = "Constant String";
	char a = 'a';
	char b = 'b';
	const char* constCharPtr = &a;		// pointer to a constant character (const before the pointer)

	// *constCharPtr = 'z'; 		// error, cannot change the value here 
	constCharPtr = &b; 			// is ok, changing the pointer 

	cout << constStringPtr << endl;
	cout << constCharPtr << endl;

	char const * charConstPtr;		// same as above

	char* const constPtrChar = &a;		// constant pointer to a character (const after the pointer)
	*constPtrChar = 'z';
	// constPtrChar = &b;			// error, cannot change the pointer

	cout << constPtrChar << endl;

	return 0;
}
