#include <iostream>

using namespace std;

class Point
{
	int x, y;

public:

	Point(int a, int b) : x(a), y(b)
	{ 
		std::cout << "Constructing point ( " << a << ", " << b << " ) " << std::endl;
	}

	Point(const Point& p) : x(p.x), y(p.y)
	{
		std::cout << "In copy constructor " << p.x << " " << p.y << std::endl;
	}

	Point& operator=(const Point& p)
	{
		std::cout << "In assignment operator " << p.x << " " << p.y << std::endl;
		x = p.x;
		y = p.y;
		return *this;
	}

	int X()
	{
		return x;
	}

	int Y()
	{
		return y;
	}
};

int main()
{
	Point p1 = Point(1, 2);	
	Point p2(p1);
	Point p3 = p2;

	return 0;
}
