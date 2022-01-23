#include <iostream>

using namespace std;

int main() {
    /* variables */
    int number1;
    int number2, number3;

    number1 = 100;

    int number4 = 101;

    /* constants */
    const int fixedNumber = 1;
    cout << "number is" << fixedNumber << endl;

    /* conversion */
    char a = 'A';
    cout << "a is " << a << endl;

    int ascii;
    ascii = (int) a;
    cout << "ascii is " << ascii << endl;

    string input;
    cout << "enter your input:" << endl;
    cin >> input;
    cout << "you have entered: " << input << endl;
}
