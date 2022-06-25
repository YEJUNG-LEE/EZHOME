package EZHome.entity;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;

@Entity
@Table(name = "content")
@Getter
@Setter
@ToString
public class Content extends BaseEntity{
    @Id
    @Column(name = "content_id")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(nullable = false, length = 50)
    private String title;

    @Lob
    @Column(nullable = false, length = 5000)
    private String main_text;

    @Column(nullable = false)
    private String category;

    @Column
    private String tags;

    @Column
    private Integer views;

    @Column
    private String email;

   // @Enumerated(EnumType.STRING)
    //private ContentLikeStatus contentLikeStatus;

//    public void updateContent()
}
