public class YearReader
{
    private int month;
    private int amount;
    private boolean isExpense;

    public YearReader(int month, int amount, boolean isExpense)
    {
        this.amount = amount;
        this.month = month;
        this.isExpense = isExpense;

    }

    public int getAmount()
    {
        return amount;
    }

    public int getMonth()
    {
        return month;
    }

    public boolean isExpense()
    {
        return isExpense;
    }
}
