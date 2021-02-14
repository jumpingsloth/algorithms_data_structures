public class UnionFind {
	public static void main(String[] args) {
		int N = 10;
		QuickUnion uf = new QuickUnion(N);

		for (int i=0; i < (N-1); i++) {
			uf.union(i, i+1);
		}
		System.out.println(uf.allConnected());
		System.out.println(uf.find(3));
	}
}
