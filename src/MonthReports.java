import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.HashMap;


public class MonthReports
    {
    private HashMap <Integer, ArrayList<MonthReader>> months = new HashMap<>();
    private ArrayList<MonthReader> monthReaders = new ArrayList<>();
    public MonthReports ()
    {
        months = new HashMap<>();
        monthReaders = new ArrayList<>();
    }

        public HashMap<Integer, ArrayList<MonthReader>> getMonth()
        {
           return months;
        }

        public static String readFileContentsOrNull(String paths)
    {
        try {
            return Files.readString(Path.of(paths));
        } catch (IOException e) {
            System.out.println("Невозможно прочитать файл с месячным отчётом. Возможно, файл не находится в нужной директории.");
            return null;
        }
    }
    public void saveReportsPerMonth() {
        for (int month = 1; month < 3; month++) {
            String paths = readFileContentsOrNull("resources/m.20210" + month + ".csv");
            if (paths == null) {
                return;
            }

        String[] lines = paths.split("\r?\n");
        for (int j = 1; j < lines.length; j++) {
            String[] lineContents = lines[j].split(",");
            String itemName = lineContents[0];
            boolean isExpense = Boolean.parseBoolean(lineContents[1]);
            int quantity = Integer.parseInt(lineContents[2]);
            int sumOfOne = Integer.parseInt(lineContents[3]);
            MonthReader monthReader = new MonthReader(itemName, isExpense, quantity, sumOfOne);
            monthReaders.add(monthReader);
            months.put(month, monthReaders);
        }
    }
    }
    public int getProfitItem( ArrayList<MonthReader> monthReader)
    {
        int sumOfProfit = 0;
            for (MonthReader monthReaders : monthReader  )
        {
            if (!monthReaders.getIsExpense())
            {
                sumOfProfit = monthReaders.getQuantity() * monthReaders.getSumOfOne();
            }
        }
        return sumOfProfit;
    }
    public int getSpendingPerMonth(ArrayList<MonthReader> monthReader)
    {
        int sumOfSpending = 0;
        for (MonthReader monthReaders : monthReader  )
        {
            if (monthReaders.getIsExpense())
            {
                sumOfSpending = monthReaders.getQuantity() * monthReaders.getSumOfOne();
            }
        }
        return sumOfSpending;
    }


    public String infoByMonth()
    {
        int currentMonth = 0;
        int maxSpendingItem = 0;
        int maxProfitItem = 0;
            int profit;
            int spending;
            String nameOfMaxProfitItem = "";
            String nameOfMaxSpendingItem = "";

        for (Integer month : months.keySet())
        { currentMonth = month;
            for(MonthReader monthReaders : months.get(currentMonth))
            {
                if (!(monthReaders.getIsExpense()))
                {
                    profit = monthReaders.getQuantity() * monthReaders.getSumOfOne();
                    if (profit > maxProfitItem)
                    {
                        maxProfitItem = profit;
                        nameOfMaxProfitItem= monthReaders.getItemName();

                    }

                }
                else
                {
                    spending = monthReaders.getQuantity() * monthReaders.getSumOfOne();
                    if (spending > maxSpendingItem)
                    {
                        maxSpendingItem = spending;
                        nameOfMaxSpendingItem = monthReaders.getItemName();

                    }

                }

            }

        }
        return "Самый прибыльный товар за " +  currentMonth + " месяц - " + nameOfMaxProfitItem + "\n" +
                "На сумму: " + maxProfitItem  + "\n" +
                "Самая большая трата за " +  currentMonth + " месяц - " + nameOfMaxSpendingItem +  "\n"
                +"На сумму: " + maxSpendingItem;


    }

    }

