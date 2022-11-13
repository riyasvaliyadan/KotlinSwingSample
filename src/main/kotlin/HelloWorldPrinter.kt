import java.awt.Graphics
import java.awt.Graphics2D
import java.awt.print.PageFormat
import java.awt.print.Printable

class HelloWorldPrinter : Printable {

    override fun print(g: Graphics?, pageFormat: PageFormat?, pageIndex: Int): Int {
        // We have only one page, and 'page'
        // is zero-based

        // We have only one page, and 'page'
        // is zero-based
        if (pageIndex > 0) {
            return Printable.NO_SUCH_PAGE
        }

        // User (0,0) is typically outside the
        // imageable area, so we must translate
        // by the X and Y values in the PageFormat
        // to avoid clipping.

        // User (0,0) is typically outside the
        // imageable area, so we must translate
        // by the X and Y values in the PageFormat
        // to avoid clipping.
        val g2d = g as Graphics2D
        g2d.translate(pageFormat!!.imageableX, pageFormat!!.imageableY)

        // Now we perform our rendering

        // Now we perform our rendering
        g.drawString("Hello world!", 100, 100)

        // tell the caller that this page is part
        // of the printed document

        // tell the caller that this page is part
        // of the printed document
        return Printable.PAGE_EXISTS
    }
}