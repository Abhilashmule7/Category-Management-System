package product.entities;

public class Availability 
{
	private boolean inStock;
    private int quantity;
    
    // Constructors
	public Availability()
	{
		super();
		// TODO Auto-generated constructor stub
	}

	public Availability(boolean inStock, int quantity)
	{
		super();
		this.inStock = inStock;
		this.quantity = quantity;
	}

	 //getters and setters
	public boolean isInStock() {
		return inStock;
	}

	public void setInStock(boolean inStock) {
		this.inStock = inStock;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	//toString
	@Override
	public String toString()
	{
		return "Availability [inStock=" + inStock + ", quantity=" + quantity + "]";
	}
	

  
    
    
}