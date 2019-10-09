package idv.springboot.demo.Enum;

public enum SysStsEm {

	SUCCESS,
	
	FAIL
	
	
	private SysStsEm(String key, String val){
	    this.key = key;
	    this.val = val;
	  }

	  private String day;
	  private String chinese;
}
