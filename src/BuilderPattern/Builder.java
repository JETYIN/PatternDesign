package BuilderPattern;
/**����builder��**/
public abstract class Builder {

	/**��������**/
	public abstract void buildBoard(String board);
	
	/**������ʾ��**/
	public abstract void buildDisplay(String dispaly);
	/**���ò���ϵͳ**/
	public abstract void buildOS();
	/**����product-computer**/
	public abstract Computer createProduct();
}
