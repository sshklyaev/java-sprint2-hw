public class MonthReader {
    private String itemName;
    private boolean isExpense;
    private int quantity;
    private int sumOfOne;
    public MonthReader(String itemName, boolean isExpense, int quantity, int sumOfOne )
    {
        this.itemName = itemName;
        this.isExpense = isExpense;
        this.quantity = quantity;
        this.sumOfOne = sumOfOne;

    }

    public boolean getIsExpense()
    {
        return isExpense;
    }

    public int getQuantity()
    {
        return quantity;
    }

    public int getSumOfOne()
    {
        return sumOfOne;
    }

    public String getItemName()
    {
        return itemName;
    }
}
