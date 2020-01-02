package idv.springboot.demo;

public class GenericTest<T> {

	private T att;

	public void setAtt(T att) {
		this.att = att;
	}

	public T getAtt() {
		return att;
	}
}
