public class QuickUnion {
	private int[] id;
	private int[] sz;
	private int N;

	public QuickUnion(int n) {
		N = n;
		id = new int[N];
		sz = new int[N];
		for (int i=0; i < N; i++) {
			id[i] = i;
			sz[i] = 1;
		}
	}

	private int root(int i) {
		while (i != id[i]) {
			id[i] = id[id[i]];
			i = id[i];
		}
		return i;
	}

	public int find(int index) {
		int largest = 0;
		for (int i=0; i < N; i++) {
			if (root(i) == root(index)) {
				int j = i;
				while (j != id[j]) {
					if (j > largest) {
						largest = j;
					} else if (id[j] > largest) {
						largest = id[j];
					}
					j = id[j];
				}
			}
		}

		return largest;
	}

	public boolean allConnected() {
		boolean status = false;
		for (int i=0; i < (N-1); i++) {
			status = root(id[i]) == root(id[i+1]);
		}
		return status;
	}

	public boolean connected(int p, int q) {
		return root(p) == root(q);
	}

	public void union(int p, int q) {
		int i = root(p);
		int j = root(q);
		if (i == j)
			return;

		if (sz[i] < sz[j]) {
			id[i] = j;
			sz[j] += sz[i];
		} else {
			id[j] = i;
			sz[i] += sz[j];
		}
	}

}
