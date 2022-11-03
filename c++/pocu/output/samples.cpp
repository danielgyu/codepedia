#include <iostream>

namespace samples
{
	void printEverything() {
		std::cout << "+--------+" << std::endl;
		std::cout << "Everything" << std::endl;
		std::cout << "+--------+" << std::endl;

		int number = 10;
		float decimal = 1.5f;
		char letter = 'A';
		char string[] = "hello world";

		std::cout << number << std::endl;
		std::cout << decimal << std::endl;
		std::cout << letter << std::endl
			<< string << std::endl;
	}
}
