package com.moneybyn;
import com.moneybyn.model.Prospect;
import com.moneybyn.service.MortgageCalculatorService;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@SpringBootApplication
public class MoneyBinApplication {
    public static void main(String[] args) {
        SpringApplication.run(MoneyBinApplication.class, args);

        // Read prospects from file
        List<Prospect> prospects = readProspectsFromFile();

        // Calculate and print monthly payments
        MortgageCalculatorService calculatorService = new MortgageCalculatorService();
        calculatorService.calculateMonthlyPayments(prospects);
    }

    private static List<Prospect> readProspectsFromFile() {
        List<Prospect> prospects = new ArrayList<>();
        String filePath = "/app/prospects.txt";

        try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
            // Skip the header line
            reader.readLine();

            String line;
            while ((line = reader.readLine()) != null) {
                String[] data = line.split(",");
                Prospect prospect = new Prospect();
                prospect.setCustomerName(data[0].trim());
                prospect.setTotalLoanAmount(Double.parseDouble(data[1].trim()));
                prospect.setYearlyInterestRate(Double.parseDouble(data[2].trim()));
                prospect.setLoanPeriod(Integer.parseInt(data[3].trim()));
                prospects.add(prospect);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        return prospects;
    }

}



