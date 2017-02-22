package BuilderPattern;
/**抽象builder类**/
public abstract class Builder {

	/**设置主板**/
	public abstract void buildBoard(String board);
	
	/**设置显示器**/
	public abstract void buildDisplay(String dispaly);
	/**设置操作系统**/
	public abstract void buildOS();
	/**创建product-computer**/
	public abstract Computer createProduct();
}
