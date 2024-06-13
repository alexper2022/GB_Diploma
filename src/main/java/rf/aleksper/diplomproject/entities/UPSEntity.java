package rf.aleksper.diplomproject.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@Entity(name = "ups")
@NoArgsConstructor
public class UPSEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long upsId;
    private String upsName;
    private String upsManufacturer;
    private String upsModel;
    private String upsSerialNumber;

    public UPSEntity(String name, String manufacturer, String model, String serialNumber) {
        this.upsName = name;
        this.upsManufacturer = manufacturer;
        this.upsModel = model;
        this.upsSerialNumber = serialNumber;
    }
}
