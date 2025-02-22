package blaybus.hair_mvp.domain.review.repository;

import blaybus.hair_mvp.domain.review.entity.Review;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface ReviewRepository extends JpaRepository<Review, UUID>, CustomReviewRepository {
}
