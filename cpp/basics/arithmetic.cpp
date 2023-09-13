#include <iostream> 

using namespace std;

int main() {
    char operand1 = 'n';
    char operand2 = 'c';

    char division = operand1 / operand2;
    char modulus = operand1 % operand2;

    cout << "division: " << division << endl;
    cout << "moudlus: " << modulus << endl;

    cout << "division: " << operand1 / operand2 << endl;
    cout << "moudlus: " << operand1 % operand2 << endl;

    cout << "logical and: " << (operand1 && operand1) << endl;

    cout << "----" << endl;

    char current = 'B';
    char before = int (current) - 1;

    cout << "before_char: " << before << endl;

    return 0;
}

