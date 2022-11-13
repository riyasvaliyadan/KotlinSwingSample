import java.awt.Dimension
import javax.swing.JFrame
import javax.swing.WindowConstants.EXIT_ON_CLOSE

fun main() {
    val jFrame = JFrame()
    jFrame.contentPane = Screen().panel
    jFrame.defaultCloseOperation = EXIT_ON_CLOSE
    jFrame.size = Dimension(600, 600) // size
    jFrame.setLocationRelativeTo(null) // this center the form
    jFrame.isVisible = true
}