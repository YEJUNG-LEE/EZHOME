package EZHome.entity;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.processing.Generated;
import com.querydsl.core.types.Path;
import com.querydsl.core.types.dsl.PathInits;


/**
 * QContentImg is a Querydsl query type for ContentImg
 */
@Generated("com.querydsl.codegen.DefaultEntitySerializer")
public class QContentImg extends EntityPathBase<ContentImg> {

    private static final long serialVersionUID = 2101089115L;

    private static final PathInits INITS = PathInits.DIRECT2;

    public static final QContentImg contentImg = new QContentImg("contentImg");

    public final QBaseEntity _super = new QBaseEntity(this);

    public final QContent content;

    //inherited
    public final StringPath createdBy = _super.createdBy;

    public final NumberPath<Long> id = createNumber("id", Long.class);

    public final StringPath imgName = createString("imgName");

    public final StringPath imgUrl = createString("imgUrl");

    //inherited
    public final StringPath modifiedBy = _super.modifiedBy;

    public final StringPath oriImgName = createString("oriImgName");

    //inherited
    public final DateTimePath<java.time.LocalDateTime> regTime = _super.regTime;

    public final StringPath repImgYn = createString("repImgYn");

    //inherited
    public final DateTimePath<java.time.LocalDateTime> updateTime = _super.updateTime;

    public QContentImg(String variable) {
        this(ContentImg.class, forVariable(variable), INITS);
    }

    public QContentImg(Path<? extends ContentImg> path) {
        this(path.getType(), path.getMetadata(), PathInits.getFor(path.getMetadata(), INITS));
    }

    public QContentImg(PathMetadata metadata) {
        this(metadata, PathInits.getFor(metadata, INITS));
    }

    public QContentImg(PathMetadata metadata, PathInits inits) {
        this(ContentImg.class, metadata, inits);
    }

    public QContentImg(Class<? extends ContentImg> type, PathMetadata metadata, PathInits inits) {
        super(type, metadata, inits);
        this.content = inits.isInitialized("content") ? new QContent(forProperty("content")) : null;
    }

}

