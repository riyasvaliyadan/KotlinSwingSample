import javax.swing.*;
import java.awt.event.ActionListener;
import java.util.List;
import java.util.Random;

public class Screen {
    public JPanel panel;
    private JButton nextButton;
    private JLabel quoteLabel;

    Screen() {
        nextButton.addActionListener(ActionListener -> {
            Random random = new Random();
            String[] quotes = Quotes.data.split("%");
            String quote = quotes[random.nextInt(quotes.length)];
            quoteLabel.setText(quote);
        });

    }
}
