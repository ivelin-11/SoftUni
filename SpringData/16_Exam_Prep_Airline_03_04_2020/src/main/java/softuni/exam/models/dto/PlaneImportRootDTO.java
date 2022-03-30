package softuni.exam.models.dto;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.Collections;
import java.util.List;

@XmlRootElement(name = "planes")
@XmlAccessorType(XmlAccessType.FIELD)
public class PlaneImportRootDTO {

    @XmlElement(name = "plane")
    private List<PlaneImportDTO> planeImportDTOS;

    public List<PlaneImportDTO> getPlaneImportDTOS() {
        return Collections.unmodifiableList(planeImportDTOS);
    }

    public PlaneImportRootDTO(){}
}
