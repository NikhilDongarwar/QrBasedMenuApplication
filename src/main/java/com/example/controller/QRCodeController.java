package com.example.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.example.service.QRCodeService;
import com.google.zxing.WriterException;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.ByteArrayOutputStream;
import java.io.IOException;

@RestController
public class QRCodeController {

    @Autowired
    private QRCodeService qrCodeService;

    @GetMapping("/generateQRCode/{roomId}")
    public ResponseEntity<byte[]> generateQRCode(@PathVariable String roomId) {
        try {
            BufferedImage qrImage = qrCodeService.generateQRCode(roomId);
            ByteArrayOutputStream baos = new ByteArrayOutputStream();
            ImageIO.write(qrImage, "PNG", baos);
            byte[] imageBytes = baos.toByteArray();

            HttpHeaders headers = new HttpHeaders();
            headers.setContentType(MediaType.IMAGE_PNG);
           //", roomId + ".png");"
            headers.setContentDispositionFormData("attachment", "qr_" + roomId + ".png");

            return ResponseEntity.ok()
                    .headers(headers)
                    .body(imageBytes);
        } catch (WriterException | IOException e) {
            return ResponseEntity.status(500).body(null);
        }
    }
}