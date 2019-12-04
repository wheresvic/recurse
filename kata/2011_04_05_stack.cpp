#include <iostream>

using namespace std;

template <class T>
class Node
{
public:
	
	Node(T d) : next(NULL), data(d)
	{ }

	Node *next;
	T data;
};


template <class T>
class Stack
{
public:
	
	Stack() : head(NULL)
	{ }

	~Stack()
	{
		std::cout << "Destroying stack " << std::endl;

		while (head != NULL)
		{
			Node<T> *t = head;
			head = head->next;
			std::cout << "deleting " << t->data << std::endl;
			delete t;
		}
	}

	void push(T data)
	{
		if (head == NULL)
		{
			head = new Node<T>(data);
		}
		else
		{
			Node<T> *n = new Node<T>(data);
			n->next = head;
			head = n;
		}
	}

	T pop()
	{
		if (head != NULL)
		{
			Node<T> *d = head;
			T data = d->data;
			head = head->next;
			delete d;
			return data;
		}
		else
		{
			throw "stack is empty";
		}
	}

private:
	Node<T> *head;
};

int main()
{

	Stack<int> stack;

	try
	{
		stack.pop();
	}
	catch (const char *e)
	{
		std::cout << e << std::endl;
	}

	stack.push(10);
	stack.push(20);
	stack.push(30);
	stack.push(40);
	stack.push(50);

	int x = stack.pop();
	std::cout << x << std::endl;

	return 0;
}
