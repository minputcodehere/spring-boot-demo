package idv.springboot.demo;

public class TestBean {

	private String name;

	private int id;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public TestBean() {

	}

	public TestBean(String text, int num) {
		this.name = name;
		this.id = id;
	}
}
