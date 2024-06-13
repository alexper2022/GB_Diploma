package rf.aleksper.diplomproject.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity(name = "printers")
@NoArgsConstructor
public class PrinterEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long printerId;
    private String printerName;
    private String printerBrand;
    private String printerModel;
    private String printerSerialNumber;
    private boolean printerIsMFU; // МФУ или нет
    private String printerIpAddress; // Адрес печати

    public PrinterEntity(String name, String brand, String model, String serialNumber, boolean isMfu, String ipAddress) {
        this.printerName = name;
        this.printerBrand = brand;
        this.printerModel = model;
        this.printerSerialNumber = serialNumber;
        this.printerIsMFU = isMfu;
        this.printerIpAddress = ipAddress;
    }
}
