package Model;
import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JButton;
/**
 * Insert Image with an Image Icon.
 */
public class InsertImage {
/**
 * Create Image
 * @param boton Button
 * @param obtenerImagen Get Image Icon
 */
    public void createImage(JButton boton, String obtenerImagen) {

        ImageIcon icon = new ImageIcon(getClass().getResource(obtenerImagen));

        ImageIcon imagen = new ImageIcon(
                icon.getImage().getScaledInstance(boton.getWidth(),
                        boton.getHeight(), Image.SCALE_SMOOTH));

        boton.setIcon(imagen);

    }
}
