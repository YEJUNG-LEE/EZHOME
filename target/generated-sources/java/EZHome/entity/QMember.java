package EZHome.entity;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.processing.Generated;
import com.querydsl.core.types.Path;


/**
 * QMember is a Querydsl query type for Member
 */
@Generated("com.querydsl.codegen.DefaultEntitySerializer")
public class QMember extends EntityPathBase<Member> {

    private static final long serialVersionUID = 2021147115L;

    public static final QMember member = new QMember("member1");

    public final StringPath email = createString("email");

    public final NumberPath<Long> id = createNumber("id", Long.class);

    public final StringPath Memb_address = createString("Memb_address");

    public final StringPath Memb_birth = createString("Memb_birth");

    public final StringPath Memb_name = createString("Memb_name");

    public final StringPath Memb_nick = createString("Memb_nick");

    public final StringPath Memb_password = createString("Memb_password");

    public final StringPath Memb_phone = createString("Memb_phone");

    public final EnumPath<EZHome.constant.Role> role = createEnum("role", EZHome.constant.Role.class);

    public QMember(String variable) {
        super(Member.class, forVariable(variable));
    }

    public QMember(Path<? extends Member> path) {
        super(path.getType(), path.getMetadata());
    }

    public QMember(PathMetadata metadata) {
        super(Member.class, metadata);
    }

}

