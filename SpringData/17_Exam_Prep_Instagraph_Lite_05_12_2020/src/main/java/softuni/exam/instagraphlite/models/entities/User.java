package softuni.exam.instagraphlite.models.entities;

import org.hibernate.mapping.Collection;

import javax.persistence.*;
import java.text.DecimalFormat;
import java.util.Collections;
import java.util.Comparator;
import java.util.Set;
import java.util.stream.Collectors;

@Entity
@Table(name = "users")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;


    @Column(nullable = false,unique = true)
    private String username;

    @Column(nullable = false)
    private String password;

    @ManyToOne
    @JoinColumn(name = "profile_picture_id")
    private Picture picture;

    @OneToMany(mappedBy = "user",targetEntity = Post.class)
    private Set<Post> posts;

    public User(){}

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Picture getPicture() {
        return picture;
    }

    public void setPicture(Picture picture) {
        this.picture = picture;
    }

    public Set<Post> getPosts() {
        return posts;
    }

    public void setPosts(Set<Post> posts) {
        this.posts = posts;
    }

    @Override
    public String toString() {

        StringBuilder output = new StringBuilder();


        output.append(String.format("User: %s%n", username));
        output.append(String.format("Post count: %d%n", posts.size()));


        DecimalFormat df = new DecimalFormat("#########.00");

      posts.stream().sorted(new Comparator<Post>() {
            @Override
            public int compare(Post p1, Post p2) {
                return p1.getPicture().getSize().
                        compareTo(p2.getPicture().getSize());
            }
        }).forEach( p -> {
          output.append("==Post Details:\n");
          output.append(String.format("----Caption: %s%n",p.getCaption()));
          output.append(String.format("----Picture Size: %s%n",df.format(p.getPicture().getSize())));
      });

          return output.toString();
    }
}
