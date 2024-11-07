package org.example;

import com.google.zxing.BarcodeFormat;
import com.google.zxing.WriterException;
import com.google.zxing.client.j2se.MatrixToImageWriter;
import com.google.zxing.common.BitMatrix;
import com.google.zxing.qrcode.QRCodeWriter;

import java.io.IOException;
import java.nio.file.FileSystems;
import java.nio.file.Path;

public class QRCodeGenerator {
    public static void main(String[] args) {
        String data = "https://discord.gg/MhNUMjSc"; // Texto o enlace a convertir en QR
        String filePath = "codigoqr.png"; // Nombre y formato del archivo de salida
        int width = 300; // Ancho del código QR
        int height = 300; // Altura del código QR

        try {
            generateQRCode(data, filePath, width, height);
            System.out.println("Código QR generado correctmente.");
        } catch (WriterException | IOException e) {
            System.err.println("Error al generar el código QR: " + e.getMessage());
        }
    }

    private static void generateQRCode(String data, String filePath, int width, int height) throws WriterException, IOException {
        QRCodeWriter qrCodeWriter = new QRCodeWriter();
        BitMatrix bitMatrix = qrCodeWriter.encode(data, BarcodeFormat.QR_CODE, width, height);
        Path path = FileSystems.getDefault().getPath(filePath);
        MatrixToImageWriter.writeToPath(bitMatrix, "PNG", path);
    }
}
