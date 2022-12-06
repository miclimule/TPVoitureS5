package metier;

public enum HashAlgo {
	
	MD2(1,"MD2"), 
	MD5(2,"MD5"), 
	SHA1(3,"SHA-1"), 
	SHA224(4,"SHA-224") , 
	SHA226(5,"SHA-226") , 
	SHA384(6,"SHA-384") , 
	SHA512(7,"SHA-512");
	
	public int val;
	public String algo;
	
	HashAlgo(int val, String algo) {
		this.val = val;
		this.algo = algo;
	}

	public int getVal() {
		return val;
	}

	public void setVal(int val) {
		this.val = val;
	}

	public String getAlgo() {
		return algo;
	}

	public void setAlgo(String algo) {
		this.algo = algo;
	}

}
