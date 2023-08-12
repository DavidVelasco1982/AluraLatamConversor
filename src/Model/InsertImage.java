package Model;
import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JButton;

public class InsertImage {
    public void createImage(JButton boton, String obtenerImagen) {

        // La ruta de la imagen a ajustar
        ImageIcon icon = new ImageIcon(getClass().getResource(obtenerImagen));
        //Ajusta una imagen al tamaño del botón especificado.
        ImageIcon imagen = new ImageIcon(
                icon.getImage().getScaledInstance(boton.getWidth(),
                        boton.getHeight(), Image.SCALE_SMOOTH));

        boton.setIcon(imagen);

    }
}
