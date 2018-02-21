
public class Hash {

	public static void main(String[] args) {
		universalHash((long) Math.pow(2, 30));
	}

	public static long universalHash(long m) {
		boolean found = false;
		long count = 0;
		long[] keys = make(m);
		while (!found) {
			count++;
			long key1 = getKey();
			long key2 = getKey();
			long hash1 = hashValue(keys, key1);
			long hash2 = hashValue(keys, key2);
			if (hash1 == hash2) {
				found = true;
				System.out.println("Key 1 = " + key1);
				System.out.println("Key 2 = " + key2);
				System.out.println("Count = " + count);
				System.out.println("A = " + keys[0]);
				System.out.println("B = " + keys[1]);
				System.out.println("P = " + keys[2]);
				System.out.println("M = " + keys[3]);
			}
			count++;
		}

		return count;
	}

	public static long[] make(long m) {
		long[] key = new long[4];
		long prime = m + (long) (Math.random() * (m + 1));
		while (!isPrime(prime)) {
			prime = m + (long) (Math.random() * (m + 1));
		}
		long a = (long) (Math.random() * (prime + 1));
		long b = (long) (Math.random() * (prime + 1));
		key[0] = a;
		key[1] = b;
		key[2] = prime;
		key[3] = m;
		return key;
	}

	public static long hashValue(long[] keys, long k) {
		long step1 = (keys[0] * k + keys[1]) % keys[2];
		long step2 = step1 % keys[3];
		return step2;
	}

	public static boolean isPrime(long number) {
		long sqrt = (long) Math.sqrt(number) + 1;
		for (long i = 2; i < sqrt; i++) {
			if (number % i == 0) {
				return false;
			}
		}
		return true;
	}

	public static long getKey() {
		long min = (long) Math.pow(2, 60);
		long max = (long) (Math.pow(2, 63) - 1);
		return min + (long) (Math.random() * ((max - min) + 1));
	}

}
