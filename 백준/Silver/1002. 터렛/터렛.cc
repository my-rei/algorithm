#include <iostream>
#include <cmath>

using namespace std;


int main() {
	int n; int x1, y1, r1, x2, y2, r2; int cnt = 0;
	int add, sub; double z3=0;

	cin >> n;
	for (int i = 0; i < n; i++) {
		cnt = 0; z3 = 0;
		cin >> x1 >> y1 >> r1 >> x2 >> y2 >> r2;

		z3 = sqrt((x1 - x2) * (x1 - x2) + (y1 - y2) * (y1 - y2));
		add = r1 + r2; 
		sub = r1 - r2; if (r2 > r1) sub = r2 - r1;

		if ((z3 > sub) && (z3 < add)) {
			cout << 2;
		}
		else if ((z3 == add) || (z3 == sub && z3 != 0)) {
			cout << 1;
		}
		else if ((z3 < sub) || z3 > add) {
			cout << 0;
		}
		else if (z3 == 0) {
			if (r1 != r2) {
				cout << 0;
			}
			else {
				cout << -1;
			}
		}

		cout << '\n';
	}
}
