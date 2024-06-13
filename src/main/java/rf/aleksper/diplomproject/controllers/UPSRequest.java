package rf.aleksper.diplomproject.controllers;

import lombok.Data;

@Data
public class UPSRequest {
    private String upsName;
    private String upsManufacturer;
    private String upsModel;
    private String upsSerialNumber;
}
