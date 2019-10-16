package idv.springboot.demo.Enum;

public enum SysStsEm {

	FAIL("0", "失敗"),

	SUCCESS("1", "成功"),

	NONE("99", "尚未定義狀態");

	private String code;

	private String name;

	private SysStsEm(String code, String name) {

		this.code = code;

		this.name = name;
	}

	public static String getCode(SysStsEm val) {

		for (SysStsEm e : SysStsEm.values()) {

			if (val.code.equals(e.code)) {

				return e.code;
			}
		}

		return NONE.code;
	}

	public static String getName(SysStsEm val) {

		for (SysStsEm e : SysStsEm.values()) {

			if (val.name.equals(e.name)) {

				return e.name;
			}
		}

		return NONE.name;
	}
}
