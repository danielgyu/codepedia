#include "helloPope.h"
#include "hiPope.h"
#include "samples.h"
#include "manipulator.h"

int main() {
    // namespace:: example
    hi::helloWorld();
    hello::helloWorld();

    // simple formatting
    samples::printEverything();

    // manipulator formatting
    manipulator::printMenu();
}
