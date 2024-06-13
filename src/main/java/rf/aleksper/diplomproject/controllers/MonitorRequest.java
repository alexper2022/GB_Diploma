package rf.aleksper.diplomproject.controllers;

import lombok.Data;

@Data
public class MonitorRequest {
    private String monitorName;
    private String monitorManufacturer;
    private String monitorModel;
    private String monitorSerialNumber;
    private Integer monitorDiagonal;
    private Integer monitorResolutionX;
    private Integer monitorResolutionY;
    private String monitorDescription;
}
