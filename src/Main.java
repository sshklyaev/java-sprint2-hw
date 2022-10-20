import java.util.Scanner;
public class Main
{

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        YearReports yearReports = new YearReports();
        MonthReports monthReports = new MonthReports();
        DataReconciliation dataReconciliation = new DataReconciliation(monthReports, yearReports);
        while(true)
        {
            printMenu();
            int command = scanner.nextInt();
            if (command == 1 )
            {
                monthReports.saveReportsPerMonth();
                if (monthReports.getMonth().isEmpty())
                {

                    System.out.println("Месячные отчёты не были считаны");
                    break;

                }
                else
                {

                    System.out.println("Месячные отчёты были считаны!");
                }

            } else if (command == 2)
            {
                yearReports.saveReportsPerYear();
                if (yearReports.getYear().isEmpty())
                {
                    System.out.println("Годовой отчёт не был считан!");
                }
                else
                {

                    System.out.println("Годовой отчёт был считан!");
                }


            }
            else if (command == 3)
            {
                if (monthReports.getMonth().isEmpty() || yearReports.getYear().isEmpty() )
                {
                    System.out.println("Отчёты не были считаны, попробуйте снова!");
                }
                else
                {
                    System.out.println(dataReconciliation.getReconciliation());
                }


            }
            else if (command == 4)
            {
                monthReports.infoByMonth();
                if (monthReports.getMonth().isEmpty())
                {
                    System.out.println("Месячные отчёты не были считаны");


                }
                else {


                    System.out.println(monthReports.infoByMonth());

                }

            }
            else if (command == 5)
            {
                if (yearReports.getYear().isEmpty())
                {
                    System.out.println("Годовой отчёт не был считан!");
                }
                else
                {
                    for (int month = 1 ; month < yearReports.getYear().size(); month+=2)

                    {
                        System.out.println("Прибыль за " + yearReports.getYear().get(month).getMonth() + "-ый месяц = " + yearReports.profitForEachMonth(month));

                    }
                    System.out.println("Средний расход за все месяцы в году: " + yearReports.averageExpensesOfYear());
                    System.out.println("Средний доход за все месяцы в году: "+ yearReports.averageProfitOfYear());

                }

                

            }
            else if (command == 0)
            {
                System.out.println("Выход!");
            }
            else
            {
                System.out.println("Такой команды ещё нет!");
            }

        }
    }

    public static void printMenu(){
        System.out.println("\nЧто вы хотите сделать? ");
        System.out.println("1 - Считать все месячные отчёты");
        System.out.println("2 - Считать годовой отчёт");
        System.out.println("3 - Сверить отчёты");
        System.out.println("4 - Вывести информацию о всех месячных отчётах");
        System.out.println("5 - Вывести информацию о годовом отчёте");
        System.out.println("0 - Выход");
    }
}


