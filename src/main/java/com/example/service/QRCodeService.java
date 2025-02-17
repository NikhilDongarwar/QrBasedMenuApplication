package com.example.service;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.nio.file.FileSystems;
import java.nio.file.Path;

import javax.imageio.ImageIO;

import org.springframework.stereotype.Service;

import com.google.zxing.BarcodeFormat;
import com.google.zxing.WriterException;
import com.google.zxing.client.j2se.MatrixToImageWriter;
import com.google.zxing.common.BitMatrix;
import com.google.zxing.qrcode.QRCodeWriter;

@Service
public class QRCodeService {

	 public BufferedImage generateQRCode(String roomId) throws WriterException {
	        QRCodeWriter qrCodeWriter = new QRCodeWriter();
	       // String qrContent = "http://localhost:9091/api/qr/getmenu/" + roomId;
	        String qrContent="https://github.com/";
	        BitMatrix bitMatrix = qrCodeWriter.encode(qrContent, BarcodeFormat.QR_CODE, 350, 350);
	        return MatrixToImageWriter.toBufferedImage(bitMatrix);
	    }
}