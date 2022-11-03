#include <iomanip>
#include <iostream>

using namespace std;

namespace manipulator
{
	void printMenu() {
		cout << "+------------+" << endl;
		cout << "| print menu |" << endl;
		cout << "+------------+" << endl;

		const float coffePrice = 1.25f;
		const float lattePrice = 4.75f;
		const float comboPrice = 12.104f;

		const size_t nameLength = 20;
		const size_t priceLength = 20;

		cout << left << fixed << showpoint << setprecision(2);
	}
    
}
