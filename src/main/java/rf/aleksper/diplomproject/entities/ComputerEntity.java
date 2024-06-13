package rf.aleksper.diplomproject.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity(name = "computers")
@AllArgsConstructor
@NoArgsConstructor
public class ComputerEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long computerId;
    private String computerName;
    private String computerManufacturer;
    private String computerModel;
    private String computerProcessor;
    private Double computerProcessorFrequencyGHz; //GHz
    private String computerRam;
    private Integer computerRamSizeGB; //GB
    private String computerVideoCard;
    private String computerStorage;
    private String computerStorageType; //SSD, HDD и т.д.
    private Integer computerStorageSizeGB; //GB
    private String computerOSVendor; //Microsoft, Linux и т.д.
    private String computerOSVersion;
    private String computerOSArchitecture;

    public ComputerEntity(String name, String manufacturer, String model, String processor, Double processorFrequencyGHz, String ram, Integer ramSizeGB, String videoCard, String storage, String storageType, Integer storageSizeGB, String osVendor, String osVersion, String osArchitecture) {
        this.computerName = name;
        this.computerManufacturer = manufacturer;
        this.computerModel = model;
        this.computerProcessor = processor;
        this.computerProcessorFrequencyGHz = processorFrequencyGHz;
        this.computerRam = ram;
        this.computerRamSizeGB = ramSizeGB;
        this.computerVideoCard = videoCard;
        this.computerStorage = storage;
        this.computerStorageType = storageType;
        this.computerStorageSizeGB = storageSizeGB;
        this.computerOSVendor = osVendor;
        this.computerOSVersion = osVersion;
        this.computerOSArchitecture = osArchitecture;
    }
}

