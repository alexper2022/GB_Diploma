package rf.aleksper.diplomproject.controllers;

import lombok.Data;

@Data
public class PrinterRequest {
    private String printerName;
    private String printerBrand;
    private String printerModel;
    private String printerSerialNumber;
    private boolean printerIsMFU;
    private String printerIpAddress;
}
