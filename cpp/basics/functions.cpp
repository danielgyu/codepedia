#include <iostream>

using namespace std;

// declaration
int add(int num1, int num2);

// definition with default
int dadd(int num1 = 10, int num2 = 40) {
    cout << "adding " << num1 << " and " << num2 << endl;
    return num1 + num2;
}

int main() {
    int n1 = 10;
    int n2 = 33;
    int sum = add(n1, n2);
    cout << "sum is " << sum << endl;

    int sum2 = dadd();
    cout << "default sum is " << sum << endl;
}


// no default
int add(int num1, int num2) {
    cout << "adding " << num1 << " and " << num2 << endl;
    return num1 + num2;
}
