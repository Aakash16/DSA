package CodeChef.repo;

public class Numbers {

	public static boolean isPrime(int n) {
		// Corner cases
		if (n <= 1)
			return false;
		if (n <= 3)
			return true;

		// This is checked so that we can skip
		// middle five numbers in below loop
		if (n % 2 == 0 || n % 3 == 0)
			return false;

		for (int i = 5; i * i <= n; i = i + 6)
			if (n % i == 0 || n % (i + 2) == 0)
				return false;

		return true;
	}

	public static long fact(long a, long mod) {
		long ans = 1;
		for (int i = 1; i <= a; i++) {
			ans *= i;
			ans %= mod;
		}
		return ans % mod;

	}

	public static long ncr(long n, long r, long mod) {
		long nom = 1, dom = 1;
		nom = (fact(n, mod)) % mod;
		dom = (fact(r, mod) * fact(n - r, mod)) % mod;
		return (nom * fastpow(dom, mod - 2, mod)) % mod;
	}

	public static long gcd(long x, long y) {
		if (x == 0)
			return y;
		if (y == 0)
			return x;
		long r = 0, a, b;
		a = (x > y) ? x : y; // a is greater number
		b = (x < y) ? x : y; // b is smaller number
		r = b;
		while (a % b != 0) {
			r = a % b;
			a = b;
			b = r;
		}
		return r;
	}

	public static long fastpow(long a, long b, long mod) {
		long ans = 1;
		while (b != 0) {
			if (b % 2 == 1) {
				ans = (ans * a) % mod;
			}
			a = (a * a) % mod;
			b /= 2;
		}
		return ans;
	}
}
