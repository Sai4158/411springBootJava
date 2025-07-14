package sql.test.demo.topiccontroller;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "topics")
public class Topics {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String description;

    // 1. A no-argument constructor (required by JPA)
    public Topics() {
    }

    // 2. An all-argument constructor (for convenience)
    public Topics(Long id, String name, String description) {
        this.id = id;
        this.name = name;
        this.description = description;
    }

    // 3. Getter methods (for reading data)
    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    // 4. Setter methods (for changing data)
    public void setId(Long id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}