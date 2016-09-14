#include <iostream>

using namespace std;

typedef struct linkedList {

	int data;
	linkedList *next;

	linkedList() {
		next = NULL;
		data = 0;
	}

} linkedList;


void printList (linkedList **head) {

	if (*head == NULL) {
		cout << "List is empty!" << endl;
		return;
	}

	linkedList *temp = *head;

	while (temp != NULL) {
		cout << temp->data << endl;
		temp = temp->next;
	}	

}


void push(linkedList **head, int n) {

	linkedList *l = new linkedList;
	l->data = n;
	l->next = NULL;

	if (*head == NULL) {
		*head = l;
		cout << "first" << endl;
	} else {
		l->next = *head;
		*head = l;
		cout << "more" << endl;
	}

}


void deleteFromList(linkedList **head, int d) {

	if ((*head)->data == d) {
		linkedList *d = *head;
		*head = (*head)->next;
		delete d;
	} else {
		linkedList *cur = *head;
		linkedList *prev = *head;

		while (cur != NULL) {
			if (cur->data == d) {
				prev->next = cur->next;
				delete cur;
				return;
			}
			prev = cur;
			cur = cur->next;
		}
	}	

}


int main() {

	cout << "hello! Input numbers into the list" << endl;

	linkedList *head = NULL;
	int num;

	// addList(&head, 1);
	// addList(&head, 2);
	
	
	while (cin >> num) {
		push(&head, num);
	}
	
	
	/*
	linkedList *t1 = new linkedList;
	t1->data = 1;
	t1->next = NULL;
	head = t1;

	linkedList *t2 = new linkedList;
	t2->data = 2;
	t2->next = head;
	head = t2;
	*/

	cout << "Printing the list once" << endl;
	
	printList(&head);	

	cout << "Printing it again ..." << endl;

	printList(&head);	
	
	deleteFromList(&head, 3);
	
	cout << "New list" << endl;
	printList(&head);

	return 0;

}
