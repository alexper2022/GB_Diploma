package rf.aleksper.diplomproject.controllers;

import lombok.Data;

@Data
public class ComputerRequest {
    private final String computerName;
    private final String computerManufacturer;
    private final String computerModel;
    private final String computerProcessor;
    private final Double computerProcessorFrequencyGHz;
    private final String computerRam;
    private final Integer computerRamSizeGB;
    private final String computerVideoCard;
    private final String computerStorage;
    private final String computerStorageType;
    private final Integer computerStorageSizeGB;
    private final String computerOSVendor;
    private final String computerOSVersion;
    private final String computerOSArchitecture;
}
