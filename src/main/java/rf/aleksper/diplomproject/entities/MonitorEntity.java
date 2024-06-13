package rf.aleksper.diplomproject.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity(name = "monitors")
@NoArgsConstructor
public class MonitorEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long monitorId;
    private String monitorName;
    private String monitorManufacturer;
    private String monitorModel;
    private String monitorSerialNumber;
    private Integer monitorDiagonal;
    private Integer monitorResolutionX;
    private Integer monitorResolutionY;
    private String monitorDescription;

    public MonitorEntity(String monitorName, String monitorManufacturer, String monitorModel, String monitorSerialNumber, Integer monitorDiagonal, Integer monitorResolutionX, Integer monitorResolutionY, String monitorDescription) {
        this.monitorName = monitorName;
        this.monitorManufacturer = monitorManufacturer;
        this.monitorModel = monitorModel;
        this.monitorSerialNumber = monitorSerialNumber;
        this.monitorDiagonal = monitorDiagonal;
        this.monitorResolutionX = monitorResolutionX;
        this.monitorResolutionY = monitorResolutionY;
        this.monitorDescription = monitorDescription;
    }
}
