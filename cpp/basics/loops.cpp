#include <iostream>

using namespace std;

int main() {
    int count = 0;
    while (count < 3) {
	cout << "increasing. ";
	count++;
    }
    cout << endl;

    int page;
    for (page = 3; page > 0; page--) {
	cout << "decreasing. ";
    }
    cout << endl;

    /*
    while (true) {
	cout << "infinite. "; 
    }
    *
}
