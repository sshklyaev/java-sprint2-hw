public class DataReconciliation
{
private MonthReports monthReports;
private YearReports yearReports;



public DataReconciliation(MonthReports monthReports, YearReports yearReports)
{
    this.monthReports = monthReports;
    this.yearReports = yearReports;

}
 public String getReconciliation()
 {

     for (YearReader yearReader : yearReports.getYear())
     {
        int month = yearReader.getMonth();

         if (yearReader.isExpense()) {
             int spendingByMonth = monthReports.getSpendingPerMonth(monthReports.getMonth().get( month));
             if (yearReader.getAmount() != spendingByMonth)
             {

                 return "Месяц в котром обноружена ошибка - " + month;

             }
         }
         else
         {
             int profitByMonth = monthReports.  getProfitItem(monthReports.getMonth().get(month));
             if (yearReader.getAmount() != profitByMonth)
             {
                 return "Месяц в котром обноружена ошибка - " + month;
             }

         }

     }
     return "Метод успешно выполнен!";
     }

}
