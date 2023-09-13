#include <iostream>
#include <vector>

using namespace std;

void rotate() {
    int N, R;
    cin >> N >> R;

    vector<int> v(N);
    for (int i = 0; i < N; i++) {
        v[i] = i+1;
    }

    vector<int> v_c;
    v_c = v;
    int r = 0;
    R = R % N;
    for (int i = N-R; i < N; i++) {
        v_c[r++] = v[i];
    }
    for (int i = 0; i < N-R; i++) {
        v_c[r++] = v[i];
    }

    for (int i=0; i<N; i++) cout << v_c[i] << " ";
    cout << endl;
}

void reverse() {
    int N;
    cin >> N;

    vector<int> v(N, 0); 
    for (int i = 0; i < N; i++) {
        cin >> v[i];
    }

    int left = 0;
    int right = N-1;
    while (left < right) {
        swap(v[left++], v[right--]);
    }

    for (int i=0; i<N; i++) cout << v[i] << " ";
    cout << endl;
}

vector<int> makeVector(int length) {
    vector<int> v(length, 0);
    for (int i = 0; i < length; i++) {
        cin >> v[i];
    }
    return v;
}

void merge() {
    int L, R;
    cin >> L >> R;

    vector<int> vl = makeVector(L);
    vector<int> vr = makeVector(R);
    vector<int> res(L+R, -1);

    int l = 0, r = 0, s = 0;
    while (l < L and r < R) {
        if (vl[l] < vr[r]) {
            res[s++] = vl[l++];
        } else {
            res[s++] = vr[r++];
        }
    }

    while (l < L) {
        res[s++] = vl[l++];
    }
    while (r < R) {
        res[s++] = vr[r++];
    }

    for (int i=0; i<L+R; i++) cout << res[i] << " ";
}

int main() {
    // reverse();
    // rotate();
    merge();
}