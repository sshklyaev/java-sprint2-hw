import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;

public class YearReports {
    private ArrayList<YearReader> year;

    public YearReports() {
        year = new ArrayList<>();
    }

    public ArrayList<YearReader> getYear() {
        return year;
    }

    public String readFileContentsOrNull(String paths) {
        try {
            return Files.readString(Path.of(paths));
        } catch (IOException e) {
            System.out.println("Невозможно прочитать файл с месячным отчётом. Возможно, файл не находится в нужной директории.");
            return null;
        }
    }

    public void saveReportsPerYear() {
         String paths = readFileContentsOrNull("resources/y.2021.csv");
        String[] lines = paths.split("\r?\n");
        for (int i = 1; i < lines.length; i++) {
            String[] lineContents = lines[i].split(",");
            YearReader yearReader = new YearReader(Integer.parseInt(lineContents[0]),
                    Integer.parseInt(lineContents[1]),
                    Boolean.parseBoolean(lineContents[2]));
            year.add(yearReader);
        }

    }

    public Integer profitOrExpenseForEachMonth(int month)
    {
        int expenseByCurrentMonth;
        int profitByCurrentMonth;

        if (year.get(month).isExpense())
        {
            expenseByCurrentMonth= year.get(month).getAmount();
            profitByCurrentMonth = year.get(month + 1).getAmount();
        }
        else
        {
            profitByCurrentMonth = year.get(month).getAmount();
            expenseByCurrentMonth = year.get(month + 1).getAmount();

        }
        return profitByCurrentMonth - expenseByCurrentMonth ;

    }
    public int averageExpensesOfYear()
    {
        int averageExpense = 0;
        int expensePerMonth;
      for (YearReader yearReader : year)
      {
          if (yearReader.isExpense())
          {
              expensePerMonth = yearReader.getAmount();
              averageExpense += expensePerMonth;

          }
      }
      return averageExpense / 3;

    }
    public int averageProfitOfYear()
    {
        int averageProfit = 0;
        int profitPerMonth ;
        for (YearReader yearReader : year)
        {
            if (!(yearReader.isExpense()))
            {
                profitPerMonth = yearReader.getAmount();
                averageProfit += profitPerMonth;

            }
        }
        return averageProfit / 3;
    }

}
