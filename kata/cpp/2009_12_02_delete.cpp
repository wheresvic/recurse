#include <iostream>
using namespace std;

int main() {

	class T {
		int val;
	};

	T *p = new T[10];
	delete p;

	/**
	 * Note that the compiler can't warn of an incorrect scalar deletion of an array, 
	 * since it can't distinguish between a pointer to an array and a pointer to a single element. 
	 * Typically, array new will insert information adjacent to the memory allocated 
	 * for an array that indicates not only the size of the block of storage 
	 * but also the number of elements in the allocated array. 
	 * This information is examined and acted upon by array delete when the array is deleted.
	 *
	 * The format of this information is probably different from that of the information 
	 * stored with a block of storage obtained through scalar new. 
	 * If scalar delete is invoked upon storage allocated by array new, the information 
	 * about size and element count - which are intended to be interpreted by an array 
	 * delete - will probably be misinterpreted by the scalar delete, with undefined results. 
	 *
	 * It's also possible that scalar and array allocation employ different memory pools. 
	 * Use of a scalar deletion to return array storage allocated from the array pool to the 
	 * scalar pool is likely to end in disaster.
	 */

	T *q = 0;
	delete q;

	return 0;
}
