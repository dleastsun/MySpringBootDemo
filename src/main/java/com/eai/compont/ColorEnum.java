package com.eai.compont;

/**
 * 
 * @author lixudong
 *
 */
public enum ColorEnum {
	/**
	 * red
	 */
	RED("红色", 1),
	/**
	 * yellow
	 */
	YELLOW("黄色", 2),
	/**
	 * green
	 */
	GREEN("绿色", 3),
	/**
	 * pink
	 */
	PINK("粉色", 4),
	/**
	 * orange
	 */
	ORANGE("橙色", 5),
	/**
	 * blue
	 */
	BLUE("蓝色", 7);

	private ColorEnum(String value, int key) {
		this.value = value;
		this.key = key;
	}

	/**
	 * key
	 */
	private int key;

	/**
	 * value
	 */
	private String value;

	public int getKey() {
		return key;
	}

	public void setKey(int key) {
		this.key = key;
	}

	public String getValue() {
		return value;
	}

	public void setValue(String value) {
		this.value = value;
	}

	/**
	 * 根据key获取value的值
	 * 
	 * @param key
	 * @return
	 */
	public static String getValueByKey(int key) {
		for (ColorEnum s : ColorEnum.values()) {
			if (s.getKey() == key) {
				return s.getValue();
			}
		}
		return "";
	}

	/**
	 * 根据匹配value的值获取key
	 * 
	 * @param channelName
	 * @return
	 */
	public static int getKeyByValue(String channelName) {
		for (ColorEnum s : ColorEnum.values()) {
			if (channelName.equals(s.getValue())) {
				return s.getKey();
			}
		}
		return 0;
	}

	public static void main(String[] args) {
		System.out.println(ColorEnum.getValueByKey(1));
	}
}