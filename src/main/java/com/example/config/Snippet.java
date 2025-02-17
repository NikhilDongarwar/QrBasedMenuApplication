/*
 * package com.example.config;
 * 
 * import com.google.zxing.BarcodeFormat; import
 * com.google.zxing.WriterException; import
 * com.google.zxing.qrcode.QRCodeWriter; import
 * com.google.zxing.client.j2se.MatrixToImageWriter; import
 * com.google.zxing.common.BitMatrix;
 * 
 * import java.awt.image.BufferedImage; import java.io.IOException; import
 * java.nio.file.FileSystems; import java.nio.file.Path;
 * 
 * public class Snippet{
 * 
 * 
 * 
 * public static void generateQRCodeImage(String text, int width, int height,
 * String filePath) throws WriterException, IOException { QRCodeWriter
 * qrCodeWriter = new QRCodeWriter(); BufferedImage qrImage =
 * MatrixToImageWriter.toBufferedImage(qrCodeWriter.encode(text,
 * BarcodeFormat.QR_CODE, width, height)); java.nio.file.Path path =
 * FileSystems.getDefault().getPath(filePath);
 * MatrixToImageWriter.writeToStream(qrImage, "PNG", path); }
 * 
 * }
 */