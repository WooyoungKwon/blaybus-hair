package blaybus.hair_mvp.domain.user.entity;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.processing.Generated;
import com.querydsl.core.types.Path;
import com.querydsl.core.types.dsl.PathInits;


/**
 * QUser is a Querydsl query type for User
 */
@Generated("com.querydsl.codegen.DefaultEntitySerializer")
public class QUser extends EntityPathBase<User> {

    private static final long serialVersionUID = -1053485015L;

    public static final QUser user = new QUser("user");

    public final blaybus.hair_mvp.domain.common.QBaseTimeEntity _super = new blaybus.hair_mvp.domain.common.QBaseTimeEntity(this);

    //inherited
    public final DateTimePath<java.time.LocalDateTime> createdAt = _super.createdAt;

    public final StringPath email = createString("email");

    public final ComparablePath<java.util.UUID> id = createComparable("id", java.util.UUID.class);

    //inherited
    public final DateTimePath<java.time.LocalDateTime> modifiedAt = _super.modifiedAt;

    public final StringPath name = createString("name");

    public final StringPath profileUrl = createString("profileUrl");

    public final ListPath<blaybus.hair_mvp.domain.reservation.entity.Reservation, blaybus.hair_mvp.domain.reservation.entity.QReservation> reservations = this.<blaybus.hair_mvp.domain.reservation.entity.Reservation, blaybus.hair_mvp.domain.reservation.entity.QReservation>createList("reservations", blaybus.hair_mvp.domain.reservation.entity.Reservation.class, blaybus.hair_mvp.domain.reservation.entity.QReservation.class, PathInits.DIRECT2);

    public final ListPath<blaybus.hair_mvp.domain.review.entity.Review, blaybus.hair_mvp.domain.review.entity.QReview> reviews = this.<blaybus.hair_mvp.domain.review.entity.Review, blaybus.hair_mvp.domain.review.entity.QReview>createList("reviews", blaybus.hair_mvp.domain.review.entity.Review.class, blaybus.hair_mvp.domain.review.entity.QReview.class, PathInits.DIRECT2);

    public final EnumPath<Role> role = createEnum("role", Role.class);

    public QUser(String variable) {
        super(User.class, forVariable(variable));
    }

    public QUser(Path<? extends User> path) {
        super(path.getType(), path.getMetadata());
    }

    public QUser(PathMetadata metadata) {
        super(User.class, metadata);
    }

}

