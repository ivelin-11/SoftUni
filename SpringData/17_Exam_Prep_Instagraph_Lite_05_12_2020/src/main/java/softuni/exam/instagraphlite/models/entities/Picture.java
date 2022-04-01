package softuni.exam.instagraphlite.models.entities;



import javax.persistence.*;
import java.math.BigDecimal;
import java.text.DecimalFormat;

@Entity
@Table (name = "pictures")
public class Picture {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(nullable = false,unique = true)
    private String path;

    @Column(nullable = false)
    private BigDecimal size;


    public Picture(){}

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }

    public BigDecimal getSize() {
        return size;
    }

    public void setSize(BigDecimal size) {
        this.size = size;
    }



    @Override
    public String toString() {
         DecimalFormat df = new DecimalFormat("#########.00");
      return  String.format("%s – %s",df.format(size),path);
    }
}
