#include <iostream>

using namespace std;

int main() {
    int amount = 20;

    if (amount < 30) {
	cout << "less than thirty" << endl;
    }

    char grade = 'C';

    switch(grade) {
	case 'A':
	    cout << "great job" << endl;
	    break;
	case'B':
	    cout << "good job" << endl;
	    break;
	case 'C':
	    cout << "not bad" << endl;
	    break;
	default:
	    cout << "huh?" << endl;
    }

    string result = (amount > 10) ? "Good" : "Bad";
    cout << "ternary result: " << result << endl;

    return 0;
}
