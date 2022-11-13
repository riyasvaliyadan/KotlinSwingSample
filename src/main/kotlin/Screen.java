import javax.print.PrintService;
import javax.print.attribute.Attribute;
import javax.print.attribute.PrintServiceAttributeSet;
import javax.swing.*;
import java.awt.print.PrinterException;
import java.awt.print.PrinterJob;
import java.util.Random;

public class Screen {
    public JPanel panel;
    private JButton nextButton;
    private JLabel quoteLabel;
    private JTextField thisIsASampleTextField;
    private JButton printButton;

    Screen() {
        nextButton.addActionListener(ActionListener -> {
            Random random = new Random();
            String[] quotes = Quotes.data.split("%");
            String quote = quotes[random.nextInt(quotes.length)];
            quoteLabel.setText(quote);
        });

        printButton.addActionListener(ActionListener -> {
            PrinterJob printerJob = PrinterJob.getPrinterJob();
            printerJob.setPrintable(new HelloWorldPrinter());
            if (printerJob.printDialog()) {
                // try to get some printer specific data
                PrintService printService = printerJob.getPrintService();
                String name = printService.getName();
                printAllAttributes(printService.getAttributes());

                try {
                    printerJob.print();
                } catch (PrinterException e) {
                    throw new RuntimeException(e);
                }
            }
        });
    }

    private void printAllAttributes(PrintServiceAttributeSet attributes) {
        for (Attribute a : attributes.toArray()) {
            String name = a.getName();
            String value = attributes.get(a.getClass()).toString();
            System.out.println(name + " : " + value);
        }
    }

    private void createUIComponents() {
        // TODO: place custom component creation code here
    }
}
