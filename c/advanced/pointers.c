#include <stdio.h>
#include <math.h>


void areaPeri(
	double radius, double length, double breadth,
	double *cirArea, double *cirPeri, double *recArea, double *recPeri
) {
	// calculate area of the circle and store in cirArea (pi * r2)
	*cirArea = M_PI * pow(radius, 2);
	// calculate perimeter(circumference) of the circle and store in cirPeri (pi * (2 * radius))
	*cirPeri = M_PI * (2 * radius);
	// calculate area of the rectangle and store in cirArea (w l)
	*recArea = length * breadth;
	// calculate perimeter(circumference) of the rectangle and store in cirPeri (2(l+w))
	*recPeri = 2 * (length * breadth);
}

void areaOperator() {
	int i = 3;
	printf("Address of i = %p\n", &i);
	printf("Value of i = %d\n", i);
	printf("Value of i = %d\n", *(&i));
}

int main() {
	double cirArea, cirPeri, recArea, recPeri;
	cirArea = 0;
	cirPeri = 0;
	recArea = 0;
	recPeri = 0;
	areaPeri(2.5, 4.9, 6.8, &cirArea, &cirPeri, &recArea, &recPeri);

	printf("value of cirArea: %f\n", cirArea);
	printf("value of cirArea: %f\n", cirPeri);
	printf("value of cirArea: %f\n", recArea);
	printf("value of cirArea: %f\n", recPeri);
}
